package jvm.loader;

/**
 * @program: ThreadLearn
 * @description: 父类
 * @author: xiamu
 * @create: 2021-03-11 15:33
 */
public class SupClass {

    static {
        System.out.println("this is super class");
    }

    //静态常量
    public static final String FLAG = "FLAG";
    //静态变量
    public static String FLAG01 = "FLAG01";


    public String show(String show) {
        System.out.println("invoke :" + show);
        return show;
    }

    public String show(String show, String show1) {
        System.out.println("invoke :" + show);
        System.out.println("show1  =" + show1);
        return show;
    }

    public void unShow() {
        System.out.println("invoke : unshow");
    }


}
