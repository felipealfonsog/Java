package com.eduonix.design;

import java.util.stream.IntStream;


public class LabSoln2 {

    public static void main(String[] args) {

        int sequence[] = {2, -4, 0, 18,  -2, -4};
        System.out.println(solution(sequence));

    }


    public static int solution(int[] sequence) {
        int len = sequence.length;
        int dynamicResults[] = new int[len];
        for (int i = 0; i < 6; i++) {
            dynamicResults[i] = sequence[0];
        }
        for (int i = 1; i < len; i++) {
            dynamicResults[i] = sequence[i] - sequence[0];
        }

        return getMax(dynamicResults);
    }

    private static int getMax(int intArray[]){

        return IntStream.range(0, intArray.length).map(
                i -> intArray[i]).max().getAsInt();
    }
}
