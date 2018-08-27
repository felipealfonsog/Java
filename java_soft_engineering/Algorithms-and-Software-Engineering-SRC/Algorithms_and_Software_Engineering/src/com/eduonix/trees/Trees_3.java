package com.eduonix.trees;

import java.util.Random;

/**
 * Created by ubu on 7/27/2016.
 *
 * https://en.wikipedia.org/wiki/AVL_Trees_in_Java
 */
public class Trees_3 {

    public static void main(String[] args) {

        AVLTree<Integer> tree = new AVLTree<>( );
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



    }

   static class AVLTree<T extends Comparable<? super T>> {
       private TreeNode<T> rootNode;

       private static final int ALLOWED_IMBALANCE = 1;

       public AVLTree( )  {
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


       private TreeNode<T> insert(T data, TreeNode<T> node) {
           if( node == null )
               return new TreeNode<>(data, null, null );

           int compareResult = data.compareTo( node.element );

           if( compareResult < 0 )
               node.left = insert(data, node.left );
           else if( compareResult > 0 )
               node.right = insert(data, node.right );
           else ;  // Duplicate; do nothing
           return balance( node );
       }

       // Assume node is either balanced or within one of being balanced
       private TreeNode<T> balance( TreeNode<T> node)
       {
           if( node == null )
               return null;

           if( height( node.left ) - height( node.right ) > ALLOWED_IMBALANCE )
               if( height( node.left.left ) >= height( node.left.right ) )
                   node = rotateWithLeftChild(node);
               else
                   node = doubleWithLeftChild(node);
           else
           if( height( node.right ) - height( node.left ) > ALLOWED_IMBALANCE )
               if( height( node.right.right ) >= height( node.right.left ) )
                   node = rotateWithRightChild(node);
               else
                   node = doubleWithRightChild(node);

           node.height = Math.max( height( node.left ), height( node.right ) ) + 1;
           return node;
       }

       private int height( TreeNode<T> node)  {
           return node == null ? -1 : node.height;
       }

       private TreeNode<T> rotateWithLeftChild( TreeNode<T> nodeToRotate) {
           TreeNode<T> balanceNode = nodeToRotate.left;
           nodeToRotate.left = balanceNode.right;
           balanceNode.right = nodeToRotate;
           nodeToRotate.height = Math.max( height( nodeToRotate.left ), height( nodeToRotate.right ) ) + 1;
           balanceNode.height = Math.max( height( balanceNode.left ), nodeToRotate.height ) + 1;
           return balanceNode;
       }

       private TreeNode<T> rotateWithRightChild( TreeNode<T> k1 ) {
           TreeNode<T> k2 = k1.right;
           k1.right = k2.left;
           k2.left = k1;
           k1.height = Math.max( height( k1.left ), height( k1.right ) ) + 1;
           k2.height = Math.max( height( k2.right ), k1.height ) + 1;
           return k2;
       }

       private TreeNode<T> doubleWithLeftChild( TreeNode<T> k3 )  {
           k3.left = rotateWithRightChild( k3.left );
           return rotateWithLeftChild( k3 );
       }

       private TreeNode<T> doubleWithRightChild( TreeNode<T> k1 ) {
           k1.right = rotateWithLeftChild( k1.right );
           return rotateWithRightChild( k1 );
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
            height   = 0;
        }

        E element;            // The data in the node
        TreeNode<E> left;   // Left child
        TreeNode<E> right;  // Right child
        int height;         // Height
    }



}
