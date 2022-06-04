package com.xiamu.agent;

import java.lang.instrument.Instrumentation;

/**
 * @program: ObjectShallowSizeAgent
 * @description:    jvm 将class文件load到内存时候会有一个agent机制
 * @author: xiamu
 * @create: 2021-03-25 14:36
 */
public class ObjectShallowSizeAgent {
    /**
     * 调弦 操作class类
     */
    private static Instrumentation inst;

    /**
     * 固定的，虚拟机自动调用
     * @param agentArgs
     * @param instP
     */
    public static void premain(String agentArgs, Instrumentation instP) {
        System.out.println(agentArgs);
        inst = instP;

    }

    /**
     * 自己的实现
     * @param obj
     * @return
     */
    public static long sizeOf(Object obj) {
        return inst.getObjectSize(obj);

    }
}
