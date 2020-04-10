package tech.pathtoprogramming.java7examples;

import java.util.ArrayList;
import java.util.List;

/***
 * One liner examples done only using Java 7 features
 */
public class Examples7 {

    public static void main(String[] args) {
        // 1. Multiple Each Item in a List by 2
        List<Integer> items = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            items.add(i);
        }
        for (int item: items) {
            result.add(item * 2);
        }
        System.out.println(result);

        // 2. Sum a List of Numbers
        List<Integer> numbers = new ArrayList<>();
        int sum = 0;

        for (int i = 1; i < 1000; i++) {
            numbers.add(i);
        }
        for (int number: numbers) {
            sum += number;
        }
        System.out.println(sum);
    }
}

