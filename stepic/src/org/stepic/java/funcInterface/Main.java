package org.stepic.java.funcInterface;

import java.util.Objects;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Created by dimon on 30.08.17.
 */
public class Main {
    public static void main(String[] args) {
        Predicate<Object> condition = Objects::isNull;
        Function<Object, Integer> ifTrue = obj -> 0;
        Function<CharSequence, Integer> ifFalse = CharSequence::length;
        Function<String, Integer> safeStringLength = ternaryOperator(condition, ifTrue, ifFalse);

        String string = null;
        System.out.println(safeStringLength.apply(string));
    }

    public static <T, U> Function<T, U> ternaryOperator(
            Predicate<? super T> condition,
            Function<? super T, ? extends U> ifTrue,
            Function<? super T, ? extends U> ifFalse) {

        return t -> condition.test(t) ? ifTrue.apply(t): ifFalse.apply(t);

    }
}
