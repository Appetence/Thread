package thread.thread1126;

/**
 * @program: ThreadLearn
 * @description: 线程资源开销分析
 * @author: liuhao
 * @date: 2021-11-26 15:53
 */
public class ThreadSourceTest {
    private static int count = 0;

    public static void main(String[] args) throws InterruptedException {
        //TODO  耗时主要发生在线程启动时候


        // 记录程序开始执行时间
        long startTime = System.currentTimeMillis();
        //耗时     4817
        testChangeSource();
        // 耗时  146 ms
//        testNotChangeSource();
        // 耗时 1ms
//        testNotCreateSource();
        // 耗时 3641 ms
//        testSourceNotJoin();
        // 记录程序执行结束时间
        long endTime = System.currentTimeMillis();
        // 打印消耗的时间
        System.out.println("耗时 : " + (endTime - startTime) + " ms , 最终 count = " + count);



    }

    private static void testNotChangeSource() {
        // 耗时  146 ms
        for (int i = 0; i < 100000; i++) {
            Thread thread = new Thread(() -> {
                count++;
            });
        }

    }

    private static void testNotCreateSource() {
        // 耗时 1ms
        for (int i = 0; i < 100000; i++) {

        }
    }

    private static void testSourceNotJoin() {
        // 耗时 3641 ms
        for (int i = 0; i < 100000; i++) {
            Thread thread = new Thread(() -> {
                count++;
            });
            thread.start();
        }
    }

    private static void testChangeSource() throws InterruptedException {
        //耗时     4817
        for (int i = 0; i < 100000; i++) {
            Thread thread = new Thread(() -> {
                count++;
            });
            thread.start();
            // 确保线程切换
            thread.join();
        }
        System.out.println("");
    }
}
