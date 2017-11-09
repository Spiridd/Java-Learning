package org.stepic.java.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

/**
 * Created by dimon on 29.08.17.
 */
public class PlayWildcard {
    public static void main(String[] args) {
        Collection<?> collection = new ArrayList<>();
        Object object = "ololo";
        collection.size();
        //collection.add(object);
        collection.remove(object);
        collection.toArray();
        collection.iterator();
        collection.clear();
        collection.contains(object);
        //collection.addAll(Arrays.asList(object));
    }
}
