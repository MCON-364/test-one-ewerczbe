package edu.touro.las.mcon364.test;

import java.util.*;
import java.util.stream.Collectors;

public class BasicStreamsQuiz {

    private final Map<String, List<Integer>> scoresByCourse;

    public BasicStreamsQuiz() {
        scoresByCourse = new LinkedHashMap<>();
        scoresByCourse.put("Algorithms", List.of(91, 84, 96, 88));
        scoresByCourse.put("Databases", List.of(77, 81, 79, 85));
        scoresByCourse.put("Networks", List.of(68, 73, 70, 75));
        scoresByCourse.put("Java", List.of(95, 92, 90, 98));
    }

    /**
     * Problem 6
     * Return all course names sorted alphabetically.
     */
    public List<String> getSortedCourseNames() {
        return scoresByCourse.keySet().stream()
                .sorted()
                .toList();
    }

    /**
     * Problem 7
     * Across all courses, count how many scores are greater than or equal to threshold.
     */
    public long countScoresAtLeast(int threshold) {

        return scoresByCourse.values().stream()
                .flatMap(List::stream)
                .mapToInt(Integer::intValue).filter(x -> x >= threshold).count();
    }

    /**
     * Problem 8
     * Return the first word whose length is greater than minLength.
     * If none exists, return Optional.empty().
     */
    public Optional<String> firstLongWord(List<String> words, int minLength) {
        Optional<String> firstlongWord = words.stream().filter(x->x.length() > minLength).findFirst();
        if (firstlongWord.isEmpty()) {
            return Optional.empty();
        }
        return firstlongWord;
    }

    /**
     * Problem 9
     * Return a new list containing the square of each number.
     * Use streams.
     */
    public List<Integer> squareAll(List<Integer> numbers) {
        return numbers.stream().map(x -> x*x).collect(Collectors.toList());
    }

    /**
     * Problem 10
     * Return the average of all passing scores across all courses.
     * A passing score is 70 or above.
     *
     * Return 0.0 if there are no passing scores.
     */
    public double averagePassingScore() {
        return scoresByCourse.values().stream()
                .flatMap(List::stream).filter(s -> s >= 70)
                .mapToDouble(s -> s )
                .average()
                .orElse(0.0);
    }
}
