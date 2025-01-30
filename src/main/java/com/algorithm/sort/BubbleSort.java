package com.algorithm.sort;

/**
 * 冒泡排序算法实现
 * 时间复杂度：O(n^2)
 * 空间复杂度：O(1)
 * 稳定性：稳定
 */
public class BubbleSort implements Sort {
    @Override
    public void sort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }

        // 外层循环控制排序轮数
        for (int i = 0; i < arr.length - 1; i++) {
            // 优化标志，如果一轮中没有发生交换，说明数组已经有序
            boolean swapped = false;
            
            // 内层循环进行相邻元素比较和交换
            for (int j = 0; j < arr.length - 1 - i; j++) {
                // 如果前一个元素大于后一个元素，交换它们
                if (arr[j] > arr[j + 1]) {
                    SortUtils.swap(arr, j, j + 1);
                    swapped = true;
                }
            }
            
            // 如果没有发生交换，说明数组已经有序，可以提前退出
            if (!swapped) {
                break;
            }
        }
    }

    @Override
    public String getName() {
        return "冒泡排序";
    }
} 