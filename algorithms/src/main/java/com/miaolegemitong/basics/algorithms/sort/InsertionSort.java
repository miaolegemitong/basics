package com.miaolegemitong.basics.algorithms.sort;

/**
 * @author mitong
 * @email mitong@staff.sina.com.cn
 * @date 2017/1/18
 * @description
 */
public class InsertionSort {
    public static void straightInsertionSort(int[] data) {
        for (int i = 1; i < data.length; i++) {
            if (data[i] < data[i - 1]) {
                int j = i - 1;
                int x = data[i];
                while (j >= 0 && x < data[j]) {
                    data[j + 1] = data[j];
                    j--;
                }
                data[j + 1] = x;
            }
        }
    }
}
