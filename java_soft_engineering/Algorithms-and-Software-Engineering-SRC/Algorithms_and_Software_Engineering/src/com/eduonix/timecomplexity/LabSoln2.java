package com.eduonix.timecomplexity;

/**
 * Created by ubu on 7/12/2016.
 */
public class LabSoln2 {

    public static void main(String[] args) {
        int[] sequence2 = new int[]{ 1, 2, 3, 5 };

        int result = solution(sequence2);
        System.out.println(result);
    }

    private static int solution(int[] sequence) {
        int length =  sequence.length;

        double sum1 = 0;
        double sum2 = 0;

        for (int i = 1; i <= length + 1; i++)
            sum1 +=  i;

        for (int i = 0; i < length; i++)
            sum2 += sequence[i];

        return (int) (sum1 - sum2);

    }
}
