package com.eduonix.design;

/**
 * greedy search
 */
public class Design_1 {

    public static void main(String[] args) {
        int sequence1[] = {2, 6, 14, 18, 18};
        int sequence2[] = {10, 12, 16, 18, 20};

        System.out.println(solution(sequence1, sequence2 ));
    }
        public static  int solution(int[] start, int[] end) {

            int result = 1;
            int prevEnd = end[0];

            /**
             * Iterate through the segments, picking whichever segments
             *  do not overlap with the previous segments checked by prevEnd <  start[i]
             */
            for (int i = 1; i < start.length; i++) {
                if (start[i] > end[i-1] || start[i] > prevEnd) {
                    result++;
                    prevEnd = end[i];
                }
            }
            return result;
        }

}
