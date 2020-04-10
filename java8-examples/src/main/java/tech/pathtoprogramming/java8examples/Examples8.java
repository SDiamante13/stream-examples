package tech.pathtoprogramming.java8examples;

import java.util.List;

import static java.util.stream.Collectors.toList;
import static java.util.stream.IntStream.range;

/***
 * One liner examples done using Java 8 features
 */
public class Examples8 {

    public static void main(String[] args) {

        // 1. Multiple Each Item in a List by 2
        List<Integer> result = range(1, 10)
                .map(i -> i * 2)
                .boxed()
                .collect(toList());
        System.out.println(result);

        // 2. Sum a List of Numbers
        int sum = range(1, 1000).sum();
        int sum2 = range(1, 1000).reduce(0, Integer::sum);
        System.out.printf("Sum using sum method: %d %nSum using reduce method: %d", sum, sum2);
    }
}
