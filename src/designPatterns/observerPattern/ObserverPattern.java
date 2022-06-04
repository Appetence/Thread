package designPatterns.observerPattern;

import java.util.Vector;

/**
 * @program: ThreadLearn
 * @description: 观察者模式，也叫发布-订阅模式    行为模式，当一个对象的状态发生变化的时候通知其他关心该状态的对象
 * @author: chuchen
 * @create: 2020-12-29 13:24
 */
public class ObserverPattern {

    public static void main(String[] args) {
        //主题
        ConcreteSubjec concreteSubjec = new ConcreteSubjec();
        //观察者
        ConcreteObesrver obesrver = new ConcreteObesrver();
        //开始监听
        concreteSubjec.addVector(obesrver);
        //通知
        concreteSubjec.display();
    }

}

/**
 * 抽象的主题方法
 */
abstract class Subject{

    private Vector<Observer> vector;

    public Subject() {
        this.vector = new Vector();
    }
    public void addVector(Observer observer){
        vector.add(observer);
    }
    public void removeVector(Observer observer){
        vector.remove(observer);
    }
    public void display(){
        for(Observer observer : vector){
            observer.updaet();
        }
    }
}

/**
 * 抽象的观察者
 */
interface Observer{
    /**
     * 更新
     */
    public void updaet();
}

/**
 * 具体的主题
 */
class ConcreteSubjec extends Subject{
    public void display(){
        super.display();
    }
}
class ConcreteObesrver implements Observer{

    @Override
    public void updaet() {
        System.out.println("接收到了更新的消息");
    }
}