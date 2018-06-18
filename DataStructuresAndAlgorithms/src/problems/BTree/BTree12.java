/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problems.BTree;

/**
 *
 * @author Sanatt Abrol
 */

public class BTree12 {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);

        tree.root.left.left  = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left  = new Node(6);
        tree.root.right.right = new Node(7);
  
        tree.root.left.left.left  = new Node(8);
        tree.root.left.left.right  = new Node(9);
        tree.root.left.right.left  = new Node(10);
        tree.root.left.right.right  = new Node(11);
        tree.root.right.left.left  = new Node(12);
        tree.root.right.left.right  = new Node(13);
        tree.root.right.right.left  = new Node(14);
        tree.root.right.right.right  = new Node(15);
    
        Node target = tree.root.left.left;
        
        new BTree12().printK(tree.root, target, 3 );
    }
    
    void printKDown(Node node, int k){
        if(node == null || k < 0)
            return;
        if(k == 0){
            System.out.print(node.data + " ");
            return;
        }
        printKDown(node.left, k - 1);
        printKDown(node.right, k - 1);
    }
    
    int printK(Node node, Node target, int k){
        if(node == null)
             return -1;
        if(node == target){
            printKDown(node, k);
            return 0;
        }
        
        int dl = printK(node.left, target, k);
        if(dl != -1){
            if(dl + 1 == k)
                System.out.print(node.data + " ");
            else
                printKDown(node.right,k - 2 - dl);
            return 1 + dl;
        }
        
        int dr = printK(node.right, target, k);
        if(dr != -1){
            if(dr + 1== k)
                System.out.print(node.data + " ");
            else
                printKDown(node.right, k - 2 - dr);
            return 1 + dr;
        }
        
        return -1;
    }
}
