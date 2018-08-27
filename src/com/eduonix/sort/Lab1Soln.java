package com.eduonix.sort;

import com.eduonix.timecomplexity.LabSoln3;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.stream.IntStream;

/**
 * Created by ubu on 8/7/2016.
 */
public class Lab1Soln {


    public static void main(String[] args) {

        Random random = new Random();
        IntStream intStream = random.ints(0, 10000);
        int[] sequence = intStream.limit(10000).toArray();

        System.out.println(solution(sequence));
    }

    public static int solution( int sequence[]) {
       Set coverSet = new HashSet();

        for (int i = 0; i < sequence.length; i++) {
            coverSet.add(i);
        }

        return coverSet.size();
    }

}
