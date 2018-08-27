package com.eduonix.graphs;

import java.io.*;
import java.util.*;

/**
 * Created by ubu on 8/2/2016.
 *
 */
public class Graphs_3 {


    public static void main( String [ ] args ) throws IOException {
        File initialFile =
                new File(UniGraph.class.getResource("directedAcyclicGraph.txt").getFile());
        InputStream targetStream = new FileInputStream(initialFile);
        Scanner scanner = new Scanner(new BufferedInputStream(targetStream), "UTF-8");
        scanner.useLocale(Locale.US);
        TopologicalGraph graph = new TopologicalGraph(scanner);
        graph.topologicalSort();
    }

    static class TopologicalGraph extends DirectedGraph {

        public TopologicalGraph(Scanner in) {
            super(in);
        }

        void topologicalSortDFS(int vertex, Boolean visited[], Stack stack) {

            visited[vertex] = true;
            Integer node;

            Iterator<Integer> itr = findAdjacentNodes(vertex).iterator();
            while (itr.hasNext()) {
                node = itr.next();
                if (!visited[node])
                    topologicalSortDFS(node, visited, stack);
            }

            stack.push(new Integer(vertex));
        }


        void topologicalSort() {
          //  Empty stack that will contain the sorted elements
            Stack stack = new Stack();
            Boolean visited[] = new Boolean[NUM_VERTICES];
            // initialise
            for (int i = 0; i < NUM_VERTICES; i++)
                visited[i] = false;

            for (int i = 0; i < NUM_VERTICES; i++)
                if (visited[i] == false)
                    topologicalSortDFS(i, visited, stack);

            // sort completed pop the resuts to standard output
            while (stack.empty() == false)
                System.out.print(stack.pop() + " ");
            }

        }

    }
