package designPatterns.facadePattern;

/**
 * @program: ThreadLearn
 * @description:    外观模式 门面模式   解决多个复杂接口调用带来的使用困难，简化用户操作
 * 影院观影流程场景
 * @author: chuchen
 * @create: 2020-12-20 15:45
 */
public class FacadePattern {
    public static void main(String[] args) {
        PlayManager playManager = new PlayManager();
        playManager.dvdPlay();
        playManager.screan();
        playManager.off();
    }
}
