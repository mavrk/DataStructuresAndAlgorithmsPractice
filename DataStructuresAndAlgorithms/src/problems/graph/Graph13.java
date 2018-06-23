/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problems.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Stack;

/**
 *
 * @author Sanatt Abrol
 * GFG problem https://practice.geeksforgeeks.org/problems/circle-of-strings/0
 */

class Edge {
    boolean visited;
    char v;
    Edge(char v){
        this.v = v;
        this.visited = false;
    }

    @Override
    public String toString() {
        return "Edge{" + visited + "," + v + '}';
    }    
}

class Node {
    char u, v;
    Node(char u, char v){
        this.u = u;
        this.v = v;
    }
}

public class Graph13 {
    
    static boolean visited[];
    static Node[] input;
    static Stack<Node> st;
    static int V;
    
    static boolean DFS(Node first){
        if(st.size() == V){
            if(st.peek().v == first.u)
                return true;
        } else {
            Node n = st.peek();
            for(int i = 0; i < V; i++){
                if(!visited[i] && n.v == input[i].u){
                    visited[i] = true;
                    st.push(input[i]);
                    if(DFS(first))
                        return true;
                    st.pop();
                    visited[i] = false;
                }
            }
        }        
        return false;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();
            V = n;
            input = new Node[n];
            visited = new boolean[n];
            for(int i = 0; i < n; i++){
                String s = sc.next();
                input[i] = new Node(s.charAt(0), s.charAt(s.length() - 1));
            }
            st = new Stack();
            Node first = input[0];
            visited[0] = true;
            st.push(first);
            System.out.println(DFS(first) ? 1 : 0);
        }
        
    }
}
