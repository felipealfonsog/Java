package com.eduonix.trees;

/**
 * Created by ubu on 7/27/2016.
 */
public class Lab2Soln {

    public static void main(String[] args) {

        BSTree<Integer> tree = new BSTree<>( );

        for(int k = 0; k < 10; k++) {
            if(k ==7) {
                tree.insert( Integer.valueOf(40) );
                continue;
            }
            tree.insert( Integer.valueOf(k) );
        }

        System.out.println(tree.findMax( ));
        System.out.println(tree.findMin( ));
    }


   static class BSTree<T extends Comparable<? super T>> {
       private TreeNode<T> rootNode;

       public BSTree( )  {
           rootNode = null;
       }
       public void insert( T data)  {
           rootNode = insert(data, rootNode);
       }

       public  Integer  findMax( ) {
           Integer max = (Integer) findMax( rootNode ).element;
           return max;
       }

       public  Integer  findMin( ) {
           Integer min = (Integer) findMin( rootNode ).element;
           return min;
       }

       private TreeNode<T> findMax( TreeNode<T> node ) {
           if( node != null )
               while( node.right != null )
                   node = node.right;
           return node;
       }



       private TreeNode<T> findMin( TreeNode<T> node) {

//           if( node != null )
//               while( node.left != null )
//                   node = node.left;
//           return node;

           if( node == null )
               return null;
           else if( node.left == null )
               return node;
           return findMin( node.left );



       }



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
