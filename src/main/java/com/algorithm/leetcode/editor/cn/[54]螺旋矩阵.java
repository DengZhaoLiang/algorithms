//给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。 
//
// 
//
// 示例 1： 
// 
// 
//输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[1,2,3,6,9,8,7,4,5]
// 
//
// 示例 2： 
// 
// 
//输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
//输出：[1,2,3,4,8,12,11,10,9,5,6,7]
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 10 
// -100 <= matrix[i][j] <= 100 
// 
//
// Related Topics 数组 矩阵 模拟 👍 1863 👎 0


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        List<Integer> res = new ArrayList<Integer>();
        // 定义四个边界
        int left = 0, right = n - 1;
        int top = 0, bottom = m - 1;

        // 要填充个数
        int num = 1;
        // 要填充的次数
        int total = m * n;

        while (num <= total) {
            // 从左到右填充上边
            for (int i = left; i <= right && num <= total; i++) {
                res.add(matrix[top][i]);
                num++;
            }
            top++;

            // 从上到下填充右边
            for (int i = top; i <= bottom && num <= total; i++) {
                res.add(matrix[i][right]);
                num++;
            }
            right--;

            // 从右到左填充下边
            for (int i = right; i >= left && num <= total; i--) {
                res.add(matrix[bottom][i]);
                num++;
            }
            bottom--;

            // 从下到上填充左边
            for (int i = bottom; i >= top && num <= total; i--) {
                res.add(matrix[i][left]);
                num++;
            }
            left++;
        }

        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
