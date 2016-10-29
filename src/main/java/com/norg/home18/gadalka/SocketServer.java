package com.norg.home18.gadalka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Сервер, принимающий подключения от клиентов, желающих поиграть в гадалку
 */
public class SocketServer {
    private static final Logger logger = LoggerFactory.getLogger(SocketServer.class);

    private static BlockingQueue<Runnable> queue = new ArrayBlockingQueue<>(10);
    private static ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(4, 10, 12, TimeUnit.SECONDS, queue);
    static {
        poolExecutor.setRejectedExecutionHandler((r, executor) -> logger.debug("No free threads in pool, client refused."));
    }

    public static void main(String[] args) {
        while (!Thread.currentThread().isInterrupted()) {
            try (ServerSocket socket = new ServerSocket(5555)) {
                logger.debug("Listening on port {}...", socket.getLocalPort());
                Socket socketClient = socket.accept();
                poolExecutor.execute(new Gadalka(socketClient));
                logger.debug("Client connected.");
            } catch (IOException e) {
                logger.error(e.getMessage());
            }
        }
    }
}
