package com.eduonix.timecomplexity;


import java.util.Random;
import java.util.stream.IntStream;

/**
 * Created by ubu on 7/12/2016.
 */
public class TimeComplexity2 {

    public static void main(String[] args) {
        TimeComplexity2 runner = new TimeComplexity2();
        int[] sequence1 =  {-7, 1, 5, 2, -4, 3, 0};
        int[] sequence2 = new int[]{3, 1, 2, 4,  3};

        runner.arrayOperations1(sequence1);

        int optimalDiff =  runner.arrayOperations2(sequence2);
        System.out.println(optimalDiff);

        Random random = new Random();
        IntStream intStream = random.ints(0, 100);
        int[] sequence = intStream.limit(100).toArray();
        runner.arrayOperationsSort(sequence);

    }

    public void arrayOperations1(int[] sequence) {

        int totalSum = 0;

        for (int i = 0; i < sequence.length; i++) {
            totalSum += sequence[i];
        }

        int runningSum = 0;

        for (int i = 0; i < sequence.length; i++) {
            int n = sequence[i];
            totalSum -= n;
            if(runningSum == totalSum ) {
                System.out.println(i);
            }

            runningSum += n;
        }
    }



    public int arrayOperations2(int[] sequence) {
        long rightSum = 0;
        long leftSum = 0;
        long result = 0;

        for (int i = 1; i < sequence.length; i++)
            rightSum += sequence[i];

        leftSum = sequence[0];

        result = Math.abs(leftSum - rightSum);

        for (int counter = 1; counter < sequence.length - 1; counter++) {

            leftSum += sequence[counter];
            rightSum -= sequence[counter];

            if(Math.abs(leftSum - rightSum) < result ) {
                result = Math.abs(leftSum - rightSum);

            }

        }

        return (int) result;
    }

   void arrayOperationsSort(int[] sequence) {

       for (int i = 0; i < sequence.length; i++) {

           int select = 1;

           for (int j = i + 1; j < sequence.length -1; j++) {
               if(sequence[select] >  sequence[j] ) {
                   select = j;
               }

               int holder = sequence[i];
               sequence[i] = sequence[select];
               sequence[select] = holder;
           }

       }

       for(int element : sequence ) {
           System.out.print(element+" ");

       }

   }


}
