package designPatterns.functory.abstracts;

import designPatterns.functory.abstracts.handle.AbstractHandle;
import designPatterns.functory.abstracts.handle.FileHandle;

/**
 * @program: ThreadLearn
 * @description:
 * @author: chuchen
 * @create: 2020-12-07 13:12
 */
public class FileFunctory implements AbstractFunctory {
    @Override
    public void createHandle() {
        AbstractHandle abstractHandle = new FileHandle();
        abstractHandle.doHandle();

    }
}
