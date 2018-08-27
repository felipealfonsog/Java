package com.eduonix.counting;

import java.util.HashSet;

/**
 * Created by ubu on 7/12/2016.
 */
public class Lab2Soln {

    public static void main(String[] args) {

        Lab2Soln runner = new Lab2Soln();
        int[] permTrue = new int[]{4, 1, 3, 2 };
        int[] permFalse = new int[]{4, 1, 3, 5 };
        int k = runner.findMissingValue(permFalse);

        System.out.println(k);

    }

    private int findMissingValue(int[] sequence) {
        int num =1;
        HashSet<Integer> coverMap = new HashSet<>();
        for (int i = 0; i < sequence.length; i++) {
            coverMap.add(sequence[i]);

            while(coverMap.contains(num)) {
                num++;
            }
        }

        return num;
    }


}
