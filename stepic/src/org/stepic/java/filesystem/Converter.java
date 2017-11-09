package org.stepic.java.filesystem;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 * Created by dimon on 18.08.17.
 */
public class Converter {
    public static final int carriage_return = 13;
    public static final int next_line = 10;
    private static final Logger logger = Logger.getLogger(Converter.class.getName());

    public static void main(String[] args) throws IOException {
        logger.setUseParentHandlers(false);
        Handler handler = new FileHandler();
        handler.setFormatter(new SimpleFormatter());
        logger.addHandler(handler);

        byte[] arr = {65, 66, 13, 13, 10, 10, 13, 67, 13, 13};
        //byte[] arr = {65, 13, 10, 10, 13};
        ByteArrayInputStream input = new ByteArrayInputStream(arr);
        System.setIn(input);
        //InputStream input = System.in;
        // Для работы с InputStream требуется перенаправить stdin так,
        // чтобы он был не пуст к моменту чтения.
        // Например, перенаправить данные из файла.
        // Ввод с консоли, разумеется, сразу завершает программу.

        int prev = 0;
        int current = 0;
        if (input.available() > 0) {
            prev = input.read();
            while (input.available() > 0) {
                current = input.read();
                if (current == next_line && prev == carriage_return) {
                    prev = current;
                } else {
                    System.out.write(prev);
                    logger.info("write: " + prev);
                    prev = current;
                }
            }
            System.out.write(current);
            logger.info("write: " + current);
        }

        System.out.flush();
    }
}