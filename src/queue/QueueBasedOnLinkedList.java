package queue;

/**
 * 基于链表实现的队列
 * @author ynx
 * @version V1.0
 * @date 2020-08-01
 */
public class QueueBasedOnLinkedList {
    private ListNode head = null;
    private ListNode tail = null;

    /**
     * 入队
     */
    public void enqueue(String value) {
        if (tail == null) {
            ListNode newNode = new ListNode(value, null);
            head = newNode;
            tail = newNode;
        } else {
            tail.next = new ListNode(value, null);
            tail = tail.next;
        }
    }

    /**
     * 出队
     */
    public String dequeue() {
        if (head == null) return null;

        String value = head.data;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        return value;
    }

    private static class ListNode {
        private String data;
        private ListNode next;

        public ListNode(String data, ListNode next) {
            this.data = data;
            this.next = next;
        }

        public String getData() {
            return data;
        }
    }
}
