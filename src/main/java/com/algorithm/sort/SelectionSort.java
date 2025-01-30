package com.algorithm.sort;

/**
 * 选择排序算法实现
 * 时间复杂度：O(n^2)
 * 空间复杂度：O(1)
 * 稳定性：不稳定
 * 
 * 工作原理：
 * 1. 首先在未排序序列中找到最小元素，存放到排序序列的起始位置
 * 2. 再从剩余未排序元素中继续寻找最小元素，然后放到已排序序列的末尾
 * 3. 重复第二步，直到所有元素均排序完毕
 */
public class SelectionSort implements Sort {
    @Override
    public void sort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }

        // 外层循环控制已排序序列的边界
        for (int i = 0; i < arr.length - 1; i++) {
            // 记录最小元素的索引
            int minIndex = i;
            
            // 在未排序序列中寻找最小的数
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            
            // 将找到的最小值和边界处的元素交换位置
            // 如果最小值就是边界处的元素，则不交换
            if (minIndex != i) {
                SortUtils.swap(arr, i, minIndex);
            }
        }
    }

    @Override
    public String getName() {
        return "选择排序";
    }
} 