package com.eduonix.counting;

import com.eduonix.sort.Sorting_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by ubu on 8/21/2016.
 */
public class Counting3 {

    public static void main(String[] args) {

        Counting3 runner = new Counting3();
        int[] xVal = new int[] {3, 1, 4,  7,  1, 4, 0};
        int[] yVal = new int[] {6, 2, 8, 1, 5, 9,  4};

        OrderedPair[] inputSequence = runner.genTestData(xVal, yVal);
     //   OrderedPair[] orderedInputSequence = runner.pairSort(inputSequence);
        OrderedPair[] orderedInputSequence = runner.pigeonHoleSort(inputSequence);
        for(OrderedPair k: orderedInputSequence) {
            System.out.print(k+ " ");
        }
    }



    ArrayList<Integer> sortInts1( ArrayList<Integer> inputSequence) {
        Collections.sort(inputSequence);
        return inputSequence;
    }

    public int[] sortInts2(int[] inputSequence) {
        Arrays.sort(inputSequence);
        return inputSequence;
    }

    public int[] countingSort(int[] inputSequence) {
        int  maxValue = -1;
        for (int i = 0; i < inputSequence.length; i++) {
            int x = inputSequence[i];
            if (x > maxValue) {
                maxValue = x;
            }
        }

            int[] counts = new int [maxValue + 1];

            for (int i : inputSequence) {
                counts[i] += 1;
            }
        for (int i = 0, j = 0; i <= maxValue; i++) {
            int c = counts[i];
            for (int k = 0; k < c; k++, j++) {
                inputSequence[j] = i;
            }
        }
        return inputSequence;
    }



    public ArrayList<OrderedPair> pairSort(ArrayList< OrderedPair> inputSequence) {

        Collections.sort(inputSequence, new Comparator<OrderedPair>() {
            @Override
            public int compare(OrderedPair o1,OrderedPair o2) {
                return o1.getKey() - o2.getKey();
            }
        });
        return inputSequence;
    }

    public  OrderedPair[] pairSort(OrderedPair[]inputSequence) {

        Arrays.sort(inputSequence, new Comparator<OrderedPair>() {
            @Override
            public int compare(OrderedPair o1,OrderedPair o2) {
                return o1.getKey() - o2.getKey();
            }
        });
        return inputSequence;
    }


    public OrderedPair[] pigeonHoleSort(OrderedPair[] inputSequence) {
        int maxValue = -1;
        for (int i=0; i<inputSequence.length; i++) {
            int x = inputSequence[i].getKey();
            if (x > maxValue) {
                maxValue = x;
            }
        }
        int[] counts = new int[maxValue + 1];
        for (OrderedPair b : inputSequence) {
            counts[b.getKey()] += 1;
        }

        OrderedPair[][] slots = new OrderedPair[maxValue + 1][];

        for (int i=0; i<counts.length; i++) {
            int size = counts[i];
            if (size > 0) {
                slots[i] = new OrderedPair[size];
            }
            counts[i]=0;
        }

        for (int i=0; i<inputSequence.length; i++) {
            OrderedPair bs = inputSequence[i];
            int k = bs.getKey();
            int j = counts[k]++;
            slots[k][j]=bs;

        }
        for (int i = 0, j = 0; i <= maxValue; i++) {
            int c = counts[i];
            for (int k = 0; k < c; k++, j++) {
                inputSequence[j] = slots[i][k];
            }

        }

            return inputSequence;
    }




    private OrderedPair[] genTestData(int[] xVal, int[] yVal) {
        OrderedPair[] inputSequence = new  OrderedPair[xVal.length];
        for (int k = 0; k < inputSequence.length; k++) {
            inputSequence[k] = new  OrderedPair(xVal[k],yVal[k]);
        }
        return inputSequence;
    }

    static class OrderedPair {
        private int k;
        private int x;

        public OrderedPair(int k, int x) {
            this.k = k;
            this.x = x;
        }

        public int getKey() {
            return k;
        }

        @Override
        public String toString() {
            return "(" + k +", "+ x + ')';
        }
    }

}
