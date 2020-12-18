package designPatterns.singleton;

/**
 * @program: ThreadLearn
 * @description: 单例模式
 * @author: chuchen
 * @create: 2020-12-07 00:04
 */
public class SingletonDesignPatterns {

    public SingletonDesignPatterns() {
        System.out.println("double check init");
    }

    private volatile static SingletonDesignPatterns singletonDesignPatterns;

    public static SingletonDesignPatterns getInstance() {

        if (singletonDesignPatterns == null) {

            synchronized (SingletonDesignPatterns.class) {

                if (singletonDesignPatterns == null) {

                    //这一步设计如下三小步，在编译器优化的时候可能会发生指令重排序，需要对singletonDesignPatterns添加volatile
                    //1.为对象分配内存
                    //2.调用构造方法初始化
                    //3.将对象的指针指向内存
                    singletonDesignPatterns = new SingletonDesignPatterns();

                }

            }

        }
        return singletonDesignPatterns;
    }


}
