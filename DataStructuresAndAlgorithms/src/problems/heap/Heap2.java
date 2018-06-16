/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problems.heap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sanatt Abrol GFG problem
 * https://practice.geeksforgeeks.org/problems/rearrange-characters/0
 */
public class Heap2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = "";
            try {
                s = br.readLine();
            } catch (IOException ex) {
                Logger.getLogger(Heap2.class.getName()).log(Level.SEVERE, null, ex);
            }
            //create an arr of freq
            int[] freq = new int[26];
            for (int i = 0; i < s.length(); i++) {
                freq[s.charAt(i) - 'a']++;
            }
            int tolChars = 0;
            for (char c = 'a'; c <= 'z'; c++) {
                if (freq[c - 'a'] > 0) {
                    tolChars++;
                }
            }
            //create the MaxHeap
            PriorityQueue<Integer> pq = new PriorityQueue<Integer>(tolChars,
                    Collections.reverseOrder());
            for (char c = 'a'; c <= 'z'; c++) {
                if (freq[c - 'a'] > 0) {
                    pq.add(freq[c - 'a']);
                }
            }
            //traverse the MaxHeap
            int prev = -1; //starting value should be low
            int n = 0; //n is the length of formed string
            while (pq.size() > 0) {
                int curr = pq.poll();
                curr--;
                n++;//decrease by one
                if (prev > 0) {
                    pq.add(prev);
                }
                prev = curr;
            }
            if (n != s.length()) {
                System.out.println(0);
            } else {
                System.out.println(1);
            }
        }
    }
}
