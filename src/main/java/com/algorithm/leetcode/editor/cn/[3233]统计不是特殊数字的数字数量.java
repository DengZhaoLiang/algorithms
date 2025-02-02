//给你两个 正整数 l 和 r。对于任何数字 x，x 的所有正因数（除了 x 本身）被称为 x 的 真因数。 
//
// 如果一个数字恰好仅有两个 真因数，则称该数字为 特殊数字。例如： 
//
// 
// 数字 4 是 特殊数字，因为它的真因数为 1 和 2。 
// 数字 6 不是 特殊数字，因为它的真因数为 1、2 和 3。 
// 
//
// 返回区间 [l, r] 内 不是 特殊数字 的数字数量。 
//
// 
//
// 示例 1： 
//
// 
// 输入： l = 5, r = 7 
// 
//
// 输出： 3 
//
// 解释： 
//
// 区间 [5, 7] 内不存在特殊数字。 
//
// 示例 2： 
//
// 
// 输入： l = 4, r = 16 
// 
//
// 输出： 11 
//
// 解释： 
//
// 区间 [4, 16] 内的特殊数字为 4 和 9。 
//
// 
//
// 提示： 
//
// 
// 1 <= l <= r <= 10⁹ 
// 
//
// Related Topics 数组 数学 数论 👍 41 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

/**
 * 统计不是特殊数字的数字数量
 * 
 * 优化思路：
 * 1. 特殊数字必须是质数的平方
 * 2. 使用埃氏筛法找出范围内的质数
 * 3. 只需要检查质数的平方是否在范围内
 */
class Solution {
    public int nonSpecialCount(int l, int r) {
        // 计算范围内的所有特殊数字（质数的平方）
        int sqrtR = (int) Math.sqrt(r);
        boolean[] isNotPrime = new boolean[sqrtR + 1]; // 标记非质数
        int specialCount = 0;
        
        // 埃氏筛法找出质数
        for (int i = 2; i <= sqrtR; i++) {
            if (!isNotPrime[i]) {
                // 如果i是质数，标记其倍数为非质数
                for (int j = i * i; j <= sqrtR; j += i) {
                    isNotPrime[j] = true;
                }
                
                // 计算质数的平方，检查是否在范围内
                long square = (long) i * i;
                if (square >= l && square <= r) {
                    specialCount++;
                }
            }
        }
        
        // 返回不是特殊数字的数量
        return r - l + 1 - specialCount;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
