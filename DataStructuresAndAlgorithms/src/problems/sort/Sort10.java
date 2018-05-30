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
 * GFG problem https://www.geeksforgeeks.org/rearrange-array-maximum-minimum-form-set-2-o1-extra-space/
 * O(n) complexity
 */
public class Sort10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();
            int arr[] = new int[n];
            for(int i = 0; i < n ; i++){
                arr[i] = sc.nextInt();
            }
            int min = 0, max = n - 1, maxElem = arr[max]+1;
            for(int i=0; i<n; i++){
                if(i%2==0)
                    arr[i] += (arr[max--] % maxElem) * maxElem;
                else
                    arr[i] += (arr[min++] % maxElem) * maxElem;
            }
            for(int i : arr){
                System.out.print(i/maxElem + " ");
            }
            System.out.println("");
        }
    }
}
