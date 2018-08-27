package com.eduonix.sort;

import java.util.Random;

/**
 * Created by ubu on 8/21/2016.
 */
public class ShellSort {

    public static void main(String[] args) {
        ShellSort runner = new ShellSort();
        Integer[] sequence = new Integer[100];
        Random rnd = new Random();

        for (int i = 0; i < sequence.length; i++) sequence[i] = rnd.nextInt(i+1);

        runner.shellsort(sequence);
        // look at the output
        processOutput(sequence);
    }

    public static <T extends Comparable<? super T>>  void shellsort( T [ ] sequence)
    {
        int j;

        for(int gap = sequence.length / 2; gap > 0; gap /= 2 )
            for(int i = gap; i < sequence.length; i++ )
            {
                T tmp = sequence[ i ];
                for(j = i; j >= gap &&
                        tmp.compareTo( sequence[ j - gap ] ) < 0; j -= gap )
                    sequence[ j ] = sequence[ j - gap ];
                sequence[ j ] = tmp;
            }
    }


    private static void processOutput(Integer[] a) {

        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }

}
