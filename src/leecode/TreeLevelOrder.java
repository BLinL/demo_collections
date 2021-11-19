package leecode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 102. 二叉树层序遍历
 */
public class TreeLevelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int count = queue.size();

            List<Integer> level = new ArrayList<>();
            for(;count > 0;){
                TreeNode node = queue.poll();
                if(node != null){
                    level.add(node.val);
                    queue.offer(node.left);
                    queue.offer(node.right);
                }

                count--;
            }

            if(!level.isEmpty())
                result.add(level);

        }
        return result;
    }
}
