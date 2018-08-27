package com.eduonix.sort;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by ubu on 8/7/2016.
 */
public class Lab2Soln {

    public static void main(String[] args) {

        Lab2Soln runner = new Lab2Soln();
        int[] sequence = new int[10];
        Random rnd = new Random();
        for (int i = 0; i < sequence.length; i++) {
            sequence[i]= rnd.nextInt(i+1);
        }
        int k =   runner.solution(sequence);
        System.out.println(k);
    }

    private int solution(int[] sequence) {
        int[] maxTuple  = new int[3];

        for (int a: sequence) {
           compareAndUpdateTuple(a, maxTuple);
        }

        int result = maxTuple[0] + maxTuple[1] +maxTuple[2];

        System.out.println(Arrays.toString(maxTuple));

        return result;
    }

    private void compareAndUpdateTuple(int possibleMax, int[] maxTuple) {

        if(possibleMax >=  maxTuple[2]) {
            maxTuple[0] = maxTuple[1];
            maxTuple[1] = maxTuple[2];
            maxTuple[2] = possibleMax;
        } else if(possibleMax >=  maxTuple[1]) {
            maxTuple[0] = maxTuple[1];
            maxTuple[1] = possibleMax;
        } else if(possibleMax >  maxTuple[0]) {
            maxTuple[0] = possibleMax;
        }

    }
}
