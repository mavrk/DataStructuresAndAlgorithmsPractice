/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problems.sort;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author Sanatt Abrol
 * GFG problem https://practice.geeksforgeeks.org/problems/find-all-four-sum-numbers/0
 * Time complexity O((n*n)logn)
 */
public class Sort8 {

    class Pair {

        int a, b;

        public Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }

    }

    void printQuad(int arr[], int n, int k) {
        //create a hashMap of pairs and their sums
        HashMap<Integer, Pair> hashMap = new HashMap<>();
        //create a TreeSet to store answers (auto sorted)
        Set<String> st = new TreeSet();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                hashMap.put(arr[i] + arr[j], new Pair(i, j));
            }
        }
        //now traverse other distinct elems which have sum k-X and are not same as  
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int sum = arr[i] + arr[j];
                Pair p = hashMap.get(k - sum);
                if (p != null) {
                    if (p.a != i && p.a != j && p.b != i && p.b != j) {
                        int res[] = new int[4];
                        String s = "";
                        res[0] = arr[p.a];
                        res[1] = arr[p.b];
                        res[2] = arr[i];
                        res[3] = arr[j];
                        Arrays.sort(res);
                        for (int r : res) {
                            s += r + " ";
                        }
                        st.add(s);
                    }
                }
            }
        }
        st.forEach((s) -> {
            sb.append(s + "$");
        });

        System.out.println((sb.length() > 0) ? sb.toString() : "-1");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            new Sort8().printQuad(arr, n, k);
        }
    }
}
