/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problems;

import java.util.HashSet;
import java.util.Scanner;

/**
 *
 * @author Sanatt Abrol 
 * GFG problem https://www.geeksforgeeks.org/count-pairs-difference-equal-k/ 
 * Time Complexity O(n)
 */
public class Sort3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            HashSet<Integer> hashSet = new HashSet();
            HashSet<Integer> duplicatesSet = new HashSet();
            int val;
            for (int i = 0; i < n; i++) {
                val = sc.nextInt();
                if (!hashSet.add(val)) {
                    duplicatesSet.add(val);
                }
            }
            int k = sc.nextInt();
            if (k == 0) {
                System.out.println(duplicatesSet.size());
            } else {
                int count = 0;
                for (int i : hashSet) {
                    if (hashSet.contains(i + k)) {
                        count++;
                    }
                }
                System.out.println(count);
            }
        }
    }
}
