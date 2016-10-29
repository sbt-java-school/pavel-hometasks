package com.norg.home18.chat;

import com.norg.home18.chat.server.ChatServer;
import com.norg.home18.chat.server.dao.InMemoryMessageDaoImpl;

import java.io.IOException;

/**
 * Запуск сервера
 */
public class StartServer {
    public static void main(String[] args) throws IOException {
        ChatServer server = new ChatServer(new InMemoryMessageDaoImpl());
        new Thread(server).start();
    }
}
