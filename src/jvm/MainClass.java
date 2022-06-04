package jvm;

/**
 * @program: ThreadLearn
 * @description:
 * @author: xiamu
 * @create: 2021-03-26 16:48
 */
public class MainClass {
    public static void main(String[] args) {
        int i = 3;
        i = i++;
        i = i +2;
        System.out.println(i);
        System.gc();
    }
}
