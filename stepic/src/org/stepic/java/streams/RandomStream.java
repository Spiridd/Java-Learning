package org.stepic.java.streams;

import java.util.Comparator;
import java.util.function.BiConsumer;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by dimon on 30.08.17.
 */
public class RandomStream {
    public static void main(String[] args) {
//        IntStream stream = pseudoRandomStream(13);
//        stream.limit(10).forEach(System.out::println);


    }

    public static IntStream pseudoRandomStream(int seed) {
        return IntStream.iterate(seed, x -> (x*x % 10000)/10);
    }

    public static <T> void findMinMax(
            Stream<? extends T> stream,
            Comparator<? super T> order,
            BiConsumer<? super T, ? super T> minMaxConsumer) {

        T[] objects = (T[])stream.sorted(order).toArray();
        if (objects != null && objects.length>0) {
            minMaxConsumer.accept(objects[0], objects[objects.length - 1]);
        } else {
            minMaxConsumer.accept(null, null);
        }
    }
}
