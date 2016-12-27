package com.miaolegemitong.basics.dp.singleton;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author mitong
 * @email mitong@staff.sina.com.cn
 * @date 2016/12/26
 * @description 多个固定数量的实例
 */
public class FixedNumberSingleton {
    // 定义最多能产生的实例数量
    private static int maxNumberOfInstance = 2;

    // 实例的属性
    private static List<String> nameList = new ArrayList<>();

    // 所有实例
    private static List<FixedNumberSingleton> instanceList = new ArrayList<>();

    // 当前实例序列号
    private static int countNumberOfInstance = 0;

    static {
        for (int i = 0; i < maxNumberOfInstance; i++) {
            instanceList.add(new FixedNumberSingleton("第" + (i + 1) + "个实例"));
        }
    }

    private FixedNumberSingleton() {
    }

    private FixedNumberSingleton(String name) {
        nameList.add(name);
    }

    // 随机获得一个实例
    public static FixedNumberSingleton getInstance() {
        Random random = new Random();
        countNumberOfInstance = random.nextInt(maxNumberOfInstance);
        return instanceList.get(countNumberOfInstance);
    }

    // 获取实例的属性
    public static void say() {
        System.out.println(nameList.get(countNumberOfInstance));
    }
}
