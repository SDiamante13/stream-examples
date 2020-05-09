package tech.pathtoprogramming.java7examples;

import tech.pathtoprogramming.common.model.Person;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FunctionalInterfaceDemo7 {

    public interface Condition<T> {
        boolean check(T t);
    }

    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person("Adam", "Wolf", 23),
                new Person("Billy", "Serge", 28),
                new Person("Catey", "Shaw", 28),
                new Person("Horace", "Grant", 52)
        );

        // print people with first name beginning with a C
        // print people that are older than 25

//        Condition<Person> startsWithC = p -> p.getFirstName().startsWith("C");
//        Condition<Person> olderThan25 = p -> p.getAge() > 25;

        Condition<Person> startsWithC = new Condition<Person>() {
            @Override
            public boolean check(Person person) {
                return person.getFirstName().startsWith("C");
            }
        };

        Condition<Person> olderThan25 = new Condition<Person>() {
            @Override
            public boolean check(Person person) {
                return person.getAge() > 25;
            }
        };

        List<Person> people1 = printConditionally(people, startsWithC);
        List<Person> people2 = printConditionally(people, olderThan25);

        System.out.println(people1);
        System.out.println(people2);
    }

    @SuppressWarnings("Duplicates")
    private static List<Person> printConditionally(List<Person> people, Condition<Person> condition) {
        List<Person> filteredPeople = new ArrayList<>();
        for (Person person : people) {
            if (condition.check(person)) {
                filteredPeople.add(person);
            }
        }
        return filteredPeople;
    }
}
