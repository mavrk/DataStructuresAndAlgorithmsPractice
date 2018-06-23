/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problems.graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Stack;

/**
 *
 * @author Sanatt Abrol
 */
public class Graph10 {
    
    
    public static void main(String[] args) {
        ArrayList<String> wordList = new ArrayList<String>();
        wordList.add("GEEKS");
        wordList.add("FOR");
        wordList.add("QUIZ");
        wordList.add("GO");
        char boggle[][]   = {{'G','I','Z'},
                       {'U','E','K'},
                       {'Q','S','E'}};
        HashSet<String> set = new HashSet<String>();
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                //DFS
                boolean visited[][] = new boolean[3][3];
                Stack<Character> st = new Stack<Character>();
                st.push(boggle[i][j]);
                visited[i][j] = true;
                
            }
        }
    }
}
