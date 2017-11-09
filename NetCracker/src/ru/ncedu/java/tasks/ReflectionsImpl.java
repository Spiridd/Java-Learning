package ru.ncedu.java.tasks;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.*;

/**
 * Created by dimon on 03.10.17.
 */
public class ReflectionsImpl implements Reflections {
    @Override
    public Object getFieldValueByName(Object object, String fieldName) throws NoSuchFieldException {
        if (object == null || fieldName == null)    throw new NullPointerException();
        Object result = null;
        try {
            Field field = object.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            result = field.get(object);
        } catch (IllegalArgumentException | IllegalAccessException e) {
        }
        return result;
    }

    @Override
    public Set<String> getProtectedMethodNames(Class clazz) {
        Set<String> methodNames = new HashSet<>();
        Method[] methods = clazz.getDeclaredMethods();
        for(Method method : methods)
            if ((method.getModifiers() & Modifier.PROTECTED) == Modifier.PROTECTED)
                methodNames.add(method.getName());
        return methodNames;
    }

    @Override
    public Set<Method> getAllImplementedMethodsWithSupers(Class clazz) {
        Set<Method> allMethods = new HashSet<>();
        Method[] declaredMethods = clazz.getDeclaredMethods();
        Method[] methods = clazz.getMethods();
        Class superClass = clazz.getSuperclass();
        if (superClass != null) {
            allMethods.addAll(getAllImplementedMethodsWithSupers(superClass));
        }
        allMethods.addAll(Arrays.asList(declaredMethods));
        allMethods.addAll(Arrays.asList(methods));
        return allMethods;
    }

    @Override
    public List<Class> getExtendsHierarchy(Class clazz) {
        List<Class> allClasses = new ArrayList<>();
        Class superClass = clazz.getSuperclass();
        while (superClass != null) {
            allClasses.add(superClass);
            clazz = superClass;
            superClass = clazz.getSuperclass();
        }
        return allClasses;
    }

    @Override
    public Set<Class> getImplementedInterfaces(Class clazz) {
        return new HashSet<Class>(Arrays.asList(clazz.getInterfaces()));
    }

    @Override
    public List<Class> getThrownExceptions(Method method) {
        return new ArrayList(Arrays.asList(method.getExceptionTypes()));
    }

    @Override
    public String getFooFunctionResultForDefaultConstructedClass() {
        try {
            Class<?> clazz = Class.forName("ru.ncedu.java.tasks.Reflections");
            clazz = clazz.getClasses()[0];

            Constructor constructor = clazz.getDeclaredConstructor(new Class<?>[0]);
            constructor.setAccessible(true);

            Object secretClassInstance = constructor.newInstance(new Object[0]);

            Method method = clazz.getDeclaredMethod("foo", new Class<?>[0]);
            method.setAccessible(true);

            return (String) method.invoke(secretClassInstance, new Object[0]);
        } catch(Exception e) {
        }
        return null;
    }

    @Override
    public String getFooFunctionResultForClass(String constructorParameter, String string, Integer... integers) {
        try {
            Class<?> clazz = Class.forName("ru.ncedu.java.tasks.Reflections");
            clazz = clazz.getClasses()[0];

            Constructor<?> constructor = clazz.getDeclaredConstructor(new Class[]{String.class});
            constructor.setAccessible(true);

            Object secretClassInstance = constructor.newInstance(constructorParameter);

            Method method = clazz.getDeclaredMethod("foo", new Class<?>[]{String.class, Integer[].class});
            method.setAccessible(true);

            return (String) method.invoke(secretClassInstance, new Object[]{string, integers});
        } catch(Exception e) {
        }
        return null;
    }

    public static void main(String[] args) throws NoSuchFieldException {
        Reflections ref = new ReflectionsImpl();
        SecretClass secretClass = new SecretClass("ololo");
        System.out.println(ref.getFieldValueByName(secretClass, "text"));
    }
}
