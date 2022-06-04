package jvm.loader.survivor;

/**
 * @program: ThreadLearn
 * @description:
 * @author: xiamu
 * @create: 2021-03-29 20:23
 */
public class Demo1 {
    public static void main(String[] args) {
        //-XX:+PrintGCDetails -XX:-UseAdaptiveSizePolicy -XX:SurvivorRatio=8 -XX:NewSize=10M -XX:MaxNewSize=10M

        /**
         * -XX:NewSize=10485760—新生代大小为10m
         * -XX:MaxNewSize=10485760—新生代最大大小为10m
         * -Xms20M—初始堆大小为20m
         * -Xmx20M—最大堆大小为20m
         * -XX:+UseParNewGC：新生代使用ParNewGC垃圾回收器
         * -XX:+UseConcMarkSweepGC---老年代使用CMS
         * -XX:+PrintGCDetails---打印GC详细日志
         * -XX:+PrintGCTimeStamps—打印GC时间
         * -XX:SurvivorRatio=8—设置eden区和survivor区的比例为8:1:1
         * -XX:PretenureSizeThreshold=10485760—设置最大对象的阈值为10m
         */
        /*  -XX:NewSize=10485760  -XX:MaxNewSize=10485760  -Xms20M  -Xmx20M  -XX:+UseParNewGC  -XX:+UseConcMarkSweepGC  -XX:+PrintGCDetails  -XX:+PrintGCTimeStamps  -XX:SurvivorRatio=8  -XX:PretenureSizeThreshold=10485760*/
        /**
         * Survivor区放不下存活对象，部分对象进入老年代
         */
        byte[] bytes1 = new byte[1024 * 1024];//1m
        bytes1 = new byte[1024 * 1024];//1m
        bytes1 = new byte[1024 * 1024];//1m
        //直接分配一个5m的对象，由于eden区只有8m，之前已经分配了3m再加上一些未知对象也会占据一定的内存空间，此时必然会引起新生代gc
        byte[] bytes3 = new byte[5 * 1024 * 1024];//5m
        /**
         * 0.172: [GC (Allocation Failure) 0.172: [ParNew: 4650K->458K(9216K), 0.0039216 secs] 4650K->1484K(19456K), 0.0040185 secs] [Times: user=0.03 sys=0.00, real=0.01 secs]
         * Heap
         *  par new generation   total 9216K, used 5746K [0x00000007bec00000, 0x00000007bf600000, 0x00000007bf600000)
         *   eden space 8192K,  64% used [0x00000007bec00000, 0x00000007bf129cc8, 0x00000007bf400000)
         *   from space 1024K,  44% used [0x00000007bf500000, 0x00000007bf572b38, 0x00000007bf600000)
         *   to   space 1024K,   0% used [0x00000007bf400000, 0x00000007bf400000, 0x00000007bf500000)
         *  concurrent mark-sweep generation total 10240K, used 1026K [0x00000007bf600000, 0x00000007c0000000, 0x00000007c0000000)
         *  Metaspace       used 3056K, capacity 4496K, committed 4864K, reserved 1056768K
         *   class space    used 334K, capacity 388K, committed 512K, reserved 1048576K
         */
        /**
         * 0.158: [GC (Allocation Failure) 0.158: [ParNew: 4612K->591K(9216K), 0.0017813 secs] 4612K->1618K(19456K), 0.0018326 secs] [Times: user=0.01 sys=0.00, real=0.00 secs]
         * Heap
         *  par new generation   total 9216K, used 5876K [0x00000007bec00000, 0x00000007bf600000, 0x00000007bf600000)
         *   eden space 8192K,  64% used [0x00000007bec00000, 0x00000007bf1290f0, 0x00000007bf400000)
         *   from space 1024K,  57% used [0x00000007bf500000, 0x00000007bf593fe8, 0x00000007bf600000)
         *   to   space 1024K,   0% used [0x00000007bf400000, 0x00000007bf400000, 0x00000007bf500000)
         *  concurrent mark-sweep generation total 10240K, used 1026K [0x00000007bf600000, 0x00000007c0000000, 0x00000007c0000000)
         *  Metaspace       used 2976K, capacity 4496K, committed 4864K, reserved 1056768K
         *   class space    used 328K, capacity 388K, committed 512K, reserved 1048576K
         */
    }
}
