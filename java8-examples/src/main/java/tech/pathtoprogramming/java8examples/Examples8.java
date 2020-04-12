package tech.pathtoprogramming.java8examples;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toCollection;
import static java.util.stream.Collectors.toList;
import static java.util.stream.IntStream.range;

/***
 * One liner examples done using Java 8 features
 */
public class Examples8 {

    public static void main(String[] args) throws URISyntaxException {

        System.out.println("1. Multiple Each Item in a List by 2");
        List<Integer> result = range(1, 10)
                .map(i -> i * 2)
                .boxed() // converts IntStream to Stream<Integer>
                .collect(toList());
        System.out.println(result);

        System.out.println("2. Sum a List of Numbers");
        int sum = range(1, 1000).sum();
        int sum2 = range(1, 1000).reduce(0, Integer::sum);
        System.out.printf("Sum using sum method: %d %nSum using reduce method: %d %n", sum, sum2);


        System.out.println("3. Verify if Exists in a String");
        final List<String> keywords = Arrays.asList("brown", "fox", "dog", "pangram");
        final String tweet = "The quick brown fox jumps over a lazy dog.";
        boolean tweetContainsAtLeastOneKeyword = keywords.stream()
                .anyMatch(s -> tweet.contains(s)); // can express as method reference
        System.out.println(tweetContainsAtLeastOneKeyword);

        System.out.println("4. Read in a file");
        Path path = Paths.get(Examples8.class.getClassLoader().getResource("data.txt").toURI());
        try (Stream<String> lines = Files.lines(path, Charset.defaultCharset())) {
            List<String> fileLines = lines.collect(toCollection(LinkedList::new));
            System.out.println(fileLines);
        } catch (IOException ex) {
            System.out.println(ex.toString());
        }

        System.out.println("5. Happy Birthday to You!");
        range(1, 5)
                .boxed()
                .map(times -> {
                    System.out.print("Happy Birthday ");
                    if (times == 3) return "dear Steven";
                    else return "to You";
                })
                .forEach(System.out::println);

        System.out.println("6. Sort a list of names alphabetically");
        List<String> names = Stream.of("Chase", "Xavier", "Phil", "Lizzy", "Tina", "Jimmy")
                .sorted(Comparator.comparing(String::toString))
                .collect(toList());
        System.out.println(names);

        System.out.println("8. Find minimum (or maximum) in a List");
        int min = Stream.of(14, 35, -7, 46, 98).reduce((n1, n2) -> Integer.min(n1, n2)).orElse(0);
        int min2 = Stream.of(14, 35, -7, 46, 98).min(Integer::compare).orElse(0);

        int max = Stream.of(14, 35, -7, 46, 98).reduce(Integer::max).orElse(0);
        int max2 = Stream.of(14, 35, -7, 46, 98).max(Integer::compare).orElse(0);

        System.out.printf("Minimum using two different methods: %d, %d %n", min, min2);
        System.out.printf("Maximum using two different methods: %d, %d %n", max, max2);

        System.out.println("9. Parallel Processing");
        // finds prime numbers from 1 to 1 million
        long count = Stream.iterate(0, n -> n + 1)
                .limit(1_000_000)
                .parallel()   // with this 23s, without this 1m 10s
                .filter(Examples8::isPrime)
                .peek(x -> System.out.format("%s\t", x))
                .count();

        System.out.println("\nTotal: " + count);

    }

    private static boolean isPrime(int number) {
        if (number <= 1) return false;
        return !IntStream.rangeClosed(2, number / 2).anyMatch(i -> number % i == 0);
    }

}
