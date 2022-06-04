package designPatterns.proxyPattern.jdkProxy;

/**
 * @program: ThreadLearn
 * @description:
 * @author: chuchen
 * @create: 2020-12-26 15:06
 */
public interface IUserDao {
    void save();
    void update();
    int delet(String message,String type);
}
