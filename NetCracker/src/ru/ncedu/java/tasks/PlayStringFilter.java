package ru.ncedu.java.tasks;

import java.util.*;

/**
 * Created by dimon on 03.09.17.
 */
public class PlayStringFilter {
    public static void main(String[] args) {
        StringFilter stringFilter = new StringFilterImpl();
        stringFilter.add("hello");
        stringFilter.add("hey");
        stringFilter.add("you");
        stringFilter.add("hey");
        stringFilter.add("25");
        stringFilter.add("that is nice");
        stringFilter.add("what's the matter");
        stringFilter.add("11.3");
        stringFilter.add("-3");
        stringFilter.remove("you");
        System.out.println(stringFilter.getCollection());
        System.out.println("-------------");

        Iterator<String> it1 = stringFilter.getStringsStartingWith("what's");
        while (it1.hasNext()) {
            System.out.println(it1.next());
        }
        System.out.println("-------------");

        Iterator<String> it2 = stringFilter.getStringsContaining("he");
        while (it2.hasNext()) {
            System.out.println(it2.next());
        }
        System.out.println("-------------");

        Iterator<String> it3 = stringFilter.getStringsByNumberFormat("-#");
        while (it3.hasNext()) {
            System.out.println(it3.next());
        }
        System.out.println("-------------");

        Iterator<String> it4 = stringFilter.getStringsByPattern("t*at*ice");
        while (it4.hasNext()) {
            System.out.println(it4.next());
        }
        System.out.println("-------------");
    }
}
