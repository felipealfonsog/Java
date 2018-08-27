package com.eduonix.stacks_queues;

import java.util.*;

/**
 * Created by ubu on 7/13/2016.
 */
public class Lab3Soln {

    public static final int WELL_FORMED = 1;
    public static final int MAL_FORMED = 0;


    public static void main(String[] args) {
        Lab3Soln runner = new Lab3Soln();

        String  string1 = "{[()]}";
        String  string2 = "{(()])";
        System.out.println();
        System.out.println(runner.isWellFormed(string1));
        System.out.println( runner.isWellFormed(string2));

    }

    public int isWellFormed(String expression) {
        if (expression.isEmpty()) return WELL_FORMED;
        java.util.Stack stack = new java.util.Stack();
        WellFomParser util = new WellFomParser();

        for (char c: expression.toCharArray()) {
            if (stack.isEmpty()){
                if (util.isOpener(c)) {
                    stack.push(c);
                } else {
                    return MAL_FORMED;
                }
            } else {
                if(util.isOpener(c)) {
                    stack.push(c);
                } else if(util.getOpenerForGivenCloser(c) == stack.peek()){
                    stack.pop();
                } else {
                    return MAL_FORMED;
                }
            }
        }

        return stack.isEmpty() ? WELL_FORMED : MAL_FORMED;
    }

    public static class WellFomParser {
        private Map<Character, Character> language = new HashMap<Character, Character>(){{
            put(')','(');
            put(']','[');
            put('}','{');
        }};

        public boolean isOpener(Character c) {
            return language.values().contains(c);
        }

        public Character getOpenerForGivenCloser(Character closer) {
            return language.get(closer);
        }
    }

}

