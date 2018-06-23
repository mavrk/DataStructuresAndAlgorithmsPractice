/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problems.graph;

/**
 *
 * @author Sanatt Abrol
 * Snakes and Ladders problem
 */
/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;

public class Graph12 {
    public static void main (String[] args) {
		//code
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- > 0){
		    int n = sc.nextInt();
		    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		    for(int i = 0; i < n; i++)
		        map.put(sc.nextInt(), sc.nextInt());
		    int[] distance = new int[31];
		    for(int i = 0; i < 31; i++)
		        distance[i] = Integer.MAX_VALUE;
		    //start BFS
		    Queue<Integer> q = new LinkedList<Integer>();
		    //start from 1
		    q.add(1);
		    distance[1] = 0;
		    int next = 0;
		    while(!q.isEmpty()){
		        int curr = q.poll();
		        if(curr == 30)
		            break;
		        //assess possible 6 moves of dice
		        for(int i = 1; i < 7; i++){
		            if(curr + i > 30)
		                break;
		            if(map.containsKey(curr + i))
		                next = map.get(curr + i);
		            else
		                next = curr + i;
                            if(distance[next] == Integer.MAX_VALUE){
                                q.add(next);
		            distance[next] = Math.min(distance[next], distance[curr] + 1);
                            }		            
		        }
		    }
		    System.out.println(distance[30]);
		}
	}
}
