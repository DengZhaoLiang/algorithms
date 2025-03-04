//给你一个 无重叠的 ，按照区间起始端点排序的区间列表 intervals，其中 intervals[i] = [starti, endi] 表示第 i 个区
//间的开始和结束，并且 intervals 按照 starti 升序排列。同样给定一个区间 newInterval = [start, end] 表示另一个区间的
//开始和结束。 
//
// 在 intervals 中插入区间 newInterval，使得 intervals 依然按照 starti 升序排列，且区间之间不重叠（如果有必要的话，
//可以合并区间）。 
//
// 返回插入之后的 intervals。 
//
// 注意 你不需要原地修改 intervals。你可以创建一个新数组然后返回它。 
//
// 
//
// 示例 1： 
//
// 
//输入：intervals = [[1,3],[6,9]], newInterval = [2,5]
//输出：[[1,5],[6,9]]
// 
//
// 示例 2： 
//
// 
//输入：intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
//输出：[[1,2],[3,10],[12,16]]
//解释：这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10] 重叠。
// 
//
// 
//
// 提示： 
//
// 
// 0 <= intervals.length <= 10⁴ 
// intervals[i].length == 2 
// 0 <= starti <= endi <= 10⁵ 
// intervals 根据 starti 按 升序 排列 
// newInterval.length == 2 
// 0 <= start <= end <= 10⁵ 
// 
//
// Related Topics 数组 👍 970 👎 0


package com.algorithm.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        // 创建动态数组存储结果
        List<int[]> result = new ArrayList<>();
        
        // 如果原始区间为空，直接返回新区间
        if (intervals == null || intervals.length == 0) {
            return new int[][] {newInterval};
        }
        
        // 标记新区间是否已被插入
        boolean hasInserted = false;
        
        // 遍历所有区间
        for (int i = 0; i < intervals.length; i++) {
            // 情况1：当前区间在新区间之前，不重叠
            if (intervals[i][1] < newInterval[0]) {
                result.add(intervals[i]);
            }
            // 情况2：当前区间在新区间之后，不重叠
            else if (intervals[i][0] > newInterval[1]) {
                // 如果新区间还没插入，先插入新区间
                if (!hasInserted) {
                    result.add(newInterval);
                    hasInserted = true;
                }
                result.add(intervals[i]);
            }
            // 情况3：有重叠，更新新区间的范围
            else {
                newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
                newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            }
        }
        
        // 如果遍历完还没插入新区间，将其加入结果
        if (!hasInserted) {
            result.add(newInterval);
        }
        
        // 将List转换为数组返回
        return result.toArray(new int[result.size()][]);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

