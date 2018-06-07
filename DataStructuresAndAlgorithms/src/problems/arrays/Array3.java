/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problems.arrays;

import java.util.Scanner;

/**
 *
 * @author Sanatt Abrol
 * GFG problem https://practice.geeksforgeeks.org/problems/minimum-swaps-required-to-bring-all-elements-less-than-or-equal-to-k-together/0
 */
public class Array3 {
    int minSwaps(int[] arr, int n, int k){
        int count = 0;
        for(int i = 0; i < n; i++)
            if(arr[i] <= k)
                count++;
        int bad = 0;
        for(int i = 0; i < count; i++)
            if(arr[i] > k)
                bad++;
        int ans = bad;
        for(int i = 0, j = count; j < n; i++, j++){
            if(arr[i] > k)
                bad--;
            if(arr[j] > k)
                bad++;
            ans = Math.min(ans, bad);
        }
        return ans;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();
            int[] arr = new int[n];
            for(int i = 0; i < n; i++)
                arr[i] = sc.nextInt();
            int k = sc.nextInt();
            System.out.println(new Array3().minSwaps(arr, n, k));
        }
    }
    
}
