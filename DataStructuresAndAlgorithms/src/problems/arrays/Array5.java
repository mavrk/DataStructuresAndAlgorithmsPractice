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
 */
public class Array5 {

    class Pair {

        int a, b;

        Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }

        Pair compare(int a1, int b1, int a2, int b2) {
            if ((b1 - a1) > (b2 - a2)) {
                return new Pair(a1, b1);
            } else {
                return new Pair(a2, b2);
            }
        }
    }

    void maxSumSubArray(int arr[], int n) {
        int maxSum = -1, l = 0;
        Pair maxPair = new Pair(0,0);
        while (l < n) {
            if (arr[l] >= 0) {
                int sum = 0, r = l;
                while (r < n && arr[r] >= 0) {
                    sum += arr[r];
                    r++;
                }
                //range l to r obtained
                if (sum > maxSum) {
                    maxSum = sum;
                    maxPair = new Pair(l, r-1);
                }
                if (sum == maxSum) {
                    maxPair = maxPair.compare(l, r-1, maxPair.a, maxPair.b);
                }
                l = r;
            }
            l++;
        }
        for(int i = maxPair.a; i <= maxPair.b; i++)
            System.out.print(arr[i]+" ");
        System.out.println("");
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();
            int[] arr = new int[n];
            for(int i = 0; i < n; i++)
                arr[i] = sc.nextInt();
            new Array5().maxSumSubArray(arr, n);
        }
    }

}
