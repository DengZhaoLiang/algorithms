//给定一个字符串 s ，请你找出其中不含有重复字符的 最长 子串 的长度。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 
//输入: s = "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 
//输入: s = "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 5 * 10⁴ 
// s 由英文字母、数字、符号和空格组成 
// 
//
// Related Topics 哈希表 字符串 滑动窗口 👍 10611 👎 0


import java.util.HashMap;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;

        int n = s.length();
        int maxLen = 0;
        // 存储字符及其最后出现的位置
        Map<Character, Integer> map = new HashMap<>();

        // 滑动窗口的左边界
        int left = 0;

        // 滑动窗口的右边界
        for (int right = 0; right < n; right++) {
            char c = s.charAt(right);

            // 如果字符已经在map中，并且其位置大于等于左边界
            // 则需要更新左边界到重复字符的下一个位置
            if (map.containsKey(c)) {
                left = Math.max(left, map.get(c) + 1);
            }

            // 更新当前字符的位置
            map.put(c, right);

            // 更新最大长度
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
