package thread.thread0301;

import java.util.concurrent.LinkedTransferQueue;

public class TransferQueueLearn {

    /**
     * 生产者发送的消息必须马上有消费者消费否则就会阻塞
     */
    static LinkedTransferQueue<String> blockingQueue = new LinkedTransferQueue<String>();

    public static void main(String[] args) throws InterruptedException {

        // 先启动消费者
        new Thread(() -> {
            try {
                blockingQueue.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        blockingQueue.transfer("123");
        new Thread(() -> {
            try {
                blockingQueue.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        System.out.println("结束了");
    }

}
