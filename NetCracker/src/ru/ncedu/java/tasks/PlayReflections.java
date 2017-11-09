package ru.ncedu.java.tasks;

import java.lang.reflect.*;

/**
 * Created by dimon on 03.10.17.
 */
public class PlayReflections {
    public static void main(String[] args) throws Exception {
        MyClass s = new MyClass(2);
        Class c = s.getClass();
        Method[] fields = c.getDeclaredMethods();
        for(Method field : fields) {
            System.out.println(field.getModifiers());
            if ((field.getModifiers() & Modifier.PROTECTED) == Modifier.PROTECTED) System.out.println("fuck");
        }
    }

    public static class MyClass {
        int pp;
        String a;
        public float p;
        protected double pr;

        public MyClass() {
        }

        private MyClass(int z) {
            pp = z;
        }

        protected void setString(String s) {
            a = s;
        }

        public void setInt(int w) {
            pp = w;
        }

        protected static void method() {
        }
    }
}
