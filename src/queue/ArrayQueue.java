package queue;

/**
 * 数组实现队列
 * @author ynx
 * @version V1.0
 * @date 2020-08-01
 */
public class ArrayQueue {
    // 数组:items, 数组大小: n
    private String[] items;
    private int n = 0;
    // head标识队头下标，tail标识队尾下标
    private int head = 0;
    private int tail = 0;

    public ArrayQueue(int capacity) {
        items = new String[capacity];
        n = capacity;
    }

    /**
     * 入队
     */
    public boolean enqueue(String item) {
        if (tail==n) return false;
        items[tail] = item;
        ++tail;
        return true;
    }

    /**
     * 出队
     */
    public String dequeue() {
        if(head == tail) return null;

        String ret = items[head];
        ++head;
        return ret;
    }
}
