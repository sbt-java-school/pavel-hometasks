package com.norg.home18.chat.server;

import com.norg.home18.chat.exception.WrongInputException;
import com.norg.home18.chat.server.model.ChatCommand;
import com.norg.home18.chat.server.model.ChatMessage;
import com.norg.home18.chat.server.dao.MessageDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * Поток сервера, общающийся с клиентом
 */
public class ChatConnectionServer implements Runnable {
    private static final Logger logger = LoggerFactory.getLogger(ChatConnectionServer.class);
    private final MessageDao storage;
    private final Socket socket;
    private String clientName;

    @Override
    public void run() {
        logger.debug("Starting ChatConnectionServer...");
        try (ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream())) {
            objectOutputStream.flush();

            Object input;
            logger.info("Waiting for client name...");
            while (!((input = objectInputStream.readObject()) instanceof String)) {
                objectOutputStream.writeObject(new WrongInputException("String client name expected!"));
                objectOutputStream.flush();
            }
            clientName = (String) input;

            while (!Thread.currentThread().isInterrupted()) {
                logger.info("Client name is {}. Waiting for commands...", clientName);
                while (!((input = objectInputStream.readObject()) instanceof ChatCommand)) {
                    objectOutputStream.writeObject(new WrongInputException("Chat command expected!"));
                    objectOutputStream.flush();
                }
                ChatCommand command = (ChatCommand) input;
                logger.debug("Got command: {}, processing...", command.name());
                processCommand(objectOutputStream, objectInputStream, command);
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
        }finally {
            try {
                socket.close();
            } catch (IOException e) {
                logger.error(e.getMessage());
            }
        }
        logger.debug("Client disconnected.");
    }

    private void processCommand(ObjectOutputStream objectOutputStream, ObjectInputStream objectInputStream, ChatCommand command) throws IOException, ClassNotFoundException {
        switch (command) {
            case GET_MESSAGES:
                objectOutputStream.writeObject(storage.getMessages(clientName));
                objectOutputStream.flush();
                logger.debug("Client messages have sent.");
                break;
            case SEND_MESSAGE:
                storage.saveMessage(readMessage(objectOutputStream, objectInputStream).setSender(clientName));
                logger.debug("Client message has stored.");
                break;
            default:
                objectOutputStream.writeObject(new WrongInputException("Unknown command!"));
                objectOutputStream.flush();
        }
    }

    private ChatMessage readMessage(ObjectOutputStream objectOutputStream, ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        Object input;
        logger.info("Waiting for message...");
        while (!((input = objectInputStream.readObject()) instanceof ChatMessage)) {
            objectOutputStream.writeObject(new WrongInputException("Chat message expected!"));
            objectOutputStream.flush();
        }
        return (ChatMessage) input;
    }

    public ChatConnectionServer(Socket socket, MessageDao storage) {
        logger.debug("Creating new ChatConnectionServer...");
        this.socket = socket;
        this.storage = storage;
    }

}
