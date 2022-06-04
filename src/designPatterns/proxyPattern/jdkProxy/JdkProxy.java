package designPatterns.proxyPattern.jdkProxy;

/**
 * @program: ThreadLearn
 * @description: jdk动态代理
 * @author: chuchen
 * @create: 2020-12-26 14:56
 */
public class JdkProxy {
    public static void main(String[] args) {
        // 目标对象
        IUserDao target = new UserDao(false);
        // 【原始的类型 class cn.itcast.b_dynamic.UserDao】
        System.out.println(target.getClass());

        // 给目标对象，创建代理对象
        IUserDao proxy = (IUserDao) new ProxyFactory(target).getProxyInstance();
        // class $Proxy0   内存中动态生成的代理对象
        System.out.println(proxy.getClass());

        // 执行方法   【代理对象】
        proxy.save();
        proxy.update();
        int result = proxy.delet("this is message","delete");
        System.out.println(result);
    }
}
