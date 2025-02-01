package com.algorithm.sort;

/**
 * 希尔排序算法
 * <p>
 * 基本思想：
 * 希尔排序是插入排序的改进版，它通过比较相距一定间隔的元素来工作。
 * 开始时间隔较大，然后逐渐减小间隔，最终间隔为1，完成排序。
 * <p>
 * 时间复杂度：
 * - 最好情况：O(n*logn)
 * - 最坏情况：O(n²)
 * - 平均情况：取决于间隔序列，约为O(n^1.3)
 * <p>
 * 空间复杂度：O(1)
 * <p>
 * 稳定性：不稳定
 * <p>
 * 优点：
 * 1. 对于中等规模数据表现良好
 * 2. 比简单插入排序更高效
 * 3. 适合于数据量在5000以下并且速度要求不是特别高的场合
 * <p>
 * 缺点：
 * 1. 不稳定排序
 * 2. 复杂度分析依赖于间隔序列的选择
 * <p>
 * 关键点：
 * 1. 间隔序列的选择很重要，常用的有：
 * - Shell增量：N/2, N/4, ..., 1
 * - Hibbard增量：2^k-1: 1, 3, 7, 15, ...
 * - Knuth增量：(3^k-1)/2: 1, 4, 13, 40, ...
 * <p>
 * 适用场景：
 * 1. 数据量在5000以下
 * 2. 数据基本有序或接近有序
 * 3. 需要快速排序但不要求稳定性
 */
public class ShellSort implements Sort {
    @Override
    public void sort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }

        // 计算初始间隔（使用Shell增量：N/2, N/4, ..., 1）
        int gap = arr.length / 2;

        while (gap > 0) {
            // 对每个间隔进行插入排序
            for (int i = gap; i < arr.length; i++) {
                int temp = arr[i];
                int j = i;

                // 对间隔为gap的元素进行插入排序
                while (j >= gap && arr[j - gap] > temp) {
                    arr[j] = arr[j - gap];
                    j -= gap;
                }

                arr[j] = temp;
            }

            // 缩小间隔
            gap /= 2;
        }
    }

    @Override
    public String getName() {
        return "希尔排序";
    }
} 