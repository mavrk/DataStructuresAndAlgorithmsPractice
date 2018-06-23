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
 * @author Sanatt Abrol GFG problem
 * https://www.geeksforgeeks.org/find-minimum-numbers-moves-needed-move-one-cell-M-another/
 */
public class Graph6 {

    void minDistance(int[][] M) {
        int N = M.length;
        int distance[] = new int[N * N];
        Graph G = new Graph(N * N);
        int s = 0, d = 0, k = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                distance[k] = -1;
                if (M[i][j] != 0) {
                    //right
                    if (isSafe(i, j + 1, M)) {
                        G.addPath(k, k + 1);
                    }
                    //left
                    if (isSafe(i, j - 1, M)) {
                        G.addPath(k, k - 1);
                    }
                    //down
                    if (isSafe(i + 1, j, M)) {
                        G.addPath(k, k + N);
                    }
                    //up
                    if (isSafe(i - 1, j, M)) {
                        G.addPath(k, k - N);
                    }
                    if (M[i][j] == 1) {
                        s = k;
                    } else if (M[i][j] == 2) {
                        d = k;
                    }
                }
                k++;
            }
        }

        Queue<Integer> q = new LinkedList<Integer>();
        q.add(s);
        distance[s] = 0;
        while (!q.isEmpty()) {
            int curr = q.poll();
            for (Integer i : G.alist[curr]) {
                if (distance[i] < 0 || distance[i] > distance[curr] + 1) {
                    q.add(i);
                    distance[i] = 1 + distance[curr];
                }
                if (i == d) {
                    q.clear();
                    break;
                }
            }
        }

        System.out.println(distance[d]);
    }

    boolean isSafe(int i, int j, int[][] M) {
        int l = M.length - 1;
        if (i < 0 || j < 0 || i > l || j > l || M[i][j] == 0) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int M[][] = {{3, 3, 1, 0},
        {3, 0, 3, 3},
        {2, 3, 0, 3},
        {0, 3, 3, 3}
        };

        new Graph6().minDistance(M);
    }
}
