package designPatterns.proxyPattern.staticProxy;

import java.util.Objects;

/**
 * @program: ThreadLearn
 * @description: 静态代理
 * @author: chuchen
 * @create: 2020-12-25 13:04
 */

public class Single {
    public static void main(String[] args) {
        StaticProxy staticProxy = new StaticProxySingle();
        System.out.println("___________start");
        ProxyFunctory proxyFunctory = new ProxyFunctory(staticProxy);
        proxyFunctory.invoke("single");
        System.out.println("___________end");
    }
}

interface StaticProxy {

    String send(String message);

}

class StaticProxySingle implements StaticProxy {

    @Override
    public String send(String message) {
        System.out.println("this message is :" + message);
        return message;
    }
}

class ProxyFunctory {
    private StaticProxy staticProxy;

    public ProxyFunctory(StaticProxy staticProxy) {
        this.staticProxy = staticProxy;
    }

    public void invoke(String message) {
        before();
        target(message);
        affter();

    }

    private void target(String message) {
        System.out.println("------target-start------");
        String result = staticProxy.send(message);
        System.out.println(result);
        System.out.println("------target-end------");

    }

    private void before() {
        System.out.println("------before");
    }

    private void affter() {
        System.out.println("-----affter");
    }
}