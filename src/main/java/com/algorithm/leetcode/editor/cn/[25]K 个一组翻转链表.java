//给你链表的头节点 head ，每 k 个节点一组进行翻转，请你返回修改后的链表。 
//
// k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。 
//
// 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。 
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,2,3,4,5], k = 2
//输出：[2,1,4,3,5]
// 
//
// 示例 2： 
//
// 
//
// 
//输入：head = [1,2,3,4,5], k = 3
//输出：[3,2,1,4,5]
// 
//
// 
//提示：
//
// 
// 链表中的节点数目为 n 
// 1 <= k <= n <= 5000 
// 0 <= Node.val <= 1000 
// 
//
// 
//
// 进阶：你可以设计一个只用 O(1) 额外内存空间的算法解决此问题吗？ 
//
// 
// 
//
// Related Topics 递归 链表 👍 2502 👎 0


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
    /**
     * 主函数：K个一组翻转链表
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) return head;

        // 创建虚拟头节点
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // 初始化指针
        ListNode prev = dummy;
        ListNode curr = head;

        while (curr != null) {
            // 1. 检查剩余节点是否足够k个
            if (!hasKNodes(curr, k)) {
                break;  // 不足k个节点，保持原有顺序
            }

            // 2. 保存当前组的起始节点（翻转后会变成尾节点）
            ListNode start = curr;

            // 3. 找到下一组的起始节点
            ListNode nextGroupStart = getKthNext(curr, k);

            // 4. 翻转当前k个节点
            ListNode newHead = reverseKNodes(curr, k);

            // 5. 连接前面的节点
            prev.next = newHead;

            // 6. 连接后面的节点
            start.next = nextGroupStart;

            // 7. 移动指针到下一组
            prev = start;
            curr = nextGroupStart;
        }

        return dummy.next;
    }

    /**
     * 检查从当前节点开始是否有k个节点
     */
    private boolean hasKNodes(ListNode node, int k) {
        int count = 0;
        while (node != null && count < k) {
            count++;
            node = node.next;
        }
        return count == k;
    }

    /**
     * 获取从当前节点往后第k个节点
     */
    private ListNode getKthNext(ListNode node, int k) {
        while (node != null && k > 1) {
            node = node.next;
            k--;
        }
        return node != null ? node.next : null;
    }

    /**
     * 翻转k个节点，返回新的头节点
     */
    private ListNode reverseKNodes(ListNode head, int k) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null && k > 0) {
            // 保存下一个节点
            ListNode next = curr.next;

            // 改变指针方向
            curr.next = prev;

            // 移动指针
            prev = curr;
            curr = next;

            k--;
        }

        return prev;  // prev 现在是新的头节点
    }
}
//leetcode submit region end(Prohibit modification and deletion)
