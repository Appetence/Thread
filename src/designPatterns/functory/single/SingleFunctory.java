package designPatterns.functory.single;

/**
 * @program: ThreadLearn
 * @description: 单例工厂
 * @author: chuchen
 * @create: 2020-12-07 12:35
 */
public class SingleFunctory {
    //静态内部类实现
    public static SingleFunctory getInstance() {
        return StaticFunctory.singleFunctory;
    }

    private static class StaticFunctory {
        public static SingleFunctory singleFunctory = new SingleFunctory();
    }
}
