/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problems.BTree;

/**
 *
 * @author Sanatt Abrol
 */
public class BTree10 {

    public static void main(String[] args) {
        int pre[] = {40, 30, 32, 35, 80, 90, 100, 120};
        System.out.println(new BTree10().post(pre, 0, pre.length - 1));    
    }

    boolean isPre(int[] pre, int l, int r) {
        if(l >= pre.length)
            return false; 
        int root = pre[l];
        int i;
        for (i = l; i <= r; i++) {
            if (pre[i] > root) {
                break;
            }
        }
        for (; i <= r; i++) {
            if (pre[i] < root) {
                return false;
            }
        }
        return true;
    }

    String post(int[] pre, int l, int r) {
        if(l > r)
           return "";     
        if (!isPre(pre, l, r)) {
            return "";
        }
        int j;
        for (j = l + 1; j <= r; j++) {
            if (pre[j] > pre[l]) {
                break;
            }
        }
        
        String s = post(pre, l + 1, j) + " " + post(pre, j, r) + " " + pre[l];
        return s;
    }
}
