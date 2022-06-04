package jvm.gurbage;

import base.Xiamu;

import java.lang.ref.SoftReference;

/**
 * @program: ThreadLearn
 * @description:
 * @author: xiamu
 * @create: 2021-05-14 14:47
 */
public class GC4 {
    public static void main(String[] args) {
        SoftReference ref = new SoftReference(new Xiamu());
        //重写了finalize方法，在内存不足时候回触发

                 System.out.println(ref.get());
         //        System.gc();
                 String[] array = new String[1024 * 500];
                 for(int i = 0; i < 1024 * 500; i++) {//系统消耗大量内存，JVM需要进行内存回收
                         for(int j = 'a'; j <= 'z'; j++) {
                                 array[i] += (char)j;
                             }
                     }
    }
}
