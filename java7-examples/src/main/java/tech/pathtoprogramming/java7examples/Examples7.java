package tech.pathtoprogramming.java7examples;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/***
 * One liner examples done only using Java 7 features
 */
public class Examples7 {

    public static void main(String[] args) throws URISyntaxException {

        System.out.println("1. Multiple Each Item in a List by 2");
        List<Integer> items = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        List<Integer> result = new ArrayList<>();
        for (int item : items) {
            result.add(item * 2);
        }
        System.out.println(result);

        System.out.println("2. Sum a List of Numbers");
        List<Integer> numbers = new ArrayList<>();
        int sum = 0;

        for (int i = 1; i < 1000; i++) {
            numbers.add(i);
        }
        for (int number : numbers) {
            sum += number;
        }
        System.out.println(sum);

        System.out.println("3. Verify if Exists in a String");
        final List<String> keywords = Arrays.asList("brown", "fox", "dog", "pangram");
        final String tweet = "The quick brown fox jumps over a lazy dog.";
        boolean tweetContainsAtLeastOneKeyword = false;
        for (String s : keywords) {
            if (tweet.contains(s)) {
                tweetContainsAtLeastOneKeyword = true;
                break;
            }
        }
        System.out.println(tweetContainsAtLeastOneKeyword);

        System.out.println("4. Read in a file");
        Path path = Paths.get(Examples7.class.getClassLoader().getResource("data.txt").toURI());
        try (BufferedReader reader = Files.newBufferedReader(path, Charset.defaultCharset())) {
            for (String line = reader.readLine(); line != null; line = reader.readLine()) {
                System.out.println(line);
            }
        } catch (IOException ex) {
            System.out.println(ex.toString());
        }

        System.out.println("5. Happy Birthday to You!");
        for (int times = 1; times < 5; times++) {
            System.out.print("Happy Birthday ");
            if (times == 3) System.out.print("dear Steven\n");
            else System.out.print("to You\n");
        }

        System.out.println("6. Sort a list of names alphabetically");
        final List<String> names = Arrays.asList("Chase", "Xavier", "Phil", "Lizzy", "Tina", "Jimmy");
        Collections.sort(names);
        System.out.println(names);

        System.out.println("8. Find minimum (or maximum) in a List");
        List<Integer> numbersList = Arrays.asList(14, 35, -7, 46, 98);
        int min = Collections.min(numbersList);
        System.out.println(min);
        int max = Collections.max(numbersList);
        System.out.println(max);

        System.out.println("9. Parallel Processing");

        int count = 0;
        for (int num = 0; num < 1_000_000; num++) {
            if (isPrime(num)) {
                System.out.format("%s\t", num);
                count++;
            }
        }

        System.out.println("\nTotal: " + count);


    }

    private static boolean isPrime(int number) {
        if (number <= 1) return false;
        int bound = number / 2;
        for (int i = 2; i <= bound; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}

