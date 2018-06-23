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
public class Graph11 {
    public static void main (String[] args) {
		//code
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- > 0){
		    int n = sc.nextInt();
		    int m = sc.nextInt();
		    char[][] M = new char[n][m];
		    int xCount = 0;
		    for(int i = 0; i < n; i++){
		        for(int j = 0; j < m; j++){
		            M[i][j] = sc.next().charAt(0);
		            if(M[i][j] == 'X')
		                xCount++;
		        }
		    }
		    System.out.println(xCount);
		    for(int i = 0; i < n; i++)
		        for(int j = 0; j < m; j++)
		            System.out.print(M[i][j] + " ");
		}
		
	}
    
}
