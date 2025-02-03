//给你一个字符串 s，最多 可以从中删除一个字符。 
//
// 请你判断 s 是否能成为回文字符串：如果能，返回 true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "aba"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：s = "abca"
//输出：true
//解释：你可以删除字符 'c' 。
// 
//
// 示例 3： 
//
// 
//输入：s = "abc"
//输出：false 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10⁵ 
// s 由小写英文字母组成 
// 
//
// Related Topics 贪心 双指针 字符串 👍 688 👎 0


import java.util.HashMap;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean validPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        
        // 从两端向中间检查
        while (left < right) {
            // 如果字符不相等，尝试删除一个字符
            if (s.charAt(left) != s.charAt(right)) {
                // 尝试删除左边的字符或右边的字符
                return isPalindrome(s, left + 1, right) || 
                       isPalindrome(s, left, right - 1);
            }
            left++;
            right--;
        }
        
        return true;
    }
    
    /**
     * 检查字符串指定范围是否为回文
     * @param s 字符串
     * @param left 左边界
     * @param right 右边界
     * @return 是否为回文
     */
    private boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
