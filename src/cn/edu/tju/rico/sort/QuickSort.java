package cn.edu.tju.rico.sort;

import java.util.Arrays;

/**
 * Title: 交换排序中的快速排序，目前应用最为广泛的排序算法，是一个递归算法
 * 基本思想是：通过一趟排序将要排序的数据分割成独立的两部分，其中一部分的所有数据都比另外一部分的所有数据都要小，然后再按此方法对这两部分数据分别进行快速排序，整个排序过程可以递归进行，以此达到整个数据变成有序序列。
 * Description:快速排序包括两个过程：划分 和 快排
 * "划分"是指将原序列按基准元素划分两个子序列
 * "快排"是指分别对子序列进行快排
 * 性能分析：https://baike.baidu.com/item/%E5%BF%AB%E9%80%9F%E6%8E%92%E5%BA%8F%E7%AE%97%E6%B3%95/369842#%E6%80%A7%E8%83%BD%E5%88%86%E6%9E%90
 * <p>
 * 就平均计算时间而言，快速排序是所有内部排序方法中最好的一个
 * <p>
 * 对大规模数据排序时，快排是快的；对小规模数据排序时，快排是慢的，甚至慢于简单选择排序等简单排序方法
 * <p>
 * 快速排序依赖于原始序列，因此其时间复杂度从O(nlgn)到O(n^2)不等
 * 时间复杂度：最好情形O(nlgn)，平均情形O(nlgn)，最差情形O(n^2)
 * <p>
 * 递归所消耗的栈空间
 * 空间复杂度：O(lgn)
 * <p>
 * 可选任一元素作为基准元素
 * 稳 定 性：不稳定
 * <p>
 * <p>
 * 内部排序(在排序过程中数据元素完全在内存)
 *
 * @author rico
 * @created 2017年5月20日 上午10:40:00
 */
public class QuickSort {

	/**
	 * @param target
	 * @param left
	 * @param right
	 * @return
	 * @description 快排算法(递归算法)：在递去过程中就把问题解决了
	 * @author rico
	 * @created 2017年5月20日 下午5:12:06
	 */
	public static int[] quickSort(int[] target, int left, int right) {
		// 递归终止条件，如果左右边界相等，则序列长度为1，不再划分子序列
		if (right > left) {
			// 原序列划分排序后基准元素的位置
			int base_index = partition(target, left, right);
			// 对左侧子序列快速排序，不包含基准元素！
			quickSort(target, left, base_index - 1);
			// 对右侧子序列快速排序，不包含基准元素！
			quickSort(target, base_index + 1, right);
		}
		return target;
	}


	/**
	 * 选择基准元素，并划分序列：将小于基准元素的放在左边，大于基准元素的放在右边
	 *
	 * @param target 序列
	 * @param left   序列左端
	 * @param right  序列右端
	 * @return
	 * @description 以第一个元素为基准元素，划分序列
	 * @author rico
	 * @created 2017年5月20日 下午5:10:54
	 */
	//不好理解
	public static int partition(int[] target, int left, int right) {

		int base = target[left];   // 基准元素的值
		int base_index = left;    // 基准元素最终应该在的位置

		for (int i = left + 1; i <= right; i++) {  // 从基准元素的下一个元素开始遍历至最右侧
			if (target[i] < base) {       //  若其小于基准元素
				base_index++;           // 若其小于基准元素,则基准元素最终位置后移；否则不用移动
				if (base_index != i) {    // 相等意味着i之前的元素都小于base,只需要换一次即可，不必每次都换；
					// i >= base_index 大，在其准右侧，所以当a[i]<base时，我们把a[i]放到pivot位置上，
					//遇到小于基数的元素就放到当前的基准位置上，随着不断往后搜索，基准位置逐渐后移，之前换到基准位置上的元素最终都会在基准位置之前
					int temp = target[base_index];
					target[base_index] = target[i];
					target[i] = temp;
				}
			}
		}

		// 将基准元素就位，上方在基准位置上的较小数会被换到基准位置前面
		target[left] = target[base_index];
		target[base_index] = base;

		System.out.println(Arrays.toString(target));

		return base_index;  //返回一趟排序后/划分后基准元素的位置，以便下一次递归区分边界
	}


	void quick_sort(int s[], int l, int r) {   //l  and r is the index of the leftmost number and rightmost number
		//挖坑填数，分而治之
		//算法总结-排序相关算法 - OwenLiuzZ的文章 - 知乎 https://zhuanlan.zhihu.com/p/40834291
		if (l < r) {
			int i = l, j = r, base = s[l];//挖坑
			while (i < j) {//控制本轮搜索结束
				while (i < j && s[j] >= base) // 从右向左找第一个小于x的数
					j--;
				if (i < j)
					s[i++] = s[j];//交换填坑

				while (i < j && s[i] < base) // 从左向右找第一个大于等于x的数
					i++;
				if (i < j)
					s[j--] = s[i];
			}
			s[i] = base;//lp=rp时，最后留下的坑就是基准所在的位置
			quick_sort(s, l, i - 1); // 左侧递归调用
			quick_sort(s, i + 1, r);//右侧递归调用
		}
	}
}
