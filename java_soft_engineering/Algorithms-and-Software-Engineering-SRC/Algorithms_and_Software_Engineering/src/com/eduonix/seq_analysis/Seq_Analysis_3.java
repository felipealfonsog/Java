package com.eduonix.seq_analysis;

/**
 * Created by ubu on 7/19/2016.
 */
public class Seq_Analysis_3 {

    public static void main(String[] args) {

        doSieve(121);

    }


    public static void doSieve( int bound) {

        // initially assume all integers are prime
        boolean[] isPrime = new boolean[bound + 1];
        for (int i = 2; i <= bound; i++) {
            isPrime[i] = true;
        }

        // mark non-primes <= bound using Sieve of Eratosthenes
        for (int i = 2; i*i <= bound; i++) {

            // if i is prime, then mark multiples of i as nonprime
            // suffices to consider mutiples i, i+1, ..., bound/i
            if (isPrime[i]) {
                for (int j = i; i*j <= bound; j++) {
                    isPrime[i*j] = false;
                }
            }
        }

        // count primes
        int primes = 0;
        for (int i = 2; i <= bound; i++) {
            if (isPrime[i]){
                System.out.print(i+" ");
                primes++;
            }
        }
        System.out.println("The number of primes <= " + bound + " is " + primes);
    }



}
