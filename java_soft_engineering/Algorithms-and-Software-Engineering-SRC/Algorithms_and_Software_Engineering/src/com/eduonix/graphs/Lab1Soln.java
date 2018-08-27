package com.eduonix.graphs;

import java.io.*;
import java.util.Locale;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by ubu on 8/2/2016.
 */
public class Lab1Soln {

    public static void main(String[] args) throws FileNotFoundException {
        File initialFile =
                new File(Lab1Soln.class.getResource("simpleunigraph.txt").getFile());
        InputStream targetStream = new FileInputStream(initialFile);
        Scanner scanner = new Scanner(new BufferedInputStream(targetStream), "UTF-8");
        scanner.useLocale(Locale.US);
        UniGraph graph = new UniGraph(scanner);

        DepthFirstPath dfs = new DepthFirstPath(graph, 4);

        for (int vertex = 0; vertex < graph.numVertices(); vertex++) {
            if (dfs.pathExists(vertex)) {
                System.out.printf("%d to %d:  ", 4, vertex);
                for (int node : dfs.findPath(vertex)) {
                    if (node ==  4)  System.out.print(node);
                    else  System.out.print( node+"->");
                }
                System.out.println();
            }
        }

    }





    static class DepthFirstPath {

        private boolean[] marked;
        private int[] edgeTo;
        private  int sourceNode;

        public DepthFirstPath(UniGraph graph, int source) {
            this.sourceNode = source;
            edgeTo = new int[graph.numVertices()];
            marked = new boolean[graph.numVertices()];
            dfs(graph, source);
        }

        // depth first search from vertex
        private void dfs(UniGraph graph, int vertex) {
            marked[vertex] = true;
            for (int nextVertex : graph.findAdjacentNodes(vertex)) {
                if (!marked[nextVertex]) {
                    edgeTo[nextVertex] = vertex;
                    dfs(graph, nextVertex);
                }
            }
        }

        public boolean pathExists(int vertex) {
            return marked[vertex];
        }


        public Iterable<Integer> findPath(int vertex) {
            if (!pathExists(vertex)) return null;
            Stack<Integer> path = new Stack<Integer>();
            for (int x = vertex; x != sourceNode; x = edgeTo[x])
                path.push(x);
            path.push(sourceNode);
            return path;
        }
    }
}
