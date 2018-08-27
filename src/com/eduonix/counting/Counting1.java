package com.eduonix.counting;

/**
 * Created by ubu on 8/21/2016.
 */
public class Counting1 {

    public static void main(String[] args) {
        Counting1 runner = new Counting1();
        int[] matrix = new int[]{2, 1, 3, 4, 6, 3, 8, 9, 10, 12, 56};
        int[] minWin = runner.example1(matrix, 4);

        for(int k : minWin) {
            System.out.print(k+" ");
        }
        System.out.println();

        int[] minWin2 = runner.example2(matrix, 4);
        for(int k : minWin2) {
            System.out.print(k+" ");
        }
    }


    private int[] example1(int[] sequence, final int w) {
        final int[] min_left = new int[sequence.length];
        final int[] min_right = new int[sequence.length];
        min_left[0] =  sequence[0];
        min_right[sequence.length -1] =  sequence[sequence.length -1];

        for (int i = 1; i < sequence.length; i++) {
            min_left[i] = (i % w ==0) ? sequence[i]: Math.min(min_left[i-1], sequence[i]);

            final int j = sequence.length -i -1;
            min_right[j] = (j % w ==0) ? sequence[j]: Math.min(min_right[j + 1], sequence[j]);


        }

        final int[] sliding_min = new int [sequence.length -w + 1];
        for (int i = 0, j = 0; i + w  <= sequence.length; i++) {

            sliding_min[j++] =  Math.min(min_right[i], min_left[i + w - 1]);
        }

        return sliding_min;
    }


    private int[] example2(final int[] in, int w) {
        final int[] max_left = new int[in.length];
        final int[] max_right = new int[in.length];
        max_left[0] =  in[0];

        max_right[in.length -1] =  in[in.length -1];
        for (int i = 1; i < in.length; i++) {
            max_left[i] = (i % w ==0) ? in[i]: Math.max(max_left[i-1], in[i]);

            final int j = in.length -i -1;
            max_right[j] = (j % w ==0) ? in[j]: Math.max(max_right[j + 1], in[j]);


        }

        final int[] sliding_max = new int [in.length -w + 1];
        for (int i = 0, j = 0; i + w  <= in.length; i++) {

            sliding_max[j++] =  Math.max(max_right[i], max_left[i + w - 1]);
        }

        return sliding_max;
    }


}
