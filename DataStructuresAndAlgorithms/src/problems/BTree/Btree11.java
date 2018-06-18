/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problems.BTree;

/**
 *
 * @author Sanatt Abrol
 * GFG problem https://practice.geeksforgeeks.org/problems/make-binary-tree/1
 */
/*class Tree{
int data;
Tree left;
Tree right;
Tree(int d){
	data=d;
	left=null;
	right=null;
}
}
class Node {
    int data;
    Node next;
    Node(int d) {
        data = d;
        next = null;
    }
}*/
class GfG{
	public static Tree convert(Node head,Tree node){
    //add code here.}
     Queue<Tree> q = new LinkedList<Tree>();
  
        // Base Case
        if (head == null) 
        {
            node = null; 
            return null;
        }
  
        node = new Tree(head.data);
        q.add(node);
  
        head = head.next;
  
        while (head != null) 
        {
            Tree parent = q.peek();
            Tree pp = q.poll();
              
            Tree leftChild = null, rightChild = null;
            leftChild = new Tree(head.data);
            q.add(leftChild);
            head = head.next;
            if (head != null) 
            {
                rightChild = new Tree(head.data);
                q.add(rightChild);
                head = head.next;
            }
  
            parent.left = leftChild;
            parent.right = rightChild;
        }
          
        return node;
}
