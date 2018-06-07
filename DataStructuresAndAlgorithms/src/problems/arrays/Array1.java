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
 * GFG problem https://practice.geeksforgeeks.org/problems/rotate-and-delete/0
 * Time Complexity O(n^2)
 */
public class Array1 {

    void rotateByOne(int[] arr, int n) {
        int temp = arr[n - 1];
        for (int i = n - 1; i > 0; i--) {
            arr[i] = arr[i - 1];
        }
        arr[0] = temp;
    }

    int[] delete(int[] arr, int n, int k) {
        int[] temp = new int[n - 1];
        int i = 0;
        if (k < n) {
            i = n - k;
        }
        for(int j=0; j<i; j++)
            temp[j] = arr[j];
        for(int j = i+1; j<n; j++)
            temp[j-1] = arr[j];
        return temp;
    }
    
    int driver(int[] arr, int n){
        int k = 1;
        while(n > 1){
            rotateByOne(arr, n);
            arr = delete(arr, n, k);
            n--;
            k++;
        }
        return arr[0];
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();
            int[] arr = new int[n];
            for(int i = 0; i < n; i++)
                arr[i] = sc.nextInt();
            System.out.println(new Array1().driver(arr, n));
        }        
    }

}
