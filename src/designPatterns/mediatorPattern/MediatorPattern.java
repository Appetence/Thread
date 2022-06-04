package designPatterns.mediatorPattern;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: ThreadLearn
 * @description: 中介者模式 处理多个对象之间的通信，使代码易于维护
 * @author: chuchen
 * @create: 2020-12-30 12:40
 */
public class MediatorPattern {
    public static void main(String[] args) {
        Mediator mediator = new ConcreteMediator();
        Colleague colleague = new ConcreteColleage(mediator,"客户1");
        Colleague colleague2 = new ConcreteColleage(mediator,"客户2");
        mediator.register(colleague);
        mediator.register(colleague2);
        colleague.send("开始了");
        colleague2.send("结束了");

    }
}

/**
 * 中介者抽象
 */
interface Mediator {
    void replay(Colleague colleague, String message);//转发

    void register(Colleague colleague);//
}

/**
 * 同事抽象类
 */
abstract class Colleague {

    /**
     * 用于中介者转发消息
     */
    private Mediator mediator;

    private String name;

    public Colleague(Mediator mediator, String name) {
        this.mediator = mediator;
        this.name = name;
    }

    public abstract void send(String message);

    public abstract void receive(String message);

    public Mediator getMediator() {
        return mediator;
    }

    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class ConcreteColleage extends Colleague {

    public ConcreteColleage(Mediator mediator, String name) {
        super(mediator, name);
    }

    @Override
    public void send(String message) {
        System.out.println(this.getName()+"  send message:" + message);
        super.getMediator().replay(this, message);
    }

    @Override
    public void receive(String message) {
        System.out.println("receive message:" + message);
    }
}

class ConcreteMediator implements Mediator {

    private List<Colleague> list;

    public ConcreteMediator() {
        this.list = new ArrayList<>();
    }

    @Override
    public void replay(Colleague colleague, String message) {
        for (Colleague c : list) {
            if (!c.equals(colleague)) {
                colleague.receive(c.getName()+"收到："+colleague.getName()+":" + message);
            }
        }
    }

    @Override
    public void register(Colleague colleague) {
        if (!list.contains(colleague)) {
            list.add(colleague);
        }
    }
}