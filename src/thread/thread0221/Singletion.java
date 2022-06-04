package thread.thread0221;

/**
 * 单例模式的实现,不用加锁，同时可以懒加载,饱汉模式
 *
 * @author liuhao
 */

public class Singletion {

    public Singletion() {
        System.out.println("初始化程序++++++");
    }

    //匿名内部类调用
    private static class inner {
        static Singletion si = new Singletion();
    }

    public static Singletion getSingletion() {
        return inner.si;
    }

    public static void main(String[] args) {

        System.out.println("单例模式");
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                Singletion.getSingletion();
            }).start();
            ;
        }


    }
}
