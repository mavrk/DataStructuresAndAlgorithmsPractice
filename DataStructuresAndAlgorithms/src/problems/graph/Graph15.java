/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problems.graph;

import java.util.Scanner;

/**
 *
 * @author Sanatt Abrol
 */
public class Graph15 {
    String result;
    int[][] M;
    
    boolean inBounds(int x, int y, int n){
        return (x > -1) && (y > -1) && (x < n) && (y < n);
    }
    
    boolean isSafe(int x, int y, int n){
        return inBounds(x, y, n) && M[x][y] != -1;
    }
    
    void print(int n){
        System.out.println("Printing board....");
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++)
                System.out.print(M[i][j] + "  ");
            System.out.println("");
        }
    }
    void set(int x, int y, int n, int v){
        //horizontally and vertically
        for(int i = 0; i < n; i++){
            M[x][i] = v; 
            M[i][y] = v;
        }
        //diagonally
        for(int i = 1; i < n; i++){
            if(inBounds(x + i, y + i, n))
                M[x + i][y + i] = v;
            if(inBounds(x + i, y - i, n))
                M[x + i][y - i] = v;
            if(inBounds(x - i, y + i, n))
                M[x - i][y + i] = v;
            if(inBounds(x - i, y - i, n))
                M[x - i][y - i] = v;
        }
        print(n);
    }
    
    void unset(int level, int i, int n, int[] path){
        set(level, i, n, 0);
        for(int k = 0; k < n; k++)
            if(path[k] != -1)
                set(k, path[k] - 1, n, -1);
    }
    void nQueen(int level, int[] path, int n){
        //check res condition
        if(level == n){ //placement at all n levels was success
            String s = "[";
            for(int i = 0; i < level; i++)
                s += path[i] + " ";
            s += "]";
            result += s;
            return;
        } else {
            //placement of Q here
            for(int i = 0; i < n; i++){
                if(isSafe(level, i, n)){ //safe to place Q at [level][i]
                    set(level, i, n, -1);
                    path[level] = i + 1;
                    //traverse next levels
                    nQueen(level + 1, path, n);
                    //traversed this route; now remove this placement
                    path[level] = -1;
                    unset(level, i, n, path);
                }
            }    
        }
    }
	
	String solution(int n){
	    this.M = new int[n][n]; //all cells 0
	    this.result = "";
	    boolean[] visited = new boolean[0];
	    int[] path = new int[n];
	    for(int i = 0; i < n; i++){//path will store pos of Q
	        path[i] = -1;
	    }
	    nQueen(0, path, n);
	    return result;
	}
	
	public static void main (String[] args) {
		//code
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- > 0){
		    int n = sc.nextInt();
		    System.out.println(new Graph15().solution(n));
		}
	}
}
