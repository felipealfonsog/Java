package com.eduonix.design;

/**
 * Created by ubu on 8/10/2016.
 */
public class Design_3 {
    static long countInversions = 0;
    public static void main(String args[]) {

        int[] sequence = { 1, 2, 6 ,3, 4, };
        System.out.println(createCountingSlice(sequence, 0, sequence.length - 1));
        System.out.print("final " );
        for(int k : sequence ) {
            System.out.print(" "+k);
        }

        System.out.println("countInversions "+ (countInversions -1) );
    }

    // recursively create counting slice
    public static long createCountingSlice(int[] sequence, int start, int end) {
        // recursion terminate
        if (start >= end) {
            return 0;
        }
        // { 1, 2, 6 ,3, 4, 5 }
        int mid = start + (end - start) / 2;  // rounds down on 2.5

        createCountingSlice(sequence, start, mid);  // first call result 1
        createCountingSlice(sequence, mid + 1, end);  // first call result 0
        // first call start  0   end  1
        long splitCount = divideAndMergeCountingSlice(sequence, start, end);
        return  splitCount ;
    }

    // builds the array by divide ...   when finds a break in counting sequence {6} divides
    // sorts ->  rebuilds
    public static long divideAndMergeCountingSlice(int[] sequence, int begin, int finish) {

        int mid = (begin) + (finish - begin) / 2;
        int i = begin;
        int j = mid + 1;
        int[] cache = new int[sequence.length];
        int k = begin;

        long countCacheInversions = 0;
        while (i <= mid && j <= finish) {

            if (sequence[i] < sequence[j]) {
                cache[k++] = sequence[i++];
            } else if (sequence[i] > sequence[j]) {
                cache[k++] = sequence[j++];
                countCacheInversions += (mid - i + 1);
                countInversions = countCacheInversions ;
            } else {
                cache[k++] = sequence[i++];
                cache[k++] = sequence[j++];
            }
        }

        if (i > mid) {
            while (j <= finish) {
                cache[k++] = sequence[j++];
                --countInversions;
            }
        } else if (j > finish) {
            while (i <= mid) {
                cache[k++] = sequence[i++];
                --countInversions;
            }
        }

        // copying the elements from result to sequence

        for (int l = begin; l <= finish; l++)
            sequence[l] = cache[l];

        System.out.print("result " );
        for(int l : cache ) {
            System.out.print(" "+l);
        }

        return countCacheInversions;

    }




}
