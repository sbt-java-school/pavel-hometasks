package com.norg.home05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;

/**
 * Home05
 */
public class Main {
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
}
