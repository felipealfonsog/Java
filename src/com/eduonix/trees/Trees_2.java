package com.eduonix.trees;

import java.util.Random;

/**
 * Created by ubu on 7/27/2016.
 */
public class Trees_2 {

    public static void main(String[] args) {

        BSTree<Integer> tree = new BSTree<>( );
        Random intgen = new Random();

        for(int k = 0; k < 20; k++) {
            if(k%2 == 0) {
                tree.insert( Integer.valueOf(k) );
            } else {
                    tree.insert(  intgen.nextInt() );
            }

        }
        tree.printTree( );
        System.out.println();
        System.out.println(tree.lookup(8));
        System.out.println(tree.height());
        System.out.println(tree.maxDepth());

    }

   static class BSTree<T extends Comparable<? super T>> {
       private TreeNode<T> rootNode;

       public BSTree( )  {
           rootNode = null;
       }

       public void insert( T data)  {
           rootNode = insert(data, rootNode);
       }
       public boolean lookup(T data) {
           return lookup(data, rootNode );
       }
       public void printTree( ) {

           printTree(rootNode);
       }

       // recursive
       public int height() {
           return(size(rootNode));
       }

       // recursive
       public int maxDepth() {
           return(maxDepth(rootNode));
       }

       // recursive helper function for 'maxDepth'
       private int maxDepth(TreeNode node) {
           if (node==null) {
               return(0);
           }
           else {
               int lDepth = maxDepth(node.left);
               int rDepth = maxDepth(node.right);

               // use the larger + 1
               return(Math.max(lDepth, rDepth) + 1);
           }
       }

       // recursive helper function for 'insert'
       private int size(TreeNode node) {
           if (node == null) return(0);
           else {
               return(size(node.left) + 1 + size(node.right));
           }
       }
       // recursive helper function for 'height'
       private TreeNode<T> insert(T data, TreeNode<T> node) {
           if( node == null )
               return new TreeNode<>(data, null, null );

           int compareResult = data.compareTo( node.element );

           if( compareResult < 0 )
               node.left = insert(data, node.left );
           else if( compareResult > 0 )
               node.right = insert(data, node.right );
           else
               ;  // Duplicate; do nothing
           return node;
       }

       private boolean lookup(T data, TreeNode<T> node) {
           if( node == null )
               return false;

           int compareResult = data.compareTo( node.element );

           if( compareResult < 0 )
               return lookup(data, node.left );
           else if( compareResult > 0 )
               return lookup(data, node.right );
           else
               return true;    // Match
       }

       private void printTree( TreeNode<T> node) {
           if( node != null ) {
               printTree( node.left );
               System.out.print( node.element+" : " );
               printTree( node.right );
           }
       }

   }


    static class TreeNode<E>  {
        // Constructors
        TreeNode(E element)  {
            this(element, null, null );
        }

        TreeNode(E element, TreeNode<E> lt, TreeNode<E> rt ) {
            this.element = element;
            left     = lt;
            right    = rt;
        }

        E element;            // The data in the node
        TreeNode<E> left;   // Left child
        TreeNode<E> right;  // Right child
    }



}
