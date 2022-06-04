package designPatterns.facadePattern;

/**
 * @program: ThreadLearn
 * @description:
 * @author: chuchen
 * @create: 2020-12-20 15:48
 */
public class Screen {

    private static Screen screen = new Screen();

    public static Screen getInstance() {
        return screen;
    }

    public void on() {
        System.out.println("Screen  on");
    }

    public void off() {
        System.out.println("Screen  off");
    }

    public void focus() {
        System.out.println("Screen  focus");
    }
}
