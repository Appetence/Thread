package designPatterns;

import designPatterns.functory.abstracts.AbstractFunctory;
import designPatterns.functory.abstracts.FunctoryPattern;
import designPatterns.singleton.SingletonDesignPatterns;
import designPatterns.singleton.SingletonDesignPatterns_StaticInnerClass;
import designPatterns.strategy.ActionStrategyService;
import designPatterns.strategy.BookStrategyService;
import designPatterns.strategy.FileStrategyService;
import designPatterns.strategy.StrategyContext;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @program: ThreadLearn
 * @description:
 * @author: chuchen
 * @create: 2020-12-07 00:21
 */
public class TestDesignPatterns {
    /* public static void main(String[] args) {
         ExecutorService executorService = Executors.newCachedThreadPool();
         CountDownLatch countDownLatch = new CountDownLatch(1000);
         for(int i = 0 ; i < 1000 ; i++){
             countDownLatch.countDown();
             System.out.println("this countdown is "+countDownLatch);
             executorService.submit(() -> {
                 try {
                     countDownLatch.await();
                 } catch (InterruptedException e) {
                     e.printStackTrace();
                 }
                 SingletonDesignPatterns_StaticInnerClass.getInstance();
             });

         }
         System.out.println("减完啦");
         executorService.shutdown();
     }
     public static void main(String[] args) {
         ExecutorService executorService = Executors.newCachedThreadPool();
         CountDownLatch countDownLatch = new CountDownLatch(1000);
         for(int i = 0 ; i < 1000 ; i++){
             countDownLatch.countDown();
             System.out.println("this countdown is "+countDownLatch);
             executorService.submit(() -> {
                 try {
                     countDownLatch.await();
                 } catch (InterruptedException e) {
                     e.printStackTrace();
                 }
                 SingletonDesignPatterns.getInstance();
             });

         }
         System.out.println("减完啦");
         executorService.shutdown();
     }
     */
    public static void main(String[] args) {
        /*ActionStrategyService actionStrategyService = new ActionStrategyService();
        BookStrategyService bookStrategyService = new BookStrategyService();
        FileStrategyService fileStrategyService = new FileStrategyService();
        StrategyContext actionStrategyContext = new StrategyContext(actionStrategyService);
        StrategyContext bookStrategyContext = new StrategyContext(bookStrategyService);
        StrategyContext fileStrategyContext = new StrategyContext(fileStrategyService);*/
        AbstractFunctory abstractFunctory = FunctoryPattern.getAbstractFunctory();
        abstractFunctory.createHandle();
    }
}
