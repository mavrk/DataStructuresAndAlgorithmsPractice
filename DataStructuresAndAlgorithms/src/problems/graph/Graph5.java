/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problems.graph;

/**
 *
 * @author Sanatt Abrol
 */
/*package whatever //do not write package name here */

import java.util.*;

public class Graph5 {
    
    int findNumOfPaths(int u, int v, LinkedList<Integer>[] alist){
        int count = 0;
        Queue<Vector<Integer>> q = new LinkedList<Vector<Integer>>();
        Vector<Integer> path = new Vector<Integer>();
        path.add(u);
        q.add(path);
        while(!q.isEmpty()){
            path = q.poll();
            int last = path.get(path.size() - 1);
            if(last == v)
                count++;
            for(Integer i : alist[last]){
                if(!path.contains(i)){
                    Vector<Integer> newPath = new Vector<Integer>(path);
                    newPath.add(i);
                    q.add(newPath);
                }
            }
        }
        return count;
    }
    
    public static void main (String[] args) {
		//code
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- > 0){
		    int V = sc.nextInt();
		    int E = sc.nextInt();
		    LinkedList<Integer>[] alist = new LinkedList[V];
		    for(int i = 0; i < V; i++)
		        alist[i] = new LinkedList<Integer>();
		    for(int i = 0; i < E; i++)
		        alist[sc.nextInt()].add(sc.nextInt());
	        boolean[] visited = new boolean[V];
	        Graph5 g = new Graph5();
	        System.out.println(g.findNumOfPaths(sc.nextInt(), sc.nextInt(), alist));    
		}
	}
}
