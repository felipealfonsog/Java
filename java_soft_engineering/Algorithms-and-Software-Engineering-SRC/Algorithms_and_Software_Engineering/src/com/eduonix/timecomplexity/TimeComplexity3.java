package com.eduonix.timecomplexity;


import java.util.Random;
import java.util.stream.IntStream;

/**
 * Created by ubu on 7/12/2016.
 */
public class TimeComplexity3 {

    public static void main(String[] args) {
        TimeComplexity3 runner = new TimeComplexity3();

        Random random = new Random();
        IntStream intStream = random.ints(0, 100000);
        int[] sequence = intStream.limit(100).toArray();
        runner.bubblesort(sequence);
        runner.selectsort(sequence);
    }

    public static void bubblesort(int sequence[]){

        long t = System.currentTimeMillis();

        for (int i = 1; i <= sequence.length; i++) {

            int count = i;

            for(int j = i+1; j < sequence.length; j++){

                if(sequence[count] > sequence[j]){
                    int term = sequence[count];
                    sequence[count] = sequence[j];
                    sequence[j] = term;
                }

            }

        }
        t = System.currentTimeMillis() - t;
        System.out.println("bubblesort worst case for t " + t + "(ms)");


    }


    public static void selectsort(int[] sequence) {

        long t = System.currentTimeMillis();

        for (int i = 0; i < sequence.length; i++) {

            int count = i;

            for (int j = i + 1; j < sequence.length; j++ ){

                if (sequence[count] > sequence[j]){
                    count = j;
                }

                int holder = sequence[i];
                sequence[i] = sequence[count];
                sequence[count] = holder;

            }

        }

        t = System.currentTimeMillis() - t;
        System.out.println("selectsort worst case for t " + t + "(ms)");
    }

}
