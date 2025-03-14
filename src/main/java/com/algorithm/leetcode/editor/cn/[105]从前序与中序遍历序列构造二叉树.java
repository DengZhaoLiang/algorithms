//给定两个整数数组 preorder 和 inorder ，其中 preorder 是二叉树的先序遍历， inorder 是同一棵树的中序遍历，请构造二叉树并
//返回其根节点。 
//
// 
//
// 示例 1: 
// 
// 
//输入: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
//输出: [3,9,20,null,null,15,7]
// 
//
// 示例 2: 
//
// 
//输入: preorder = [-1], inorder = [-1]
//输出: [-1]
// 
//
// 
//
// 提示: 
//
// 
// 1 <= preorder.length <= 3000 
// inorder.length == preorder.length 
// -3000 <= preorder[i], inorder[i] <= 3000 
// preorder 和 inorder 均 无重复 元素 
// inorder 均出现在 preorder 
// preorder 保证 为二叉树的前序遍历序列 
// inorder 保证 为二叉树的中序遍历序列 
// 
//
// Related Topics 树 数组 哈希表 分治 二叉树 👍 2494 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
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
    private Map<Integer, Integer> indexMap = new HashMap<>();
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // 将中序遍历的值和下标存储在哈希表中
        for (int i = 0; i < inorder.length; i++) {
            indexMap.put(inorder[i], i);
        }
        
        return buildTreeHelper(preorder, 0, preorder.length - 1,
                             inorder, 0, inorder.length - 1);
    }
    
    private TreeNode buildTreeHelper(int[] preorder, int preStart, int preEnd,
                                   int[] inorder, int inStart, int inEnd) {
        if (preStart > preEnd) {
            return null;
        }
        
        // 创建根节点
        TreeNode root = new TreeNode(preorder[preStart]);
        
        // 在中序遍历中找到根节点的位置
        int rootIndex = indexMap.get(root.val);
        int leftSubtreeSize = rootIndex - inStart;
        
        // 递归构建左右子树
        root.left = buildTreeHelper(preorder, preStart + 1, preStart + leftSubtreeSize,
                                  inorder, inStart, rootIndex - 1);
        
        root.right = buildTreeHelper(preorder, preStart + leftSubtreeSize + 1, preEnd,
                                   inorder, rootIndex + 1, inEnd);
        
        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
