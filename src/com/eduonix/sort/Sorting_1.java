package com.eduonix.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

/**
 * Created by ubu on 8/21/2016.
 */
public class Sorting_1 {

    public static void main(String[] args) {
        Sorting_1 runner = new Sorting_1();
        Integer[] sequence = new Integer[100];
        Random rnd = new Random();

        for (int i = 0; i < sequence.length; i++) sequence[i] = rnd.nextInt(i+1);

        runner.insertionSort(sequence);
        // look at the output
        processOutput(sequence);
    }

    /**
     * Simple insertion sort.
     */
    public  <T extends Comparable<? super T>> void insertionSort(T[] a) {
        int j;

        for (int p = 1; p < a.length; p++) {
            T tmp = a[p];

            for (j = p; j > 0 && tmp.compareTo(a[j - 1]) < 0; j--)
                a[j] = a[j - 1];
            a[j] = tmp;
        }
    }

    public ArrayList<OrderedPair> pairSort(ArrayList<OrderedPair> inputSequence) {

        Collections.sort(inputSequence, new Comparator<OrderedPair>() {
            @Override
            public int compare(OrderedPair o1, OrderedPair o2) {
                return o1.getKey() - o2.getKey();
            }
        });
        return inputSequence;
    }


    static class OrderedPair {
        Integer key;
        String value;

        public OrderedPair(Integer key, String value) {
            this.key = key;
            this.value = value;
        }

        public int getKey() {
            return key;
        }
    }

    private static void processOutput(Integer[] a) {

        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }
}
