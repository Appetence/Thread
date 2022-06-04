package jvm.loader;

/**
 * @program: ThreadLearn
 * @description: 引用静态方法 均无需类初始化
 * @author: xiamu
 * @create: 2021-03-11 15:38
 */
public class ClassLoader_03 {
    public static void main(String[] args) {
        //linking 准备时候赋值
        System.out.println(SunClass.FLAG);
        //解释时候赋予值
        System.out.println(SunClass.FLAG01);
    }
}
