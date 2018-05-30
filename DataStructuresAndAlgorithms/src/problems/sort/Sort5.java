/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problems.sort;

import java.util.Scanner;

/**
 *
 * @author Sanatt Abrol
 * GFG problem https://www.geeksforgeeks.org/counting-inversions/
 * Complexity O(nlogn)
 * Idea : Use MergeSort principle to calculate inversions
 */
public class Sort5 {
    int mergeSort(int arr[], int l, int r){
        int inv = 0;
        if(l<r){
            int m = (l+r)/2;
            inv += mergeSort(arr, l, m);
            inv += mergeSort(arr, m+1, r);
            inv += merge(arr, l, m, r);
        }
        return inv;
    }
    
    int merge(int arr[], int l, int m, int r){
        int nL = m-l+1;
        int nR = r-m;
        int L[] = new int[nL];
        int R[] = new int[nR];
        
        for(int i=0; i<nL; i++)
            L[i] = arr[l+i];
        for(int i=0; i<nR; i++)
            R[i] = arr[m+1+i];
        
        int i=0, j=0, k = l, inv = 0;
        while(i < nL && j < nR){
            if(L[i]<=R[j]){
                arr[k++] = L[i++];
            }
            else{
                arr[k++] = R[j++];
                System.out.println("boom");
                inv += nL-i;
            }
        }
        
        while(i<nL)
            arr[k++] = L[i++];
        while(j<nR)
            arr[k++] = R[j++];
        
        return inv;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();
            int arr[] = new int[n];
            for(int i = 0; i<n; i++)
                arr[i] = sc.nextInt();
            Sort5 gfg = new Sort5();
            System.out.println(gfg.mergeSort(arr, 0, n-1));
        }
    }
}
