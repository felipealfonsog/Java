package com.eduonix.stacks_queues;

import java.util.LinkedList;
import java.util.Queue;

/**
 */
public class Stacks_Queues2 {


    public static void main(String[] args) {

        SimpleQueue<String> simpleQueue = new SimpleQueue<String>();
        simpleQueue.enqueue("front of the queue");
        System.out.println(simpleQueue.dequeue());
    }




    void javaQue() {
        LinkedList queueAsList = new LinkedList();

        Queue queue = new LinkedList();

    }


    static class SimpleQueue<T>  {
        private Node<T> front;
        private Node<T> back;


        public SimpleQueue() {
            front = null;
            back = null;

        }

        public boolean isEmpty() {
            return front == null;
        }

        // go to the back of the queue
        public void enqueue(T obj) {
            Node<T> oldBack = back;
            back = new Node<T>();
            back.payload = obj;
            back.next = null;
            if (isEmpty()) front = back;
            else           oldBack.next = back;

        }

        public T dequeue() {
            if (isEmpty()) throw new RuntimeException("SimpleMultiSet is empty!");
            T item = front.payload;
            front = front.next;
            if (isEmpty()) back = null;
            return item;
        }

    }

    static class Node<V> {
        private V payload;
        private Node<V> next;
    }

}
