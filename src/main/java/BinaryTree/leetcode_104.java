package BinaryTree;

import javax.swing.text.LabelView;
import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;

/**
 * @Date: 2022/4/26 13:01
 */
public class leetcode_104 {
    public int depth = 0;
    public int maxDepth(TreeNode root) {
        int deep = 0;
        level(root, deep);
        return depth;
    }

    public void level(TreeNode root, int deep) {
        if (root == null) {
            return;
        }
        deep++;
        if (deep > depth) {
            depth++;
        }
        level(root.left, deep);
        level(root.right, deep);
    }


    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
