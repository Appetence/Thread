package designPatterns.facadePattern;

/**
 * @program: ThreadLearn
 * @description:
 * @author: chuchen
 * @create: 2020-12-20 15:48
 */
public class PlayManager {
    private DVDPlay dvdPlay;
    private Screen screen;

    public PlayManager() {
        this.dvdPlay = DVDPlay.getInstance();
        this.screen = Screen.getInstance();
    }

    public void dvdPlay() {
        dvdPlay.on();
    }

    public void screan() {
        screen.on();
    }

    public void off() {
        dvdPlay.off();
        screen.off();
    }

}
