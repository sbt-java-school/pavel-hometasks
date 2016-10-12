package com.norg.home18.chat.client;

import com.norg.home18.chat.server.model.ChatCommand;
import com.norg.home18.chat.server.model.ChatMessage;
import com.norg.home18.chat.server.model.ChatMessageTextImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.Socket;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;


/**
 * Клиент чата.
 */
public class ChatClient implements Runnable {
    private static final Logger logger = LoggerFactory.getLogger(ChatClient.class);
    private final Socket socket;
    private final InputStream userInputStream;
    private final PrintStream userPrintStream;
    private ObjectInputStream socketIn;
    private ObjectOutputStream socketOut;

    public final String REMOTE_HOST;
    public final int REMOTE_PORT;

    public ChatClient(String name) throws IOException {
        this(name, "localhost", 5555, System.in, System.out);
    }

    public ChatClient(String name, String host, int port, InputStream userInputStream, OutputStream userOutputStream) throws IOException {
        this.userInputStream = userInputStream;
        this.REMOTE_HOST = host;
        this.REMOTE_PORT = port;
        this.userPrintStream = new PrintStream(userOutputStream);

        logger.debug("Connecting...");
        socket = new Socket(host, port);

        socketOut = new ObjectOutputStream(socket.getOutputStream());
        socketOut.flush();
        socketIn = new ObjectInputStream(socket.getInputStream());

        socketOut.writeObject(name);

        TimerTask checkInbox = new TimerTask() {
            @Override
            public void run() {
                sendCommand(ChatCommand.GET_MESSAGES);
                try {
                    processMessages();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        };

        Timer inboxChecker = new Timer("Inbox checker", true);
        inboxChecker.schedule(checkInbox, 0, 5000);
    }

    @SuppressWarnings("unchecked")
    private void processMessages() throws IOException, ClassNotFoundException {
        Object input = socketIn.readObject();
        if (input instanceof List) {
            ((List<ChatMessage>) input).forEach(userPrintStream::println);
        }

    }

    private void sendCommand(ChatCommand command) {
        try {
            socketOut.writeObject(command);
            socketOut.flush();
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
    }

    private void sendMessage(ChatMessage message) {
        try {
            socketOut.writeObject(message);
            socketOut.flush();
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
    }

    @Override
    public void run() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(userInputStream));
            while (!Thread.currentThread().isInterrupted()) {
                userPrintStream.println("Введите сообщение:");
                String input = reader.readLine();
                logger.debug("Got message: {}, sending...", input);
                ChatMessage message = new ChatMessageTextImpl(input);
                sendCommand(ChatCommand.SEND_MESSAGE);
                sendMessage(message);
                logger.debug("Message has sent.");
            }

        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }

}
