/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problems.sort;

import java.util.Arrays;
import java.util.Comparator;

/**
 *
 * @author Sanatt Abrol 
 * GFG problem https://www.geeksforgeeks.org/sort-array-strings-according-string-lengths/
 */
public class Sort2 {

    public static void main(String[] args) {
        String[] arr = {"I", "cove", "coding", "Java"};
        Arrays.sort(arr, new Comparator<String>() {

            @Override
            public int compare(String s1, String s2) {
                int l1 = s1.length();
                int l2 = s2.length();
                if (l1 == l2) {
                    for (int i = 0; i < l1; i++) {
                        if (s1.charAt(i) != s2.charAt(i)) {
                            return s1.charAt(i) - s2.charAt(i);
                        }
                    }
                }
                return l1 - l2;
            }
        });
        for (String s : arr) {
            System.out.print(s + " ");
        }
    }
}
