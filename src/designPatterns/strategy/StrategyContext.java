package designPatterns.strategy;

/**
 * @program: ThreadLearn
 * @description: 容器类
 *              容器中装有多个action，每个action负责不同的busi
 * @author: chuchen
 * @create: 2020-12-07 00:32
 */
public class StrategyContext<T> {


    public StrategyContext(StrategyService<T> strategySetrvice) {

        strategySetrvice.read((T) strategySetrvice);
    }

}
