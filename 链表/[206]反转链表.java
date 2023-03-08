//给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
//
// 
// 
// 
// 
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,2,3,4,5]
//输出：[5,4,3,2,1]
// 
//
// 示例 2： 
// 
// 
//输入：head = [1,2]
//输出：[2,1]
// 
//
// 示例 3： 
//
// 
//输入：head = []
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目范围是 [0, 5000] 
// -5000 <= Node.val <= 5000 
// 
//
// 
//
// 进阶：链表可以选用迭代或递归方式完成反转。你能否用两种方法解决这道题？ 
//
// Related Topics 递归 链表 👍 3006 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.List;

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
    public ListNode reverseList(ListNode head) {
        if(head == null) {
            return null;
        }
        //创建一个虚拟头节点
        ListNode dummmy = null;
//        dummmy.next = head;// 一般null出现的话，代表链表已经到了末尾了 ，所以这个语句是错误的
        ListNode pre = dummmy;
        ListNode cur = head;

        while (cur != null) {
            ListNode temp = cur.next;//因为反转之后链表发生了变化，所以要有一个临时变量进行操作
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;//此时cur指向的是末尾的空节点，而pre 指向的是新的头节点。
    }
}
//leetcode submit region end(Prohibit modification and deletion)
