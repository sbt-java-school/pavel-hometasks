package com.norg.home18.gadalka;

import com.norg.home18.gadalka.exception.BusinessException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Random;

/**
 * Класс, играющий с клиентом
 */
public class Gadalka implements Runnable {
    private final Socket socketClient;
    private static final Logger logger = LoggerFactory.getLogger(Gadalka.class);

    public Gadalka(Socket socketClient) {
        this.socketClient = socketClient;
    }

    @Override
    public void run() {
        try {
            int number = new Random(System.currentTimeMillis()).nextInt(10);
            logger.info("Загадано {}", number);

            OutputStream outputStream = socketClient.getOutputStream();
            OutputStreamWriter writer = new OutputStreamWriter(outputStream);
            logger.debug("Got output stream writer.");
            BufferedReader reader = new BufferedReader(new InputStreamReader(socketClient.getInputStream()));
            writer.write(GadalkaCommands.READY.toString()+'\n');
            writer.flush();
            logger.debug("{} is sent.", GadalkaCommands.READY.toString());
            Integer guess;
            while (!(guess = Integer.parseInt(reader.readLine())).equals(number)) {
                logger.debug("Client asks: is this {}?", guess);
                writer.write(GadalkaCommands.WRONG.toString()+'\n');
                writer.flush();
                logger.debug("WRONG is sent.");
            }
            logger.debug("Client asks: is this {}?", guess);
            writer.write(GadalkaCommands.RIGHT.toString()+'\n');
            logger.debug("RIGHT is sent.");
            writer.close();
            outputStream.close();
            logger.debug("Closing connection...");
        }catch (Exception e) {
            logger.error(e.getMessage());
            throw new BusinessException(e);
        }
    }
}
