package com.norg.home18.chat.server.dao;

import com.norg.home18.chat.server.model.ChatMessage;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Реализация хранилища на мапе.
 */
public class InMemoryMessageDaoImpl implements MessageDao {
    private Map<String, List<ChatMessage>> storage = new ConcurrentHashMap<>();

    @Override
    public List<ChatMessage> getMessages(String addressee) {
        List<ChatMessage> result = new ArrayList<>();
        List<ChatMessage> messages = storage.get(addressee);
        if(messages != null) {
            result.addAll(messages);
            //архив сообщений не хранится. Полученные клиентом удаляются с сервера.
            messages.clear();
        }
        return result;
    }

    @Override
    public void saveMessage(ChatMessage message) {
        List<ChatMessage> result = storage.get(message.getAddressee());
        if(result == null) {
            result = new CopyOnWriteArrayList<>();
            storage.put(message.getAddressee(), result);
        }
        result.add(message);
    }
}
