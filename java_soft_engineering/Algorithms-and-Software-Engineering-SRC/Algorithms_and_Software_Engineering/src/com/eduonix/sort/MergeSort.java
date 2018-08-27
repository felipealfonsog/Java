package com.eduonix.sort;

import java.util.Random;

/**
 * Created by ubu on 8/21/2016.
 */
public class MergeSort {

    public static void main(String[] args) {
        MergeSort runner = new MergeSort();
        Integer[] sequence = new Integer[100];
        Random rnd = new Random();

        for (int i = 0; i < sequence.length; i++) sequence[i] = rnd.nextInt(i+1);

        runner.mergeSort(sequence);
        processOutput(sequence);
    }

    public  <T extends Comparable<? super T>>  void mergeSort( T[ ] sequence)
    {
        T[ ] tmpArray = (T[]) new Comparable[ sequence.length ];

        mergeSort(sequence, tmpArray, 0, sequence.length - 1 );
    }


    private   <T extends Comparable<? super T>> void mergeSort(T[ ] sequence, T[ ] tmpArray, int left, int right )  {
        if( left < right )
        {
            int center = ( left + right ) / 2;
            mergeSort(sequence, tmpArray, left, center );
            mergeSort(sequence, tmpArray, center + 1, right );
            merge(sequence, tmpArray, left, center + 1, right );
        }
    }


    private  <T extends Comparable<? super T>> void merge(T[ ] sequence, T[ ] tmpArray, int leftPos, int rightPos, int rightEnd )  {
        int leftEnd = rightPos - 1;
        int tmpPos = leftPos;
        int numElements = rightEnd - leftPos + 1;

        // Main loop
        while( leftPos <= leftEnd && rightPos <= rightEnd )
            if( sequence[ leftPos ].compareTo( sequence[ rightPos ] ) <= 0 )
                tmpArray[ tmpPos++ ] = sequence[ leftPos++ ];
            else
                tmpArray[ tmpPos++ ] = sequence[ rightPos++ ];

        while( leftPos <= leftEnd )    // Copy rest of first half
            tmpArray[ tmpPos++ ] = sequence[ leftPos++ ];

        while( rightPos <= rightEnd )  // Copy rest of right half
            tmpArray[ tmpPos++ ] = sequence[ rightPos++ ];

        for( int i = 0; i < numElements; i++, rightEnd-- )
            sequence[ rightEnd ] = tmpArray[ rightEnd ];
    }


    private static void processOutput(Integer[] a) {

        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }
}
