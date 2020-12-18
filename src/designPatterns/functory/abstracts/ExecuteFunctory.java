package designPatterns.functory.abstracts;

import designPatterns.functory.abstracts.handle.AbstractHandle;
import designPatterns.functory.abstracts.handle.ExecuteHandle;

/**
 * @program: ThreadLearn
 * @description:
 * @author: chuchen
 * @create: 2020-12-07 13:05
 */
public class ExecuteFunctory implements AbstractFunctory{
    @Override
    public void createHandle() {
        AbstractHandle abstractHandle = new ExecuteHandle();
        abstractHandle.doHandle();
    }
}
