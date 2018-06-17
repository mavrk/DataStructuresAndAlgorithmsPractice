
GFG problem https://practice.geeksforgeeks.org/problems/top-view-of-binary-tree/1


/*Please note that it's Function problem i.e.
you need to write your solution in the form of Function(s) only.
Driver Code to call/invoke your function is mentioned above.*/

/*Complete the function below
Node is as follows
class TreeNode
{
    int key;
    TreeNode left, right;
    public TreeNode(int key)
    {
        this.key = key;
        left = right = null;
    }
}*/

class Pair{
    int h, d;
    Pair(int h, int d){
        this.h = h;
        this.d = d;
    }
}
class GfG
{
    public void printTopView(TreeNode root)
    {
        //add code here.
        HashMap<Integer, Pair> map = new HashMap<Integer, Pair>();
        traverse(root, map, 0, 0);
        Comparator<Map.Entry<Integer, Pair>> comp = 
                                    new Comparator<Map.Entry<Integer, Pair>>(){
            @Override
            public int compare(Map.Entry<Integer, Pair> e1, Map.Entry<Integer, Pair> e2){
                int d1 = e1.getKey();
                int d2 = e2.getKey();
                int h1 = e1.getValue().h;
                int h2 = e2.getValue().h;
                
                if(h1 != h2)
                    return h1 - h2;
                return d1 - d2;
            }
        };
        
        List<Map.Entry<Integer, Pair>> list = new ArrayList<Map.Entry<Integer, Pair>>(map.entrySet());
    
        Collections.sort(list, comp);
        
        for(Map.Entry<Integer, Pair> e : list)
            System.out.print(e.getValue().d + " ");
    }
    
    void traverse(TreeNode node, HashMap<Integer, Pair> map, int d, int h){
        if(node == null)
            return;
        traverse(node.left, map, d - 1, h + 1);
        traverse(node.right, map, d + 1, h + 1);
        //add curr values to map
        Pair p = map.get(d);
        if(p == null)
            map.put(d, new Pair(h, node.key));
        else{
            if (h <= p.h)
                map.put(d, new Pair(h, node.key));
        }
    }
}