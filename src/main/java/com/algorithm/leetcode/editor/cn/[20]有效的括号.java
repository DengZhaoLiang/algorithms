//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。 
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 每个右括号都有一个对应的相同类型的左括号。 
// 
//
// 
//
// 示例 1： 
//
// 
// 输入：s = "()" 
// 
//
// 输出：true 
//
// 示例 2： 
//
// 
// 输入：s = "()[]{}" 
// 
//
// 输出：true 
//
// 示例 3： 
//
// 
// 输入：s = "(]" 
// 
//
// 输出：false 
//
// 示例 4： 
//
// 
// 输入：s = "([])" 
// 
//
// 输出：true 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10⁴ 
// s 仅由括号 '()[]{}' 组成 
// 
//
// Related Topics 栈 字符串 👍 4654 👎 0

package com.algorithm.leetcode.editor.cn;
import java.util.Stack;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isValid(String s) {
        // 创建一个栈来存储左括号
        Stack<Character> stack = new Stack<>();
        
        // 遍历字符串中的每个字符
        for (char c : s.toCharArray()) {
            // 如果是左括号，入栈
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            }
            // 如果是右括号
            else {
                // 如果栈为空，说明没有左括号与之匹配
                if (stack.isEmpty()) {
                    return false;
                }
                
                // 获取栈顶的左括号
                char left = stack.pop();
                
                // 检查是否匹配
                if (c == ')' && left != '(') return false;
                if (c == '}' && left != '{') return false;
                if (c == ']' && left != '[') return false;
            }
        }
        
        // 最后检查栈是否为空
        return stack.isEmpty();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
