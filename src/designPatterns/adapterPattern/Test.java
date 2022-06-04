package designPatterns.adapterPattern;

import designPatterns.adapterPattern.adapter.client.AdapterClient;

/**
 * @program: ThreadLearn
 * @description:
 * @author: chuchen
 * @create: 2020-12-13 22:00
 */
public class Test {

    public static void main(String[] args) {
        new AdapterClient().doRunController();
    }
}
