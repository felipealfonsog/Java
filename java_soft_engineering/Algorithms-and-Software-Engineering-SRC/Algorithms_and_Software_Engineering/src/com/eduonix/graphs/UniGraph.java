package com.eduonix.graphs;

import java.util.*;

/**
 * Created by ubu on 8/2/2016.
 */
public class UniGraph {


    private int NUM_VERTICES;
    private int NUM_EDGES;
    private Set<Integer>[] adjacencySet;

    public UniGraph(Scanner in) {
        this.NUM_VERTICES = in.nextInt();
        adjacencySet = (Set<Integer>[]) new HashSet[NUM_VERTICES];
        for (int vertex = 0; vertex < NUM_VERTICES; vertex++) {
            adjacencySet[vertex] = new HashSet<Integer>();
        }

        int numEdges = in.nextInt();

        for (int i = 0; i < numEdges; i++) {
            int vertex = in.nextInt();
            int nextVertex = in.nextInt();
            addEdgeToGraph(vertex, nextVertex);
        }
    }


    public int numVertices() {
        return NUM_VERTICES;
    }


    public int numEdges() {
        return NUM_EDGES;
    }


    public void addEdgeToGraph(int vertex, int nextVertex) {

        NUM_EDGES++;
        adjacencySet[vertex].add(nextVertex);
        adjacencySet[nextVertex].add(vertex);
    }

    // need this for traversal
    public Iterable<Integer> findAdjacentNodes(int vertex) {

        return adjacencySet[vertex];
    }

    // need this for connections
    public int findNodeDegree(int vertex) {

        return adjacencySet[vertex].size();
    }


    public String toString() {
        StringBuilder s = new StringBuilder();

        for (int vertex = 0; vertex < NUM_VERTICES; vertex++) {
            s.append(vertex + ": ");
            for (int nextVertex : adjacencySet[vertex]) {
                s.append(nextVertex + " ");
            }
            s.append("\n");
        }
        return s.toString();
    }


}
