package com.eduonix.graphs;

import java.io.*;
import java.util.*;

/**
 * Created by ubu on 8/2/2016.
 */
public class Graphs_2 {


    public static void main(String[] args) throws FileNotFoundException {
        File initialFile = new File(UniGraph.class.getResource("directedGraph.txt").getFile());
        InputStream targetStream = new FileInputStream(initialFile);
        Scanner scanner = new Scanner(new BufferedInputStream(targetStream), "UTF-8");
        scanner.useLocale(Locale.US);
        DirectedGraph graph = new DirectedGraph(scanner);
        System.out.println(graph);

        BreadthFirstSearch bfs = new BreadthFirstSearch(graph, 2 );

        System.out.print(bfs.hasPathTo(6));
    }




    public  static class BreadthFirstSearch {

        protected boolean[] marked;
        protected int[] edgeTo;
        protected int[] distance;

        public BreadthFirstSearch(DirectedGraph graph, int source) {
            marked = new boolean[graph.numVertices()];
            distance = new int[graph.numVertices()];
            edgeTo = new int[graph.numVertices()];
            bfs(graph, source);

        }
        // breadth-first search from source
        protected void bfs(DirectedGraph graph, int source) {
            LinkedList<Integer> q = new LinkedList<Integer>();
            for (int vertex = 0; vertex < graph.numVertices(); vertex++)
                distance[vertex] = -1;

            distance[source] = 0;
            marked[source] = true;
            q.add(source);
            while (!q.isEmpty()) {
                int vertex = q.removeFirst();
                for (int nextVertex : graph.findAdjacentNodes(vertex)) {
                    if (!marked[nextVertex]) {
                        edgeTo[nextVertex] = vertex;
                        distance[nextVertex] = distance[vertex] + 1;
                        marked[nextVertex] = true;
                        q.addLast(nextVertex);
                    }
                }
            }
        }

        public Iterable<Integer> pathTo(int vertex) {
            if (!hasPathTo(vertex)) return null;
            Stack<Integer> path = new Stack<Integer>();
            int x;
            for (x = vertex; distance[x] != 0; x = edgeTo[x])
                path.push(x);
            path.push(x);
            return path;
        }

        public boolean hasPathTo(int vertex) {
            return marked[vertex];
        }

    }




}
