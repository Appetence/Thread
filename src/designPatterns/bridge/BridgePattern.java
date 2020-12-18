package designPatterns.bridge;

/**
 * @program: ThreadLearn
 * @description: 桥接模式  实现和抽象放到两个层次，两个模式可以独立改变
 * 类的最小原则，将抽象（abstract）和行为实现 （implementation）分离开来，从而可以保持各部分的独立以及他们功能的扩展
 * @author: chuchen
 * @create: 2020-12-15 00:11
 */
public class BridgePattern {

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