/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problems.graph;
import java.util.*;
import java.lang.*;
import java.io.*;

/**
 *
 * @author Sanatt Abrol
 */

/*package whatever //do not write package name here */

class Graph9 {
    static int[] row = {0, 0, -1, 1};
    static int[] col = {1, -1, 0, 0};
    static int[][] M;
    static boolean[][] visited;
    
    static boolean isSafe(int x, int y, int m){
        return (x > -1) && (y > -1) && (x < m) && (y < m) && (M[x][y] != 0) && (!visited[x][y]);
    }
   
    public static void main (String[] args) {
        //code
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            int m = sc.nextInt();
            M = new int[m][m];
            visited = new boolean[m][m];
            Point s = null, d = null;
            for(int i = 0; i < m; i++){
                for(int j = 0; j < m; j++){
                    M[i][j] = sc.nextInt();
                    if(M[i][j] == 1)
                        s = new Point(i, j);
                    if(M[i][j] == 2)
                        d = new Point(i, j);
                }
            }
            //BFS from s to search d
            

            boolean found = false;
            System.out.println("S" + s + " D" + d);
            Queue<Point> q = new LinkedList<Point>();
            q.add(s);
            visited[s.x][s.y] = true;
            while(!q.isEmpty()){
                Point p = q.poll();
                if(M[p.x][p.y] == 2){
                    found = true;
                    break;
                }
                int x, y;
                for(int i = 0; i < 4; i++){
                    x = p.x + row[i];
                    y = p.y + col[i];
                    if(isSafe(x, y, m)){
                        System.out.println("Adding " + x + "," + y);
                        q.add(new Point(x, y));
                        visited[x][y] = true;
                    }
                }
            }
            System.out.println(found ? 1 : 0);
        }
    }
}
