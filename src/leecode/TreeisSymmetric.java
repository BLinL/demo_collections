package leecode;

/**
 * 101. 对称二叉树
 * 难度 简单
 * 递归解法
 */
public class TreeisSymmetric {

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        } else {
            return isMirro(root.left, root.right);
        }
    }

    public boolean isMirro(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }

        if (left == null || right == null) {
           return false;
        }

        if (left.val == right.val) {
            return isMirro(right.left, left.right) && isMirro(left.left, right.right);
        }

        return false;
    }

}
