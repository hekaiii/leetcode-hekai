package BinaryTree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.SortedMap;
import javax.print.DocFlavor.READER;

/**  ArrayDeque是双端队列
 * @Date: 2022/4/23 21:38
 */
public class leetcode_102 {
    private TreeNode root;
    Deque<TreeNode> deque;
    public static List<List<Integer>> resList = new ArrayList<List<Integer>>();

    public static List<List<Integer>> levelOrder(TreeNode root) {
        level(root,0);
        return resList;
    }

    public static void level(TreeNode node, Integer deep) {
        if (node == null) return;
        deep++;
        if (resList.size() < deep) {
            //当层级增加时，list的Item也增加，利用list的索引值进行层级界定
            List<Integer> item = new ArrayList<Integer>();
            resList.add(item);
        }
        resList.get(deep - 1).add(node.val);
        level(node.left, deep);
        level(node.right, deep);
    }

    //插入二叉平衡树结点
    public boolean insertAVL(int data) {
        TreeNode node = new TreeNode(data);
        if(root == null){
            root = node;
            return true;
        }
        TreeNode targetNode  = root;
        while (targetNode != null) {
            if( data == targetNode.val){
                System.out.println("二叉查找树中已有重复的结点：" + data);
                return false;
            }
            else if (data > targetNode.val) {
                if(targetNode.right == null){
                    targetNode.right = node;
                    return true;
                }
                targetNode = targetNode.right;
            }
            else {
                if(targetNode.left == null){
                    targetNode.left = node;
                    return true;
                }
                targetNode = targetNode.left;
            }
        }
        return true;
    }

    //插入二叉树
    public void insert(int data) {
        this.root = root;
        deque = new LinkedList();
        Queue<TreeNode> queue = new LinkedList();
        queue.offer(root);

        // BFS to populate deque
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left == null || node.right == null)
                deque.offerLast(node);
            if (node.left != null)
                queue.offer(node.left);
            if (node.right != null)
                queue.offer(node.right);
        }

    }

    public static List<List<Integer>> levelOrder01(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> ints = new ArrayDeque<>();
        ints.add(root);

        while (!ints.isEmpty()) {
            int size = ints.size();
            ArrayList<Integer> list = new ArrayList<>();
            while (size > 0) {
                TreeNode poll = ints.poll();
                list.add(poll.val);
                size--;
                if (poll.left != null) {
                    ints.add(poll.left);
                }
                if (poll.right != null) {
                    ints.add(poll.right);
                }
                if (size == 0) {
                    result.add(list);
                }
            }
        }

        return result;
    }
    public static List<List<Integer>> levelOrder02(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        ArrayDeque<TreeNode> lists = new ArrayDeque<>();
        lists.add(root);
        while (!lists.isEmpty()) {
            int size = lists.size();
            ArrayList<Integer> level = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode pop = lists.pop();
                level.add(pop.val);
                if (pop.left != null) {
                    lists.add(pop.left);
                }
                if (pop.right != null) {
                    lists.add(pop.right);
                }
            }
            result.add(level);
        }
        return result;
    }

    public static List<List<Integer>> levelOrder03(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        ArrayDeque<TreeNode> nodes = new ArrayDeque<>();
        nodes.add(root);
        while (!nodes.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int size = nodes.size();
            while (size > 0) {
                TreeNode poll = nodes.poll();
                list.add(poll.val);
                size--;
                if (poll.left != null) {
                    nodes.add(poll.left);
                }
                if (poll.right != null) {
                    nodes.add(poll.right);
                }
                if (size == 0) {
                    result.add(list);
                }
            }
        }
        return result;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        List<List<Integer>> list = levelOrder03(root);
        System.out.println(String.valueOf(list));
    }
}
