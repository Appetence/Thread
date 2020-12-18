package designPatterns.adapterPattern;

/**
 * @program: ThreadLearn
 * @description: 适配器模式    将某个类的接口转换成客户期望的另一个接口表示 主要是目的是兼容性，别名（wrapper）
 *                 分三类 类适配器 接口适配器 对象适配器
 * @author: chuchen
 * @create: 2020-12-13 16:28
 */
public abstract class AbstractControllerAdapter {
    /**
     * 获取代理
     * @return
     */
    public abstract AbstractController getHandler();
}
