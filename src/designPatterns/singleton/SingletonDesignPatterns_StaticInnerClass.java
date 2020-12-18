package designPatterns.singleton;

/**
 * @program: ThreadLearn
 * @description: 静态内部类
 * @author: chuchen
 * @create: 2020-12-07 00:14
 */
public class SingletonDesignPatterns_StaticInnerClass {

    public SingletonDesignPatterns_StaticInnerClass() {
        System.out.println("static class init");
    }

    public static SingletonDesignPatterns_StaticInnerClass getInstance() {
        return StaticInnerClass.singletonDesignPatterns_staticInnerClass;
    }
    private static class StaticInnerClass{
        private static SingletonDesignPatterns_StaticInnerClass singletonDesignPatterns_staticInnerClass = new SingletonDesignPatterns_StaticInnerClass();

    }

}
