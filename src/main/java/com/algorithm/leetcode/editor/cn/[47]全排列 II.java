//给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,2]
//输出：
//[[1,1,2],
// [1,2,1],
// [2,1,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 8 
// -10 <= nums[i] <= 10 
// 
//
// Related Topics 数组 回溯 排序 👍 1672 👎 0


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        
        // 先对数组排序，便于处理重复元素
        Arrays.sort(nums);
        
        // 用于标记元素是否被使用
        boolean[] used = new boolean[nums.length];
        
        // 回溯法生成排列
        backtrack(nums, used, new ArrayList<>(), result);
        
        return result;
    }
    
    /**
     * 回溯方法生成排列
     * @param nums 原始数组
     * @param used 标记数组，记录元素是否被使用
     * @param current 当前正在构建的排列
     * @param result 结果集合
     */
    private void backtrack(int[] nums, boolean[] used, List<Integer> current, List<List<Integer>> result) {
        // 当前排列已完成
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }
        
        for (int i = 0; i < nums.length; i++) {
            // 跳过已使用的元素
            if (used[i]) {
                continue;
            }
            
            // 剪枝：跳过重复元素
            // 当前元素与前一个元素相同，且前一个元素未被使用时，跳过
            // 这样确保对于重复元素，我们只会按照它们在数组中出现的顺序使用它们
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }
            
            // 选择当前元素
            used[i] = true;
            current.add(nums[i]);
            
            // 递归生成后续排列
            backtrack(nums, used, current, result);
            
            // 回溯，撤销选择
            current.remove(current.size() - 1);
            used[i] = false;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
