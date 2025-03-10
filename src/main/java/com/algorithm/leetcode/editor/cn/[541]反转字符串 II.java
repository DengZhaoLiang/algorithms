//给定一个字符串 s 和一个整数 k，从字符串开头算起，每计数至 2k 个字符，就反转这 2k 字符中的前 k 个字符。 
//
// 
// 如果剩余字符少于 k 个，则将剩余字符全部反转。 
// 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "abcdefg", k = 2
//输出："bacdfeg"
// 
//
// 示例 2： 
//
// 
//输入：s = "abcd", k = 2
//输出："bacd"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10⁴ 
// s 仅由小写英文组成 
// 1 <= k <= 10⁴ 
// 
//
// Related Topics 双指针 字符串 👍 647 👎 0


import com.sun.tools.javac.Main;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String reverseStr(String s, int k) {
        char[] arr = s.toCharArray();

        // 每隔2k个字符处理一次
        for (int start = 0; start < arr.length; start += 2 * k) {
            // 计算需要反转的字符数量
            // 如果剩余字符小于k，全部反转
            // 如果剩余字符大于等于k，反转k个字符
            int i = start;
            int j = Math.min(start + k - 1, arr.length - 1);

            // 反转字符
            while (i < j) {
                char temp = arr[i];
                arr[i++] = arr[j];
                arr[j--] = temp;
            }
        }

        return new String(arr);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
