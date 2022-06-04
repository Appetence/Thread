package designPatterns.proxyPattern.jdkProxy;

/**
 * @program: ThreadLearn
 * @description:
 * @author: chuchen
 * @create: 2020-12-26 15:07
 */
public class UserDao implements IUserDao {

    private boolean flag;

    public UserDao() {
    }

    public UserDao(boolean flag) {
        this.flag = flag;
    }

    @Override
    public void save() {
        System.out.println("----已经保存数据!----");
    }

    @Override
    public void update() {
        System.out.println("-------update----");
    }

    @Override
    public int delet(String message, String type) {
        System.out.println("-------delet----");
        System.out.println("-------message:" + message + "----");
        System.out.println("-------delet:" + type + "----");
        return 999;
    }

   /* @Override
    public void delet() {
    }*/
}