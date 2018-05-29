/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problems;

import java.util.Scanner;

/**
 *
 * @author Sanatt Abrol
 * GFG problem https://www.geeksforgeeks.org/sort-an-array-of-0s-1s-and-2s/
 * Time Complexity O(n)
 */
public class Sort7 {
    void sort(int arr[], int n){
        int l=0, m=0, r=n-1;
        while(m<=r){
            switch(arr[m]){
                case 0 : 
                    swap(arr,m,l);
                    m++;
                    l++;
                    break;
                case 1 :
                    m++;
                    break;
                case 2 :
                    swap(arr, m, r);
                    r--;
                    break;
            }
        }
    }
    
    void swap(int arr[], int i, int j){
        if(arr[i] == arr[j])
            return;
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();
            int arr[] = new int[n];
            for(int i=0; i<n; i++){
                arr[i] = sc.nextInt();
            }
            new Sort7().sort(arr, n);
            for(int i : arr)
                System.out.print(i+" ");
            System.out.println("");
        }
    }
}
