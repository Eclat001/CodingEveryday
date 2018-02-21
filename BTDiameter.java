package facebook;

import structure.TreeNode;

public class BTDiameter {
//For every node, length of longest path which pass it = MaxDepth of its left subtree + MaxDepth of its right subtree.
    
    int max = 0;
    
    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return max;
    }
    
    private int maxDepth(TreeNode node) {
        if (node == null) return 0;
        
        int left = maxDepth(node.left);
        int right = maxDepth(node.right);
        
        max = Math.max(max, left + right);
        
        return Math.max(left, right) + 1;
    }
    
    public static void main(String[] args) {
    	TreeNode root = new TreeNode(1);
    	root.left = new TreeNode(2);
    	root.right = new TreeNode(3);
    	root.left.left = new TreeNode(4);
    	root.left.right = new TreeNode(5);
    	BTDiameter bt = new BTDiameter();
    	System.out.println(bt.diameterOfBinaryTree(root));
    }
}
