//编写一个算法来判断一个数 n 是不是快乐数。 
//
// 「快乐数」 定义为： 
//
// 
// 对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和。 
// 然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。 
// 如果这个过程 结果为 1，那么这个数就是快乐数。 
// 
//
// 如果 n 是 快乐数 就返回 true ；不是，则返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 19
//输出：true
//解释：
//1² + 9² = 82
//8² + 2² = 68
//6² + 8² = 100
//1² + 0² + 0² = 1
// 
//
// 示例 2： 
//
// 
//输入：n = 2
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 2³¹ - 1 
// 
//
// Related Topics 哈希表 数学 双指针 👍 1675 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 判断一个数是否为快乐数。
     *
     * @param n 要判断的正整数
     * @return 如果n是快乐数，返回true；否则，返回false
     */
    public boolean isHappy(int n) {
        // 初始化快慢指针
        int slow = n;
        int fast = getNext(n);

        // 使用快慢指针检测循环
        while (fast != 1 && slow != fast) {
            slow = getNext(slow);          // 慢指针每次移动一步
            fast = getNext(getNext(fast)); // 快指针每次移动两步
        }

        // 如果fast为1，说明是快乐数
        return fast == 1;
    }

    /**
     * 计算一个数的各位数字平方和。
     *
     * @param number 要计算的整数
     * @return 各位数字平方和
     */
    private int getNext(int number) {
        int totalSum = 0;
        while (number > 0) {
            int digit = number % 10;        // 取最低位数字
            totalSum += digit * digit;      // 加上该数字的平方
            number /= 10;                   // 去掉最低位数字
        }
        return totalSum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
