/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problems.sort;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Sanatt Abrol
 * GFG problem https://www.geeksforgeeks.org/longest-common-prefix-set-6-sorting/
 * O(MAX * nlogn)
 */
public class Sort11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();
            String s[] = new String[n];
            for(int i = 0; i < n; i++){
                s[i] = sc.next();
            }
            Arrays.sort(s);
            int min = 0, max = n-1, i=0;
            String lcp = "";
            int minLen = Integer.min(s[min].length(), s[max].length());
            for(;i<minLen && (s[min].charAt(i) == s[max].charAt(i));i++)
                    lcp += s[min].charAt(i);
            if(i==0)
                System.out.println("-1");
            else
                System.out.println(lcp);
        }
    }
}
