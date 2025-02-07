//给你一个正整数 n ，生成一个包含 1 到 n² 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。 
//
// 
//
// 示例 1： 
// 
// 
//输入：n = 3
//输出：[[1,2,3],[8,9,4],[7,6,5]]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：[[1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 20 
// 
//
// Related Topics 数组 矩阵 模拟 👍 1400 👎 0
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        
        // 定义四个边界
        int left = 0, right = n - 1;
        int top = 0, bottom = n - 1;
        
        // 要填充的数字
        int num = 1;
        // 要填充的总数
        int total = n * n;
        
        while (num <= total) {
            // 从左到右填充上边
            for (int i = left; i <= right && num <= total; i++) {
                matrix[top][i] = num++;
            }
            top++;
            
            // 从上到下填充右边
            for (int i = top; i <= bottom && num <= total; i++) {
                matrix[i][right] = num++;
            }
            right--;
            
            // 从右到左填充下边
            for (int i = right; i >= left && num <= total; i--) {
                matrix[bottom][i] = num++;
            }
            bottom--;
            
            // 从下到上填充左边
            for (int i = bottom; i >= top && num <= total; i--) {
                matrix[i][left] = num++;
            }
            left++;
        }
        
        return matrix;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
