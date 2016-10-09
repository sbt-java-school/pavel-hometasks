package com.norg.home18.chat;

import com.norg.home18.chat.client.ChatClient;

import java.io.IOException;

/**
 * Запуск клиента.
 */
public class StartClient {
    public static void main(String[] args) throws IOException {

        ChatClient client = new ChatClient("Client1");
        new Thread(client).start();
    }
}
