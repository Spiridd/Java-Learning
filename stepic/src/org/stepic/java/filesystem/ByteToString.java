package org.stepic.java.filesystem;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by dimon on 28.08.17.
 */
public class ByteToString {
    public static void main(String[] args) throws IOException {
        byte[] arr = {48, 49, 50, 51};
        ByteArrayInputStream input = new ByteArrayInputStream(arr);
        System.setIn(input);
        System.out.println(readAsString(System.in, StandardCharsets.US_ASCII));
    }

    public static String readAsString(InputStream inputStream, Charset charset)
            throws IOException {
        ArrayList<Byte> input = new ArrayList();
        int one_byte;
        while ((one_byte=inputStream.read()) != -1) {
            input.add((byte)one_byte);
        }
        byte[] array = new byte[input.size()];
        for(int i=0; i<input.size(); ++i) {
            array[i] = input.get(i);
        }
        return new String(array, charset);
    }
}
