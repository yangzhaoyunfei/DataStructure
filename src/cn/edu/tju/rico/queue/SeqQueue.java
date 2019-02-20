package cn.edu.tju.rico.queue;

import java.util.Arrays;


/**
 * Title: 基于数组的队列实现
 * Description:
 *
 * @author rico
 * @created 2017年5月19日 下午8:23:55
 */
public class SeqQueue<E> {


    /**
     * 队列的存储结构   (@author: rico)
     */
    private Object[] queue;
    private int size;
    private int maxSize;    // 最大容量

    public SeqQueue(int maxSize) {
        this.maxSize = maxSize;
        queue = new Object[maxSize];
    }


    /**
     * @param data
     * @description 添加元素到队尾
     * @author rico
     * @created 2017年5月19日 下午8:25:32
     */
    public void put(E data) {
        if (!isFull()) {
            queue[size] = data;
            size++;
        }
    }


    /**
     * @return
     * @description 删除队头并返回队头元素的值
     * @author rico
     * @created 2017年5月19日 下午8:25:47
     */
    public E pop() {
        if (!isEmpty()) {
            E temp = (E) queue[0];
            for (int i = 0; i < size - 1; i++) {
                queue[i] = queue[i + 1];
            }
            queue[size - 1] = null;
            size--;
            return temp;
        }
        return null;
    }


    /**
     * @return
     * @description 返回队头元素
     * @author rico
     * @created 2017年5月19日 下午8:26:01
     */
    public E peek() {
        if (!isEmpty()) {
            return (E) queue[0];
        }
        return null;
    }


    /**
     * @return
     * @description 队列是否已满
     * @author rico
     * @created 2017年5月19日 下午8:26:14
     */
    public boolean isFull() {
        return size == maxSize;
    }


    /**
     * @return
     * @description 队列是否为空
     * @author rico
     * @created 2017年5月19日 下午8:26:25
     */
    public boolean isEmpty() {
        return size == 0;
    }


    /**
     * @return
     * @description 队列的大小
     * @author rico
     * @created 2017年5月19日 下午8:26:34
     */
    public int size() {
        return size;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return Arrays.toString(queue);
    }
}
