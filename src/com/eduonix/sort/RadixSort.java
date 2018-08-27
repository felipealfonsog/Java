package com.eduonix.sort;

import java.util.ArrayList;

/**
 * Created by ubu on 8/21/2016.
 */
public class RadixSort {


    public static void countingRadixSort( String [ ] sequence, int keyspace) {
        final int UNICODE_CHARACTER_INTEGERS = 256;

        int N = sequence.length;
        String [ ] buffer = new String[ N ];

        String [ ] in = sequence;
        String [ ] out = buffer;

        for(int pos = keyspace - 1; pos >= 0; pos-- )  {
            int[ ] count = new int [ UNICODE_CHARACTER_INTEGERS + 1 ];

            for( int i = 0; i < N; i++ )
                count[ in[ i ].charAt( pos ) + 1 ]++;

            for(int b = 1; b <= UNICODE_CHARACTER_INTEGERS; b++ )
                count[ b ] += count[ b - 1 ];

            for( int i = 0; i < N; i++ )
                out[ count[ in[ i ].charAt( pos ) ]++ ] = in[ i ];

            // swap in and out roles
            String [ ] tmp = in;
            in = out;
            out = tmp;
        }

        // if odd number of passes, in is buffer, out is arr; so copy back
        if( keyspace % 2 == 1 )
            for( int i = 0; i < sequence.length; i++ ) {
                out[ i ] = in[ i ];
                System.out.println( out[ i ] +" ");
            }

    }


}
