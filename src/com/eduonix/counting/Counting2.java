package com.eduonix.counting;

import java.math.BigInteger;
import java.util.Collections;
import java.util.List;

/**
 * Created by ubu on 8/21/2016.
 */
public class Counting2 {

    public static void main(String[] args) {

        Counting2 runner = new Counting2();

        System.out.println(runner.findCombinationsCount(10, 4));
        System.out.println(runner.findCombinationsBigCount(10, 4));
        System.out.println(runner.comboCountRecursion(10, 4));
    }


    int findCombinationsCount(int cardinality, int subset) {
        int result = 0;
        for (int n = 0; n < cardinality + 1; n++) {
            int nCk = 1;
            for (int k = 0; k <= n; k++) {
                nCk = nCk * (n - k) / (k + 1);

                if (n == cardinality && k == subset - 1) {
                    result = nCk;
                }
            }
        }
        return result;
    }

    int comboCountRecursion(int n, int j) {

        return j == 0 || n == j ? 1 : comboCountRecursion(n - 1, j - 1) + comboCountRecursion(n - 1, j);
    }


    BigInteger findCombinationsBigCount(final int cardinality, final int subset) {
        BigInteger ret = BigInteger.ONE;
        for (int k = 0; k < subset; k++) {

            ret = ret.multiply(BigInteger.valueOf(cardinality - k))
                    .divide(BigInteger.valueOf(k + 1));
        }
        return ret;
    }

    void permute(List<Integer> sequence, int k) {
        for (int i = 0; i < sequence.size(); i++) {

            Collections.swap(sequence, i, k);
            permute(sequence, k + 1);
            Collections.swap(sequence, k, i);
        }


    }


}
