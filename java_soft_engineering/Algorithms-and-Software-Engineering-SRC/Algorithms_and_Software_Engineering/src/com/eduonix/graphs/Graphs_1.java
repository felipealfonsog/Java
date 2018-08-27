package com.eduonix.graphs;
import java.io.*;
import java.util.*;


/**
 * Created by ubu on 8/2/2016.
 */
public class Graphs_1 {


    public static void main(String[] args) throws FileNotFoundException {

        File initialFile = new File(UniGraph.class.getResource("simpleunigraph.txt").getFile());
        // File initialFile = new File(UniGraph.class.getResource("diconnectedunigraph.txt").getFile());
        InputStream targetStream = new FileInputStream(initialFile);
        Scanner scanner = new Scanner(new BufferedInputStream(targetStream), "UTF-8");
        scanner.useLocale(Locale.US);
        UniGraph graph = new UniGraph(scanner);
      //  System.out.println(graph);

        //<editor-fold desc="== processing ==" >
       // System.out.println("number self loops "+numberOfSelfLoops(graph));

     //   System.out.println("average  Node Degree  "+avgDegree(graph));
        //</editor-fold>
        DepthFirstSearch search = new DepthFirstSearch(graph, 4);
        System.out.println("number of connections for 4 "+search.count());

        if (search.count() == graph.numVertices())   System.out.println("connected");

        if (search.count() != graph.numVertices())   System.out.println("disconnected");

    }
    //<editor-fold desc="== processing ==" >
    // number of self-loops
    public static int numberOfSelfLoops(UniGraph graph) {
        int count = 0;
        for (int vertex = 0; vertex < graph.numVertices(); vertex++)
            for (int nextVertex : graph.findAdjacentNodes(vertex))
                if (vertex == nextVertex) count++;
        return count/2;   // self loop appears in adjacency list twice
    }

    public static int avgDegree(UniGraph graph) {
        // each edge incident on two vertices
        return 2 * graph.numEdges() / graph.numVertices();
    }
    //</editor-fold>

   static class  DepthFirstSearch {
       private boolean[] marked;
       private int count;

       public DepthFirstSearch(UniGraph graph, int match) {
           marked = new boolean[graph.numVertices()];
           dfs(graph, match);
       }


       // depth first search from v
       private void dfs(UniGraph graph, int vertex) {
           count++;
           marked[vertex] = true;
           for (int nextVertex : graph.findAdjacentNodes(vertex)) {
               if (!marked[nextVertex]) {
                   dfs(graph, nextVertex);
               }
           }
       }

       public boolean marked(int vertex) {
           return marked[vertex];
       }

       // number of vertices connected to s
       public int count() {
           return count;
       }

   }



}