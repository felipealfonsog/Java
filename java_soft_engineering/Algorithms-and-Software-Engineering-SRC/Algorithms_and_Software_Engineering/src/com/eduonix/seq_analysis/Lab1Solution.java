package com.eduonix.seq_analysis;

/**
 * Created by ubu on 7/18/2016.
 */
public class Lab1Solution {

    public static void main(String[] args) {

        int sequence[] = {2, 1, 3, 4, 1, 2, 1, 5, 4};


        System.out.println(solution(sequence));
    }


    static int solution(int[] sequence) {

        int size = sequence.length;
        int[] gainsLosses = new int[size];
        if (size <= 1) {
            return 0;
        }
        int lowestPrice = sequence[0];
        int maxProfit = 0;
        for (int i = 1; i < size; i++) {
            gainsLosses[i-1] = sequence[i] - sequence[i-1];

            if (sequence[i] <= lowestPrice) {
                lowestPrice = sequence[i];

            } else {
                if (sequence[i] - lowestPrice > maxProfit) {
                    maxProfit = sequence[i] - lowestPrice;
                }
            }


        }
        for (int k = 0; k < gainsLosses.length-1; k++) {
            System.out.print(gainsLosses[k] + " ");
        }
        System.out.println();

        return maxProfit;
    }


}
