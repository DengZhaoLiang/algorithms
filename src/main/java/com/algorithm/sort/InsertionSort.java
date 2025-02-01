package com.algorithm.sort;

import java.util.Arrays;
import java.util.Collections;

/**
 * 插入排序算法
 * 
 * 基本思想：
 * 将数组分为已排序和未排序两部分，每次从未排序部分取出一个元素，
 * 插入到已排序部分的合适位置。
 * 
 * 时间复杂度：
 * - 最好情况：O(n)，当数组已经有序时
 * - 最坏情况：O(n²)，当数组逆序时
 * - 平均情况：O(n²)
 * 
 * 空间复杂度：O(1)，只需要一个临时变量
 * 
 * 稳定性：稳定
 * 
 * 优点：
 * 1. 实现简单
 * 2. 对于小规模数据或基本有序的数据效率高
 * 3. 稳定排序
 * 4. 原地排序算法
 * 
 * 缺点：
 * 1. 对于大规模乱序数组效率低
 * 
 * 适用场景：
 * 1. 数据量小
 * 2. 数据基本有序
 * 3. 数据量在千级以下
 */
public class InsertionSort implements Sort {
    @Override
    public void sort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }

        // 从第二个元素开始，认为第一个元素已经有序
        for (int i = 1; i < arr.length; i++) {
            // 保存当前要插入的元素
            int current = arr[i];
            // 已排序部分的最后一个位置
            int j = i - 1;
            
            // 从后向前查找插入位置，将大于current的元素都向后移动一位
            while (j >= 0 && arr[j] > current) {
                arr[j + 1] = arr[j];
                j--;
            }
            
            // 找到插入位置，将current插入
            arr[j + 1] = current;
        }
    }

    @Override
    public String getName() {
        return "插入排序";
    }
} 