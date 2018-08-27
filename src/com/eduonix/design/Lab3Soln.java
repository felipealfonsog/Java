package com.eduonix.design;

/**
 * Created by ubu on 8/10/2016.
 */
public class Lab3Soln {


    public static void main(String[] args) {
        int simpleInversion[] =  {6, 7, 1, 2, 3, 4, 5};
        System.out.println("simpleInversion "+
                new Lab3Soln()
                        .findUniqueInversions(simpleInversion, 0, simpleInversion.length-1));

        int simpleRepeatInversion[] =  {2, 2, 1, 2};
        System.out.println("simpleRepeatInversion "+
                new Lab3Soln()
                        .findUniqueInversions(simpleRepeatInversion, 0,
                                simpleRepeatInversion.length-1));


        int complexRepeatInversion[] =  {3, 2, 3, 4, 4, 4, 4, 5, 3, 3};
        System.out.println("complexRepeatInversion "+
                new Lab3Soln().findUniqueInversions(complexRepeatInversion, 0,
                        complexRepeatInversion.length-1));


    }


    int findUniqueInversions(int sequence[], int recursiveLow, int recursiveHigh){


        if(recursiveHigh < recursiveLow)
            return sequence[0];

        if(recursiveHigh == recursiveLow)
            return sequence[recursiveLow];

        int mid = (recursiveLow + recursiveHigh)/2;

        //if mid value is the minimum element
        if(mid < recursiveHigh && (sequence[mid] < sequence[mid+1] && sequence[mid] < sequence[mid-1]))
            return sequence[mid];

        if(sequence[mid] == sequence[recursiveLow] && sequence[mid] == sequence[recursiveHigh])
            return min(findUniqueInversions(sequence, recursiveLow, mid-1), findUniqueInversions(sequence, mid+1, recursiveHigh));

        if(sequence[mid] < sequence[recursiveHigh])
            return findUniqueInversions(sequence, recursiveLow, mid-1);
        else
            return findUniqueInversions(sequence, mid+1, recursiveHigh);
    }

    int min(int x, int y) { return (x < y)? x :y; }

}
