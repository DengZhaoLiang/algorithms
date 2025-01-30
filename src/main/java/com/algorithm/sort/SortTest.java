package com.algorithm.sort;

/**
 * 排序算法测试类
 */
public class SortTest {
    public static void main(String[] args) {
        // 测试不同的排序算法
        testSort(new BubbleSort());
        System.out.println("------------------------");
        testSort(new SelectionSort());
    }
    
    /**
     * 测试排序算法
     * @param sort 排序算法实现
     */
    private static void testSort(Sort sort) {
        // 创建测试数组
        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        
        // 打印原始数组
        System.out.println(sort.getName() + " 前的数组：");
        SortUtils.printArray(arr);
        
        // 执行排序
        sort.sort(arr);
        
        // 打印排序后的数组
        System.out.println(sort.getName() + " 后的数组：");
        SortUtils.printArray(arr);
        
        // 验证排序结果
        System.out.println("排序是否正确：" + SortUtils.isSorted(arr));
    }
} 