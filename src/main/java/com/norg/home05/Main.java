package com.norg.home05;

import com.norg.representer.Representable;

import java.io.*;
import java.net.MalformedURLException;

/**
 * Home05
 */
public class Main implements Representable {
    public static void main(String[] args) throws IOException {
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        while(true) {
            System.out.print("Input URL: ");
            String url = consoleReader.readLine();
            try {
                String content = URLHelper.readContent(url);
                if(!content.isEmpty()) {
                    System.out.println(content);
                    break;
                }
            }catch (MalformedURLException e) {
                System.out.println("Wrong URL! Try again.");
            }catch (IOException e) {
                System.out.println("Cannot read URL! Try again.");
            }
        }

    }

    @Override
    public void represent(OutputStream outputStream) throws Exception {
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream));
        writer.write("********\n");
        writer.write("# Домашнее задание 05\n");
        writer.write("### Реализован метод readContent(), который получает содержимое по URL\n");
        writer.flush();
    }
}
