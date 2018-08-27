package com.eduonix.design;

/**
 * Created by ubu on 8/8/2016.
 */
public class LabSoln1 {


    public static void main(String[] args) {
        int sequence1[] = {2, 1, 4, 5};
        int sequence2[] = {3, 9, 5, 8};
        solution(sequence1, sequence2 );

    }

    public static void sortOnEndpoints(int endpoints[], int startpoints[]){

        for (int i = 1; i <= endpoints.length; i++) {

            int count = i;

            for(int j = i+1; j < endpoints.length; j++){

                if(endpoints[count] > endpoints[j]){
                    int t = endpoints[count];
                    int t2 = startpoints[count];
                    endpoints[count] = endpoints[j];
                    startpoints[count] = startpoints[j];
                    endpoints[j] = t;
                    startpoints[j] = t2;
                }

            }

        }

        for (int Item : startpoints){
            System.out.print(Item+" ");
        }
        System.out.println();
        for (int Item : endpoints){
            System.out.print(Item+" ");
        }
        System.out.println();
    }

    public static void solution(int[] start, int[] end) {

        sortOnEndpoints(end, start);
        // first sort the arrays as endpoints is not ordered
        int prevEnd = end[0];
        if(start[1] > prevEnd) {
            System.out.print("( " + start[0] + " : " + prevEnd + " )");
        }
        for (int i = 1; i < start.length; i++) {

            if (start[i] >= prevEnd) {
                System.out.print("( " + start[i] + " : " + end[i] + " )");
                prevEnd = end[i];
            } else {
                prevEnd = end[i];
            }
        }
    }
}
