/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problems.sort;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Sanatt Abrol GFG problem
 * https://www.geeksforgeeks.org/kth-smallestlargest-element-unsorted-array-set-2-expected-linear-time/
 * Idea : Implement randomised pivot QuickSelect
 */
public class Sort4 {

    int quickSelect(int arr[], int low, int high, int k) {
        if (k > 0 && k <= high - low + 1) {
            int pos = partition(arr, low, high);

            // If position is same as k
            if (pos - low == k - 1) {
                return arr[pos];
            }

            // If pos is more, try L
            if (pos - low > k - 1) {
                return quickSelect(arr, low, pos - 1, k);
            }

            // Else try R
            return quickSelect(arr, pos + 1, high, k - pos + low - 1);
        }

        // If k is more than number of elements
        // in array
        return Integer.MAX_VALUE;
    }

    void swap(int arr[], int i, int j) {
        //swap i & j elem of arr
        if (arr[i] == arr[j]) {
            return;
        }
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }

    int partition(int arr[], int low, int high) {
        Random rand = new Random();
        //generate random pivot and swap with high
        int pp = low + rand.nextInt(high - low + 1);
        swap(arr, pp, high);
        int pivot = arr[high];
        //i keeps track of swapped elems
        int i = low - 1;
        //j loops through [low...pp...high]
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                //swap i and j elem
                swap(arr, i, j);
            }
        }
        //swap i+1 with pivot (high)
        swap(arr, i + 1, high);
        return (i + 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();                
            }
            int k = sc.nextInt();
            Sort4 gfg = new Sort4();
            System.out.println(gfg.quickSelect(arr, 0, arr.length - 1, k));
        }
    }

}
