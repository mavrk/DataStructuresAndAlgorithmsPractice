/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problems.sort;

import java.util.Arrays;
import java.util.Scanner;
import javafx.util.Pair;

/**
 *
 * @author Sanatt Abrol
 * GFG problem https://www.geeksforgeeks.org/minimum-length-unsorted-subarray-sorting-which-makes-the-complete-array-sorted/
 */
public class Sort1 {
    Pair<Integer, Integer> findMinLength(int arr[]){
        //find candidate s and e in the arr
        int e, s, len = arr.length;
        if(len == 1)
            return new Pair<>(0,0);
        
        for(s=0; s<len-1; s++){
            if(arr[s] > arr[s+1]){
                break;
            }
        }
        for(e=len - 1; e>0; e--){
            if(arr[e] < arr[e-1])
                break;
        }
        //already sorted
        if(s == len-1 && e == 0)
            return new Pair<>(0,0);
        //sort the subarray from s to e
        Arrays.sort(arr, s, e);
        //check if total array is sorted
        if(isSorted(arr))
            return new Pair<>(s,e);
        //if not sorted then compute new candidates for s and e
        int min = arr[s], max = arr[s];
        for(int i=s+1; i<=e; i++){
            if(min > arr[i])
                min = arr[i];
            if(max < arr[i])
                max = arr[i];
        }
        //now using new min and max search for new candidates of s and e to L of s and R of e
        for(int i=0; i<s; i++){
            if(arr[i] > min){
                s = i;
                break;
            }
        }
        for(int i=len-1; i>e; i-- ){
            if(arr[i] < max){
                e = i;
                break;
            }
        }
                
        return new Pair<>(s,e);
    }
    
    boolean isSorted(int arr[]){
        int temp = arr[0];
        for(int i : arr){
            if(temp > i)
                return false;
            temp = i;
        }
        return true;
    }
    
    public static void main(String[] args) throws InterruptedException {
        Sort1 sort1 = new Sort1();
        Scanner sc = new Scanner(System.in);
        
        int t = sc.nextInt();
        while(t-- > 0){
            int len = sc.nextInt();
            int arr[] = new int[len];
            for(int i=0; i<len; i++){
                arr[i] = sc.nextInt();
            }
            Pair<Integer, Integer> answer = sort1.findMinLength(arr);
            System.out.println(answer.getKey() + " " + answer.getValue());    
        }
    }
}