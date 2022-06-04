package netty;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @program: ThreadLearn
 * @description:
 * @author: chuchen
 * @create: 2021-01-01 12:18
 */
public class BIOServer {
    public static void main(String[] args) throws IOException {

        ExecutorService executorService = Executors.newCachedThreadPool();
        ServerSocket serverSocket = new ServerSocket(6666);

        while (true) {
            //监听等待客户端连接
            final Socket accept = serverSocket.accept();
            System.out.println("连接到一个客户端");
            executorService.execute(() -> {

            });
        }
    }
}
