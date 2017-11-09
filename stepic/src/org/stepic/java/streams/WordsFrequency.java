package org.stepic.java.streams;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by dimon on 30.08.17.
 */
public class WordsFrequency {
    public static void main(String[] args) {
        Stream<String> stream = getStreamFromSystemIn();
        stream.flatMap(s -> Arrays.stream(s.split("[^\\wа-яА-я\\d]+")))
                .map(String::toLowerCase)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Comparator.comparing(Map.Entry<String, Long>::getValue).reversed().thenComparing(Map.Entry::getKey))
                .limit(10)
                .forEachOrdered(e -> System.out.println(e.getKey()));
    }

    public static Stream<String> getStreamFromSystemIn() {
        return new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8)).lines();
    }
}
