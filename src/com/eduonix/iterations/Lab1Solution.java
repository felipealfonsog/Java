package com.eduonix.iterations;

import java.util.stream.IntStream;

/**
 * Created by ubu on 7/12/2016.
 */
public class Lab1Solution {

    public static void main(String[] args) {

        int j = 0;

        for ( ; j <= 10; j++) {
            int finalJ = j;
            if(j==0) {
                IntStream.range(0,2*j-1).forEach(s -> {
                    System.out.print(" ");
                });

                IntStream.range(0,2*j-1).forEach( s -> {
                    System.out.print("*");
                    if(s == 2*finalJ -2) {
                        System.out.println();
                    }
                });

                continue;
            }
            IntStream.range(0,10-j).forEach(s -> {
                System.out.print(" ");
            });

            IntStream.range(0,2*j-1).forEach( s -> {
                System.out.print("*");
                if(s == 2*finalJ -2) {
                    System.out.println();
                }
            });



        }


    }
}
