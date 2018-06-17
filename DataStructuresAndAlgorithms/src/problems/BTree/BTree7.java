GFG problem https://practice.geeksforgeeks.org/problems/extreme-nodes-in-alternate-order/1

/*Please note that it's Function problem i.e.
you need to write your solution in the form of Function(s) only.
Driver Code to call/invoke your function is mentioned above.*/

/*Complete The given function
The Node class is as follows:
class Node{
    int data;
    Node left,right;
    
    Node(int d)
     {
      data=d;
      left=null;
      right=null;
    }
}*/
class GfG{
    public  void printExtremeNode(Node node)
    {
        //add code here.
        Queue<Node> q = new LinkedList<Node>();
        q.add(node);
        int level = 0, count = 0;
        Node temp;
        while(!q.isEmpty()){
            count = q.size();
            for(int i = 0; i < count; i++){
                temp = q.poll();
                if(temp == null)
                    break;
                if(level % 2 == 0 && i == count - 1)
                    System.out.print(temp.data + " ");
                if(level % 2 != 0 && i == 0)
                    System.out.print(temp.data + " ");
                if(temp.left != null)
                    q.add(temp.left);
                if(temp.right != null)
                    q.add(temp.right);
            }
            level++;
        }
    }
}