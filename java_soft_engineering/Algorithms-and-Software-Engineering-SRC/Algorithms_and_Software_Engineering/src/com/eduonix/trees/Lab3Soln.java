package com.eduonix.trees;

/**
 * Created by ubu on 7/26/2016.
 */
public class Lab3Soln {

    public static void main(String[] args) {

           AVLTree<Integer> tree = new  AVLTree<>();

            for (int k = 0; k < 10; k++) {
                tree.insert(Integer.valueOf(k));
            }
            tree.printPaths();
        }

        static class AVLTree<T extends Comparable<? super T>> {
            private  TreeNode<T> rootNode;

            private static final int ALLOWED_IMBALANCE = 1;

            public AVLTree() {
                rootNode = null;
            }

            public void insert(T data) {
                rootNode = insert(data, rootNode);
            }

            public boolean lookup(T data) {
                return lookup(data, rootNode);
            }

            public void printTree() {

                printTree(rootNode);
            }


            public void printPaths() {
                int[] path = new int[1000];
                printPaths(rootNode, path, 0);
            }

            private void printPaths( TreeNode<T> node, int[] path, int pathIndex) {
                if (node == null) return;

                // append this node to the path array
                path[pathIndex] = (Integer) node.element;
                pathIndex++;

                // it's a leaf, so print the path that led to here
                if (node.left == null && node.right == null) {
                    printArray(path, pathIndex);
                } else {
                    // otherwise try both subtrees
                    printPaths(node.left, path, pathIndex);
                    printPaths(node.right, path, pathIndex);
                }
            }

            /**
             * Utility that prints ints from an array on one line.
             */
            private void printArray(int[] ints, int len) {
                int i;
                for (i = 0; i < len; i++) {
                    System.out.print(ints[i] + " ");
                }
                System.out.println();
            }


            private  TreeNode<T> insert(T data,  TreeNode<T> node) {
                if (node == null)
                    return new  TreeNode<>(data, null, null);

                int compareResult = data.compareTo(node.element);

                if (compareResult < 0)
                    node.left = insert(data, node.left);
                else if (compareResult > 0)
                    node.right = insert(data, node.right);
                else ;  // Duplicate; do nothing
                return balance(node);
            }

            // Assume t is either balanced or within one of being balanced
            private  TreeNode<T> balance( TreeNode<T> t) {
                if (t == null)
                    return t;

                if (height(t.left) - height(t.right) > ALLOWED_IMBALANCE)
                    if (height(t.left.left) >= height(t.left.right))
                        t = rotateWithLeftChild(t);
                    else
                        t = doubleWithLeftChild(t);
                else if (height(t.right) - height(t.left) > ALLOWED_IMBALANCE)
                    if (height(t.right.right) >= height(t.right.left))
                        t = rotateWithRightChild(t);
                    else
                        t = doubleWithRightChild(t);

                t.height = Math.max(height(t.left), height(t.right)) + 1;
                return t;
            }

            private int height( TreeNode<T> t) {
                return t == null ? -1 : t.height;
            }

            private  TreeNode<T> rotateWithLeftChild( TreeNode<T> k2) {
                TreeNode<T> k1 = k2.left;
                k2.left = k1.right;
                k1.right = k2;
                k2.height = Math.max(height(k2.left), height(k2.right)) + 1;
                k1.height = Math.max(height(k1.left), k2.height) + 1;
                return k1;
            }

            private  TreeNode<T> rotateWithRightChild( TreeNode<T> k1) {
                TreeNode<T> k2 = k1.right;
                k1.right = k2.left;
                k2.left = k1;
                k1.height = Math.max(height(k1.left), height(k1.right)) + 1;
                k2.height = Math.max(height(k2.right), k1.height) + 1;
                return k2;
            }

            private  TreeNode<T> doubleWithLeftChild( TreeNode<T> k3) {
                k3.left = rotateWithRightChild(k3.left);
                return rotateWithLeftChild(k3);
            }

            private  TreeNode<T> doubleWithRightChild( TreeNode<T> k1) {
                k1.right = rotateWithLeftChild(k1.right);
                return rotateWithRightChild(k1);
            }

            private boolean lookup(T data, TreeNode<T> node) {
                if (node == null)
                    return false;

                int compareResult = data.compareTo(node.element);

                if (compareResult < 0)
                    return lookup(data, node.left);
                else if (compareResult > 0)
                    return lookup(data, node.right);
                else
                    return true;    // Match
            }

            private void printTree( TreeNode<T> node) {
                if (node != null) {
                    printTree(node.left);
                    System.out.println(node.element);
                    printTree(node.right);
                }
            }


        }


        static class TreeNode<E> {
            // Constructors
            TreeNode(E element) {
                this(element, null, null);
            }

            TreeNode(E element,  TreeNode<E> lt, TreeNode<E> rt) {
                this.element = element;
                left = lt;
                right = rt;
                height = 0;
            }

            E element;            // The data in the node
            TreeNode<E> left;   // Left child
            TreeNode<E> right;  // Right child
            int height;       // Height
        }

    }