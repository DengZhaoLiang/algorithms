package com.algorithm.sort;

/**
 * 基数排序算法
 * 
 * 基本思想：
 * 基数排序是一种非比较型整数排序算法，其原理是将整数按位数切割成不同的数字，然后按每个位数分别比较。
 * 它是这样实现的：将所有待比较数值统一为同样的数位长度，数位较短的数前面补零。
 * 然后，从最低位开始，依次进行一次排序。这样从最低位排序一直到最高位排序完成以后，数列就变成一个有序序列。
 * 
 * 时间复杂度：
 * - 最好情况：O(n*k)，k是最大数的位数
 * - 最坏情况：O(n*k)
 * - 平均情况：O(n*k)
 * 
 * 空间复杂度：O(n+k)，k是进制数（十进制是10）
 * 
 * 稳定性：稳定
 * 
 * 优点：
 * 1. 稳定的排序算法
 * 2. 可以用于字符串排序
 * 3. 适合大规模数据，特别是对于整数排序
 * 4. 可以避免比较操作
 * 
 * 缺点：
 * 1. 需要额外的空间
 * 2. 只能排序整数或字符串
 * 3. 当数据位数不均匀时可能造成浪费
 * 
 * 适用场景：
 * 1. 数据范围较大但是位数较少
 * 2. 整数或字符串排序
 * 3. 要求排序稳定
 * 4. 数据位数相同或相近
 * 
 * 算法步骤：
 * 1. 找出最大数的位数
 * 2. 从最低位开始，对每一位进行计数排序
 * 3. 重复步骤2直到最高位
 */
public class RadixSort implements Sort {
    @Override
    public void sort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }

        // 1. 找出最大数，确定位数
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        // 2. 对每个位数进行计数排序
        // exp是位数，从个位开始，每次乘以10
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingSortByDigit(arr, exp);
        }
    }

    /**
     * 对数组按照某个位数进行计数排序
     * @param arr 待排序数组
     * @param exp 位数（1代表个位，10代表十位，等等）
     */
    private void countingSortByDigit(int[] arr, int exp) {
        int n = arr.length;
        
        // 创建输出数组和计数数组
        int[] output = new int[n];
        int[] count = new int[10]; // 0-9共10个数字
        
        // 统计每个数字出现的次数
        for (int i = 0; i < n; i++) {
            count[(arr[i] / exp) % 10]++;
        }
        
        // 计算累积次数
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }
        
        // 从后向前遍历，构建输出数组
        for (int i = n - 1; i >= 0; i--) {
            int digit = (arr[i] / exp) % 10;
            output[count[digit] - 1] = arr[i];
            count[digit]--;
        }
        
        // 将排序结果复制回原数组
        System.arraycopy(output, 0, arr, 0, n);
    }

    @Override
    public String getName() {
        return "基数排序";
    }
} 