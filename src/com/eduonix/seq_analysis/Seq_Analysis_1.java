package com.eduonix.seq_analysis;

/**
 * Created by ubu on 7/18/2016.
 */
public class Seq_Analysis_1 {


    public static void main(String[] args) {
        int sequence[] = {-2, 1, -3, 4, -1,  2,  1, -5, 4};
        System.out.println(maxDoubleSlice(sequence));
    }

    // Kadane's algorithm
    public static int maxSlice(int[] sequence) {
        int maxSum = 0;
        int thisSum = 0;
        int startOfBestSequence = 0;
        int endOfBestSequence = -1;
        for (int i = 0, j = 0; j < sequence.length; j++) {
            thisSum += sequence[j];

            if (thisSum > maxSum) {
                maxSum = thisSum;
                startOfBestSequence = i;
                endOfBestSequence = j;
          // the starting position is just after the last position
          // thisSum went negative
            } else if (thisSum < 0) {
                i = j + 1;
                thisSum = 0;
            }
        }
        for (int k = startOfBestSequence; k <= endOfBestSequence; k++) {
            System.out.print(sequence[k] + " ");
        }
        System.out.println();
        return maxSum;
    }

    // double slice
    public static int maxDoubleSlice(int[] sequence) {
        int[] maxStartingHere = new int[sequence.length];
        int[] maxEndingHere = new int[sequence.length];
        int maxSum = 0, len = sequence.length;

        // For each index, calculate the maxSum
        // value by using a modified Kadane's algorithm in
        // createCloneGrapth direction.
        for (int i = len - 1; i > 0; --i) {
            maxSum = Math.max(0, sequence[i] + maxSum);
            maxStartingHere[i] = maxSum;
        }
        maxSum = 0;

        //For each index, calculate the maxSum
        // value by using a modified Kadane's algorithm in
        // forward direction.
        for (int i = 1; i < len - 1; ++i) {
            maxSum = Math.max(0, sequence[i] + maxSum);
            maxEndingHere[i] = maxSum;
        }
        int maxDoubleSlice = 0;
        //Iterate these arrays simultaneously and choose the
        // maxDoubleSlice that has the maximum value of
        // maxEndingHere[i] + maxStartingHere[i + 2]
        for (int i = 0; i < len - 2; ++i) {
            maxDoubleSlice = Math.max(maxDoubleSlice,
                    maxEndingHere[i] + maxStartingHere[i + 2]);
        }

            for (int i = 0; i < len - 2; ++i)
                System.out.print(maxEndingHere[i]+" ");
            System.out.println();

            for (int i = 0; i < len - 2; ++i)
                System.out.print(maxStartingHere[i + 2]+" ");
        System.out.println();

        return maxDoubleSlice;
    }


}
