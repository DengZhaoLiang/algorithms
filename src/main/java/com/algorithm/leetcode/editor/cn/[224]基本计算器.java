//给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。 
//
// 注意:不允许使用任何将字符串作为数学表达式计算的内置函数，比如 eval() 。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "1 + 1"
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：s = " 2-1 + 2 "
//输出：3
// 
//
// 示例 3： 
//
// 
//输入：s = "(1+(4+5+2)-3)+(6+8)"
//输出：23
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 3 * 10⁵ 
// s 由数字、'+'、'-'、'('、')'、和 ' ' 组成 
// s 表示一个有效的表达式 
// '+' 不能用作一元运算(例如， "+1" 和 "+(2 + 3)" 无效) 
// '-' 可以用作一元运算(即 "-1" 和 "-(2 + 3)" 是有效的) 
// 输入中不存在两个连续的操作符 
// 每个数字和运行的计算将适合于一个有符号的 32位 整数 
// 
//
// Related Topics 栈 递归 数学 字符串 👍 1109 👎 0

package com.algorithm.leetcode.editor.cn;

import java.util.Stack;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();  // 用于保存之前的结果和符号
        int result = 0;    // 当前计算结果
        int num = 0;       // 当前数字
        int sign = 1;      // 当前符号：1表示加，-1表示减

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            } else if (c == '+') {
                result += sign * num;
                num = 0;
                sign = 1;
            } else if (c == '-') {
                result += sign * num;
                num = 0;
                sign = -1;
            } else if (c == '(') {
                // 保存当前结果和符号
                stack.push(result);
                stack.push(sign);
                // 重置当前计算
                result = 0;
                sign = 1;
            } else if (c == ')') {
                // 处理括号内最后一个数字
                result += sign * num;
                num = 0;
                // 获取括号前的符号和结果
                result *= stack.pop();    // 与括号前的符号相乘
                result += stack.pop();    // 加上括号前的结果
            }
        }

        // 处理最后一个数字
        result += sign * num;

        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
