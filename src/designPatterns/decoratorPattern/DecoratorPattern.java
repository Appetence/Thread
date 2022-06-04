package designPatterns.decoratorPattern;

/**
 * @program: ThreadLearn
 * @description: 装饰器模式
 * 动态地给一个对象添加一些额外的职责。就增加功能来说，装饰器模式相比生成子类更为灵活
 *
 *
 * 对装饰器模式来说，装饰者（decorator）和被装饰者（decoratee）都实现同一个 接口。对代理模式来说，代理类（proxy class）和真实处理的类（real class）都实现同一个接口。他们之间的边界确实比较模糊，两者都是对类的方法进行扩展，具体区别如下：
 *
 * 1、装饰器模式强调的是增强自身，在被装饰之后你能够在被增强的类上使用增强后的功能。增强后你还是你，只不过能力更强了而已；代理模式强调要让别人帮你去做一些本身与你业务没有太多关系的职责（记录日志、设置缓存）。代理模式是为了实现对象的控制，因为被代理的对象往往难以直接获得或者是其内部不想暴露出来。
 *
 * 2、装饰模式是以对客户端透明的方式扩展对象的功能，是继承方案的一个替代方案；代理模式则是给一个对象提供一个代理对象，并由代理对象来控制对原有对象的引用；
 *
 * 3、装饰模式是为装饰的对象增强功能；而代理模式对代理的对象施加控制，但不对对象本身的功能进行增强；
 *
 * 装饰器，你仍然是你，但是你的内在变了
 * 代理，无论怎么变你仍然是你，变得是被代理的对象
 * <p>
 * 蛋糕问题,星巴克咖啡
 * @author: chuchen
 * @create: 2020-12-19 19:16
 */
public class DecoratorPattern {

    public static void main(String[] args) {
        Component component = new LuckyCoffee();
        System.out.println(component.getNane() + component.getPrice());

        component = new MilkConcreteDecorator(component);

        System.out.println(component.getNane() + component.getPrice());

        component = new Soy(component);
        System.out.println(component.getNane() + component.getPrice());

    }
}

/**
 * 抽象构件
 */
abstract class Component {

    private String nane;
    private double price = 0.0d;

    abstract double cost();

    public String getNane() {
        return nane;
    }

    public void setNane(String nane) {
        this.nane = nane;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

/**
 * 具体构件，或者基础构件
 */
class LuckyCoffee extends Component {

    public LuckyCoffee() {
        setNane("lucky");
        setPrice(1.0d);
    }

    @Override
    public double cost() {
        return getPrice();
    }
}

/**
 * 具体构件，或者基础构件
 */
class StarBucksCoffee extends Component {

    public StarBucksCoffee() {
        setNane("星巴克");
        setPrice(2.0);
    }

    @Override
    public double cost() {
        return getPrice();
    }
}

/**
 * 装饰角色
 */
abstract class Decorator extends Component {

    private Component component;

    public Decorator(Component component) {
        this.component = component;
    }

    @Override
    double cost() {
        return super.getPrice() + component.getPrice();
    }

    @Override
    public String getNane() {
        return super.getNane() + "&&" + component.getNane();
    }
}

/**
 * 具体装饰角色
 */
class MilkConcreteDecorator extends Decorator {

    public MilkConcreteDecorator(Component component) {
        super(component);
        setNane("牛奶");
        setPrice(2d);
    }
}

class Soy extends Decorator {

    public Soy(Component component) {
        super(component);
        setNane("豆浆");
        setPrice(1.5f);
    }
}