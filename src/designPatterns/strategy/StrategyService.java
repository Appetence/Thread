package designPatterns.strategy;

/**
 * @program: ThreadLearn
 * @description: Service interface
 * @author: chuchen
 * @create: 2020-12-07 00:32
 */
public interface StrategyService<T> {

    public void read(T t);

}
