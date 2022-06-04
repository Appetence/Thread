package designPatterns.commontPattern;

import java.util.LinkedList;
import java.util.List;

/**
 * @program: ThreadLearn
 * @description: 命令模式 行为模式，将命令的请求者和执行者分开
 * <p>
 *      优点：
 *          减耦合，扩展灵活
 *      缺点：
 *          行为太多不好维护
 * </p>
 *      <p>
 *      注意：
 *          空命令也是命令模式的一种
 *      角色
 *          invoke  调用者
 *          command 命令角色
 *          receiver    命令的执行者
 *          concreteCommond     命令接受者与命令绑定
 *
 *         命令接受者接到命令后通过绑定关系让指定的行为执行
 *
 *      </p>
 * @author: chuchen
 * @create: 2020-12-26 18:01
 */
public class CommontPattern {
    public static void main(String[] args) {
        Action action = new FundAction();
        Commont commont = new BaseCommont(action);
        List<Commont> list = new LinkedList<>();
        list.add(commont);
        Manager manager = new Manager(list);
        manager.doManager();
    }
}

/**
 * 命令的调用者
 */
class Manager {
    private List<Commont> list;

    public Manager(List<Commont> list) {
        this.list = list;
    }

    public void doManager() {
        for (Commont commont : list) {
            commont.excute();
        }
    }
}

/**
 * 命令行为关联者
 */
interface Commont {
    boolean excute();

    boolean undo();
}

class BaseCommont implements Commont {
    private Action action;

    public BaseCommont(Action action) {
        this.action = action;
    }

    @Override
    public boolean excute() {
        System.out.println("do execute");
        action.doAction();
        return true;
    }

    @Override
    public boolean undo() {
        System.out.println("do undo execute");
        return true;
    }
}

/**
 * 行为
 */
interface Action {
    void doAction();
}

class FundAction implements Action {

    @Override
    public void doAction() {
        System.out.println("do action");
    }
}