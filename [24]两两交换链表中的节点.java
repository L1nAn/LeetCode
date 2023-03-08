//给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。 
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,2,3,4]
//输出：[2,1,4,3]
// 
//
// 示例 2： 
//
// 
//输入：head = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：head = [1]
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目在范围 [0, 100] 内 
// 0 <= Node.val <= 100 
// 
//
// Related Topics 递归 链表 👍 1742 👎 0


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
    public ListNode swapPairs(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode dummy = new ListNode(-1, head);
        ListNode cur = dummy;
        ListNode temp;
        ListNode firstnode; // 定义临时节点，两个节点中的第一个节点
        ListNode secondnode;// 定义临时节点，两个节点中的第二个节点

        while (cur.next != null && cur.next.next != null) {
            firstnode = cur.next;
            secondnode = cur.next.next;
            temp = secondnode.next;
            cur.next = secondnode;
            secondnode.next = firstnode;
            firstnode.next = temp;
            //到此为止交换完毕

            cur = firstnode;
        }
        return dummy.next;


    }
}
//leetcode submit region end(Prohibit modification and deletion)
