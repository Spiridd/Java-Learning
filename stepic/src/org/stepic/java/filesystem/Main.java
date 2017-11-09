package org.stepic.java.filesystem;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * Created by dimon on 28.08.17.
 */
public class Main {
    public static void main(String[] args) throws IOException{
        Scanner input = new Scanner(Paths.get("/home/dimon/input.txt"));
        input.useDelimiter("\\s");
        double sum = 0.0;
        while (input.hasNext()) {
            String next = input.next();
            try {
                double next_double = Double.parseDouble(next);
                sum += next_double;
            } catch (NumberFormatException e) {
            }
        }
        input.close();
        System.out.printf("%.6f", sum);
    }
}
