package com.eduonix.stacks_queues;

import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 * Created by ubu on 7/13/2016.
 */
public class LabSoln2 {

    static LinkedList queue = new LinkedList();

    static void arrive(PetOrder patient) {
        queue.addLast(patient);
    }

    static PetOrder process() {
        if (queue.isEmpty()) {
            return null;
        } else {
            return (PetOrder)queue.removeFirst();
        }
    }


    static String[] petorders = new String[]{"pet bird", "pet cat","petfood chunkytreats", "petfood fishdelights"  , "process"   };



    public static void main(String[] args) {

        for (String petorder : petorders) {
            StringTokenizer tok = new StringTokenizer(petorder);
            String verb = tok.nextToken();

            if (verb.contains("pet")) {
                String category = verb ;
                String orderItem = tok.nextToken();
                PetOrder order = new PetOrder(category, orderItem);

                arrive(order);
            } else if (verb.equals("process") ) {
                PetOrder order = process();
                if (order == null) {
                    System.out.println("No petorders, take a break");
                } else {
                    System.out.println("processing PetOrder " + order);
                }
            } else if (verb.equals("exit") || verb.equals("e")) {
                break;
            }
        }
    }


    static class PetOrder {
        private String category;
        private String orderItem;


        public PetOrder(String name, String problem ) {
            this.category = name;
            this.orderItem = problem;

        }

        public String toString() {
            return "category: " + category + ",  orderItem: " + orderItem ;
        }
    }
}
