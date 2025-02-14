//给定一个整数数组 nums，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [1,2,3,4,5,6,7], k = 3
//输出: [5,6,7,1,2,3,4]
//解释:
//向右轮转 1 步: [7,1,2,3,4,5,6]
//向右轮转 2 步: [6,7,1,2,3,4,5]
//向右轮转 3 步: [5,6,7,1,2,3,4]
// 
//
// 示例 2: 
//
// 
//输入：nums = [-1,-100,3,99], k = 2
//输出：[3,99,-1,-100]
//解释: 
//向右轮转 1 步: [99,-1,-100,3]
//向右轮转 2 步: [3,99,-1,-100] 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// -2³¹ <= nums[i] <= 2³¹ - 1 
// 0 <= k <= 10⁵ 
// 
//
// 
//
// 进阶： 
//
// 
// 尽可能想出更多的解决方案，至少有 三种 不同的方法可以解决这个问题。 
// 你可以使用空间复杂度为 O(1) 的 原地 算法解决这个问题吗？ 
// 
//
// Related Topics 数组 数学 双指针 👍 2310 👎 0


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length <= 1 || k == 0) {
            return;
        }
        
        int n = nums.length;
        k = k % n; // 处理 k > n 的情况
        
        // 1. 反转整个数组
        reverse(nums, 0, n - 1);
        // 2. 反转前k个元素
        reverse(nums, 0, k - 1);
        // 3. 反转剩余元素
        reverse(nums, k, n - 1);
    }
    
    /**
     * 反转数组指定范围内的元素
     * @param nums 数组
     * @param start 起始位置
     * @param end 结束位置
     */
    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            // 使用异或运算交换元素，不需要额外的临时变量
            nums[start] ^= nums[end];
            nums[end] ^= nums[start];
            nums[start] ^= nums[end];
            start++;
            end--;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
