package jvm.gurbage;

import base.Xiamu;

/**
 * @program: ThreadLearn
 * @description:
 * @author: xiamu
 * @create: 2021-05-14 14:47
 */
public class GC2 {
    public static void main(String[] args) {
        Xiamu xiamu = new Xiamu();
        xiamu = null;
        System.gc();//手动触发gc
    }
}
