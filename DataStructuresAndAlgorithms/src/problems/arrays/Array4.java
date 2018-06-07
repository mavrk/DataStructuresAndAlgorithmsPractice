/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problems.arrays;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 *
 * @author Sanatt Abrol GFG problem
 * https://practice.geeksforgeeks.org/problems/largest-number-formed-from-an-array/0
 * Idea : Custom comparator function
 */
public class Array4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            Integer[] arr = new Integer[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            Comparator<Integer> comp = new Comparator<Integer>() {

                @Override
                public int compare(Integer i1, Integer i2) {
                    String s1 = "" + i1 + i2;
                    String s2 = "" + i2 + i1;
                    i1 = Integer.parseInt(s1);
                    i2 = Integer.parseInt(s2);
                    return i2 - i1;
                }
            };
            Arrays.sort(arr, comp);
            for (Integer i : arr) {
                System.out.print(i);
            }
            System.out.println("");
        }
    }
}
