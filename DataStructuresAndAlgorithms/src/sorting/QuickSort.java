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
public class QuickSort {

    int partition(int arr[], int low, int high) {
        //select last elem as pivot
        int pivot = arr[high];
        //init i as low - 1
        int i = low - 1;
        //GOAL : Shift all elem LT pivot to L and GT than pivot to R
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                //swap a[i] & a[j]
                swap(arr, i, j);
            }
        }
        //swap i+1 elem with pivot
        swap(arr, i + 1, high);
        //i+1 is pos of partition
        return (i + 1);
    }

    void swap(int arr[], int i, int j) {
        //swap i & j elem of arr
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }

    void sort(int arr[], int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            //sort L and R of pi
            sort(arr, low, pi - 1);
            sort(arr, pi + 1, high);
        }
    }

    public static void main(String[] args) {
        int arr[] = {10, 7, 8, 9, 1, 5};
        QuickSort quickSort = new QuickSort();
        quickSort.sort(arr, 0, arr.length - 1);
        //print
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
