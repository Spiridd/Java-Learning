package ru.ncedu.java.tasks;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by dimon on 03.10.17.
 */
public class PlayChecker {
    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("<\\s*[aA]\\s*[hH][rR][eE][fF]\\s*=\\s*(?:(?:\"[^\"]*?\")|(?:[^ \"]*?))\\s*/?\\s*>");
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String test = scanner.nextLine();
            Matcher matcher = pattern.matcher(test);
            System.out.println(matcher.matches());
        }
    }
}
