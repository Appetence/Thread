package jvm.stack;

/**
 * @program: ThreadLearn
 * @description:
 * @author: liuhao
 * @date: 2022-01-30 09:04
 */
public class JavaStack {
    public static void main(String[] args) {
        A();

    }

    static void A() {
        B();
    }

    static void B() {
        C();
    }

    static void C() {
        Throwable throwable = new Throwable();
        StackTraceElement[] ourStackTrace = throwable.getStackTrace();
        System.out.println(ourStackTrace[0].getMethodName());
    }
}
