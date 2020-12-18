package designPatterns.functory.simple.extend;

import designPatterns.functory.simple.AbstractHandle;

/**
 * @program: ThreadLearn
 * @description: 执行方法
 * @author: chuchen
 * @create: 2020-12-07 12:44
 */
public class ExecuteHandle extends AbstractHandle {


    @Override
    public void doHandle() {

        System.out.println("do execute handle");

    }
}
