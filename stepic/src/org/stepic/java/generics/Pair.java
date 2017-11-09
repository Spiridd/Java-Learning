package org.stepic.java.generics;

import java.util.Objects;

/**
 * Created by dimon on 29.08.17.
 */
public class Pair <T, U> {
    private final T first;
    private final U second;

    private Pair(T first, U second) {
        this.first = first;
        this.second = second;
    }

    public static <T, U> Pair<T, U> of(T first, U second) {
        return new Pair<>(first, second);
    }

    T getFirst() {
        return this.first;
    }

    public U getSecond() {
        return this.second;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)  return true;
        if (o instanceof Pair) {
            Pair other = (Pair) o;
            return Objects.equals(this.first, other.first)
                    && Objects.equals(this.second, other.second);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.first)
                + Objects.hashCode(this.second);
    }
}
