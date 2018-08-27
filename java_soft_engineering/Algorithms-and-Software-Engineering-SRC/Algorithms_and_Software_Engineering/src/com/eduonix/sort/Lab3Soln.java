package com.eduonix.sort;

import java.util.ArrayList;

/**
 * Created by ubu on 8/7/2016.
 */
public class Lab3Soln {


    public static void main(String[] args) {
        Lab3Soln runner = new Lab3Soln();
        String[] sequence = new String[]{"baba", "aaab", "cbab", "aaaa"};
        runner.radixSortA(sequence, 4);
    }

    void radixSortA(String[] arr, int keySpace) {

        final int UNICODE_CHARACTER_INTEGERS = 256;

        ArrayList<String>[] buckets = (ArrayList<String>[]) new ArrayList[UNICODE_CHARACTER_INTEGERS];

        for (int i = 0; i < UNICODE_CHARACTER_INTEGERS; i++) {
            buckets[i] = new ArrayList<>();
        }

        for (int pos = keySpace - 1; pos >= 0; pos--) {
            for (String s : arr) {
                buckets[s.charAt(pos)].add(s);
            }
            int idx = 0;
            for (ArrayList<String> thisBucket : buckets) {
                for (String s : thisBucket)
                    arr[idx++] = s;

                thisBucket.clear();
            }

        }
        for (String s : arr) {
            System.out.println(s);
        }
    }
}
