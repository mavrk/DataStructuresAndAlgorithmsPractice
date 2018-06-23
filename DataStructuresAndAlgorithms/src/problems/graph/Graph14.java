/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problems.graph;

/**
 *
 * @author Sanatt Abrol
 * https://practice.geeksforgeeks.org/problems/hamiltonian-path/0
 */
import java.util.*;
import java.lang.*;
import java.io.*;

public class Graph14 {
    public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		int tt=scn.nextInt();
		for(int t=0;t<tt;t++) {
			
			int n=scn.nextInt();
			int e=scn.nextInt();
			int[][] adj=new int[n+1][n+1];
			
			
			for(int i=0;i<e;i++) {
				int from=scn.nextInt();
				int to=scn.nextInt();
				
				adj[from][to]=1;
				adj[to][from]=1;
				
			}
			
			boolean[] visited=new boolean[n+1];
			Arrays.fill(adj[0], 1);
			if(checkhamiltonian(adj,visited,-1,0)) {
				System.out.println("1");
			}else {
				System.out.println("0");
			}
			
		}

	}
	
	public static boolean checkhamiltonian(int[][] adj,boolean[] visited,int visitcount,int vertex) {
		if(visitcount==adj.length-2)
		    return true;
		
		visited[vertex]=true;
		boolean ans=false;
		for(int i=1;i<adj.length;i++) {
			if(adj[vertex][i]==1 && !visited[i]) {
				ans|=checkhamiltonian(adj, visited, visitcount+1, i);
			}
		}
		visited[vertex]=false;
		return ans;
		
	}
}
