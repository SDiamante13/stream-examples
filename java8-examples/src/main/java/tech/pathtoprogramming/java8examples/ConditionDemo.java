package tech.pathtoprogramming.java8examples;

import tech.pathtoprogramming.common.model.Person;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class ConditionDemo {

    /***
     * Condition is a functional interface that is the exact same thing as Predicate
     * It is being used to demonstrate how Functional Interfaces work
     * @param <T>
     */
    @FunctionalInterface
    public interface Condition<T> {
        boolean check(T t);

        default Condition<T> and(Condition<? super T> other) {
            Objects.requireNonNull(other);
            return t -> check(t) && other.check(t);
        }

        default Condition<T> or(Condition<? super T> other) {
            Objects.requireNonNull(other);
            return t -> check(t) || other.check(t);
        }

        default Condition<T> negate() {
            return t -> !check(t);
        }
    }

    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person("Adam", "Wolf", 23),
                new Person("Billy", "Serge", 28),
                new Person("Catey", "Shaw", 28),
                new Person("Horace", "Grant", 52)
        );

        Condition<Person> startsWithC = person -> person.getFirstName().startsWith("C");
        Condition<Person> olderThan25 = person -> person.getAge() > 25;

        Condition<Person> lastNameStartWithS = person -> person.getLastName().startsWith("S");
        Condition<Person> lastNameStartWithW = person -> person.getLastName().startsWith("W");
        Condition<Person> lastNameStartWithSOrW = lastNameStartWithS.or(lastNameStartWithW);

        System.out.println(refine(people, startsWithC));
        System.out.println(refine(people, olderThan25));
        System.out.println(refine(people, startsWithC.negate().and(olderThan25)));
        System.out.println(refine(people, lastNameStartWithSOrW));
    }

    @SuppressWarnings("Duplicates")
    private static List<Person> refine(List<Person> people, Condition<Person> condition) {
        List<Person> filteredPeople = new ArrayList<>();
        for (Person person : people) {
            if (condition.check(person)) {
                filteredPeople.add(person);
            }
        }
        return filteredPeople;
    }
}
