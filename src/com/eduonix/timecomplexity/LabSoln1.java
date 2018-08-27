package com.eduonix.timecomplexity;

/**
 * Created by ubu on 7/12/2016.
 */
public class LabSoln1 {

    public static void main(String[] args) {
        double term = 0.0, seriesSum= 0.0;
        int power = 1;
        int  limit = 11;
        double radians = 0.7;
        double co_eff = 1.0;

        while(power <= limit) {
            term = Math.pow(radians, power )/factorial(power);
            seriesSum += co_eff*term;
            power += 2;
            co_eff= -co_eff;

        }

        System.out.println("series sum " + seriesSum );
        System.out.println("Java math sin("+ radians+ ") = " + Math.sin(radians));

    }





    public static double factorial(int limit) {

        double num = limit;
        while(--limit > 1)
            num *= limit;

        return num;

    }

}
