package com.eduonix.iterations;


import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by ubu on 7/12/2016.
 */
public class Iterations3 {

    public static void main(String[] args) {

        Iterations3 runner = new Iterations3();
        //runner.example1();
        //  runner.example2();


    }

    private void example1() {
        Integer[] intKeys = new Integer[]{0, 1, 2, 3, 4};
        String[] stringValues = new  String[]{"one","two","three","four"};

        Map<Integer, String> map = new HashMap<>();

        int counter = 0;
        for(Integer iBoxed: intKeys) {
            map.put(iBoxed, stringValues[counter++]) ;
        }
        System.out.print(map);

        Set<Integer> keys  = map.keySet();
        Collection<String> values = map.values();
        if(values instanceof List) {
            System.out.print("values is a list");
        }
        List  valuesList = new ArrayList(values);

        for(Map.Entry<Integer, String> entry: map.entrySet()) {
            System.out.print(entry.getKey()+"/"+entry.getValue());
        }

    }
    // http://docs.oracle.com/javase/8/docs/api/java/util/stream/Collectors.html
    private void example2() {

        List<Model> resultSet  = createModelList().stream().map(Model::copy).collect(Collectors.toList());

        List<String> projectionResultSet = createModelList().stream().map(Model::getField1).collect(Collectors.toList());

        Set<String> set =  createModelList().stream().map(Model::getField1).collect(Collectors.toCollection(TreeSet::new));

        String joined = createModelList().stream().map(Object::toString).collect(Collectors.joining(", "));

        int total = createModelList().stream().collect(Collectors.summingInt(Model::getLength));

        Map<String, List<Model>> byField1 = createModelList().stream().collect(Collectors.groupingBy(Model::getField1));



    }

    private  List<Model> createModelList() {
        List<Model> resultSet = new LinkedList<>();
        resultSet.add(new Model("f1", "f2"));
        resultSet.add(new Model("g1", "g2"));
        resultSet.add(new Model("h1", "h2"));
        return resultSet;

    }


    class Model {
        String field1;
        String field2;

        public Model(String field1, String field2) {
            this.field1 = field1;
            this.field2 = field2;
        }

        public Model copy() {
            return new Model(field1, field2);
        }
        public String getField1() {
            return field1;
        }

        public String getField2() {
            return field2;
        }

        public int getLength() {
            return toString().length();
        }
    }



}