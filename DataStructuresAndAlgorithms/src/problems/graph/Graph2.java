/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problems.graph;

/**
 *
 * @author Sanatt Abrol
 */
import java.io.*;
import java.util.*;
public class Graph2{
	@SuppressWarnings("unchecked")
    public static void main(String[] args)
    {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while(t-- > 0){
			int v = in.nextInt();
			int e = in.nextInt();
			LinkedList<Integer>[] alist = new LinkedList[v];
			for(int i=0;i<v;i++) alist[i] = new LinkedList<Integer>();
			while(e-->0) {
				int n1 = in.nextInt();
				int n2 = in.nextInt();
				alist[n1].add(n2);
				alist[n2].add(n1);
			}
			GfG2 g = new GfG2();
			if(g.isCyclic(v,alist)) {
				System.out.println(1);
			}
			else
				System.out.println(0);
		}
    }
}

/*Please note that it's Function problem i.e.
you need to write your solution in the form of Function(s) only.
Driver Code to call/invoke your function is mentioned above.*/

/*Complete the function below*/
class GfG2
{
    boolean isCyclic(int V,LinkedList<Integer>[] alist)
    {
       //add code here.
        boolean[] visited = new boolean[V];
        for(int v = 0; v < V; v++)
            if(!visited[v])
                if(check(v, alist, visited, -1))
                    return true;
        return false;
    }
    
    boolean check(int v, LinkedList<Integer>[] alist, boolean[] visited, int parent){
        visited[v] = true;
        for(Integer i : alist[v])
        {
            System.out.println("Checking " + i);
            
            if (!visited[i])
            {
                if (check(i, alist, visited, v))
                    return true;
            } else if (i != parent)
                return true;
        }
        return false;
    }
}
