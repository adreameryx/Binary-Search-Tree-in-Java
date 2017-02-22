package lab9;

public class BinarySearchTree {


private Node root; 

    private static class Node {
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


    public void insert( int data ) {
        root = insert( root, data );
    }
// ** This is where we insert ** //
    
    
    
    public Node insert( Node node, int data ) {
        if( node == null ) {
            node = new Node( data );
        } else if( data < node.data ) {
            node.left = insert( node.left, data );
            node.left.parent = node;
        } else {
            node.right = insert( node.right, data );
            node.right.parent = node;
        }
        return node;
    }
    
    // ** Magic happens ^^ ** //

    private void swap( Node a, Node b ) {

        if( a.parent == null ) {
            root = b;
        } else if( a == a.parent.left ) {
            a.parent.left = b;
        } else {
            a.parent.right = b;
        }

        if( b != null ) {
            b.parent = a.parent;
        }
    }

    public void delete( int data ) {
        delete( root, data );
    }

    public void delete( Node node, int data ) {

        if( node == null ) {
            return;
        }
        else if ( data == node.data) {
            if( node.left == null ) {
                swap( node, node.right ); 
            }
            else if( node.right == null ) {
                swap( node, node.left );
            }
            else {
                Node minNode = node.right;
                while( minNode.left != null ) {
                    minNode = minNode.left;
                }
                if( minNode.parent != node ) {
                    swap( minNode, minNode.right );
                    minNode.right = node.right;
                    minNode.right.parent = minNode;
                }

                swap( node, minNode );
                minNode.left = node.left;
                minNode.left.parent = minNode;
            }
        } 
        // Continue searching in the left subtree.
        else if( data < node.data) {
            delete( node.left, data );
        } 
        // Continue searching in the right subtree.
        else {
            delete( node.right, data );
        }
    }

    public boolean lookup( int data ) {
        return lookup( root, data );
    }

    public boolean lookup( Node node, int data ) {
        if( node == null ) {
            // Can't find it.
            return false;
        } else if( data == node.data) {
            // Found it.
            return true;
        } else if( data < node.data) {
            // Search left subtree.
            return lookup( node.left, data );
        } else {
            // Search right subtree.
            return lookup( node.right, data );
        }
    }

    public int minValue( ) {
        return minValue( root );
    }

    public int minValue( Node node ) {
        Node cursor = node;
        while( cursor.left != null ) {
            cursor = cursor.left;
        }
        return cursor.data;
    }

    public int maxValue( ) {
        return maxValue( root );
    }

    public int maxValue( Node node ) {
        Node cursor = node;
        while( cursor.right != null ) {
            cursor = cursor.right;
        }
        return cursor.data;
    }

    public void inorderTraversal( ) {
        inorderTraversal( root );
    }

    private void inorderTraversal( Node node ) {
        if( node != null ) {
            inorderTraversal( node.left );
            System.out.print( node.data + " " );
            inorderTraversal( node.right );
        }
    }
}