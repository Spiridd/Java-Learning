package org.stepic.java.exceptions;

/**
 * Created by dimon on 07.08.17.
 */
public class Main {
    public static void main(String[] args) {
        Object dummy = new Dummy();
        Object dummy2 = new Dummy2();
        if (true)   dummy = (Dummy) dummy2;
    }
}
