/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problems.graph;

import java.util.LinkedList;

/**
 *
 * @author Sanatt Abrol
 */
public class Graph {
    int V;
    LinkedList<Integer> alist[];
    boolean visited[];
    Graph(int V){
        this.V = V;
        this.alist = new LinkedList[V];
        for(int i = 0; i < V; i++)
            alist[i] = new LinkedList<Integer>();
        this.visited = new boolean[V];
    }
    
    void addPath(int u, int v){
        if(u >= V)
            return;
        alist[u].add(v);
    }
    
    void addPath(char u, char v){
        alist[u - 'A'].add(v - 'A');
    }
}
