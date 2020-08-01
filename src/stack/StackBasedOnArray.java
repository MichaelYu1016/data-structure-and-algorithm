package stack;

/**
 * 基于数组实现栈
 * @author ynx
 * @version V1.0
 * @date 2020-07-31
 */
public class StackBasedOnArray {
    private String[] items;
    private int count; // 栈中元素个数
    private int size; // 栈大小

    /**
     * 初始化数组，申请一个大小为n的数组空间
     */
    public StackBasedOnArray(int size) {
        this.items = new String[size];
        this.size = size;
        this.count = 0;
    }

    /**
     * 入栈操作
     */
    public boolean push(String item) {
        if (count == size) return false;

        items[count] = item;
        ++count;
        return true;
    }

    /**
     * 出栈操作
     */
    public String pop() {
        if (count == 0) return null;

        String tmp = items[count-1];
        --count;
        return tmp;
    }
}
