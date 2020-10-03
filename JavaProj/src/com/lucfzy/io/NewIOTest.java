package com.lucfzy.io;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.*;

public class NewIOTest {

    private static final List<SocketChannel> clients = new LinkedList<>();

    public static void main(String[] args) throws IOException {

        // 1. 开启监听，绑定服务器端口。
        ServerSocketChannel ss = ServerSocketChannel.open();
        ss.bind(new InetSocketAddress(8090));
        // 3. 设置非阻塞参数。
        ss.configureBlocking(false);
        // 2. while死循环
        for(;;) {
            // 4. 非阻塞的进行系统调用accept方法，进行系统调用读取系统空间缓冲区中是否有客户端连接可用。
            SocketChannel client = ss.accept();
            // 每个SocketChannel就是一个客户端连接对象
            Selector selector = Selector.open();

            // 5. 判断获取到的client是否为空。
            if (client == null) {
                System.out.println("client is null 。。。");
            } else {
                client.configureBlocking(false);
                // 将client加入到list集合中去
                clients.add(client);
            }
            // 启用用户空间缓冲区，大小为4096字节
            ByteBuffer buffer = ByteBuffer.allocateDirect(4096);
            // 非阻塞的查看连接中是否有数据，启用read方法。
            for (SocketChannel localClient : clients) {
                int read = localClient.read(buffer);
                // 说明此时有数据过来
                if (read > 0) {
                    buffer.flip();
                    byte[] result = new byte[buffer.limit()];
                    buffer.get(result);
                    System.out.println("client data is: "+ Arrays.toString(result));
                }
            }
            // 9. 继续走循环
        }
    }
}
