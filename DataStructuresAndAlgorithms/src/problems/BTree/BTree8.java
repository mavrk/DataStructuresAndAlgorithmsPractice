GFG problem https://practice.geeksforgeeks.org/problems/count-bst-nodes-that-lie-in-a-given-range/1
class GfG
{   
    int getCountOfNode(Node root, int low, int high) 
    {
        // Your code here
        if(root == null)
            return 0;
        int left = getCountOfNode(root.left, low, high);
        int right = getCountOfNode(root.right, low, high);
        if(root.data >= low && root.data <= high)
            return 1 + left + right;
        else
            return left + right;
    }
}