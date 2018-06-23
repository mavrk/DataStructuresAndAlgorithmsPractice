/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problems.graph;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 *
 * @author Sanatt Abrol
 */

public class PrimsMST {
    static int V;
    static LinkedList<Pair>[] alist;
    static PriorityQueue<Pair> minHeap;
    static void addEdge(int u, int v, int w){
        alist[u].add(new Pair(v,w));
        alist[v].add(new Pair(u,w));
    }
    
    public static void main(String[] args) {
        V = 9;
        alist = new LinkedList[V];
        //add edges
        addEdge(0,1,4);     addEdge(0,7,8);
        addEdge(1,2,8);     addEdge(1,7,11);
        addEdge(2,3,7);     addEdge(2,5,4);     addEdge(2,8,2);
        addEdge(3,5,14);    addEdge(3,4,9);     
        addEdge(4,5,10);
        addEdge(5,6,2);     
        addEdge(6,8,6);     addEdge(6,7,1);     
        addEdge(7,8,7);
        Comparator<Pair> comp = new Comparator<Pair>(){
            @Override
            public int compare(Pair p1, Pair p2){
                return p1.y - p2.y;
            }
        };
        //parent arr to store result
        int[] parent = new int[V];
        int[] key = new int[V];
        //minHeap & key arr
        minHeap = new PriorityQueue<Pair>(V,comp);
        minHeap.add(new Pair(0,0));
        key[0] = 0;
        for(int i = 1; i < V; i++){
            minHeap.add(new Pair(i, Integer.MAX_VALUE));
            key[i] = Integer.MIN_VALUE;
        }
        while(!minHeap.isEmpty()){
            Pair u = minHeap.poll();
            
            for(Pair p : alist[u.x]){
                if(minHeap.contains(p) && p.y < key[p.x]){
                    //update key
                    key[p.x] = p.y;
                    //update parent
                    parent[p.x] = u.x;
                    //update minHeap key also
                    
                }
            }
        }
        
    }
    
}
