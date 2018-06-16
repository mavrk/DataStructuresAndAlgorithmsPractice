/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problems.heap;

import java.util.PriorityQueue;
import java.util.Scanner;

/**
 *
 * @author Sanatt Abrol 
 * GFG problem
 * https://practice.geeksforgeeks.org/problems/kth-largest-element-in-a-stream/0
 */
public class Heap3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int k = sc.nextInt();
            int n = sc.nextInt();
            //MinHeap 
            PriorityQueue<Integer> pq = new PriorityQueue<Integer>(k);
            //scan the stream
            for (int i = 0; i < n; i++) {
                int elem = sc.nextInt();
                if (i < k - 1) {
                    pq.add(elem);
                    System.out.print(-1 + " ");
                } else if (i == k - 1) {
                    pq.add(elem);
                    System.out.print(pq.peek() + " ");
                } else {
                    if (elem > pq.peek()) {
                        pq.poll();
                        pq.add(elem);
                    }
                    System.out.print(pq.peek() + " ");
                }
            }
            System.out.println();
        }
    }
}
