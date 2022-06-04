package designPatterns.templatePattern;

/**
 * @program: ThreadLearn
 * @description: 模版方法模式（行为型模式），父类公开定义一系列的模版方法，子类根据需要进行实现
 *                  基本步骤相同，部分步骤不同的情况下考虑此方法
 * @author: chuchen
 * @create: 2020-12-26 16:47
 */
public class TemplatePattern {
    public static void main(String[] args) {
        Base busiBase = new BusiBase(true);
        System.out.println(busiBase.isFlag());
        busiBase.build();
    }
}

abstract class Base {

    private boolean flag;

    public Base() {
    }

    public Base(boolean flag) {
        this.flag = flag;
    }

    /**
     * 把几乎不变的公共部分代码集中在父亲类
     *  禁止重写
     */
    final void build() {
        before();
        if (flag) {
            target();
        }
        after();

    }

    void before() {
        System.out.println("-----before");
    }

    void after() {
        System.out.println("-----after");
    }

    /**
     * 钩子方法
     * 父类中定义一个方法，默认不做任何事情，子类可以看情况对其进行覆盖，这种方法称为"钩子"
     */
    void setFlag(boolean flag) {

    }

    abstract void target();

    public boolean isFlag() {
        return flag;
    }
}

class BusiBase extends Base {
    public BusiBase(boolean flag) {
        super(flag);
    }

    @Override
    void target() {
        System.out.println("-----target");
    }

    @Override
    void setFlag(boolean flag) {
    }
}
