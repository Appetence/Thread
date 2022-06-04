package designPatterns.facadePattern;

/**
 * @program: ThreadLearn
 * @description:
 * @author: chuchen
 * @create: 2020-12-20 15:48
 */
public class DVDPlay {

    private static DVDPlay dvdPlay = new DVDPlay();

    public static DVDPlay getInstance() {
        return dvdPlay;
    }

    public void on() {
        System.out.println("dvd  on");
    }

    public void off() {
        System.out.println("dvd  off");
    }

    public void focus() {
        System.out.println("dvd  focus");
    }
}
