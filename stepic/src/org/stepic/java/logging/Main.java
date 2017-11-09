package org.stepic.java.logging;

import java.io.IOException;
import java.util.logging.*;

/**
 * Created by dimon on 08.08.17.
 */
public class Main {
    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());
    public static void main(String[] args) throws IOException {
        LOGGER.severe("severe msg");
        LOGGER.fine("fine msg");
        LOGGER.setLevel(Level.FINE);
        //Handler fileHandler = new FileHandler();
        //fileHandler.setLevel(Level.ALL);
        Handler consoleHandler = new ConsoleHandler();
        consoleHandler.setLevel(Level.FINE);
        LOGGER.addHandler(consoleHandler);
        //LOGGER.addHandler(fileHandler);
        LOGGER.setUseParentHandlers(false);
        LOGGER.severe("severe msg");
        LOGGER.fine("fine msg");
    }
}
