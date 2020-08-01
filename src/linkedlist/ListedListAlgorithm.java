package linkedlist;

/**
 * @author ynx
 * @version V1.0
 * @date 2020-07-30
 */
public class ListedListAlgorithm {

    /**
     * 单链表反转
     */
    public static ListNode reverse(ListNode list) {
        ListNode curr = list, pre = null;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }

    /**
     * 检测环
     */
    public static boolean checkCircle(ListNode list) {
        if (list == null) return false;

        ListNode fast = list.next;
        ListNode slow = list;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (slow == fast) return true;
        }
        return false;
    }

    /**
     * 有序链表合并
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode soldier = new ListNode(0);
        ListNode p = soldier;

        while (l1 != null && l2 != null) {
            if (l1.data < l2.data) {
                p.next = l1;
                l1 = l1.next;
            } else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }

        if (l1 != null) {
            p.next = l1;
        }
        if (l2 != null) {
            p.next = l2;
        }
        return soldier.next;

    }

    /**
     * 删除倒数第k个节点
     */
    public static ListNode deleteLastKth(ListNode list, int k) {
        ListNode fast = list;
        int i = 1;
        while (fast != null && i < k) {
            fast = fast.next;
            ++i;
        }
        if (fast == null) return list;

        ListNode slow = list;
        ListNode pre = null;
        while (fast.next != null) {
            fast = fast.next;
            pre = slow;
            slow = slow.next;
        }

        if (pre == null) {
            list = list.next;
        } else {
            pre.next = pre.next.next;
        }
        return list;
    }

    /**
     * 求中间节点
     */
    public static ListNode findMiddleNode(ListNode list) {
        if (list == null) return null;

        ListNode fast = list;
        ListNode slow = list;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }


    public static class ListNode {
        private int data;
        private ListNode next;

        ListNode(int data) {
            this.data = data;
        }

        public ListNode(int data, ListNode next) {
            this.data = data;
            this.next = next;
        }

        public int getData() {
            return data;
        }
    }

    public static void main(String[] args) {
        // p和soldier引用的是同一个对象，p操作对象也会导致soldier发生改变
        ListNode soldier = new ListNode(0);
        ListNode p = soldier;
        p.next = new ListNode(1);
        p = p.next;
    }
}
