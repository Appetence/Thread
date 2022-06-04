package jvm.loader.survivor;

/**
 * @program: ThreadLearn
 * @description:
 * @author: xiamu
 * @create: 2021-03-29 20:23
 */
public class Demo2 {
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
        /**
         * Survivor区放不下存活对象，部分对象进入老年代
         */
        byte[] bytes1 = new byte[1024 * 1024];//1m
        bytes1 = new byte[1024 * 1024];//1m
        bytes1 = new byte[1024 * 1024];//1m
        byte[] bytes0 = new byte[128 * 1024];//128kb
        //直接分配一个5m的对象，由于eden区只有8m，之前已经分配了3m再加上一些未知对象也会占据一定的内存空间，此时必然会引起新生代gc
        byte[] bytes3 = new byte[7 * 1024 * 1024];//5m


    }
}
