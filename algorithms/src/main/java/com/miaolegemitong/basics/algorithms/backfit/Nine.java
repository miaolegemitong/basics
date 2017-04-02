package com.miaolegemitong.basics.algorithms.backfit;

import java.util.Arrays;

/**
 * Created by mitong on 2017/3/30.
 * 从1-9这9个数字  挑出9个数字来填 下图的9个格   ，使得3边之和 都相等，找出所有的结果。
 *                口
 *              /    \
 *            口      口
 *          /          \
 *        口            口
 *       /               \
 *      口 —— 口 —— 口 —— 口
 */
public class Nine {
    //pos数组用于保存从根到叶子的路径上每个节点的值。
    private int[] pos = new int[9];
    private int count;

    /**
     * Check函数的作用就是剪枝的。用于砍掉那些不符合要求的树枝。使得结果集变小和符合要求。
     * 对于9个节点，只要保证每边之和为17，3个顶点的取值为1，2，3就行了。
     * */
    private boolean check(int index, int value) {
        //if(index==0){return true;}
        if (index == 0 && value >= 1 && value <= 3) {
            return true;
        }
        for (int i = 0; i < index; i++) {
            if (pos[i] == value) {
                //value is exists in pos array
                return false;
            }
        }
        switch (index) {
            case 1:
            case 2:
                if ((pos[0] + value) < 17) {
                    return true;
                }
                break;
            case 3:
                if ((pos[0] + pos[1] + value) < 17) {
                    return true;
                }
                break;
            case 4:
                if ((pos[0] + pos[2] + value) < 17) {
                    return true;
                }
                break;
            case 5:
                if (value >= 1 && value <= 3 && (pos[0] + pos[1] + pos[3] + value) == 17) {
                    return true;
                }
                break;
            case 6:
                if ((pos[5] + value) < 17) {
                    return true;
                }
                break;
            case 7:
                if ((pos[5] + pos[6] + value) < 17) {
                    return true;
                }
                break;
            case 8:
                if (value >= 1 && value <= 3 && (pos[0] + pos[2] + pos[4] + value == 17) &&
                        (pos[5] + pos[6] + pos[7] + value == 17)) {
                    return true;
                }
                break;
        }
        return false;
    }

    /**
     * print函数就是这个回溯算法的核心，是用递归实现的，每个index代表树的一个层次，有多少层递归就进行多少次。
     * for(int i=1;i<=9;i++)表示可以尝试的候选结果。if(index==8) 表示达到叶子节点。
     * */
    public void print(int index) {
        if (index < 9) {
            for (int i = 1; i <= 9; i++) {
                if (check(index, i)) {
                    pos[index] = i;
                    print(index + 1);
                    if (index == 8) {
                        count++;
                        System.out.println(Arrays.toString(pos));
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Nine n = new Nine();
        n.print(0);
        System.out.println("count=" + n.count);
    }
}
