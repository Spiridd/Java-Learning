package ru.ncedu.java.tasks;

import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * Created by dimon on 01.10.17.
 */
public class PlayBusinnessCard {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String input = "Alexander;Kharichkin;DSI;07-09-1988;M;1000;9032606540";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        Scanner scanner = new Scanner(System.in);
        BusinessCard businessCard = new BusinessCardImpl().getBusinessCard(scanner);

        System.out.println(businessCard.getEmployee());
    }
}
