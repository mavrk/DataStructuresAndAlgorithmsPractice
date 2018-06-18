/*package whatever //do not write package name here */
/*
 * GFG problem https://practice.geeksforgeeks.org/problems/find-median-in-a-stream/0
 */
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		//code
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		PriorityQueue<Integer> min = new PriorityQueue<Integer>();
		PriorityQueue<Integer> max = new PriorityQueue<Integer>(Collections.reverseOrder());
		int median = 0;
		while(n-- > 0){
		    int curr = sc.nextInt();
		    int size = max.size() - min.size();
		    if(size == 0){
		        //elems in max and min are equal
		        if(curr < median){ //add to maxHeap and make it median
		            max.add(curr);
		            median = max.peek();
		        } else { //add to minHeap and make it median
		            min.add(curr);
		            median = min.peek();
		        }
		    } else if(size == -1){ //elems in minHeap are more
		        if(curr > median){ //add to minHeap
		            max.add(min.poll());
		            min.add(curr);
		        } else { //add curr to maxHeap
		            max.add(curr);
		        }
		        //both contain eq elems now, median is avg of tops
		        median = (max.peek() + min.peek()) / 2;
		    } else if(size == 1){ //elems in maxHeap are more
		        if(curr < median){ //add to maxHeap
		            min.add(max.poll());
		            max.add(curr);
		        } else { //add curr to minHeap
		            min.add(curr);
		        }
		        //both contain eq elems now, median is avg
		        median = (max.peek() + min.peek()) / 2;
		    }
		    
		    System.out.println(median);
		}
	}
}