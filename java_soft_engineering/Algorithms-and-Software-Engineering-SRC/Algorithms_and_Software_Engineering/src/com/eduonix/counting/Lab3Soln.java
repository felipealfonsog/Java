package com.eduonix.counting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/**
 * Created by ubu on 7/12/2016.
 */
public class Lab3Soln {

    public static void main(String[] args) {

        Lab3Soln runner = new Lab3Soln();

        ArrayList<String> missingBinSeries =
                new ArrayList<String>(Arrays.asList("000", "010", "001", "100", "101", "111", "110"));

        int m = missingNumber(missingBinSeries);
        System.out.println(m);


    }

    private static int missingNumber(ArrayList<String> sequence) {

        int k = sequence.get(0).length();
        return missingNumber(sequence, k - 1);


    }

    private static int missingNumber(ArrayList<String> sequence, int k) {
        if (k < 0) {
            return 0;
        }
        ArrayList<String> zero = new ArrayList<String>();
        ArrayList<String> one = new ArrayList<String>();

        for (String integer : sequence) {
            if (integer.charAt(k) == '0') {
                zero.add(integer);
            } else if (integer.charAt(k) == '1') {
                one.add(integer);
            } else {
                System.out.println("Invalid Input");
                System.exit(1);

            }
        }

        if(zero.size() <= one.size())
            return  missingNumber(zero, k - 1) << 1 | 0;
        else
            return  missingNumber(one, k - 1) << 1 | 1;

    }

    private long linear(int[] sequence, int count) {
        long sum = 0;
        long countSum = 0;
        for (int i = 0; i < count - 1; i++) {
            sum = sum + sequence[i];
        }

        countSum = (count * (count + 1) / 2);

        return (countSum - count);
    }


}
