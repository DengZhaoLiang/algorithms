package com.algorithm.sort;

/**
 * 归并排序算法
 * 
 * 基本思想：
 * 采用分治法（Divide and Conquer）的思想。
 * 将待排序数组分成若干个子序列，每个子序列是有序的，
 * 然后再将有序子序列合并为整体有序序列。
 * 
 * 时间复杂度：
 * - 最好情况：O(nlogn)
 * - 最坏情况：O(nlogn)
 * - 平均情况：O(nlogn)
 * 
 * 空间复杂度：O(n)，需要额外的数组空间
 * 
 * 稳定性：稳定
 * 
 * 优点：
 * 1. 稳定的排序算法
 * 2. 时间复杂度稳定，不受输入数据的影响
 * 3. 适合处理大数据量
 * 4. 适合外部排序
 * 
 * 缺点：
 * 1. 需要额外的内存空间
 * 2. 对于小规模数据，可能比简单排序算法慢
 * 
 * 算法步骤：
 * 1. 分割：递归地把当前序列平均分割成两半
 * 2. 集成：在保持元素顺序的同时将上一步得到的子序列集成到一起
 * 
 * 适用场景：
 * 1. 数据量大
 * 2. 要求排序稳定
 * 3. 有足够的内存空间
 * 4. 适合于链表排序
 */
public class MergeSort implements Sort {
    @Override
    public void sort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        
        // 创建一个临时数组，用于合并过程
        int[] temp = new int[arr.length];
        mergeSort(arr, 0, arr.length - 1, temp);
    }

    /**
     * 递归进行归并排序
     * @param arr 待排序数组
     * @param left 左边界
     * @param right 右边界
     * @param temp 临时数组
     */
    private void mergeSort(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            // 找出中间索引
            int mid = left + (right - left) / 2;
            
            // 递归对左半部分进行归并排序
            mergeSort(arr, left, mid, temp);
            // 递归对右半部分进行归并排序
            mergeSort(arr, mid + 1, right, temp);
            
            // 合并两个有序序列
            merge(arr, left, mid, right, temp);
        }
    }

    /**
     * 合并两个有序序列
     * @param arr 原始数组
     * @param left 左边界
     * @param mid 中间位置
     * @param right 右边界
     * @param temp 临时数组
     */
    private void merge(int[] arr, int left, int mid, int right, int[] temp) {
        // 左序列指针
        int i = left;
        // 右序列指针
        int j = mid + 1;
        // 临时数组指针
        int t = 0;
        
        // 比较两个序列的元素，将较小的元素放入临时数组
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[t++] = arr[i++];
            } else {
                temp[t++] = arr[j++];
            }
        }
        
        // 将左序列剩余元素放入临时数组
        while (i <= mid) {
            temp[t++] = arr[i++];
        }
        
        // 将右序列剩余元素放入临时数组
        while (j <= right) {
            temp[t++] = arr[j++];
        }
        
        // 将临时数组中的元素复制回原数组
        t = 0;
        while (left <= right) {
            arr[left++] = temp[t++];
        }
    }

    @Override
    public String getName() {
        return "归并排序";
    }
} 