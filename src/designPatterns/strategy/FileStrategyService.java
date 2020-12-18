package designPatterns.strategy;

/**
 * @program: ThreadLearn
 * @description:
 * @author: chuchen
 * @create: 2020-12-07 00:34
 */
public class FileStrategyService implements StrategyService<FileStrategyService>{


    @Override
    public void read(FileStrategyService fileStrategyService) {
        System.out.println("read file");

    }
}
