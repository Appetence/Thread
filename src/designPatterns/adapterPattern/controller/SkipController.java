package designPatterns.adapterPattern.controller;

import designPatterns.adapterPattern.controller.AbstractController;

/**
 * @program: ThreadLearn
 * @description:
 * @author: chuchen
 * @create: 2020-12-13 21:58
 */
public class SkipController extends AbstractController {
    @Override
    public void doHandler() {
        System.out.println("this is SkipController");
    }
}
