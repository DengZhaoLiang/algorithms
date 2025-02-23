//给定一个字符串 s 和一个字符串数组 words。 words 中所有字符串 长度相同。 
//
// s 中的 串联子串 是指一个包含 words 中所有字符串以任意顺序排列连接起来的子串。 
//
// 
// 例如，如果 words = ["ab","cd","ef"]， 那么 "abcdef"， "abefcd"，"cdabef"， "cdefab"，
//"efabcd"， 和 "efcdab" 都是串联子串。 "acdbef" 不是串联子串，因为他不是任何 words 排列的连接。 
// 
//
// 返回所有串联子串在 s 中的开始索引。你可以以 任意顺序 返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "barfoothefoobarman", words = ["foo","bar"]
//输出：[0,9]
//解释：因为 words.length == 2 同时 words[i].length == 3，连接的子字符串的长度必须为 6。
//子串 "barfoo" 开始位置是 0。它是 words 中以 ["bar","foo"] 顺序排列的连接。
//子串 "foobar" 开始位置是 9。它是 words 中以 ["foo","bar"] 顺序排列的连接。
//输出顺序无关紧要。返回 [9,0] 也是可以的。
// 
//
// 示例 2： 
//
// 
//输入：s = "wordgoodgoodgoodbestword", words = ["word","good","best","word"]
//输出：[]
//解释：因为 words.length == 4 并且 words[i].length == 4，所以串联子串的长度必须为 16。
//s 中没有子串长度为 16 并且等于 words 的任何顺序排列的连接。
//所以我们返回一个空数组。
// 
//
// 示例 3： 
//
// 
//输入：s = "barfoofoobarthefoobarman", words = ["bar","foo","the"]
//输出：[6,9,12]
//解释：因为 words.length == 3 并且 words[i].length == 3，所以串联子串的长度必须为 9。
//子串 "foobarthe" 开始位置是 6。它是 words 中以 ["foo","bar","the"] 顺序排列的连接。
//子串 "barthefoo" 开始位置是 9。它是 words 中以 ["bar","the","foo"] 顺序排列的连接。
//子串 "thefoobar" 开始位置是 12。它是 words 中以 ["the","foo","bar"] 顺序排列的连接。 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10⁴ 
// 1 <= words.length <= 5000 
// 1 <= words[i].length <= 30 
// words[i] 和 s 由小写英文字母组成 
// 
//
// Related Topics 哈希表 字符串 滑动窗口 👍 1194 👎 0


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0) {
            return result;
        }

        // 初始化单词频率表
        Map<String, Integer> wordCount = new HashMap<>();
        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        int wordLength = words[0].length();  // 每个单词的长度
        int totalWords = words.length;       // 单词总数
        int totalLength = wordLength * totalWords;  // 所有单词串联后的总长度

        // 考虑所有可能的起始位置
        for (int i = 0; i < wordLength; i++) {
            // 使用滑动窗口
            int left = i;
            Map<String, Integer> windowCount = new HashMap<>();
            int count = 0;  // 窗口中匹配的单词数

            // 右指针移动
            for (int right = i; right <= s.length() - wordLength; right += wordLength) {
                // 获取当前单词
                String word = s.substring(right, right + wordLength);

                // 如果是目标单词
                if (wordCount.containsKey(word)) {
                    // 添加到窗口计数
                    windowCount.put(word, windowCount.getOrDefault(word, 0) + 1);
                    count++;

                    // 如果当前单词出现次数超过要求，收缩窗口
                    while (windowCount.get(word) > wordCount.get(word)) {
                        String leftWord = s.substring(left, left + wordLength);
                        windowCount.put(leftWord, windowCount.get(leftWord) - 1);
                        left += wordLength;
                        count--;
                    }

                    // 如果找到所有单词
                    if (count == totalWords) {
                        result.add(left);
                        // 移除最左边的单词，继续寻找下一个匹配
                        String leftWord = s.substring(left, left + wordLength);
                        windowCount.put(leftWord, windowCount.get(leftWord) - 1);
                        left += wordLength;
                        count--;
                    }
                } else {
                    // 如果不是目标单词，重置窗口
                    windowCount.clear();
                    count = 0;
                    left = right + wordLength;
                }
            }
        }

        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
