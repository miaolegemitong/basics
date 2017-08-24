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
}
