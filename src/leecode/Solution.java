package leecode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;


/**
 * 二叉树中序遍历
 *
 **/
class TreeNode {
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

public class Solution {

    /*
    *遍历
    * */
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        while(null != root) {
            stack.push(root);
            root = root.left;
        }

        while (stack.size() > 0) {
            TreeNode t = stack.pop();
            res.add(t.val);
            t = t.right;

            while(null != t) {
                stack.push(t);
                t = t.left;
            }
        }

        return res;
    }



    public List<Integer> inorderTraversal1(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        traversal(root, res);
        return res;
    }

    /*
    * 递归
    * */
    public void traversal(TreeNode treeNode,  ArrayList<Integer> res) {
        if(null != treeNode) {
            traversal(treeNode.left, res);
            res.add(treeNode.val);
            traversal(treeNode.right, res);
        }else{
            return;
        }
    }
}