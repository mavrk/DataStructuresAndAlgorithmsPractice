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
import java.lang.*;
import java.io.*;



public class Graph8 {
    
    static int[] row = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] col = {-1, 0, 1, -1, 1, -1, 0, 1};
	
	static int[][] M;
	static boolean[][] visited;
	
	static boolean isSafe (int x, int y, int n, int m){
	    return (x > -1) && (y > -1) && (x < n) && (y < m) && (M[x][y] != 0) && (!visited[x][y]); 
	}
	
	public static void main (String[] args) {
		//code
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- > 0){
		    int n = sc.nextInt();
		    int m = sc.nextInt();
		    M = new int[n][m];
		    visited = new boolean[n][m];
		    for(int i = 0; i < n; i++){
		        for(int j = 0; j < m; j++){
		            M[i][j] = sc.nextInt();
		            visited[i][j] = false;
		        }
		    }
		    
		    int max = Integer.MIN_VALUE;
		    
		    for(int i = 0; i < n; i++){
		        for(int j = 0; j < m; j++){
		            if(M[i][j] == 0)
		                continue;
		            if(visited[i][j])
		                continue;
		            //now DFS
		            Stack<Point> st = new Stack<Point>();
		            st.push(new Point(i,j));
                            visited[i][j] = true;
		            int count = 0;
		            while(!st.isEmpty()){
		                Point p = st.pop();
		                count++;
                                System.out.println("Popped " + p.x + "," + p.y + "    count " + count);
		                int x, y;
		                //see all possible neighbors
		                for(int k = 0; k < 8; k++){
		                    x = p.x + row[k];
		                    y = p.y + col[k];
		                    if(isSafe(x, y, n, m)){
		                        st.push(new Point(x, y));
		                        visited[x][y] = true;
		                    }
		                }
		            }
		            max = Math.max(max, count);
		        }
		    }
		    System.out.println(max);
		}
	}
}
