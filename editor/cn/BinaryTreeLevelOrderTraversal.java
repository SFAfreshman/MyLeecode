//给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。 
//
// 
//
// 示例： 
//二叉树：[3,9,20,null,null,15,7], 
//
// 
//    3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回其层序遍历结果： 
//
// 
//[
//  [3],
//  [9,20],
//  [15,7]
//]
// 
// Related Topics 树 广度优先搜索 
// 👍 881 👎 0

import java.util.*;

/* 2021-05-30 21:49:24 */
public class BinaryTreeLevelOrderTraversal {
    public static void main(String[] args) {
        Solution solution = new BinaryTreeLevelOrderTraversal().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            ArrayList<List<Integer>> res = new ArrayList<>();//TODO 只分配空间的ArrayList等初始值是[]吗?:是
            Queue<TreeNode> q1 = new LinkedList<>();
            q1.offer(root);
            if (root != null) {
                res.add(Arrays.asList(new Integer[]{root.val}));
            }
            else return res;//新增:解决传入[]空二叉树
            while (!q1.isEmpty()) {
                ArrayList<Integer> curlevel = new ArrayList<>();//当前层值 默认为[]
                int size = q1.size();
                for (int i = 0; i < size; i++) {
                    TreeNode cur = q1.poll();
                    if (cur.left != null) {
                        q1.offer(cur.left);
                        curlevel.add(cur.left.val);
                    }
                    if (cur.right != null) {
                        q1.offer(cur.right);
                        curlevel.add(cur.right.val);
                    }
                }
                if(!curlevel.isEmpty())
                res.add(curlevel);//for循环结束即操作了一层,进入下一个while循环
            }
            return res;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}