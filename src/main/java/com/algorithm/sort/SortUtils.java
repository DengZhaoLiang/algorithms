package com.algorithm.sort;

/**
 * 排序算法工具类
 */
public class SortUtils {
    /**
     * 交换数组中的两个元素
     * @param arr 数组
     * @param i 位置i
     * @param j 位置j
     */
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * 打印数组
     * @param arr 待打印的数组
     */
    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    /**
     * 判断数组是否已排序
     * @param arr 待检查的数组
     * @return 如果已排序返回true，否则返回false
     */
    public static boolean isSorted(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i - 1]) {
                return false;
            }
        }
        return true;
    }
} 