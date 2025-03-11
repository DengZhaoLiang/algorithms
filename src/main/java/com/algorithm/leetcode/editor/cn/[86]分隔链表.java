//给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。 
//
// 你应当 保留 两个分区中每个节点的初始相对位置。 
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,4,3,2,5,2], x = 3
//输出：[1,2,2,4,3,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [2,1], x = 2
//输出：[1,2]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目在范围 [0, 200] 内 
// -100 <= Node.val <= 100 
// -200 <= x <= 200 
// 
//
// Related Topics 链表 双指针 👍 894 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode partition(ListNode head, int x) {
        // 创建两个虚拟头节点
        ListNode smallDummy = new ListNode(0);  // 小于x的链表虚拟头节点
        ListNode largeDummy = new ListNode(0);  // 大于等于x的链表虚拟头节点
        
        // 创建两个指针，分别用于构建两个链表
        ListNode smallTail = smallDummy;
        ListNode largeTail = largeDummy;
        
        // 遍历原链表
        ListNode curr = head;
        while (curr != null) {
            if (curr.val < x) {
                // 添加到小值链表
                smallTail.next = curr;
                smallTail = smallTail.next;
            } else {
                // 添加到大值链表
                largeTail.next = curr;
                largeTail = largeTail.next;
            }
            curr = curr.next;
        }
        
        // 连接两个链表
        smallTail.next = largeDummy.next;
        largeTail.next = null;  // 防止形成环
        
        return smallDummy.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
