package designPatterns.strategy;

/**
 * @program: ThreadLearn
 * @description:
 * @author: chuchen
 * @create: 2020-12-07 00:34
 */
public class BookStrategyService implements StrategyService<BookStrategyService>{


    @Override
    public void read(BookStrategyService bookStrategyService) {
        System.out.println("read book");

    }
}
