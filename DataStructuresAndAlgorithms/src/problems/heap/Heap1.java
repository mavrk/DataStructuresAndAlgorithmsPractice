/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problems.heap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 *
 * @author Sanatt Abrol GFG problem
 * https://practice.geeksforgeeks.org/problems/merge-k-sorted-arrays/1
 */
public class Heap1 {
    public static void main(String[] args) {
        int[][] arrays = new int[3][3];
        int[] elements = {1,2,3,4,5,6,7,8,9};
        for(int i = 0; i < 9; i++)
            arrays[i/3][i%3] = elements[i];

        ArrayList<Integer> list = GFG.mergeKArrays(arrays, 3);
        for(Integer i : list)
            System.out.print(i + " ");
    }
}

class Node {

    int elem, arr, nextElem;
}

class GFG {

    public static ArrayList<Integer> mergeKArrays(int[][] arrays, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        Comparator<Node> comp = new Comparator<Node>() {
            @Override
            public int compare(Node n1, Node n2) {
                return n1.elem - n2.elem;
            }
        };
        PriorityQueue<Node> pq = new PriorityQueue<>(k, comp);
        for (int i = 0; i < k; i++) {
            Node node = new Node();
            node.elem = arrays[i][0];
            node.arr = i;
            node.nextElem = 1;
            pq.add(node);
        }
        for(int count = 0; count < k*k; count++){
            //get min element
            Node min = pq.poll();
            //add to list
            list.add(min.elem);
            //fnd next elem or INFINITE
            if(min.nextElem < k){
                min.elem = arrays[min.arr][min.nextElem];
                min.nextElem ++;
            } else {
                min.elem = Integer.MAX_VALUE;
            }
            //add to pq again
            pq.add(min);
        }
        return list;
    }
}
