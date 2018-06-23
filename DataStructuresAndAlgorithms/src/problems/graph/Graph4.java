/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problems.graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author Sanatt Abrol
 */
class Pair {

    int x, y;

    Pair(int a, int b) {
        this.x = a;
        this.y = b;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + this.x;
        hash = 13 * hash + this.y;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pair other = (Pair) obj;
        if (this.x != other.x) {
            return false;
        }
        if (this.y != other.y) {
            return false;
        }
        return true;
    }
    
    
}

public class Graph4 {

    boolean isPossible(int m, int n, int k, int r, Pair[] circles) {
        int[][] rect = new int[m][n];
        //init rect 
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                rect[i][j] = 0;
            }
        }
        //for all circles make cell underlying -1
        int x, y, xSym, ySym;
        for (Pair p : circles) {
            for (x = p.x - r; x <= p.x; x++) {
                for (y = p.y - r; y <= p.y; y++) {
                    if ((x - p.x) * (x - p.x) + (y - p.y) * (y - p.y) <= r * r) {
                        xSym = p.x - (x - p.x);
                        ySym = p.y - (y - p.y);
                        // (x, y), (x, ySym), (xSym , y), (xSym, ySym) are in the circle
                        block(x, y, rect, m, n);
                        block(x, ySym, rect, m, n);
                        block(xSym, y, rect, m, n);
                        block(xSym, ySym, rect, m, n);
                    }
                }
            }

        }

        //if start/ end is blocked
        if(rect[0][0] == -1 || rect[m - 1][n - 1] == -1)
            return false;
        Queue<Pair> q = new LinkedList<Pair>();
        q.add(new Pair(0,0));
        while(!q.isEmpty()){
            Pair p = q.poll();
            //check for 8 adjacent points and add to Q
            for(int i = -1; i < 2; i++)
                for(int j = -1; j < 2; j++)
                    if(i == 0 && j == 0)
                        continue;
                    else
                        visitAndEnqueue(p.x + i, p.y + j, m, n, rect, q);
        }
        return rect[m - 1][n - 1] == 1;
    }

    void block(int x, int y, int[][] rect, int m, int n) {
        if (x >= 0 && y >= 0 && x < m && x < n) {
            rect[x][y] = -1;
        }
    }
    
    void visitAndEnqueue(int x, int y, int m, int n, int[][] rect, Queue<Pair> q){
        if (x >= 0 && y >= 0 && x < m && y < n && rect[x][y] == 0) {
            rect[x][y] = 1;
            q.add(new Pair(x,y));
        }
    }

    public static void main(String[] args) {
        Graph4 g = new Graph4();
        Pair[] p = new Pair[2];
        p[0] = new Pair(2 - 1, 3 - 1);
        p[1] = new Pair(3 - 1, 3 - 1);
        long time = System.currentTimeMillis();
        System.out.println(g.isPossible(5, 5, 2, 1, p));
        System.out.println(System.currentTimeMillis() - time);
    }
}
