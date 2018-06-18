
/*Please note that it's Function problem i.e.
you need to write your solution in the form of Function(s) only.
Driver Code to call/invoke your function is mentioned above.

GFG problem https://practice.geeksforgeeks.org/problems/clone-a-binary-tree/1

Complete the function below
Node is as follows:
class Tree{
	int data;
	Tree left,right,random;
	Tree(int d){
		data=d;
		left=null;
		right=null;
		random=null;
	}
}*/
class GfG{
    
    Tree copyLRNode(Tree tree, HashMap<Tree, Tree> map){
        if(tree == null)
            return null;
        Tree clone = new Tree(tree.data);
        map.put(tree, clone);
        clone.left = copyLRNode(tree.left, map);
        clone.right = copyLRNode(tree.right, map);
        return clone;
    }
    
    void copyRandom(Tree tree, Tree clone, HashMap<Tree, Tree> map){
        if(clone == null)
            return;
        clone.random = map.get(tree.random);
        copyRandom(tree.left, clone.left, map);
        copyRandom(tree.right, clone.right, map);
    }
    
    public Tree cloneTree(Tree tree){
       // add code here.
        if(tree == null)
            return null;
        HashMap<Tree, Tree> map = new HashMap<Tree, Tree>();
        Tree newTree = copyLRNode(tree, map);
        copyRandom(tree, newTree, map);
        return newTree;
    }
}