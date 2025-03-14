//给你一个二叉树的根节点 root ， 检查它是否轴对称。 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [1,2,2,3,4,4,3]
//输出：true
// 
//
// 示例 2： 
// 
// 
//输入：root = [1,2,2,null,3,null,3]
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [1, 1000] 内 
// -100 <= Node.val <= 100 
// 
//
// 
//
// 进阶：你可以运用递归和迭代两种方法解决这个问题吗？ 
//
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 2912 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.LinkedList;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        
        LinkedList<TreeNode> queue = new LinkedList<>();
        // 添加左右子树的根节点
        queue.add(root.left);
        queue.add(root.right);
        
        while (!queue.isEmpty()) {
            // 每次取出两个节点进行比较
            TreeNode left = queue.poll();
            TreeNode right = queue.poll();
            
            // 如果两个节点都为空，继续比较
            if (left == null && right == null) continue;
            
            // 如果其中一个为空或者值不相等，返回false
            if (left == null || right == null || left.val != right.val) {
                return false;
            }
            
            // 添加外侧节点和内侧节点，保持对称性
            queue.add(left.left);   // 左子树的左节点
            queue.add(right.right); // 右子树的右节点
            queue.add(left.right);  // 左子树的右节点
            queue.add(right.left);  // 右子树的左节点
        }
        
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
