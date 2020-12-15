package cn.edu.tju.rico.sort;

import java.util.Arrays;

/**
 * Title: 归并排序 ，概念上最为简单的排序算法，是一个递归算法
 * Description:归并排序包括两个过程：归 和 并
 * "归"是指将原序列分成半子序列，分别对子序列进行递归排序
 * "并"是指将排好序的各子序列合并成原序列
 * <p>
 * 归并排序的主要问题是：需要一个与原待排序数组一样大的辅助数组空间
 * <p>
 * 归并排序不依赖于原始序列，因此其最好情形、平均情形和最差情形时间复杂度都一样
 * 时间复杂度：最好情形O(n)，平均情形O(n^2)，最差情形O(n^2)
 * 空间复杂度：O(n)
 * 稳 定 性：稳定
 * 内部排序(在排序过程中数据元素完全在内存)
 *
 * @author rico
 * @created 2017年5月20日 上午10:40:00
 */
public class MergeSort {

    /**
     * @param target 待排序序列
     * @param left   待排序序列起始位置
     * @param right  待排序序列终止位置
     * @return
     * @description 归并排序算法(递归算法)：递去分解，归来合并
     * @author rico
     * @created 2017年5月20日 下午4:04:52
     */
    public static int[] mergeSort(int[] target, int left, int right) {

        if (right > left) {           // 递归终止条件
            int mid = (left + right) / 2;
            mergeSort(target, left, mid);   // 归并排序第一个子序列，逻辑上被递归分解成长度为1的子序列
            mergeSort(target, mid + 1, right);   // 归并排序第二个子序列
            return merge(target, left, mid, right);  // 合并子序列成原序列
        }
        /**
         * 整个运行过程就是：第一个子序列被递归逻辑分解为长度为1的子序列，然后递归返回，开始递归逻辑分解第二个子序列，
         * 分解完后，递归返回，开始从第二个子序列的尾部两个长度为1的子序列开始合并，再然后是第一个子序列子序列开始合并排序。
         */
        return target;
    }


    /**
     * @param target 用于存储归并结果
     * @param left   第一个有序表的第一个元素所在位置
     * @param mid    第一个有序表的最后一个元素所在位置
     * @param right  第二个有序表的最后一个元素所在位置
     * @return
     * @description 两路归并算法
     * @author rico
     * @created 2017年5月20日 下午3:59:16
     */
    public static int[] merge(int[] target, int left, int mid, int right) {

        // 需要一个与原待排序数组一样大的辅助数组空间
        int[] temp = Arrays.copyOf(target, target.length);

        // index 是辅助空间的存放指针
        int i1 = left;//第一个序列起始位置
        int i2 = mid + 1;//第二个序列起始位置
        int index = left;

        // 两个表都未检查完，两两比较
        while (i1 <= mid && i2 <= right) {
            if (temp[i1] <= temp[i2]) {   // =号保证稳定性
                target[index++] = temp[i1++];
            } else {
                target[index++] = temp[i2++];
            }
        }

        //若第一个表未检查完，复制到辅助空间尾部，与下方只有一个会成立
        while (i1 <= mid) {
            target[index++] = temp[i1++];
        }

        //若第二个表未检查完，复制到辅助空间尾部
        while (i2 <= right) {
            target[index++] = temp[i2++];
        }
        return target;
    }
}
