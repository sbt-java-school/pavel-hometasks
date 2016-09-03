package com.norg.home05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.Charset;

/**
 * Helps to work with URLs
 */
public class URLHelper {
    public static String readContent(String urlString) throws IOException {
        URL url = new URL(urlString);

        BufferedReader reader = new BufferedReader(
                new InputStreamReader(url.openStream(), Charset.forName("windows-1251")));
        StringBuilder result = new StringBuilder();
        String line = reader.readLine();
        if (line == null) {
            return result.toString();
        }
        do {
            result.append(line);
            result.append("\n");
        }while ((line = reader.readLine()) != null);
        return result.toString();
    }
}
