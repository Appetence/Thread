package designPatterns.adapterPattern;

/**
 * @program: ThreadLearn
 * @description:
 * @author: chuchen
 * @create: 2020-12-13 21:58
 */
public class Controller extends AbstractController{

    @Override
    public void doHandler() {
        System.out.println("this is controller");
    }
}
