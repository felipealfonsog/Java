package com.eduonix.seq_analysis;

import java.math.BigInteger;
import java.util.Random;

/**
 * Created by ubu on 7/19/2016.
 */
public class Lab3Solution {

    public static void main(String[] args) {

        BigInteger testNumber =
                new BigInteger("226673591177742970257407");
        int s = 0;
        int k = 10;
        BigInteger d = testNumber.subtract(BigInteger.ONE);
        //find s and d for the expression n -1 =  (2^s) ·d
        while (d.mod(new BigInteger("2")).equals(BigInteger.ZERO)) {
            s++;
            d = d.divide(new BigInteger("2"));
        }
        for (int i = 0; i < k; i++) {
            BigInteger a = genRandomIntInRange(testNumber.subtract(BigInteger.ONE));
            BigInteger modTest = a.modPow(d, testNumber);
            if (modTest.equals(BigInteger.ONE) ||
                    modTest.equals(testNumber.subtract(BigInteger.ONE)))
                continue;


            // choose r from  0 ≤ r ≤ s − 1
            int r = 1;
            for (; r < s; r++) {
                modTest = modTest.modPow(new BigInteger("2"), testNumber);
                if (modTest.equals(BigInteger.ONE))
                    System.out.println("226673591177742970257407 is not prime");
                if (modTest.equals(testNumber.subtract(BigInteger.ONE)))
                    break;
            }
            if (r == s) // None of the steps made modTest equal testNumber-1.
                System.out.println("226673591177742970257407 is not prime");
        }
        System.out.println("226673591177742970257407 is a prime number");
    }

    private static BigInteger genRandomIntInRange(BigInteger testNumber) {
        Random rnd = new Random();
        BigInteger randomInt;
        do {
            randomInt = new BigInteger(testNumber.bitLength(), rnd);
        } while (randomInt.compareTo(new BigInteger("2")) < 0
                                        || randomInt.compareTo(testNumber) > 0);
        return randomInt;
    }



}
