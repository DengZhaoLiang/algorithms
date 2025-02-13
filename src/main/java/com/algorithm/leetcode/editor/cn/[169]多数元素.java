//给定一个大小为 n 的数组 nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。 
//
// 你可以假设数组是非空的，并且给定的数组总是存在多数元素。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [3,2,3]
//输出：3 
//
// 示例 2： 
//
// 
//输入：nums = [2,2,1,1,1,2,2]
//输出：2
// 
//
// 
//提示：
//
// 
// n == nums.length 
// 1 <= n <= 5 * 10⁴ 
// -10⁹ <= nums[i] <= 10⁹ 
// 
//
// 
//
// 进阶：尝试设计时间复杂度为 O(n)、空间复杂度为 O(1) 的算法解决此问题。 
//
// Related Topics 数组 哈希表 分治 计数 排序 👍 2392 👎 0


import java.util.HashMap;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int majorityElement(int[] nums) {
        // Moore 投票算法
        int candidate = nums[0];  // 候选众数
        int count = 1;           // 计数器
        
        // 遍历数组
        for (int i = 1; i < nums.length; i++) {
            // 如果计数器为0，更换候选众数
            if (count == 0) {
                candidate = nums[i];
                count = 1;
                continue;
            }
            
            // 如果当前数字等于候选众数，计数器加1
            if (nums[i] == candidate) {
                count++;
            } else {
                // 如果当前数字不等于候选众数，计数器减1
                count--;
            }
        }
        
        return candidate;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
