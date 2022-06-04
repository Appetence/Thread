package designPatterns.bridge;

/**
 * @program: ThreadLearn
 * @description: 桥接模式  实现和抽象放到两个层次，两个模式可以独立改变
 * 类的最小原则，将抽象（abstract）和行为实现 （implementation）分离开来，从而可以保持各部分的独立以及他们功能的扩展
 * @author: chuchen
 * @create: 2020-12-15 00:11
 */
public class BridgePattern {
    /**
     * 这种模式涉及到一个作为桥接的接口，使得实体类的功能独立于接口实现类。这两种类型的类可被结构化改变而互不影响。
     *
     * 　　个人理解：桥接是一个接口，它与一方应该是绑定的，也就是解耦的双方中的一方必然是继承这个接口的，这一方就是实现方，而另一方正是要与这一方解耦的抽象方，
     *      如果不采用桥接模式，一般我们的处理方式是直接使用继承来实现，这样双方之间处于强链接，类之间关联性极强，如要进行扩展，必然导致类结构急剧膨胀。采用桥接模式，
     *      正是为了避免这一情况的发生，将一方与桥绑定，即实现桥接口，另一方在抽象类中调用桥接口（指向的实现类），这样桥方可以通过实现桥接口进行单方面扩展，
     *      而另一方可以继承抽象类而单方面扩展，而之间的调用就从桥接口来作为突破口，不会受到双方扩展的任何影响。
     *
     *      多实现，多结果，多个维度进行维护
     * @param args
     */
    public static void main(String[] args) {
    Notification notification = new ErrorNotification(new EmailMsgSend());
    notification.notify("错误");

    }
}

/**
 * send接口
 */
interface MsgSend {

    void send(String message);

}

class EmailMsgSend implements MsgSend {

    @Override
    public void send(String message) {
        System.out.println("邮件发送消息：" + message);
    }
}

class SmsMsgSend implements MsgSend {

    @Override
    public void send(String message) {
        System.out.println("短信发送消息：" + message);
    }
}

class WechatMsgSend implements MsgSend {

    @Override
    public void send(String message) {
        System.out.println("微信发送消息：" + message);
    }
}

/**
 * 告警抽象类
 */
abstract class Notification {
    public MsgSend msgSend;

    public Notification(MsgSend msgSend) {
        this.msgSend = msgSend;
    }

    public abstract void notify(String message);
}

class ErrorNotification extends Notification {

    public ErrorNotification(MsgSend msgSend) {
        super(msgSend);
    }

    @Override
    public void notify(String message) {
        msgSend.send("[error]" + message);
    }
}

class TrivialNotification extends Notification {

    public TrivialNotification(MsgSend msgSend) {
        super(msgSend);
    }

    @Override
    public void notify(String message) {
        msgSend.send("[trivial]" + message);

    }
}

class UrgencyNotification extends Notification {

    public UrgencyNotification(MsgSend msgSend) {
        super(msgSend);
    }

    @Override
    public void notify(String message) {
        msgSend.send("[urgency]" + message);

    }
}