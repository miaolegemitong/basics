package com.miaolegemitong.basics.algorithms.sort;

/**
 * @author miaolegemitong
 * @email mitong@miaolegemitong.com
 * @date 2017/1/18
 * @description
 */
public class BubbleSort {
    public static void bubbleSort(int[] data) {
        if (data == null || data.length == 0) {
            return;
        }
        for (int i = 0; i < data.length - 1; i++) {
            for (int j = 0; j < data.length - 1 - i; j++) {
                if (data[j] > data[j + 1]) {
                    int temp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;
                }
            }
        }
    }

    //改进版本1：
    public static void bubbleSort1(int[] data) {
        if (data == null || data.length == 0) {
            return;
        }
        boolean bSwaped;
        for (int i = 0; i < data.length - 1; i++) {
            bSwaped = false;
            for (int j = 0; j < data.length - 1 - i; j++) {
                if (data[j] > data[j + 1]) {
                    int temp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;
                    bSwaped = true;
                }
            }
            if (!bSwaped) {
                break;
            }
        }
    }

    //改进版本2
    public static void bubbleSort2(int[] data) {
        if (data == null || data.length == 0) {
            return;
        }
        int lastSwapPos;
        int lastSwapPosTemp = data.length - 1;
        for (int i = 0; i < data.length - 1; i++) {
            lastSwapPos = lastSwapPosTemp;
            for (int j = 0; j < lastSwapPos; j++) {
                if (data[j] > data[j + 1]) {
                    int temp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;
                    lastSwapPosTemp = j;
                }
            }
            if (lastSwapPos == lastSwapPosTemp) {
                break;
            }
        }
    }

    //递归版本
    public static void recursiveBubbleSort(int[] data, int len) {
        if (len == 1) {
            return;
        }

        // One pass of bubble sort. After
        // this pass, the largest element
        // is moved (or bubbled) to end.
        for (int i = 0; i < len - 1; i++) {
            if (data[i] > data[i + 1]) {
                // swap arr[i], arr[i+1]
                int temp = data[i];
                data[i] = data[i + 1];
                data[i + 1] = temp;
            }
        }
        // Largest element is fixed,
        // recur for remaining array
        recursiveBubbleSort(data, len - 1);
    }
}
