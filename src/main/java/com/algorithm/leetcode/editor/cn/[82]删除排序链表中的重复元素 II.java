//给定一个已排序的链表的头 head ， 删除原始链表中所有重复数字的节点，只留下不同的数字 。返回 已排序的链表 。 
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,2,3,3,4,4,5]
//输出：[1,2,5]
// 
//
// 示例 2： 
// 
// 
//输入：head = [1,1,1,2,3]
//输出：[2,3]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点数目在范围 [0, 300] 内 
// -100 <= Node.val <= 100 
// 题目数据保证链表已经按升序 排列 
// 
//
// Related Topics 链表 双指针 👍 1342 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        // 处理空链表和单节点链表
        if (head == null || head.next == null) return head;
        
        // 创建虚拟头节点
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode curr = head;
        
        while (curr != null) {
            // 跳过所有重复节点
            while (curr.next != null && curr.val == curr.next.val) {
                curr = curr.next;
            }
            
            if (prev.next == curr) {
                // 没有重复，移动prev
                prev = prev.next;
            } else {
                // 有重复，删除所有重复节点
                prev.next = curr.next;
            }
            
            curr = curr.next;
        }
        
        return dummy.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
