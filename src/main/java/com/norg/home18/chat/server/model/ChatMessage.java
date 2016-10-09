package com.norg.home18.chat.server.model;

import java.io.Serializable;
import java.util.List;

/**
 * Сообщение чата.
 */
public interface ChatMessage extends Serializable {
    String getText();
    List<Object> getAttachment();
    String getAddressee();
    String getSender();
    //возвращает себя для удобного соединения операций в цепочку
    ChatMessage setSender(String sender);
    String toString();
}
