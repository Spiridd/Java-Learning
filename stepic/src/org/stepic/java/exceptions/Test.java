package org.stepic.java.exceptions;

/**
 * Created by dimon on 07.08.17.
 */
public class Test {
    public static void main(String[] args) {
        System.out.println(getCallerClassAndMethodName());
        anotherMethod();
    }

    private static void anotherMethod() {
        System.out.println(getCallerClassAndMethodName());
    }

    public static String getCallerClassAndMethodName() {
        try {
            throw new NullPointerException();
        } catch (NullPointerException npe) {
            return npe.getStackTrace().length > 2 ?
                    npe.getStackTrace()[2].getClassName()+"#"+npe.getStackTrace()[2].getMethodName()
                    : null;
        }
    }
}
