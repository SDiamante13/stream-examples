package tech.pathtoprogramming.java8examples;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
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
                .boxed()
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
                .anyMatch(s -> tweet.contains(s));
        System.out.println(tweetContainsAtLeastOneKeyword);

        System.out.println("4. Read in a file");
        Path path = Paths.get(Examples8.class.getClassLoader().getResource("data.txt").toURI());
        try (Stream<String> lines = Files.lines(path, Charset.defaultCharset())) {
            List<String> fileLines = lines.collect(toCollection(LinkedList::new));
            System.out.println(fileLines);
        } catch (IOException ex) {
            System.out.println(ex.toString());
        }
    }
}
