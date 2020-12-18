package designPatterns.functory.abstracts.handle;

/**
 * @program: ThreadLearn
 * @description:
 * @author: chuchen
 * @create: 2020-12-07 13:13
 */
public class ExecuteHandle implements AbstractHandle {
    @Override
    public void doHandle() {
        System.out.println("do executo handle");
    }
}
