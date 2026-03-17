package edu.touro.las.mcon364.test;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class FunctionalWarmup {

    /**
     * Problem 1
     * Return a Supplier that gives the current month number (1-12).
     */
    public static Supplier<Integer> currentMonthSupplier() {
        //Supplier<Integer> monthSupplier = () -> LocalDate.now().getMonthValue();
       //return monthSupplier;
        return () -> LocalDate.now().getMonthValue();
    }

    /**
     * Problem 2
     * Return a Predicate that is true only when the input string
     * has more than 5 characters.
     */
    public static Predicate<String> longerThanFive() {
       // Predicate<String> longerThanFive = s -> s.length() > 5;
       // return longerThanFive;
        return x -> x != null && x.length()>=5;
    }

    /**
     * Problem 3
     * Return a Predicate that checks whether a number is both:
     * - positive
     * - even
     *
     * Prefer chaining smaller predicates.
     */
    public static Predicate<Integer> positiveAndEven() {
     Predicate<Integer> positive = x -> x > 0;
     Predicate<Integer> even = x -> x % 2 == 0;
     Predicate<Integer>positiveAndEven = positive.and(even);
     return positiveAndEven;
    }

    /**
     * Problem 4
     * Return a Function that counts words in a string.
     *
     * Notes:
     * - Trim first.
     * - Blank strings should return 0.
     * - Words are separated by one or more spaces (use can use regex "\\s+")
     *
     */
    public static Function<String, Integer> wordCounter() {
        Function<String, Integer> wordCount  = s -> {
            if(s == null || s.isBlank())
                return 0;
            return s.trim().split("\\s+").length;
        };
    return wordCount;}


    /**
     * Problem 5
     * Process the input labels as follows:
     * - remove blank strings
     * - trim whitespace
     * - convert to uppercase
     * - return the final list in the same relative order
     *
     * Example:
     * ["  math ", "", " java", "  "] -> ["MATH", "JAVA"]
     */
    public static List<String> cleanLabels(List<String> labels) {
      return labels.stream().filter(Objects::nonNull).map(String::trim).filter(s -> !s.isEmpty()).map(String::toUpperCase).collect(Collectors.toList());
    }
}
