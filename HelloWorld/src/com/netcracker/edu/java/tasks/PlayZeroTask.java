package com.netcracker.edu.java.tasks;

/**
 * Created by dimon on 03.08.17.
 */
public class PlayZeroTask {
    public static void main(String[] args) {
        ZeroTaskImpl zeroTaskImpl = new ZeroTaskImpl();
        zeroTaskImpl.setIntegerValue(10);
        System.out.println(zeroTaskImpl.getDoubleValue());
    }
}
