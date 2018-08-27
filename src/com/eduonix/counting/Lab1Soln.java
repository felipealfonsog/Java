package com.eduonix.counting;

import java.util.ArrayList;

/**
 * Created by ubu on 7/12/2016.
 */
public class Lab1Soln {

    public static void main(String[] args) {

        Lab1Soln runner = new Lab1Soln();
        int[] timeSeries = new int[]{1, 3, 1, 4, 2, 3, 5, 4};
        int k = runner.slide(5, timeSeries);

        System.out.println(k);

    }

    private int slide(int max, int[] series) {

        boolean[] bitmap = new boolean[max + 1];

        for (int i = 0; i < series.length; i++) {
            if (!bitmap[series[i]]) {
                bitmap[series[i]] = true;
                max--;
            }

            if (max == 0) {
                return i;
            }
        }

        return -1;

    }

}
