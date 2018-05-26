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
public class InsertionSort {

    void sort(int arr[]) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j--];
            }
            arr[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        int arr[] = {12, 11, 13, 5, 6};
        InsertionSort insertionSort = new InsertionSort();
        insertionSort.sort(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
