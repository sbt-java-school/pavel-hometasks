package com.norg.home18.gadalka;

import com.norg.home18.gadalka.exception.BusinessException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.Socket;

/**
 *
 */
public class GadalkaClient implements Runnable {
    private static final Logger logger = LoggerFactory.getLogger(GadalkaClient.class);
    private InputStream in;
    private OutputStream out;

    @Override
    public void run() {
        try {
            logger.debug("Connecting...");
            try {
                Socket socket = new Socket("localhost", 5555);
                in = socket.getInputStream();
                out = socket.getOutputStream();
            } catch (IOException e) {
                logger.error(e.getMessage());
                throw new BusinessException(e);
            }
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            logger.debug("Connection established.");
            String message = reader.readLine();
            logger.debug("Message: {}", message);
            if (GadalkaCommands.READY.toString().equals(message)) {
                OutputStreamWriter writer = new OutputStreamWriter(out);

                int num = -1;
                for (int i = 0; i < 10; i++) {
                    logger.debug("Is this {}?", i);
                    Thread.sleep(500);
                    writer.write(String.valueOf(i) + '\n');
                    writer.flush();
                    message = reader.readLine();
                    if (GadalkaCommands.RIGHT.toString().equals(message)) {
                        num = i;
                        break;
                    }
                }

                System.out.println("Было загадано " + num);

            }
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }
}
