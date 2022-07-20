package learn.nio;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.channels.*;
import java.nio.channels.spi.SelectorProvider;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;

/**
 * @program: Thread
 * @description:
 * @author: liuhao
 * @date: 2022-07-20 20:04
 */
public class SelectorSever {
    private Selector selector;
    private ExecutorService executorService;
    /**
     * key线程名  value 处理时间
     */
    public static Map<Socket,Long> countMap = new HashMap<>(10240);

    private void startServer() throws IOException {
        selector = SelectorProvider.provider().openSelector();
        ServerSocketChannel ssc = ServerSocketChannel.open();
        // 非阻塞
        ssc.configureBlocking(false);
        // 地址
        InetSocketAddress isa = new InetSocketAddress(InetAddress.getLoopbackAddress(), 8000);
//        InetSocketAddress isa = new InetSocketAddress(8000);
        // 绑定地址
        ssc.socket().bind(isa);

        // ServerSocketChannel 与  Socket 进行绑定     设置关注事件为accept事件
        // SelectionKey 表示一对 selector 和 channel的关系； channel注册到selctor上时候，两者关系已确认
        // selector 或 channel关闭时，SelectionKey失效
        SelectionKey acceptKey = ssc.register(selector, SelectionKey.OP_ACCEPT);
        for(;;){
            // 阻塞获取消息  一旦有数据可读，会返回准备就绪的selectionKey的数量
            selector.select();
            //准备 就绪的集合
            Set<SelectionKey> readKeys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = readKeys.iterator();

            while (iterator.hasNext()){
                SelectionKey sk = iterator.next();
                // 删除已处理过的数据，避免重复处理
                iterator.remove();
                if(sk.isAcceptable()){
                    // accept状态 客户端消息接收
                    doAccept(sk);
                }else if(sk.isValid() && sk.isReadable()){
                    Socket key = ((SocketChannel) sk.channel()).socket();
                    if(!countMap.containsKey(key))
                        countMap.put(key,System.currentTimeMillis());
                    doRead(sk);
                }else if(sk.isValid() && sk.isWritable()){
                    //
                    doWrite(sk);
                    long end = System.currentTimeMillis();
                    Socket key = ((SocketChannel) sk.channel()).socket();
                    Long begin = countMap.remove(key);
                    long diffTime = end - begin;
                    System.out.println("spend : "+ diffTime + "ms");
                }
            }
        }


    }

    private void doWrite(SelectionKey sk) {
    }

    private void doRead(SelectionKey sk) {
    }

    private void doAccept(SelectionKey sk) {
        ServerSocketChannel server =(ServerSocketChannel) sk.channel();
        SocketChannel clientChannel ;
        try {
            // 新通道
            clientChannel = server.accept();
            clientChannel.configureBlocking(false);
            // channel reigster selector  filter event op_read
            SelectionKey clientKey = clientChannel.register(selector, SelectionKey.OP_READ);
            // 对象实例
            EchoClient echoClient = new EchoClient();
            // 对象附作为附件，附加到 selectionKey上 方便后续共享
            clientKey.attach(echoClient);
            
            InetAddress inetAddress = clientChannel.socket().getInetAddress();
            System.out.println("accepted from "+ inetAddress.getHostAddress());
        } catch (IOException e) {
            System.out.println("Failed to accept new client");
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {


    }
    static class EchoClient{

    }
}
