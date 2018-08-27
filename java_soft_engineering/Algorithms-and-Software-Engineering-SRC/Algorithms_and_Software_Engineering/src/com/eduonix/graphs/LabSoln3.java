package com.eduonix.graphs;

import java.io.*;
import java.util.Locale;
import java.util.Scanner;
import java.util.Stack;


public class LabSoln3 {

    public static void main(String[] args) throws FileNotFoundException {

        File initialFile = new File(UniGraph.class.getResource("directedGraphCycle.txt").getFile());
        InputStream targetStream = new FileInputStream(initialFile);
        Scanner scanner = new Scanner(new BufferedInputStream(targetStream), "UTF-8");
        scanner.useLocale(Locale.US);
        DirectedGraph graph = new DirectedGraph(scanner);

        OptimiseCycleSearch search = new OptimiseCycleSearch(graph);
        if (search.hasCycle()) {
            System.out.print("Shortest directed cycle: ");
            for (int vertex : search.cycle()) {
                System.out.print(vertex + " ");
            }
            System.out.println();
        }

    }

  static  class OptimiseCycleSearch {
        private Stack<Integer> cycle;
        private int length;

        public OptimiseCycleSearch(DirectedGraph graph) {
            DirectedGraph clone =  createCloneGrapth(graph);
            length = graph.numVertices() + 1;
            // take each vertex in original graph and run search in clone
            for (int vertex = 0; vertex < graph.numVertices(); vertex++) {
                BreadthFirstOptimiseSearch bfs = new BreadthFirstOptimiseSearch(clone, vertex);
                for (int nextVertex : graph.findAdjacentNodes(vertex)) {
                    // if the path exists test for smaller length and update
                    if (bfs.hasPathTo(nextVertex) && (bfs.distanceToNode(nextVertex) + 1) < length) {
                        length = bfs.distanceToNode(nextVertex) + 1;
                        cycle = new Stack<Integer>();
                        for (int x : bfs.pathTo(nextVertex))
                            cycle.push(x);
                        cycle.push(vertex);
                    }
                }
            }
        }

        public DirectedGraph createCloneGrapth(DirectedGraph graph) {
          int  NUM_VERTICES = graph.numVertices();
            DirectedGraph reverse = new DirectedGraph( NUM_VERTICES );
            for (int vertex = 0; vertex < NUM_VERTICES; vertex++) {
                for (int nextVertex : graph.findAdjacentNodes(vertex)) {
                    reverse.addEdgeToGraph(nextVertex, vertex);
                }
            }
            return reverse;
        }

        public boolean hasCycle() {
            return cycle != null;
        }

        // if the cycle exists this will be the minimum
        public Iterable<Integer> cycle() {
            return cycle;
        }

        public int length() {
            return length;
        }

    }

    public  static class BreadthFirstOptimiseSearch extends  Graphs_2.BreadthFirstSearch  {

        public BreadthFirstOptimiseSearch(DirectedGraph graph, int source) {
            super(graph, source);
        }

        public int distanceToNode(int vertex) {
            return distance[vertex];
        }
    }

}
