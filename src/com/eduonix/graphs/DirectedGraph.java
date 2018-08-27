package com.eduonix.graphs;

import java.io.*;
import java.util.HashSet;
import java.util.Locale;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by ubu on 8/2/2016.
 */
public class DirectedGraph {

    protected int NUM_EDGES;
    protected int NUM_VERTICES;
    protected Set<Integer>[] adjacencySet;
    protected int[] degreeComingIn;

    public DirectedGraph(int n) {
        this.NUM_VERTICES = n ;
        adjacencySet = (Set<Integer>[]) new HashSet[NUM_VERTICES];
        for (int vertex = 0; vertex < NUM_VERTICES; vertex++) {
            adjacencySet[vertex] = new HashSet<Integer>();
        }
        degreeComingIn = new int[NUM_VERTICES];
    }


    public DirectedGraph(Scanner  in) {
            this.NUM_VERTICES = in.nextInt();
            degreeComingIn = new int[NUM_VERTICES];
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

        adjacencySet[vertex].add(nextVertex);
        degreeComingIn[nextVertex]++;
        NUM_EDGES++;
    }

    public Iterable<Integer> findAdjacentNodes(int vertex) {
        return adjacencySet[vertex];
    }

    public int outdegree(int vertex) {
        return adjacencySet[vertex].size();
    }

    public int indegree(int vertex) {
        return degreeComingIn[vertex];
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        for (int v = 0; v < NUM_VERTICES; v++) {
            s.append(String.format("%d: ", v));
            for (int w : adjacencySet[v]) {
                s.append(String.format("%d ", w));
            }
            s.append("\n");
        }
        return s.toString();
    }



}
