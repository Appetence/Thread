package util;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @program: ThreadLearn
 * @description:
 * @author: liuhao
 * @date: 2022-01-24 15:35
 */
public class RepliceString {

    public static String replaceBlank(String str) {

        String dest = "";

        if (str != null) {

            Pattern p = Pattern.compile("\\s*|\t|\r|\n");

            Matcher m = p.matcher(str);

            dest = m.replaceAll("");

        }

        return dest;

    }

    public static void main(String[] args) {
        int flag = 3;
        ExecutorService executorService = Executors.newFixedThreadPool(flag);

        CountDownLatch latch = new CountDownLatch(flag);
        for (int i = 0; i < flag; i++) {
            executorService.submit(() -> replaceData(latch));
            latch.countDown();
        }
        executorService.shutdown();
    }

    private static void replaceData(CountDownLatch latch) {
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String name = Thread.currentThread().getName() +"——";

        String content = "501642124629781\n 79641_\r 1240410_ 1240410\t";
        String s = replaceBlank(content);
        String content1 = "501642124629781\r 1240410";
        String s1 = replaceBlank(content1);
        String content2 = "501642124629781\n";
        String s2 = replaceBlank(content2);
        String content3 = "501642124629781\t";
        String s3 = replaceBlank(content3);
        String content4 = "";
        String s4 = replaceBlank(content4);
        System.out.println(name + s);
        System.out.println(name + s1);
        System.out.println(name + s2);
        System.out.println(name + s3);
        System.out.println(name + s4);
    }
}
