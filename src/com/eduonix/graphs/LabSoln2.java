package com.eduonix.graphs;

import java.io.*;
import java.util.*;

/**
 * Created by ubu on 8/2/2016.
 */
public class LabSoln2 {
    public static void main(String[] args) throws FileNotFoundException {
        File initialFile = new
                File(UniGraph.class.getResource("directedGraph.txt").getFile());
        InputStream targetStream = new FileInputStream(initialFile);
        Scanner scanner = new Scanner(new BufferedInputStream(targetStream), "UTF-8");
        scanner.useLocale(Locale.US);
        DirectedGraph graph = new DirectedGraph(scanner);
        System.out.println(graph);

        BreadthFirstSearch bfs = new BreadthFirstSearch(graph, 2);

        System.out.print(2+" -> ");
        if (bfs.hasPathTo(6)) {
            List<Integer> path = bfs.pathTo(6);
            for (int k = path.size()-1; k>=0 ; k--) {
                if(k !=0 )
                System.out.print(path.get(k)+" -> ");
                else
                    System.out.print(path.get(k));
            }
        }
    }


    static class BreadthFirstSearch {

        private boolean[] marked;
        private int[] edgeTo;
        private int[] distance;

        public BreadthFirstSearch(DirectedGraph graph, int source) {
            marked = new boolean[graph.numVertices()];
            distance = new int[graph.numVertices()];
            edgeTo = new int[graph.numVertices()];
            bfs(graph, source);
        }


        public List<Integer> pathTo(int vertex) {
            if (!hasPathTo(vertex)) return null;
            List<Integer> path = new LinkedList<Integer>();
            int x;
            for (x = vertex; distance[x] != 0; x = edgeTo[x])
                path.add(x);
            return path;
        }


        // breadth-first search from s
        private void bfs(DirectedGraph graph, int source) {
            LinkedList<Integer> queue = new LinkedList<Integer>();
            for (int vertex = 0; vertex < graph.numVertices(); vertex++)
                distance[vertex] = -1;

            distance[source] = 0;
            marked[source] = true;
            queue.add(source);
            while (!queue.isEmpty()) {
                int vertex = queue.removeFirst();
                for (int nextVertex : graph.findAdjacentNodes(vertex)) {
                    if (!marked[nextVertex]) {
                        edgeTo[nextVertex] = vertex;
                        distance[nextVertex] = distance[vertex] + 1;
                        marked[nextVertex] = true;
                        queue.addLast(nextVertex);
                    }
                }
            }
        }

        public boolean hasPathTo(int vertex) {
            return marked[vertex];
        }

    }


}
