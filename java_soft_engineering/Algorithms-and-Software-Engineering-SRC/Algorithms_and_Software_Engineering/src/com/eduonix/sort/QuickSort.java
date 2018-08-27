package com.eduonix.sort;

import java.util.Random;

/**
 * Created by ubu on 8/21/2016.
 */
public class QuickSort {

    public static void main(String[] args) {
        QuickSort runner = new QuickSort();
        Integer[] sequence = new Integer[100];
        Random rnd = new Random();

        for (int i = 0; i < sequence.length; i++) sequence[i] = rnd.nextInt(i+1);

        runner.quicksort(sequence);
        processOutput(sequence);
    }


    public <T extends Comparable<? super T>>  void quicksort( T [ ] sequence)  {
        quicksort(sequence, 0, sequence.length - 1 );
    }

    private static final int runInsertionSortInstead = 3;


    private   <T extends Comparable<? super T>>  void quicksort( T [ ] sequence, int left, int right ) {
        if( left + runInsertionSortInstead <= right )  {
            T pivot = median3( sequence, left, right );

            // Begin partitioning
            int i = left, j = right - 1;
            for( ; ; )
            {
                while( sequence[ ++i ].compareTo( pivot ) < 0 ) { }
                while( sequence[ --j ].compareTo( pivot ) > 0 ) { }
                if( i < j )
                    doSwapFirstWithSecond( sequence, i, j );
                else
                    break;
            }

            doSwapFirstWithSecond( sequence, i, right - 1 );   // Restore pivot

            quicksort( sequence, left, i - 1 );    // Sort small elements
            quicksort( sequence, i + 1, right );   // Sort large elements
        }
        else  // Do an insertion sort on the subarray
            insertionSort( sequence, left, right );
    }


    private <T extends Comparable<? super T>>  T median3( T [ ] a, int left, int right )  {
        int center = ( left + right ) / 2;
        if( a[ center ].compareTo( a[ left ] ) < 0 )
            doSwapFirstWithSecond( a, left, center );
        if( a[ right ].compareTo( a[ left ] ) < 0 )
            doSwapFirstWithSecond( a, left, right );
        if( a[ right ].compareTo( a[ center ] ) < 0 )
            doSwapFirstWithSecond( a, center, right );

        // Place pivot at position right - 1
        doSwapFirstWithSecond( a, center, right - 1 );
        return a[ right - 1 ];
    }



    public  <T> void doSwapFirstWithSecond(T [ ] a, int index1, int index2 )
    {
        T tmp = a[ index1 ];
        a[ index1 ] = a[ index2 ];
        a[ index2 ] = tmp;
    }


    private <T extends Comparable<? super T>>  void insertionSort(T [ ] sequence, int left, int right )  {
        for( int p = left + 1; p <= right; p++ ) {
            T tmp = sequence[ p ];
            int j;

            for(j = p; j > left && tmp.compareTo( sequence[ j - 1 ] ) < 0; j-- )
                sequence[ j ] = sequence[ j - 1 ];
            sequence[ j ] = tmp;
        }
    }

    private static void processOutput(Integer[] a) {

        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }

}
