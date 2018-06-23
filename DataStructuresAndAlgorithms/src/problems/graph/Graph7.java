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

class Point {
    int x, y;
    Point(int x, int y){
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Point{" + x + "," + y + '}';
    }
    
    
}
public class Graph7 {
    
    int minSteps(Point s, Point d, int N){
        int[][] distance = new int[N][N];
        for(int i = 0; i < N; i++)
            for(int j = 0; j < N; j++)
                distance[i][j] = -1;
        Queue<Point> q = new LinkedList<Point>();
        q.add(s);
        distance[s.x][s.y] = 0;//init 
        while(!q.isEmpty()){
            Point p = q.poll();
            if(p == d)
                break;
            int x = p.x;
            int y = p.y;
            //try to find which moves are possible
            if(isPossible(x + 1, y - 2, N, distance)){
                q.add(new Point(x + 1, y - 2));
                distance[x + 1][y - 2] = distance[x][y] + 1;
            }
            if(isPossible(x - 1, y - 2, N, distance)){
                q.add(new Point(x - 1, y - 2));
                distance[x - 1][y - 2] = distance[x][y] + 1;
            }
            if(isPossible(x + 1, y + 2, N, distance)){
                q.add(new Point(x + 1, y + 2));
                distance[x + 1][y + 2] = distance[x][y] + 1;
            }
            if(isPossible(x - 1, y + 2, N, distance)){
                q.add(new Point(x - 1, y + 2));
                distance[x - 1][y + 2] = distance[x][y] + 1;
            }
            if(isPossible(x - 2, y - 1, N, distance)){
                q.add(new Point(x - 2, y - 1));
                distance[x - 2][y - 1] = distance[x][y] + 1;
            }
            if(isPossible(x + 2, y - 1, N, distance)){
                q.add(new Point(x + 2, y - 1));
                distance[x + 2][y - 1] = distance[x][y] + 1;
            }
            if(isPossible(x - 2, y + 1, N, distance)){
                q.add(new Point(x - 2, y + 1));
                distance[x - 2][y + 1] = distance[x][y] + 1;
            }
            if(isPossible(x + 2, y + 1, N, distance)){
                q.add(new Point(x + 2, y + 1));
                distance[x + 2][y + 1] = distance[x][y] + 1;
            }
        }
        
        return (distance[d.x][d.y] != -1 ? distance[d.x][d.y] : 1);
    }
    
    boolean isPossible(int x, int y, int N, int[][] distance){
        if(x < 0 || y < 0 || x >= N || y >= N || distance[x][y] != -1)
            return false;
        return true;
    }
	public static void main (String[] args) {
		//code
		Graph7 g = new Graph7();
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- > 0){
		    int n = sc.nextInt();
		    Point s = new Point(sc.nextInt() - 1, sc.nextInt() - 1);
		    Point d = new Point(sc.nextInt() - 1, sc.nextInt() - 1);
		    System.out.println(g.minSteps(s,d,n));
		}
	}
}
