package com.eduonix.trees;

/**
 * Created by ubu on 7/26/2016.
 */
public class Trees_1 {

    public static void main(String[] args) {

//        int sequence[] = {1, 3, 4, 8 , 6 };
//        System.out.println(binarysearch(sequence, 6));

        HashTable table = new HashTable();
        int hashKey = table.put(27, 56);
        System.out.println("hashKey " + hashKey);
        System.out.println(table.get(27));

        hashKey = table.put(2700, 56);
        System.out.println("hashKey " + hashKey);
        System.out.println(table.get(2700));

    }

    static int binarysearch(int[] sequence, int value) {
        int low = 0;
        int high = sequence.length;

        while (high >= low) {
            int mid = (low + high) / 2;

            if (sequence[mid] > value) {
                high = mid - 1;

            } else if (sequence[mid] < value) {
                low = mid + 1;

            }
            if (sequence[mid] == value) {
                return mid;
            }
        }
        return -1;
    }

    static class HashTable {
        private final static int NUM_BUCKETS = 128;

        Bucket[] buckets;

        HashTable() {
            buckets = new Bucket[NUM_BUCKETS];
            for (int i = 0; i < NUM_BUCKETS; i++)
                buckets[i] = null;
        }

        public int get(int key) {
            int hash = (key % NUM_BUCKETS);
            while (buckets[hash] != null && buckets[hash].getKey() != key)
                hash = (hash + 1) % NUM_BUCKETS;
            if (buckets[hash] == null)
                return -1;
            else
                return buckets[hash].getValue();
        }

        public int put(int key, int value) {
            // create and compress the hash
            int hash = (key % NUM_BUCKETS);
            // deal with collisions
            while (buckets[hash] != null && buckets[hash].getKey() != key)
                hash = (hash + 1) % NUM_BUCKETS;

            buckets[hash] = new Bucket(key, value);
            return hash;
        }
    }


    static class Bucket {
        private int key;
        private int value;

        Bucket(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public int getKey() {
            return key;
        }

        public int getValue() {
            return value;
        }
    }


}
