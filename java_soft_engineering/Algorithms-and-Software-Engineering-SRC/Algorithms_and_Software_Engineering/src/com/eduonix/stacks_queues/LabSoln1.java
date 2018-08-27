package com.eduonix.stacks_queues;

import java.util.Stack;
import java.util.StringTokenizer;

/**
 * Created by ubu on 7/13/2016.
 */
public class LabSoln1 {

    public static void main(String[] args) {
        String postfix = "11+";
        int value = evalPostfix(postfix);
        System.out.println("value: " + value);

        String postfix2 = "23*";
        int value2 = evalPostfix(postfix2);
        System.out.println("value2: " + value2);
    }

    public static int evalPostfix(String postfix) {
        char[] expression = postfix.toCharArray();
        Stack valStack = new Stack();
        for(char c :expression) {

            if (Character.isDigit(c)) {
                valStack.push(  Integer.parseInt(Character.toString(c)));
            } else {
                int rightVal = ((Integer) valStack.pop()).intValue();
                int leftVal = ((Integer) valStack.pop()).intValue();
                int rslt;

                switch (c) {
                    case '+':
                        rslt = leftVal + rightVal;
                        break;
                    case '-':
                        rslt = leftVal - rightVal;
                        break;
                    case '*':
                        rslt = leftVal * rightVal;
                        break;
                    case '/':
                        rslt = leftVal / rightVal;
                        break;
                    default:
                        throw new IllegalArgumentException("invalid postfix expression");
                }

                valStack.push(new Integer(rslt));
            }
        }

        int rslt = ((Integer) valStack.pop()).intValue();
        if (!valStack.empty()) {
            throw new IllegalArgumentException("invalid postfix expression");
        }

        return rslt;
    }

}
