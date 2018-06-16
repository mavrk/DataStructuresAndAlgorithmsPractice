/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problems.BTree;

import java.util.ArrayList;

/**
 *
 * @author Sanatt Abrol
 */
    class Tree {

    Node root;

    Tree() {
    }

    public String serialize(Node root, ArrayList<Integer> aa) {
        String s = "";
        if (root == null) {
            return "#,";
        }
        s += root.data + ",";
        s += serialize(root.left, aa);
        s += serialize(root.right, aa);
        return s;
    }
    
    public Node deSerialize(String data){
        //data = data.substring(0, data.length()-2);
        String[] s = data.split(",");
        Node node = new Node(0);
        
        return create(node, s);
    }
    int i = 0;
    Node create(Node node, String[] s){
        if(i >= s.length)
            return null;
        String val = s[i++];
        System.out.println("val is " + val);
        if(val.equalsIgnoreCase("#"))
            return null;
        node = new Node(Integer.parseInt(val));
        System.out.println(node.data);
        create(node.left, s);
        create(node.right, s);
        return node;
    }
    
    void inorder(Node root){
        if(root == null)
            return;
        System.out.print(root.data + " ");
        inorder(root.left);
        inorder(root.right);
    }
}

public class BTree3 {

    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.root = new problems.BTree.Node(1);
        tree.root.left = new problems.BTree.Node(2);
        tree.root.right = new problems.BTree.Node(3);

        tree.root.left.left = new problems.BTree.Node(4);
        tree.root.left.right = new problems.BTree.Node(5);
        tree.root.right.left = new problems.BTree.Node(6);
        tree.root.right.right = new problems.BTree.Node(7);

//        tree.root.left.left.left  = new problems.BTree.Node(8);
//        tree.root.left.left.right  = new problems.BTree.Node(9);
//        tree.root.left.right.left  = new problems.BTree.Node(10);
//        tree.root.left.right.right  = new problems.BTree.Node(11);
//        tree.root.right.left.left  = new problems.BTree.Node(12);
//        tree.root.right.left.right  = new problems.BTree.Node(13);
//        tree.root.right.right.left  = new problems.BTree.Node(14);
//        tree.root.right.right.right  = new problems.BTree.Node(15);
        String data = tree.serialize(tree.root, new ArrayList<Integer>());
        System.out.println(data);
        
        Node node = tree.deSerialize(data);
        tree.inorder(node);
    }

}
