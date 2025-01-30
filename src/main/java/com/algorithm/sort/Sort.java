package com.algorithm.sort;

/**
 * 排序算法的基础接口
 */
public interface Sort {
    /**
     * 排序方法
     * @param arr 待排序的数组
     */
    void sort(int[] arr);

    /**
     * 获取排序算法名称
     * @return 算法名称
     */
    String getName();
} 