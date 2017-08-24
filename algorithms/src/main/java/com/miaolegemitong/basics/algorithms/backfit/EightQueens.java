package com.miaolegemitong.basics.algorithms.backfit;

import java.util.Arrays;

/**
 * Created by miaolegemitong on 2017/3/30.
 * 八皇后问题
 */
public class EightQueens {
    private int[] poses = new int[8];

    private int count;

    private boolean check(int row, int pos) {
        for (int i = 0; i < row; i++) {
            if (poses[i] == pos || poses[i] == pos - (row - i)  || poses[i] == pos + row - i) {
                return false;
            }
        }
        return true;
    }

    private void print(int row) {
        if (row < 8) {
            for (int i = 1; i <= 8; i++) {
                if (check(row, i)) {
                    poses[row] = i;
                    print(row + 1);
                    if (row == 7) {
                        count++;
                        System.out.println(Arrays.toString(poses));
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        EightQueens eq = new EightQueens();
        eq.print(0);
        System.out.println(eq.count);
    }
}
