package BinaryTree;

/**
 * @Author: hek32
 * @Description: AVL树是自平衡 左旋右旋
 * @Date: 2025/6/11
 */
public class AVLDelete {

    public TreeNode delete(TreeNode root, int key) {
      if (root == null) return null;

      // 1. 标准 BST 删除节点过程
      if (key < root.val) {
        root.left = delete(root.left, key);
      } else if (key > root.val) {
        root.right = delete(root.right, key);
      } else {
        // 找到要删除的节点
        if (root.left == null || root.right == null) {
          root = (root.left != null) ? root.left : root.right;
        } else {
          // 找右子树最小值替换
          TreeNode minLargerNode = getMinValueNode(root.right);
          root.val = minLargerNode.val;
          root.right = delete(root.right, minLargerNode.val);
        }
      }

      if (root == null) return null;

      // 2. 更新高度
      root.height = 1 + Math.max(getHeight(root.left), getHeight(root.right));

      // 3. 获取平衡因子
      int balance = getBalance(root);

      // 4. 平衡调整（四种情况）

      // 左左
      if (balance > 1 && getBalance(root.left) >= 0)
        return rotateRight(root);

      // 左右
      if (balance > 1 && getBalance(root.left) < 0) {
        root.left = rotateLeft(root.left);
        return rotateRight(root);
      }

      // 右右
      if (balance < -1 && getBalance(root.right) <= 0)
        return rotateLeft(root);

      // 右左
      if (balance < -1 && getBalance(root.right) > 0) {
        root.right = rotateRight(root.right);
        return rotateLeft(root);
      }

      return root;
    }

    private int getHeight(TreeNode node) {
      return (node == null) ? 0 : node.height;
    }

    private int getBalance(TreeNode node) {
      return (node == null) ? 0 : getHeight(node.left) - getHeight(node.right);
    }

    private TreeNode rotateRight(TreeNode y) {
      TreeNode x = y.left;
      TreeNode T2 = x.right;

      // 旋转
      x.right = y;
      y.left = T2;

      // 更新高度
      y.height = Math.max(getHeight(y.left), getHeight(y.right)) + 1;
      x.height = Math.max(getHeight(x.left), getHeight(x.right)) + 1;

      return x;
    }

    private TreeNode rotateLeft(TreeNode x) {
      TreeNode y = x.right;
      TreeNode T2 = y.left;

      // 旋转
      y.left = x;
      x.right = T2;

      // 更新高度
      x.height = Math.max(getHeight(x.left), getHeight(x.right)) + 1;
      y.height = Math.max(getHeight(y.left), getHeight(y.right)) + 1;

      return y;
    }

    private TreeNode getMinValueNode(TreeNode node) {
      TreeNode current = node;
      while (current.left != null)
        current = current.left;
      return current;
    }
  }
