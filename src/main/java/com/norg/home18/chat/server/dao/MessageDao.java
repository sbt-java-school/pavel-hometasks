package com.norg.home18.chat.server.dao;

import com.norg.home18.chat.server.model.ChatMessage;

import java.util.List;

/**
 * Хранилище сообщений чата.
 */
public interface MessageDao {
    List<ChatMessage> getMessages(String addressee);
    void saveMessage(ChatMessage message);
}
