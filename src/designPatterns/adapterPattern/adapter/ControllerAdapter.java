package designPatterns.adapterPattern.adapter;

import designPatterns.adapterPattern.adapter.AbstractControllerAdapter;
import designPatterns.adapterPattern.controller.AbstractController;
import designPatterns.adapterPattern.controller.Controller;

/**
 * @program: ThreadLearn
 * @description:   适配器模式    将某个类的接口转换成客户期望的另一个接口表示 主要是目的是兼容性，别名（wrapper）
 *                 分三类 类适配器 接口适配器 对象适配器
 * @author: chuchen
 * @create: 2020-12-13 16:28
 */
public class ControllerAdapter extends AbstractControllerAdapter {


    @Override
    public AbstractController getHandler() {
        return new Controller();
    }
}
