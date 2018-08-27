package com.eduonix.timecomplexity;


/**
 * Created by ubu on 7/12/2016.
 */
public class TimeComplexity1 {

    public static void main(String[] args) {
        TimeComplexity1 runner = new TimeComplexity1();
        int limit = 100000;
        runner.example1(limit);
        runner.example2(limit);
        runner.example3(limit);
    }

    public void example1(int limit) {
        int n = 0;
        long t = System.currentTimeMillis();
        for (int j = 0; j < limit; j++) {
            for (int k = 0; k < j; k++) {
                n = n + 1;
            }
        }
        t = System.currentTimeMillis() - t;
        System.out.println("quadratic worst case for t " + t + "(ms)");
        System.out.println("numeric result " + n);
    }


    public void example2(int limit) {
        int n = 0;
        long t = System.currentTimeMillis();
        for (int j = 0; j < limit; j++) {
            n = n + (j + 1);
        }
        t = System.currentTimeMillis() - t;
        System.out.println("linear worst case for t " + t + "(ms)");
        System.out.println("numeric result " + n);
    }


    public void example3(int limit) {
        long t = System.currentTimeMillis();
        int k = limit * (limit + 1) / 2;
        t = System.currentTimeMillis() - t;
        System.out.println("linear worst case for t " + t + "(ms)");
        System.out.println("numeric result " + k);
    }

    // specific calculation
    public static double factorial(int limit) {
        double num = limit;
        while (--limit > 1)
            num *= limit;

        return num;

    }
}
