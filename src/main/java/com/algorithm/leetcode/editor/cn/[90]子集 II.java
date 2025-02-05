//给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的 子集（幂集）。 
//
// 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。 
//
// 
// 
// 
// 
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,2]
//输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0]
//输出：[[],[0]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10 
// -10 <= nums[i] <= 10 
// 
//
// Related Topics 位运算 数组 回溯 👍 1286 👎 0


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        // 先对数组排序，便于处理重复元素
        Arrays.sort(nums);
        // 回溯法生成所有子集
        backtrack(nums, 0, new ArrayList<>(), result);
        return result;
    }
    
    /**
     * 回溯方法生成子集
     * @param nums 原始数组
     * @param start 当前处理的起始位置
     * @param current 当前正在构建的子集
     * @param result 结果集合
     */
    private void backtrack(int[] nums, int start, List<Integer> current, List<List<Integer>> result) {
        // 将当前子集加入结果集
        result.add(new ArrayList<>(current));
        
        // 从start开始遍历，避免重复生成
        for (int i = start; i < nums.length; i++) {
            // 跳过重复元素，确保每个数字在相同位置只被使用一次
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            // 选择当前元素
            current.add(nums[i]);
            // 递归生成后续子集
            backtrack(nums, i + 1, current, result);
            // 回溯，移除当前元素
            current.remove(current.size() - 1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
