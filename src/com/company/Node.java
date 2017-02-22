package com.company;

/**
 * Created by oscarricaud on 2/22/17.
 */
public class Node {
        Node parent;
        Node left;
        Node right;
        int data;
        Node( int data ) {
            this.data = data;
        }

        @Override
        public String toString( ) {
            return "" + data;
        }
}
