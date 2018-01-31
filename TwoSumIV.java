package first;

import java.util.HashSet;

import structure.TreeNode;

public class TwoSumIV {
	//Time O(M) Space O(M) M is # of nodes
    public boolean findTarget(TreeNode root, int k) {
        HashSet<Integer> set = new HashSet<>();
        return dfs(root, k, set);
    }
    
    public boolean dfs(TreeNode root, int k, HashSet<Integer> set) {
        if (root == null) {
            return false;
        }
        if (k - root.val != root.val && set.contains(k - root.val)) {
            return true;
        }
        set.add(root.val);
        return dfs(root.left, k, set) || dfs(root.right, k, set);
    }
    
    public static void main(String[] args) {
    	TreeNode root = new TreeNode(5);
    	root.left = new TreeNode(3);
    	root.right = new TreeNode(6);
    	root.left.left = new TreeNode(2);
    	root.left.right = new TreeNode(4);
    	root.right.right = new TreeNode(7);
    	
    	int target1 = 9;
    	int target2 = 28;
    	
    	TwoSumIV ts = new TwoSumIV();
    	System.out.println(ts.findTarget(root, target1));
    	System.out.println(ts.findTarget(root, target2));
    }
}
