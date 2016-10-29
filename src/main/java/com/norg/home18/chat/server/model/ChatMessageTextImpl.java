package com.norg.home18.chat.server.model;

import java.util.Collections;
import java.util.List;

/**
 * Текстовое сообщение.
 */
public class ChatMessageTextImpl implements ChatMessage {
    private final String text;
    private String sender;
    private final String addressee;

    public ChatMessageTextImpl(String addressee, String text) {
        this.text = text;
        this.addressee = addressee;
    }

    public ChatMessageTextImpl(String unparsed) {
        String[] parts = unparsed.split("->");
        if(parts.length != 2) {
            throw new RuntimeException("Адресат и текст сообщения должны разделяться символами \"->\"!");
        }
        text = parts[1].trim();
        addressee = parts[0].trim();
    }

    @Override
    public String getText() {
        return text;
    }

    @Override
    public List<Object> getAttachment() {
        return Collections.emptyList();
    }

    @Override
    public String getAddressee() {
        return addressee;
    }

    @Override
    public String getSender() {
        return sender;
    }

    @Override
    public ChatMessage setSender(String sender) {
        this.sender = sender;
        return this;
    }

    @Override
    public String toString() {
        return sender + ": " + text;
    }
}
