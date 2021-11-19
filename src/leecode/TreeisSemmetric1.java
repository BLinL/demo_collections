package leecode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 101. 对称二叉树
 * 难度 简单
 * 迭代解法
 */
public class TreeisSemmetric1 {
    public boolean isSemmetric(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) {
            queue.offer(root.left);
            queue.offer(root.right);
            while (!queue.isEmpty()) {
                TreeNode left = queue.poll();
                TreeNode right = queue.poll();

                if (left == null & right == null) {
                    return false;
                } else if (left == null) {
                    return false;
                } else if (right == null) {
                    return false;
                } else {
                    if (left.val == right.val) {
                        queue.offer(left.left);
                        queue.offer(right.right);
                        queue.offer(right.left);
                        queue.offer(left.right);
                    }else {
                        return false;
                    }
                }
            }
            return true;
        }else {
            return false;
        }
    }
}
