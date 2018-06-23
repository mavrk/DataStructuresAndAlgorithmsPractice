/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problems.graph;

/**
 *
 * @author Sanatt Abrol
 * GFG problem https://www.geeksforgeeks.org/count-possible-paths-two-vertices/
 */
public class Graph3 {
    Graph G;
    Graph3(Graph G){
        this.G = G;
    }
    
    int findNumOfPaths(int u, int v, int count){
        G.visited[u] = true;
        if(u == v){
            count++;
        } else {
            for(Integer i : G.alist[u]){
                if(!G.visited[v])
                    count = findNumOfPaths(i, v, count);
            }
        }
        G.visited[u] = false;
        return count;
    }
    public static void main(String[] args) {
        Graph G = new Graph(4);
        G.addPath('A', 'D');
        G.addPath('A', 'B');
        G.addPath('A', 'C');
        G.addPath('C', 'A');
        G.addPath('B', 'D');
        G.addPath('C', 'B');
        //G.addPath('D', 'C');
        
        System.out.println(new Graph3(G).findNumOfPaths('C' - 'A', 'D' - 'A', 0));
    }
}
