/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problems.BTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 *
 * @author Sanatt Abrol
 */
class Node {

    int data;
    Node left, right;

    public Node(int data) {
        this.data = data;
        left = right = null;
    }
}

class BinaryTree {

    Node root;

    BinaryTree() {
    }
    
    void printSpecialOrder(Node root){
        Stack<Integer> st = new Stack<Integer>();
        Queue<Node> q = new LinkedList<Node>();
        q.add(root.right);
        q.add(root.left);
        st.add(root.data);
        while(!q.isEmpty()){
            Node one = q.poll();
            Node two = q.poll();
            st.add(one.data);
            st.add(two.data);
            if(one.left != null){
                q.add(one.left);
                q.add(two.right);
                q.add(one.right);
                q.add(two.left);
            }
        }
        
        while(!st.isEmpty())
            System.out.print(st.pop() + " ");
    }
}

public class BTree1 {

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
  
        tree.root.left.left.left.left  = new Node(16);
        tree.root.left.left.left.right  = new Node(17);
        tree.root.left.left.right.left  = new Node(18);
        tree.root.left.left.right.right  = new Node(19);
        tree.root.left.right.left.left  = new Node(20);
        tree.root.left.right.left.right  = new Node(21);
        tree.root.left.right.right.left  = new Node(22);
        tree.root.left.right.right.right  = new Node(23);
        tree.root.right.left.left.left  = new Node(24);
        tree.root.right.left.left.right  = new Node(25);
        tree.root.right.left.right.left  = new Node(26);
        tree.root.right.left.right.right  = new Node(27);
        tree.root.right.right.left.left  = new Node(28);
        tree.root.right.right.left.right  = new Node(29);
        tree.root.right.right.right.left  = new Node(30);
        tree.root.right.right.right.right  = new Node(31);
        
        tree.printSpecialOrder(tree.root);
    }
}
