package com.miaolegemitong.basics.algorithms.sort;

/**
 * @author mitong
 * @email mitong@staff.sina.com.cn
 * @date 2017/1/18
 * @description
 */
public class QuickSort {
    public static void quickSort(int[] data, int begin, int end) {
        if (data == null || data.length == 0) {
            return;
        }
        if (begin < end) {
            int base = data[begin];
            int i = begin + 1;
            int j = end;
            while (true) {
                while (i <= j && data[i] <= base) {
                    i++;
                }
                while (j >= i && data[j] >= base) {
                    j--;
                }
                if (i < j) {
                    int temp = data[i];
                    data[i] = data[j];
                    data[j] = temp;
                } else {
                    break;
                }
            }
            if (begin < end) {
                int temp = data[begin];
                data[begin] = data[j];
                data[j] = temp;
                quickSort(data, begin, j - 1);
                quickSort(data, j + 1, end);
            }
        }
    }
}
