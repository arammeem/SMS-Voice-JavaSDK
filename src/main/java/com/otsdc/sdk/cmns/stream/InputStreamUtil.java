package com.otsdc.sdk.cmns.stream;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 *
 * @author eriseti@gmail.com
 */
public class InputStreamUtil {

    public static int DEFAULT_BUFFER_SIZE = 1024 * 8;//8KB

    public static String readString(InputStream is, int bufferSize) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        return readString(reader, bufferSize);
    }

    public static String readString(InputStream is) throws IOException {
        return readString(is, DEFAULT_BUFFER_SIZE);
    }

    public static String readString(BufferedReader reader) throws IOException {
        return readString(reader, DEFAULT_BUFFER_SIZE);
    }

    public static String readString(BufferedReader reader, int bufferSize) throws IOException {
//        char[] buffer = new char[DEFAULT_BUFFER_SIZE];
        int read = reader.read();
        StringBuilder builder = new StringBuilder(DEFAULT_BUFFER_SIZE);
        while (read != -1) {
            builder.append((char)read);
            read = reader.read();
        }
        return builder.toString().trim();
    }
}
