package designPatterns.adapterPattern.controller;

import designPatterns.adapterPattern.controller.AbstractController;

/**
 * @program: ThreadLearn
 * @description: 适配器模式
 * <p>
 *     将一个类的接口转换成客户希望的另外一个接口。适配器模式使得原本由于接口不兼容而不能一起工作的那些类可以一起工作。
 *     优点：1、可以让任何两个没有关联的类一起运行。 2、提高了类的复用。 3、增加了类的透明度。 4、灵活性好。
 *     缺点：1、过多地使用适配器，会让系统非常零乱
 *           2.由于 JAVA 至多继承一个类，所以至多只能适配一个适配者类，而且目标类必须是抽象类
 * </p>
 * @author: chuchen
 * @create: 2020-12-13 21:58
 */
public class Controller extends AbstractController {

    @Override
    public void doHandler() {
        System.out.println("this is controller");
    }
}
