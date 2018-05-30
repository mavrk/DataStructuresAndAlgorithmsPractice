/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problems.sort;

import com.sun.xml.internal.ws.binding.FeatureListUtil;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import problems.sort.Sort8.Pair;

/**
 *
 * @author Sanatt Abrol
 */
public class Sort9 {

    void merge(int a[], int e[], int n) {
        Arrays.sort(a);
        Arrays.sort(e);
        int i = 1, j = 0, guest = 1, maxGuest = 1, time = a[0];
        while (i < n && j < n) {
            if (a[i] <= e[j]) {
                //arrival 
                guest++;
                if(guest > maxGuest){
                    maxGuest = guest;
                    time = a[i];                    
                }
                i++;
            } else {
                //exit
                guest--;
                j++;            
            }
        }
        System.out.println(maxGuest + " " + time);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();
            int a[] = new int[n];
            int e[] = new int[n];
            for(int i=0; i<n; i++)
                a[i] = sc.nextInt();
            for(int i=0; i<n; i++)
                e[i] = sc.nextInt();
            new Sort9().merge(a, e, n);
        }
    }
}
