package com.eduonix.sort;

import java.util.Random;

/**
 * Created by ubu on 8/21/2016.
 */
public class HeapSort {

    public static void main(String[] args) {
        HeapSort runner = new HeapSort();
        Integer[] sequence = new Integer[100];
        Random rnd = new Random();

        for (int i = 0; i < sequence.length; i++) sequence[i] = rnd.nextInt(i+1);

        runner.heapsort(sequence);
        // look at the output
        processOutput(sequence);
    }


    public <T extends Comparable<? super T>> void heapsort( T [ ] sequence)
    {
        for(int i = sequence.length / 2 - 1; i >= 0; i-- )  /* buildHeap */
            makeHeap(sequence, i, sequence.length );
        for(int i = sequence.length - 1; i > 0; i-- )
        {
            swapReferences(sequence, 0, i );                /* deleteMax */
            makeHeap(sequence, 0, i );
        }
    }


    private  <T extends Comparable<? super T>> void makeHeap(T [ ] sequence, int i, int n )
    {
        int child;
        T tmp;

        for(tmp = sequence[ i ]; leftChild( i ) < n; i = child )
        {
            child = leftChild( i );
            if( child != n - 1 && sequence[ child ].compareTo( sequence[ child + 1 ] ) < 0 )
                child++;
            if( tmp.compareTo( sequence[ child ] ) < 0 )
                sequence[ i ] = sequence[ child ];
            else
                break;
        }
        sequence[ i ] = tmp;
    }

    public static <T> void swapReferences(T [ ] sequence, int index1, int index2 )
    {
        T tmp = sequence[ index1 ];
        sequence[ index1 ] = sequence[ index2 ];
        sequence[ index2 ] = tmp;
    }


    private static int leftChild( int i )
    {
        return 2 * i + 1;
    }


    private static void processOutput(Integer[] a) {

        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }
}
