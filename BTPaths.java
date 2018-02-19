package facebook;

import java.util.ArrayList;
import java.util.List;

import structure.TreeNode;

public class BTPaths {
	public List<String> binaryTreePaths(TreeNode root) {
        List<String> rst = new ArrayList<>();
        if (root != null) searchBT(root, "", rst);
        return rst;
    }
    
    private void searchBT(TreeNode node, String list, List<String> rst) {
        if (node.left == null && node.right == null) rst.add(list + node.val);
        if (node.left != null) searchBT(node.left, list + node.val + "->", rst);
        if (node.right != null) searchBT(node.right, list + node.val + "->", rst);
    }
    
    public static void main(String[] args) {
    	TreeNode root = new TreeNode(1);
    	root.left = new TreeNode(2);
    	root.left.right = new TreeNode(5);
    	root.right = new TreeNode(3);
    	BTPaths bt = new BTPaths();
    	System.out.println(bt.binaryTreePaths(root));
    }
}
