package com.eduonix.stacks_queues;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by ubu on 7/12/2016.
 */
public class Stacks_Queues1 {

    public static void main(String[] args) {

        LinkedListStack<String> stack = new LinkedListStack<String>();
        stack.push(" top of the stack");
        System.out.println(stack.pop());

        javaStack();
    }


    static class LinkedListStack<T> {
        private ListNode<T> top;


        public LinkedListStack() {
            top = null;

        }

        public boolean isEmpty() {
            return top == null;
        }


        public void push(T obj) {
            ListNode<T> oldtop = top;
            top = new ListNode<T>();
            top.payload = obj;
            top.next = oldtop;

        }

        public T pop() {
            if (isEmpty()) throw new RuntimeException("SimpleMultiSet is empty!");
            T item = top.payload;
            top = top.next;
            return item;
        }

    }

    static class ListNode<V> {
        private V payload;
        private ListNode<V> next;
    }






    public static class ArrayListStack<T> {
        public List<T> stack;

        public ArrayListStack(int capacity) {
            stack = new ArrayList<>(capacity);
        }

        public void push(T item) {
            stack.add(item);
        }

        public T pop() {
            T item = peek();
            stack.remove(stack.size() - 1);
            return item;
        }

        public T peek() {
            int position = stack.size();
            T item = stack.get(position - 1);
            return item;
        }

        public boolean isEmpty() {
            return stack.isEmpty();
        }
    }



    
    static void javaStack() {

        Stack valStack = new  Stack();
        String token = "11+";
        char[] expression = token.toCharArray();
        int result = 0;
        for(char c :expression) {

            if (Character.isDigit(c)) {
                valStack.push( Integer.parseInt(String.valueOf(c)));
            } else {
                result = ((Integer) valStack.pop()).intValue();
                result += ((Integer) valStack.pop()).intValue();
            }
          }
        System.out.println(result);
        }

    }


