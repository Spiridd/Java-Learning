package ru.ncedu.java.tasks;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Calendar;

/**
 * Created by dimon on 02.09.17.
 */
public class PlayDateCollections {
    public static void main(String[] args) throws ParseException {
        DateCollections dateCollections = new DateCollectionsImpl();
        String date = dateCollections.toString(Calendar.getInstance());
        System.out.println(date);
        Calendar calendar = dateCollections.toCalendar(date);
        date = dateCollections.toString(calendar);
        System.out.println(date);
    }
}
