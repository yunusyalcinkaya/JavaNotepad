import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInorderTraversal {

    public static List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> list = new ArrayList<>();
        add(root,list);

        return list;
    }

    public static void add(TreeNode root, List<Integer> list) {
        if(root == null)
            return;
        add(root.left,list);
        list.add(root.val);
        add(root.right,list);
    }
    public static void main(String[] args) {
        // https://leetcode.com/problems/binary-tree-inorder-traversal/description/
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}