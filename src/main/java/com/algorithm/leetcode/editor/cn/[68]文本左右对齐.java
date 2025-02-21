//给定一个单词数组 words 和一个长度 maxWidth ，重新排版单词，使其成为每行恰好有 maxWidth 个字符，且左右两端对齐的文本。 
//
// 你应该使用 "贪心算法" 来放置给定的单词；也就是说，尽可能多地往每行中放置单词。必要时可用空格 ' ' 填充，使得每行恰好有 maxWidth 个字符。
// 
//
// 要求尽可能均匀分配单词间的空格数量。如果某一行单词间的空格不能均匀分配，则左侧放置的空格数要多于右侧的空格数。 
//
// 文本的最后一行应为左对齐，且单词之间不插入额外的空格。 
//
// 注意: 
//
// 
// 单词是指由非空格字符组成的字符序列。 
// 每个单词的长度大于 0，小于等于 maxWidth。 
// 输入单词数组 words 至少包含一个单词。 
// 
//
// 
//
// 示例 1: 
//
// 
//输入: words = ["This", "is", "an", "example", "of", "text", "justification."], 
//maxWidth = 16
//输出:
//[
//   "This    is    an",
//   "example  of text",
//   "justification.  "
//]
// 
//
// 示例 2: 
//
// 
//输入:words = ["What","must","be","acknowledgment","shall","be"], maxWidth = 16
//输出:
//[
//  "What   must   be",
//  "acknowledgment  ",
//  "shall be        "
//]
//解释: 注意最后一行的格式应为 "shall be    " 而不是 "shall     be",
//     因为最后一行应为左对齐，而不是左右两端对齐。       
//     第二行同样为左对齐，这是因为这行只包含一个单词。
// 
//
// 示例 3: 
//
// 
//输入:words = ["Science","is","what","we","understand","well","enough","to",
//"explain","to","a","computer.","Art","is","everything","else","we","do"]，maxWidth = 2
//0
//输出:
//[
//  "Science  is  what we",
//  "understand      well",
//  "enough to explain to",
//  "a  computer.  Art is",
//  "everything  else  we",
//  "do                  "
//]
// 
//
// 
//
// 提示: 
//
// 
// 1 <= words.length <= 300 
// 1 <= words[i].length <= 20 
// words[i] 由小写英文字母和符号组成 
// 1 <= maxWidth <= 100 
// words[i].length <= maxWidth 
// 
//
// Related Topics 数组 字符串 模拟 👍 460 👎 0


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int index = 0;
        
        while (index < words.length) {
            // 计算当前行可以放入的单词数
            int count = 0;
            int lineLength = 0;
            int start = index;
            
            // 统计这一行可以放入多少个单词
            while (index < words.length && 
                   lineLength + words[index].length() + count <= maxWidth) {
                lineLength += words[index].length();
                count++;
                index++;
            }
            
            // 创建当前行
            StringBuilder line = new StringBuilder();
            
            // 特殊情况：最后一行或者只有一个单词的行
            if (index == words.length || count == 1) {
                // 左对齐处理
                for (int i = 0; i < count; i++) {
                    line.append(words[start + i]);
                    if (i < count - 1) {
                        line.append(" ");
                    }
                }
                // 在末尾补充空格
                while (line.length() < maxWidth) {
                    line.append(" ");
                }
            } else {
                // 计算空格分配
                int spaces = maxWidth - lineLength;
                int gaps = count - 1;
                int spacesPerGap = spaces / gaps;
                int extraSpaces = spaces % gaps;
                
                // 构建当前行
                for (int i = 0; i < count - 1; i++) {
                    line.append(words[start + i]);
                    // 添加空格
                    int spacesToAdd = spacesPerGap + (i < extraSpaces ? 1 : 0);
                    for (int j = 0; j < spacesToAdd; j++) {
                        line.append(" ");
                    }
                }
                // 添加最后一个单词
                line.append(words[start + count - 1]);
            }
            
            result.add(line.toString());
        }
        
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
