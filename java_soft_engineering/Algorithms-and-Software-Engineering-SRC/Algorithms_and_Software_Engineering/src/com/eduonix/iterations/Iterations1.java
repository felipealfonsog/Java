package com.eduonix.iterations;

import java.util.stream.IntStream;

/**
 * Created by ubu on 7/12/2016.
 */
public class Iterations1 {

    public static void main(String[] args) {

        Iterations1 runner = new Iterations1();
        //runner.example1();
      //  runner.example2();
        runner.example3();

    }

    private void example1() {

        int n=10, result =1;

        for (int j =1; j<= n; j++) {
            result = result*j;
            System.out.println("result= "+result);

        }
    }

    private void example2() {

        int n = 10;

        for (int j = 1; j <= n; j++) {
            for (int k = 1; k <= j; k++) {
                System.out.print("*");
            }
            System.out.println();
        }

    }

    private void example3() {

        int j = 10;

        for ( ; j >= 0; j--) {
            int finalJ = j;
            IntStream.range(0,10-j).forEach( s -> {
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

