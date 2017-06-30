package test;

import lc.TreeNode;

//	     1
//     /    \
//    2      3
//   / \    / \
//  4   5  6   7
//  		\   \
//   		 8   9 
//    
//The output of print this tree vertically will be:
//4
//2
//1 5 6
//3 8
//7
//9 

//that's pretty interesting
//first get the max, min of the distance
//then serach the distance, if find the matched distance, print it

public class VerticalOrderTraverse {

	TreeNode root;
    Values val = new Values();
  
    // A utility function to find min and max distances with respect
    // to root.
    void findMinMax(TreeNode node, Values min, Values max, int hd) 
    {
        // Base case
        if (node == null) 
            return;
  
        // Update min and max
        if (hd < min.min) 
            min.min = hd;
        else if (hd > max.max) 
            max.max = hd;
  
        System.out.println("min= "+min.min);
        System.out.println("max= "+max.max);
        // Recur for left and right subtrees
        findMinMax(node.left, min, max, hd - 1);
        findMinMax(node.right, min, max, hd + 1);
    }
  
    // A utility function to print all nodes on a given line_no.
    // hd is horizontal distance of current node with respect to root.
    void printVerticalLine(TreeNode node, int line_no, int hd) 
    {
        // Base case
        if (node == null) 
            return;
  
        // If this node is on the given line number
        if (hd == line_no) 
            System.out.print("node.val= "+node.val + " ");        
  
        // Recur for left and right subtrees
        printVerticalLine(node.left, line_no, hd - 1);
        printVerticalLine(node.right, line_no, hd + 1);
    }
  
    // The main function that prints a given binary tree in
    // vertical order
    void verticalOrder(TreeNode node) 
    {
        // Find min and max distances with resepect to root
        findMinMax(node, val, val, 0);
  
        // Iterate through all possible vertical lines starting
        // from the leftmost line and print nodes line by line
        
        for (int i=-1; i<0; i++) 
//        for (int line_no = val.min; line_no <= val.max; line_no++) 
        {
            printVerticalLine(node, i, 0);
            System.out.println("");
        }
    }
  
    // Driver program to test the above functions
    public static void main(String args[]) 
    {
    	VerticalOrderTraverse tree = new VerticalOrderTraverse();
  
        /* Let us construct the tree shown in above diagram */
        tree.root = new TreeNode(1);
        tree.root.left = new TreeNode(2);
        tree.root.right = new TreeNode(3);
        tree.root.left.left = new TreeNode(4);
        tree.root.left.right = new TreeNode(5);
        tree.root.right.left = new TreeNode(6);
        tree.root.right.right = new TreeNode(7);
        tree.root.right.left.right = new TreeNode(8);
        tree.root.right.right.right = new TreeNode(9);
  
        System.out.println("vertical order traversal is :");
        tree.verticalOrder(tree.root);
    }


}
