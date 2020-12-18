package designPatterns.functory.abstracts;

/**
 * @program: ThreadLearn
 * @description:
 * @author: chuchen
 * @create: 2020-12-07 13:19
 */
public class FunctoryPattern {
    public static AbstractFunctory getAbstractFunctory(){
        return new ExecuteFunctory();
    }
}
