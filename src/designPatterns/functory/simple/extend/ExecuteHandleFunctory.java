package designPatterns.functory.simple.extend;

import designPatterns.functory.simple.AbstractHandle;
import designPatterns.functory.simple.AbstractHandleFunctory;

/**
 * @program: ThreadLearn
 * @description: 执行处理工厂
 * @author: chuchen
 * @create: 2020-12-07 12:43
 */
public class ExecuteHandleFunctory extends AbstractHandleFunctory {

    @Override
    public void doHandleFunctory() {
        AbstractHandle executeHandle = new ExecuteHandle();
        executeHandle.doHandle();
        AbstractHandle runHandle = new RunHandle();
        runHandle.doHandle();
    }
}
