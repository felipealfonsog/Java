package com.eduonix.iterations;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by ubu on 7/12/2016.
 */
public class Iterations2 {

    public static void main(String[] args) {

        Iterations2 runner = new Iterations2();
        //runner.example1();
        //  runner.example2();


    }

    private void example1() {
        Integer[] intArray = new Integer[]{0, 1, 2, 3, 4};
        int[] intArray2 = new int[100];

        List<Integer> fixedSizeList = Arrays.asList(intArray);
        //fixedSizeList.add(1);
        List<Integer> dynamicList = new ArrayList<>();
        dynamicList.addAll(Arrays.asList(intArray));
        dynamicList.add(1);

        int[] intArray3 = new int[]{0, 1, 2, 3};

        List<Integer> dynamicList3 = Arrays.stream(intArray3)
                .boxed()
                .collect(Collectors.toList());

        dynamicList3.add(4);

        for (int k = 0; k <= dynamicList.size(); k++)
            System.out.println(dynamicList.get(k));

        for(Integer index: dynamicList)
            System.out.println(index);

        dynamicList3.forEach(s -> System.out.println(s));
    }

    private void example2() {
        Integer[] intArray = new Integer[]{0, 1, 2, 3, 4};
        List<Integer> dynamicList = new ArrayList<>();
        dynamicList.addAll(Arrays.asList(intArray));
        dynamicList.add(1);

        for (int k = 0; k <= dynamicList.size(); k++) {
          if(k==1) {
              dynamicList.remove(1)  ;
          }
        }

        for(Integer i: dynamicList) {
            if(i.intValue()==1) {
                dynamicList.remove(1)  ;
            }
        }


        Iterator itr = dynamicList.iterator();
        while(itr.hasNext()) {
            if((Integer)itr.next()==1) {
                itr.remove();
            }
        }

        System.out.println(dynamicList);
        List<Integer> queue = new LinkedList<>();
        Set<Long> dynamicSet = new HashSet<>();
        Iterator queueItr = dynamicList.iterator();
        Iterator setItr = dynamicSet.iterator();
    }


}