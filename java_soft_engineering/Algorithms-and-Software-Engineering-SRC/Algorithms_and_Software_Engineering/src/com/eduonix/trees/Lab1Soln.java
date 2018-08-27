package com.eduonix.trees;

/**
 * Created by ubu on 7/26/2016.
 */
public class Lab1Soln {

    public static void main(String[] args) {
        int sequence[] = {4, 1, 7 , 3,  4,  1,  2};
        System.out.println(findMinSum(3,  sequence ));

    }

    public static int findMinSum(int numBlocks,  int[] sequence) {
            //largest number in sequence as the minimisation optimisation
            int minimisation = 0;
            int sum = 0;

            for (int i = 0; i < sequence.length; i++) {
                sum += sequence[i];
                minimisation = Math.max(minimisation, sequence[i]);
            }
            int optimisation = sum;
            while (minimisation <= sum) {
                int mid = (minimisation + sum) / 2;
                // if (sequence[mid] > value)
                if (divisionSolvable(mid, numBlocks - 1, sequence)) {
                    sum = mid - 1;
                    optimisation = mid;
                }
                // sequence[mid] < value
                else {
                    minimisation = mid + 1;
                }
            }
            return optimisation;
        }

        // test the binary condition
        private static boolean divisionSolvable(int mid, int k, int[] sequence) {
            int sum = 0;
            for (int i = 0; i < sequence.length; i++) {
                sum += sequence[i];
                if (sum > mid) {
                    sum = sequence[i];
                    k--;
                }
                if (k < 0) {
                    return false;
                }
            }
            return true;
        }
    }