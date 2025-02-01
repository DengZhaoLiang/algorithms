package com.algorithm.sort;

/**
 * 计数排序算法
 * 
 * 基本思想：
 * 计数排序不是基于比较的排序算法，其核心在于将输入的数据值转化为键存储在额外开辟的数组空间中。
 * 作为一种线性时间复杂度的排序，计数排序要求输入的数据必须是有确定范围的整数。
 * 
 * 时间复杂度：O(n + k)，其中k是整数的范围
 * 空间复杂度：O(k)，其中k是整数的范围
 * 
 * 稳定性：稳定
 * 
 * 优点：
 * 1. 时间复杂度为线性
 * 2. 适合数据范围集中的排序
 * 3. 可以保持相等元素的相对位置
 * 
 * 缺点：
 * 1. 只能对整数进行排序
 * 2. 如果数据范围过大会浪费空间
 * 3. 需要额外的空间开销
 * 
 * 算法步骤：
 * 1. 找出待排序的数组中最大和最小的元素
 * 2. 统计数组中每个值为i的元素出现的次数，存入计数数组的第i项
 * 3. 对所有的计数累加（从计数数组的第一个元素开始，每一项和前一项相加）
 * 4. 反向填充目标数组：将每个元素i放在新数组的第C(i)项，每放一个元素就将C(i)减去1
 * 
 * 适用场景：
 * 1. 数据范围较小，最大和最小值的差值不大
 * 2. 数据量大但是数据范围小的情况
 * 3. 非负整数排序
 * 
 * 优化方案：
 * 1. 对于数据范围很大但是数据量很小的情况，可以使用map来记录计数
 * 2. 可以通过减去最小值的方式减小计数数组的大小
 */
public class CountingSort implements Sort {
    @Override
    public void sort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }

        // 1. 找出数组中的最大值和最小值
        int max = arr[0], min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
            if (arr[i] < min) {
                min = arr[i];
            }
        }

        // 计算计数数组的大小（优化：减少不必要的空间）
        int range = max - min + 1;
        
        // 2. 创建计数数组并统计每个元素出现的次数
        int[] count = new int[range];
        for (int num : arr) {
            count[num - min]++;
        }

        // 3. 计算累积次数（这步是为了保证排序的稳定性）
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }

        // 4. 创建临时数组存储排序结果
        int[] output = new int[arr.length];
        
        // 从后向前遍历原数组，保证排序的稳定性
        for (int i = arr.length - 1; i >= 0; i--) {
            int current = arr[i] - min;
            output[count[current] - 1] = arr[i];
            count[current]--;
        }

        // 5. 将结果复制回原数组
        System.arraycopy(output, 0, arr, 0, arr.length);
    }

    @Override
    public String getName() {
        return "计数排序";
    }
} 