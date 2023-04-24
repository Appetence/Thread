package access.synthetic;

import static java.lang.System.out;

/**
 * @program: ThreadLearn
 * @description: synthetic  编译器为了方便内部类的私有成员被外部类引用，生成了一个get方法，这可以被理解为一个trick，绕开了private成员变量的限制。
 * @author: xiamu
 * @create: 2021-04-20 15:24
 */
public final class InitTime {
//    private static InitTime initTime = new InitTime();
    private static int aa;
    private static int bb = 2;
    private static InitTime initTime = new InitTime();    //按照预期输出


    public InitTime() {
        aa++;
        bb++;
    }

    public static void main(final String[] arguments) {

        out.println(initTime.aa);// 1
        out.println(initTime.bb);// 2
    }

}