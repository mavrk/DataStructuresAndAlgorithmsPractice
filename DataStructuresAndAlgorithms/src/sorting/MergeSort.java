/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sorting;

/**
 *
 * @author Sanatt Abrol
 */
public class MergeSort {

    void sort(int arr[], int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;
            //sort left half
            sort(arr, l, m);
            //sort right half
            sort(arr, m + 1, r);
            //merge
            merge(arr, l, m, r);
        }
    }

    void merge(int arr[], int l, int m, int r) {
        //size of L & R
        int n1 = m - l + 1;
        int n2 = r - m;
        //new L & R
        int L[] = new int[n1];
        int R[] = new int[n2];
        //init L & R
        for (int i=0; i<n1; i++) {
            L[i] = arr[l + i];
        }
        for (int i=0; i<n2; i++) {
            R[i] = arr[m + 1 + i];
        }
        //init ptrs to L, R, arr
        int i = 0, j = 0, k = l;
        //sort and prepare arr
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
        //copy any items of left
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    public static void main(String[] args) {
        MergeSort mergeSort = new MergeSort();
        int arr[] = {1, 6, 4, 9, 3, 7, 2, 5, 8, 0};
        mergeSort.sort(arr, 0, arr.length - 1);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
