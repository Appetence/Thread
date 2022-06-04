package designPatterns.mementoPattern;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: ThreadLearn
 * @description: 备忘录模式，行为模式，记录对象某一时刻的状态并在需要的时候还原
 * @author: chuchen
 * @create: 2020-12-29 13:47
 */
public class MementoPattern {
    public static void main(String[] args) {
        Originator originator = new Originator();
        originator.setStatus("on");
        Caretaker caretaker = new Caretaker();
        caretaker.setMemento(caretaker.creatMemento(originator));
        originator.setStatus("off");
        originator.show();
        caretaker.getOriginator(0).show();


    }
}

/**
 * 需要记录的角色
 */
class Originator {

    private String status;

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return this.status;
    }

    public void show() {
        System.out.println("this Originator sttus is " + status);
    }
}

/**
 * 备忘录角色，记录Originator
 */
class Memento {


    private String status;

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return this.status;
    }

    public void show() {
        System.out.println("this memento sttus is " + status);
    }
}

/**
 * 备忘录管理者
 */
class Caretaker {

    private List<Memento> list;

    public Caretaker() {
        this.list = new ArrayList<>();
    }

    public void setMemento(Memento originator) {
        this.list.add(originator);
    }

    public Memento getOriginator(Integer index) {
        return list.get(index);
    }
    public Memento creatMemento(Originator originator){
        Memento memento =  new Memento();
        memento.setStatus(originator.getStatus());
        return memento;
    }
}

