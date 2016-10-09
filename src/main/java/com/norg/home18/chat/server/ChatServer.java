package com.norg.home18.chat.server;

import com.norg.home18.chat.server.dao.MessageDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.*;

/**
 * Сервер, принимающий подключения от клиентов
 */
public class ChatServer implements Runnable {
    private static final Logger logger = LoggerFactory.getLogger(ChatServer.class);
    private int port;
    private final MessageDao storage;

    private ExecutorService poolExecutor = Executors.newFixedThreadPool(30);//new ThreadPoolExecutor(4, 30, 1,TimeUnit.MINUTES, new ArrayBlockingQueue<>(50));

    public ChatServer(MessageDao storage) {
        this(storage, 5555);
    }

    public ChatServer(MessageDao storage, int port) {
        this.storage = storage;
        this.port = port;
    }

    @Override
    public void run() {

        while (!Thread.currentThread().isInterrupted()) {
            try (ServerSocket socket = new ServerSocket(port)) {
                logger.info("Listening on port {}...", socket.getLocalPort());
                Socket socketClient = socket.accept();
                poolExecutor.execute(new ChatConnectionServer(socketClient, storage));
                logger.info("Client {} connected.", socketClient.getRemoteSocketAddress());
            } catch (IOException e) {
                logger.error(e.getMessage());
            }
        }
    }
}
