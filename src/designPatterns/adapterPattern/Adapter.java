package designPatterns.adapterPattern;

/**
 * @program: ThreadLearn
 * @description:
 * @author: chuchen
 * @create: 2020-12-14 12:57
 */
public interface Adapter {
        public void doController();
        public void doRunController();
        public void doSkipController();
}
