package com.netcracker.edu.java.tasks;

/**
 * Created by dimon on 03.08.17.
 */
public class ZeroTaskImpl implements ZeroTask {
    private int integerValue = 0;

    @Override
    public double getDoubleValue() {
        return this.integerValue;
    }

    @Override
    public void setIntegerValue(int value) {
        this.integerValue = value;
    }
}
