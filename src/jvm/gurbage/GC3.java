package jvm.gurbage;

import base.Xiamu;

/**
 * @program: ThreadLearn
 * @description:
 * @author: xiamu
 * @create: 2021-05-14 14:47
 */
public class GC3 {
    public static void main(String[] args) {
        Xiamu xiamu = new Xiamu();
        xiamu = null;
        String[] array = new String[1024 * 500];
        for (int i = 0; i < 1024 * 500; i++) {//系统消耗大量内存，JVM需要进行内存回收
            for (int j = 'a'; j <= 'z'; j++) {
                array[i] += (char) j;
            }
        }
    }
}
