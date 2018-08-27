package com.eduonix.seq_analysis;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 *         System.out.println(greatestCommonDivisor(252 , 105));
 *         System.out.println(isPrime(101));
 */
public class Seq_Analysis_2 {

    public static void main(String[] args) {

//        Integer[] sequenceToPartition =
//                new Integer[] {0, 1, 0, 1 ,0, 1, 0, 1, 0, 1, 0, 0, 1, 0, 1, 0};
//
//       List<Integer> iterableList = Arrays.asList(sequenceToPartition) ;
//       partition(iterableList, 3);

//         partitionArray(sequenceToPartition);

 //       System.out.println(greatestCommonDivisor(252 , 105));

        System.out.println(isPrime(15485863));

    }

    static void  partitionArray(Integer[] sequenceToPartition) {

        for (int k=0; k <sequenceToPartition.length-1; k++ ) {
            if(k %3 == 0 ) {
                Integer[] partition = new Integer[3];
                System.arraycopy(sequenceToPartition, k, partition, 0, 3);
                System.out.print( "[ ");
                for (Integer n : partition) {
                    System.out.print(n + " ");
                }
                System.out.print( "] ");
            }
        }
    }

    public static <T> void partition(Iterable<T> in, int size) {
        List<Iterable<T>> lists = new ArrayList();
        Iterator<T> i = in.iterator();
        while (i.hasNext()) {
            List<T> list = new ArrayList();
            for (int j=0; i.hasNext() && j<size; j++) {
                list.add(i.next());
            }
            lists.add(list);
        }
        System.out.println(lists);
    }

    // https://en.wikipedia.org/wiki/Euclidean_algorithm
    static  int  greatestCommonDivisor(int a,  int b) {

        if (b == 0) {
            return a;
        }
        else {
            return greatestCommonDivisor(b, (a % b));
        }
    }



    static boolean isPrime(int n){
        if(n < 2){
            return false;
        }
        else if(n==2 || n==3){
            return true;
        }
        else if(n%2==0){
            return false;
        }

        /**
         *  if number a is a divisor of n, then n/a is also a divisor.
         *   a or n/a <= root(n)
         *   only consider the odd sequence 3,5,7, .....
         */
        for(int i=3;i <= Math.ceil(Math.sqrt(n));i+=2){
            if(n%i==0){
                return false;
            }
        }
        return true;
    }

}
