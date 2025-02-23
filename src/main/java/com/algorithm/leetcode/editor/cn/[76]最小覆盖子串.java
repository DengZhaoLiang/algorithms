//给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。 
//
// 
//
// 注意： 
//
// 
// 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。 
// 如果 s 中存在这样的子串，我们保证它是唯一的答案。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "ADOBECODEBANC", t = "ABC"
//输出："BANC"
//解释：最小覆盖子串 "BANC" 包含来自字符串 t 的 'A'、'B' 和 'C'。
// 
//
// 示例 2： 
//
// 
//输入：s = "a", t = "a"
//输出："a"
//解释：整个字符串 s 是最小覆盖子串。
// 
//
// 示例 3: 
//
// 
//输入: s = "a", t = "aa"
//输出: ""
//解释: t 中两个字符 'a' 均应包含在 s 的子串中，
//因此没有符合条件的子字符串，返回空字符串。 
//
// 
//
// 提示： 
//
// 
// m == s.length 
// n == t.length 
// 1 <= m, n <= 10⁵ 
// s 和 t 由英文字母组成 
// 
//
// 
//进阶：你能设计一个在 
//o(m+n) 时间内解决此问题的算法吗？
//
// Related Topics 哈希表 字符串 滑动窗口 👍 3141 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) {
            return "";
        }
        
        // 使用数组记录字符频率（比HashMap更高效）
        int[] need = new int[128];  // 需要的字符频率
        int[] have = new int[128];  // 当前窗口中的字符频率
        
        // 统计t中字符频率
        for (char c : t.toCharArray()) {
            need[c]++;
        }
        
        int left = 0;           // 窗口左边界
        int minStart = 0;       // 最小窗口的起始位置
        int minLen = Integer.MAX_VALUE;  // 最小窗口长度
        int count = 0;          // 已匹配的字符数量
        
        // 移动右边界
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            
            // 更新当前窗口中的字符频率
            have[c]++;
            
            // 如果当前字符是需要的，且数量未超过需要的数量，则匹配数加1
            if (need[c] > 0 && have[c] <= need[c]) {
                count++;
            }
            
            // 当找到一个可行解时，尝试通过移动左边界来优化
            while (count == t.length()) {
                // 更新最小窗口
                if (right - left + 1 < minLen) {
                    minStart = left;
                    minLen = right - left + 1;
                }
                
                // 移除左边界字符
                char leftChar = s.charAt(left);
                have[leftChar]--;
                
                // 如果移除的是必需字符，且移除后数量不足，则匹配数减1
                if (need[leftChar] > 0 && have[leftChar] < need[leftChar]) {
                    count--;
                }
                
                left++;
            }
        }
        
        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
