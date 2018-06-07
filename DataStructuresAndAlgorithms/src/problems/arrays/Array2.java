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
 * GFG problem https://www.geeksforgeeks.org/find-rotation-count-rotated-sorted-array/
 * Time Complexiry O(logn)
 */
public class Array2 {
    int nRotation(int[] arr, int n, int l, int r){
        if(r < l)
            return 0;
        if(r == l)
            return l;
        int m = (l+r)/2;
        if(m < r && arr[m] > arr[m+1])
            return m+1;
        if(m > l && arr[m] < arr[m-1])
            return m;
        if(arr[m] > arr[l])
            return nRotation(arr, n, m+1, r);
        else if(arr[m] < arr[r])
            return nRotation(arr, n, l, m-1);
        else{
            int r1 = nRotation(arr, n, m+1, r);
            int r2 = nRotation(arr, n, l, m-1);
            if(r1 == 0)
                return r2;
            return r1;
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();
            int[] arr = new int[n];
            for(int i = 0; i < n; i++)
                arr[i] = sc.nextInt();
            System.out.println(new Array2().nRotation(arr, n, 0, n-1));
        }
    }
}
