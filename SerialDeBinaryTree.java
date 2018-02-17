package facebook;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

import structure.TreeNode;

public class SerialDeBinaryTree {
	// Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        buildString(sb, root);
        return sb.toString();
    }
    
    private void buildString(StringBuilder sb, TreeNode node) {
        if (node == null) {
            sb.append("# ");
        } else {
            sb.append(node.val).append(" ");
            buildString(sb, node.left);
            buildString(sb, node.right);
        }   
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Deque<String> nodes = new LinkedList<>();
        nodes.addAll(Arrays.asList(data.split(" ")));
        return buildTree(nodes);
    }
    
    private TreeNode buildTree(Deque<String> nodes) {
        String val = nodes.remove();
        if (val.equals("#")) {
            return null;
        } else {
            TreeNode node = new TreeNode(Integer.valueOf(val));
            node.left = buildTree(nodes);
            node.right = buildTree(nodes);
            return node;
        }
    }
    
    public static void main(String[] args) {
    	TreeNode node = new TreeNode(1);
    	node.left = new TreeNode(2);
    	node.right = new TreeNode(3);
    	node.right.left = new TreeNode(4);
    	node.right.right = new TreeNode(5);
    	SerialDeBinaryTree sd = new SerialDeBinaryTree();
    	System.out.println(sd.serialize(node));
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
