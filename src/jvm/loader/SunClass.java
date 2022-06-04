package jvm.loader;

/**
 * @program: ThreadLearn
 * @description: 子类
 * @author: xiamu
 * @create: 2021-03-11 15:35
 */
public class SunClass extends SupClass {
    static {
        System.out.println("this is sun class");
    }

    //静态常量
    public static final String FLAG = "SUNFLAG";
    //静态变量
    public static String FLAG01 = "SUNFLAG01";
}
