package com.eduonix.timecomplexity;

import java.util.Random;
import java.util.stream.IntStream;

/**
 * Created by ubu on 7/12/2016.
 */
public class LabSoln3 {

    public static void main(String[] args) {

        LabSoln3 runner = new LabSoln3();
        Random random = new Random();
        IntStream intStream = random.ints(0, 10000);
        int[] sequence = intStream.limit(10000).toArray();
        long t = System.currentTimeMillis();
        runner.quickSort(sequence,0, sequence.length-1);
        t = System.currentTimeMillis() - t;
        System.out.println("quickSort worst case for t " + t + "(ms)");
    }

    void quickSort(int[] sequence,   int pivot,   int upper_bound) {
        if (pivot <  upper_bound ){
          int q = partition(sequence, pivot, upper_bound );
            quickSort(sequence, pivot, q);
            quickSort(sequence, q+1, upper_bound);

        }
    }

    private int partition(int[] sequence, int pivot, int upper_bound) {
        int x = sequence[pivot];
        int i = pivot;
        int j = upper_bound;

        while(true) {
            while(i < upper_bound && sequence[i] < x)
                i++;
            while(j > pivot && sequence[j] > x)
                j--;

            if(i < j ) {
                swap(sequence, i, j);
                i++;
                j--;
            } else {
                return j;
            }
        }


    }

    private void swap(int[] sequence, int i, int j) {

        int temp = sequence[i];
        sequence[i] = sequence[j];
        sequence[j] = temp;

    }


}
