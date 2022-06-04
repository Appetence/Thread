package jvm.agent;

import com.xiamu.agent.ObjectShallowSizeAgent;

/**
 * @program: ThreadLearn
 * @description: 测试一个类的大小
 * @author: xiamu
 * @create: 2021-03-25 14:16
 */
public class SizeOfAnObjectTest {
    /**
     * 启动参数中加配置 vm Options: -javaagent:/Users/liuhao/Downloads/workspake/ThreadLearn/ObjectShallowSize/target/ObjectShallowSizeAgent-1.0-SNAPSHOT.jar
     * @param args
     */
    public static void main(String[] args) {
        ObjectShallowSizeAgent.sizeOf(new AgentUtil_1());//
        ObjectShallowSizeAgent.sizeOf(new Object());//16   8 classHeader +4 classPointers(64为默认8，useCompressedOops 开启后压缩为4) +4（padding）
        ObjectShallowSizeAgent.sizeOf(new  int [] {});//16  8 classHeader +4 classPointers(64为默认8，useCompressedOops 开启后压缩为4) + 4（arrayLength）

        /**
         * long  4
         * String   4       #useCompressesClassPointesr 64bitVM 默认为8 开启后为4
         * byte     1
         * int      4
         * object   4       #引用类型指向的是classPointers 默认8字节，但是useCompressedOops默认为开启，所以为4字节
         */
    }
}
