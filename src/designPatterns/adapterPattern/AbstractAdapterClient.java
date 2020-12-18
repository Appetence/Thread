package designPatterns.adapterPattern;

/**
 * @program: ThreadLearn
 * @description:
 * @author: chuchen
 * @create: 2020-12-14 12:57
 */
public abstract class AbstractAdapterClient implements Adapter {
    public void doController() {
        new ControllerAdapter().getHandler().doHandler();
    }

    public void doRunController() {
        new RunControllerAdapter().getHandler().doHandler();

    }

    public void doSkipController() {
        new SkipControllerAdapter().getHandler().doHandler();

    }
}
