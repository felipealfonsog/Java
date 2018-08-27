package com.eduonix.iterations;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.stream.IntStream;

/**
 * Created by ubu on 7/12/2016.
 */
public class Lab1Solution2 {

    public static void main(String[] args) {
        int  len = 10000;
        LinkedList queue = new LinkedList();
        ArrayList arrayLst = new ArrayList();
        for (int m =0; m!= len; m++) {
            int x = (int)Math.random();
            queue.add(x);

        }

        long t = System.currentTimeMillis();
        for (int i = 0; i!=len; i++) {
            queue.get(i);
        }
        t = System.currentTimeMillis() - t;
        System.out.println("LinkedList -- get(index) takes "+t +"(ms)");

        t = System.currentTimeMillis();
        for  (Iterator itr = queue.iterator();
              itr.hasNext();) {
            itr.next();
        }
        t = System.currentTimeMillis() - t;
        System.out.println("LinkedList -- Iterator takes "+t +"(ms)");
    }

}
