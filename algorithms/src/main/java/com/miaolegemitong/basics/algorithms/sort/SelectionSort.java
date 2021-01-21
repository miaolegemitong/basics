package com.miaolegemitong.basics.algorithms.sort;

/**
 * @author mitong
 * @date 2018/5/5
 * @email mitong@meituan.com
 * @desc
 */
public class SelectionSort {
    public static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n-1; i++) {
            // Find the minimum element in unsorted array
            int minIdx = i;
            for (int j = i+1; j < n; j++) {
                if (arr[j] < arr[minIdx]) {
                    minIdx = j;
                }
            }

            // Swap the found minimum element with the first
            // element
            int temp = arr[minIdx];
            arr[minIdx] = arr[i];
            arr[i] = temp;
        }
    }
}
