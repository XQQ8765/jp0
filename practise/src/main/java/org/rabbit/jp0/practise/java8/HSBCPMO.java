package org.rabbit.jp0.practise.java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Stream;

/**
 * private static String[][] myStringMatrix = {
 * {"10-11", "8-4", "3-7"},
 * {"11-10", "3-8", "7-6"},
 * {"5-2", "4-3", "4-4"}
 * };
 * <p>
 * // TODO: Please implement a function to sort the
 * // input matrix and return it as 1D array.
 * // The sort order is:
 * // sort by the first number asc, if the firt numbers equals,
 * // then sort by the second number desc.
 * // Example output:3-8, 3-7, 4-4, 4-3,5-2, 7-6, 8-4, 10-11
 */
public class HSBCPMO {
    private static String[][] myStringMatrix = {
            {"10-11", "8-4", "3-7"},
            {"11-10", "3-8", "7-6"},
            {"5-2", "4-3", "4-4"}
    };

    public static void main(String[] args) {
        Arrays.stream(myStringMatrix).flatMap(Stream::of).sorted(
                (s1, s2) -> {
                    int[] s1Arr = Stream.of(s1.split("-")).mapToInt(s -> Integer.parseInt(s)).toArray();
                    int[] s2Arr = Stream.of(s2.split("-")).mapToInt(s -> Integer.parseInt(s)).toArray();
                    if (s1Arr[0] == s2Arr[0]) {
                        return Integer.compare(s2Arr[1], s1Arr[1]);
                    }
                    return Integer.compare(s2Arr[0], s1Arr[0]);
                }
        ).forEach(System.out::println);
    }
}
