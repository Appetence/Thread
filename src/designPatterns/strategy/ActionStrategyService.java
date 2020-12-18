package designPatterns.strategy;

/**
 * @program: ThreadLearn
 * @description:
 * @author: chuchen
 * @create: 2020-12-07 00:34
 */
public class ActionStrategyService implements StrategyService<ActionStrategyService>{


    @Override
    public void read(ActionStrategyService actionStrategyService) {
        System.out.println("read action");
    }
}
