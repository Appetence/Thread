package designPatterns.visitorPattern;

import java.util.LinkedList;
import java.util.List;

/**
 * @program: ThreadLearn
 * @description: 访问者模式  封装一些作用于某种数据结构元素的操作，在不改变数据结构的前提下增加新的操作，主要是将数据结构和数据操作分离，解决数据结构和操作耦合性问题
 * @author: chuchen
 * @create: 2020-12-26 19:15
 */
public class VisitorPattern {
    public static void main(String[] args) {
        ObjectStructure objectStructure = new ObjectStructure();
        objectStructure.attch(new ManVisitor());
        objectStructure.attch(new WomVisitor());
        objectStructure.display(new ManVisitor(),new Success());
    }
}

/**
 * 管理类
 */
class ObjectStructure {

    private List<Visitor> list;

    public ObjectStructure() {
        this.list =new LinkedList<>();
    }

    public void attch(Visitor visitor) {
        list.add(visitor);
    }

    ;

    public void remove(Visitor visitor) {
        list.remove(visitor);
    }

    public void display(Visitor visitor, Action action) {
        visitor.accept(action);
    }

}

/**
 * 人物
 */
interface Visitor {

    void accept(Action action);

}

/**
 * 说明：
 * 1 双分派，客户端程序中，将action作为参数传递给Visitor  第一次分派
 * 2 visitor类调用参数action的method，同时将自己 this 作为参数传传入  第二次分派
 */
class ManVisitor implements Visitor {

    @Override
    public void accept(Action action) {
        action.getManResult(this);
    }
}

class WomVisitor implements Visitor {

    @Override
    public void accept(Action action) {
        action.getWomResult(this);
    }
}


/**
 * 行为
 */
abstract class Action {

    abstract void getManResult(Visitor visitor);

    abstract void getWomResult(Visitor visitor);

}

class Success extends Action {

    @Override
    void getManResult(Visitor visitor) {
        System.out.println("do man success ");
    }

    @Override
    void getWomResult(Visitor visitor) {
        System.out.println("do wom success ");
    }
}

class Fail extends Action {

    @Override
    void getManResult(Visitor visitor) {
        System.out.println("do man fail ");
    }

    @Override
    void getWomResult(Visitor visitor) {
        System.out.println("do wom fail ");
    }
}