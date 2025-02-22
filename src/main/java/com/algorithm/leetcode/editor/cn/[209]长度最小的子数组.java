//给定一个含有 n 个正整数的数组和一个正整数 target 。 
//
// 找出该数组中满足其总和大于等于 target 的长度最小的 子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其
//长度。如果不存在符合条件的子数组，返回 0 。 
//
// 
//
// 示例 1： 
//
// 
//输入：target = 7, nums = [2,3,1,2,4,3]
//输出：2
//解释：子数组 [4,3] 是该条件下的长度最小的子数组。
// 
//
// 示例 2： 
//
// 
//输入：target = 4, nums = [1,4,4]
//输出：1
// 
//
// 示例 3： 
//
// 
//输入：target = 11, nums = [1,1,1,1,1,1,1,1]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= target <= 10⁹ 
// 1 <= nums.length <= 10⁵ 
// 1 <= nums[i] <= 10⁴ 
// 
//
// 
//
// 进阶： 
//
// 
// 如果你已经实现 O(n) 时间复杂度的解法, 请尝试设计一个 O(n log(n)) 时间复杂度的解法。 
// 
//
// Related Topics 数组 二分查找 前缀和 滑动窗口 👍 2367 👎 0


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int left = 0;  // 窗口左边界
        int sum = 0;   // 当前窗口内的和
        int minLen = Integer.MAX_VALUE;  // 最小长度

        // 窗口右边界不断右移
        for (int right = 0; right < n; right++) {
            sum += nums[right];  // 加入新元素

            // 当和大于等于目标值时，尝试缩小窗口
            while (sum >= target) {
                minLen = Math.min(minLen, right - left + 1);
                sum -= nums[left];  // 移除最左边的元素
                left++;  // 左边界右移
            }
        }

        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
