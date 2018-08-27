package com.eduonix.iterations;

import java.io.InputStream;
import java.util.Arrays;
import java.util.Iterator;
import java.util.stream.IntStream;

/**
 * Created by ubu on 7/12/2016.
 */
public class Lab1Solution3 {

    public static void main(String[] args) {

        Lab1Solution3 runner = new Lab1Solution3();
        int gapStrSoln =  runner.stringBasedSolution(169);
        System.out.println("stringBasedSolution gap "+gapStrSoln);

        int gapNumericSoln =  runner.streamBasedSolution(169);
        System.out.println("streamBasedSolution gap "+gapNumericSoln);


    }

    public int stringBasedSolution(int binaryNum) {
        String binaryNumStr = Integer.toBinaryString(binaryNum);
        System.out.println(binaryNumStr);
        binaryNumStr = binaryNumStr.replace("0", " ").trim();
        String[] binGapsAsString = binaryNumStr.split("1");

        if (binGapsAsString.length == 0) return 0;

        int[] binGapsAsInt = new int[binGapsAsString.length];
        for (int i = 0; i < binGapsAsString.length; i++){
            binGapsAsInt[i] = binGapsAsString[i].length();
        }
        Arrays.sort(binGapsAsInt);
        return binGapsAsInt[binGapsAsInt.length-1];

    }

    public int streamBasedSolution(int binaryNum) {
        String binaryNumStr = Integer.toBinaryString(binaryNum);

        IntStream is2 = binaryNumStr.chars();

        Iterator itr = is2.iterator();
        int b = 0;
        int t = 0;
        while (itr.hasNext()) {
            int digit = (int) itr.next();
            if (digit == 48) {
                b++;
            }
            if (digit == 49) {
                if (t < b) {
                    t = b;
                }
                b = 0;
            }

        }
        return t;
    }

}
