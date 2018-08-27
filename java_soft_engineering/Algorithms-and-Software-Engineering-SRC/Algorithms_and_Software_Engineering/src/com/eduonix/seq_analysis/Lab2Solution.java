package com.eduonix.seq_analysis;

import java.util.ArrayList;

/**
 * Created by ubu on 7/19/2016.
 */
public class Lab2Solution {

    public static void main(String[] args) {
        // signal 1
        int sequence[] =  { 0, 1, 0, 0, 1, 0, 0, 1, 0 };
        // signal 2
        int sequence2[] =  { 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0};

         detectPeaks(sequence) ;

    }


    static void detectPeaks(int[] sequence)  {

        ArrayList<Integer> peaks = new ArrayList<Integer>();

        int size_of_sequence = sequence.length;

        for(int i = 1; i < size_of_sequence -1; i++){
            if(sequence[i] > sequence[i-1] && sequence[i] > sequence[i+1])
                peaks.add(i);
        }

        for(int size = 1; size <= size_of_sequence -1; size++){
            if(size_of_sequence % size != 0) continue; // skip if non-divisible
            int find = 0;
            int sizeOfSlice = size_of_sequence/size;

            // Find whether every slice has a peak
            for( int peakIdx: peaks){

                if(peakIdx/size > find){

                    break;

                }
                if(peakIdx/size == find) {

                    find++;

                }

            }

            if(find == sizeOfSlice ) {
                if(peaks.size() == find ) {
                    System.out.println("size of slice "+size_of_sequence/sizeOfSlice);
                    System.out.println("number of peaks "+sizeOfSlice);
               }



            }

        }

    }

}
