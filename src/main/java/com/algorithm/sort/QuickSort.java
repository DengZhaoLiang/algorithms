package com.algorithm.sort;

/**
 * 快速排序算法
 * <p>
 * 基本思想：
 * 通过一趟排序将要排序的数据分割成独立的两部分，
 * 其中一部分的所有数据都比另外一部分的所有数据都要小，
 * 然后再按此方法对这两部分数据分别进行快速排序。
 * <p>
 * 时间复杂度：
 * - 最好情况：O(nlogn)，每次都能平均分割
 * - 最坏情况：O(n²)，已经有序或逆序时
 * - 平均情况：O(nlogn)
 * <p>
 * 空间复杂度：
 * - 最好情况：O(logn)，递归调用的栈空间
 * - 最坏情况：O(n)
 * <p>
 * 稳定性：不稳定
 * <p>
 * 优点：
 * 1. 平均情况下效率高
 * 2. 原地排序，不需要额外的存储空间
 * 3. 内部排序中速度最快的排序算法
 * <p>
 * 缺点：
 * 1. 不稳定
 * 2. 在最坏情况下性能不好
 * 3. 对于小规模数据，可能不如插入排序
 * <p>
 * 优化策略：
 * 1. 三数取中法选择基准
 * 2. 当待排序序列的长度分割到一定大小后，使用插入排序
 * 3. 在一次分割结束后，可以把与基准元素相等的元素聚在一起，继续下次分割时，不用再对与基准相等的元素分割
 * <p>
 * 适用场景：
 * 1. 大规模数据排序
 * 2. 不要求排序稳定性
 * 3. 数据分布比较随机
 */
public class QuickSort implements Sort {
    @Override
    public void sort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        quickSort(arr, 0, arr.length - 1);
    }

    private void quickSort(int[] arr, int left, int right) {
        // 递归终止条件：当左边界大于等于右边界时
        if (left >= right) {
            return;
        }

        // 获取分区点
        int pivotIndex = partition(arr, left, right);

        // 递归排序左半部分
        quickSort(arr, left, pivotIndex - 1);
        // 递归排序右半部分
        quickSort(arr, pivotIndex + 1, right);
    }

    private int partition(int[] arr, int left, int right) {
        // 优化：使用三数取中法选择基准
        int mid = left + (right - left) / 2;
        // 将中间元素与最左边元素交换
        if (arr[mid] < arr[left]) {
            SortUtils.swap(arr, left, mid);
        }
        if (arr[right] < arr[left]) {
            SortUtils.swap(arr, left, right);
        }
        if (arr[right] < arr[mid]) {
            SortUtils.swap(arr, mid, right);
        }

        // 选择基准元素
        int pivot = arr[left];

        // 双指针法进行分区
        int i = left;
        int j = right;

        while (i < j) {
            // 从右向左找第一个小于基准的元素
            while (i < j && arr[j] >= pivot) {
                j--;
            }
            // 从左向右找第一个大于基准的元素
            while (i < j && arr[i] <= pivot) {
                i++;
            }
            // 交换这两个元素
            if (i < j) {
                SortUtils.swap(arr, i, j);
            }
        }

        // 将基准元素放到最终位置
        arr[left] = arr[i];
        arr[i] = pivot;

        return i;
    }

    @Override
    public String getName() {
        return "快速排序";
    }
} 