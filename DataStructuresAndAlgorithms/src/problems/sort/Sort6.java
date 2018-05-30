/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problems.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Scanner;

/**
 *
 * @author Sanatt Abrol GFG problem
 * https://practice.geeksforgeeks.org/problems/sorting-elements-of-an-array-by-frequency/0
 * O(nlogn)
 */
public class Sort6 {

    public static void main(String[] args) {
        //int arr[] = {2, 3, 2, 4, 5, 12, 2, 3, 3, 3, 12};
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            HashMap<Integer, Integer> map = new HashMap();
            int n = sc.nextInt();
            for (int i = 0; i < n; i++) {
                int val = sc.nextInt();
                Integer count = map.get(val);
                map.put(val, (count == null) ? 1 : (count + 1));
            }
            print(map);
        }

    }

    static void print(HashMap map) {
        List<Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        Comparator<Entry<Integer, Integer>> comp = (Entry<Integer, Integer> e1, Entry<Integer, Integer> e2) -> {
            int v1 = e1.getValue();
            int v2 = e2.getValue();
            if (v1 == v2) {
                return e1.getKey() - e2.getKey();
            } else {
                return v2 - v1;
            }
        };

        Collections.sort(list, comp);
        list.forEach((e) -> {
            int val = e.getValue();
            int key = e.getKey();
            for (int i = 0; i < val; i++) {
                System.out.print(key + " ");
            }
        });
        System.out.println("");
    }
}
