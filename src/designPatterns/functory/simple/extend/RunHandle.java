package designPatterns.functory.simple.extend;

import designPatterns.functory.simple.AbstractHandle;

/**
 * @program: ThreadLearn
 * @description:
 * @author: chuchen
 * @create: 2020-12-07 12:55
 */
public class RunHandle extends AbstractHandle {
    @Override
    public void doHandle() {
        System.out.println("do handle run");
    }
}
