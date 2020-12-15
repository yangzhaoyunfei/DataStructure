package cn.edu.tju.rico.sort;

import java.util.Arrays;

/**
 * Title: 交换排序中的冒泡排序 ，一般情形下指的是优化后的冒泡排序，最多进行n-1次比较
 * Description:因为越大的元素会经由交换慢慢"浮"到数列的顶端(最后位置)，最大的数最后才确定下来，所以称为冒泡排序
 * 时间复杂度：最好情形O(n)，平均情形O(n^2)，最差情形O(n^2)
 * 空间复杂度：O(1)
 * 稳 定 性：稳定
 * 内部排序(在排序过程中数据元素完全在内存)
 * <p>
 * 代码要点：两层循环；外层为趟数，内层为趟内比较，比较索引在趟索引之后；一个交换：比较后按要求交换
 *
 * @author rico
 * @created 2017年5月20日 上午10:40:00
 */
public class BubbleSort {


    /**
     * @description 朴素冒泡排序(共进行n - 1次比较)
     * @author rico
     */
    public static int[] bubbleSort(int[] target) {
        int n = target.length;
        if (n > 1) {
            // 最多需要进行n-1躺，每一趟将比较小的元素移到前面，比较大的元素自然就逐渐沉到最后面了，这就是冒泡
            for (int i = 0; i < n - 1; i++) {
                //从最后一个元素开始往前
                for (int j = n - 1; j > i; j--) {
                    //相邻两个元素进行比较,使较小元素往下沉,较大元素往上冒,第一趟比较下来,第一个元素就是沉到底的最小元素
                    if (target[j] < target[j - 1]) {
                        int temp = target[j];
                        target[j] = target[j - 1];
                        target[j - 1] = temp;
                    }
                }
                //每比较一趟打印一下
                System.out.println(Arrays.toString(target));
            }
        }
        return target;
    }

    /**
     * @description 优化冒泡排序
     * @author rico
     */
    public static int[] optimizeBubbleSort(int[] target) {
        int n = target.length;
        if (n > 1) {
            // n个元素最多需要进行n-1趟，将前n-1个最小元素确定；每一趟将比较小的元素移到前面，比较大的元素自然就逐渐沉到最后面了，这就是冒泡
            for (int i = 0; i < n - 1; i++) {
                //一趟下来如果一个元素都没有交换，那么已经是完全排序了，后面的趟不需要做了
                boolean isExchanged = false;
                for (int j = n - 1; j > i; j--) {
                    if (target[j] < target[j - 1]) {
                        int temp = target[j];
                        target[j] = target[j - 1];
                        target[j - 1] = temp;
                        isExchanged = true;
                    }
                }
                System.out.println(Arrays.toString(target));
                if (!isExchanged) {
                    return target;
                }
            }
        }
        return target;
    }
}
