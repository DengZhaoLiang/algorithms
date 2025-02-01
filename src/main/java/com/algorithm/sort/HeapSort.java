package com.algorithm.sort;

/**
 * 堆排序算法
 * 
 * 基本思想：
 * 利用堆这种数据结构所设计的一种排序算法。
 * 堆是一个近似完全二叉树的结构，并同时满足堆的性质：
 * 即子节点的值总是小于（或大于）它的父节点。
 * 
 * 时间复杂度：
 * - 最好情况：O(nlogn)
 * - 最坏情况：O(nlogn)
 * - 平均情况：O(nlogn)
 * 
 * 空间复杂度：O(1)
 * 
 * 稳定性：不稳定
 * 
 * 优点：
 * 1. 时间复杂度稳定
 * 2. 原地排序，不需要额外空间
 * 3. 适合处理大数据量
 * 
 * 缺点：
 * 1. 不稳定排序
 * 2. 对于完全有序或接近有序的数据，性能不如快速排序
 * 
 * 算法步骤：
 * 1. 建立大顶堆（升序）或小顶堆（降序）
 * 2. 交换堆顶元素和最后一个元素
 * 3. 重新调整堆结构
 * 
 * 适用场景：
 * 1. 大数据量排序
 * 2. 不要求排序稳定性
 * 3. 需要找出数组中最大的几个数
 * 
 * 堆的性质：
 * 1. 索引为i的左孩子的索引是 (2*i + 1)
 * 2. 索引为i的右孩子的索引是 (2*i + 2)
 * 3. 索引为i的父节点的索引是 floor((i-1)/2)
 */
public class HeapSort implements Sort {
    @Override
    public void sort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }

        int len = arr.length;

        // 1. 构建最大堆（从最后一个非叶子节点开始）
        for (int i = len / 2 - 1; i >= 0; i--) {
            heapify(arr, len, i);
        }

        // 2. 逐个将堆顶元素（最大值）与末尾元素交换，并重新调整堆结构
        for (int i = len - 1; i > 0; i--) {
            // 将堆顶元素（最大值）与末尾元素交换
            SortUtils.swap(arr, 0, i);
            
            // 重新对剩余元素进行堆调整
            heapify(arr, i, 0);
        }
    }

    /**
     * 调整堆结构
     * 
     * @param arr 待调整的数组
     * @param n 需要调整的堆的大小
     * @param i 当前需要调整的节点的索引
     */
    private void heapify(int[] arr, int n, int i) {
        int largest = i;        // 假设当前节点是最大的
        int left = 2 * i + 1;   // 左子节点
        int right = 2 * i + 2;  // 右子节点

        // 如果左子节点比当前节点大
        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }

        // 如果右子节点比当前最大的还大
        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }

        // 如果最大的不是当前节点，则交换，并继续调整堆
        if (largest != i) {
            SortUtils.swap(arr, i, largest);
            // 递归调整被交换的子树
            heapify(arr, n, largest);
        }
    }

    @Override
    public String getName() {
        return "堆排序";
    }
} 