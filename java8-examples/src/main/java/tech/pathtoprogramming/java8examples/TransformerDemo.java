package tech.pathtoprogramming.java8examples;

import tech.pathtoprogramming.common.model.Artist;
import tech.pathtoprogramming.common.model.Person;

import java.util.*;

import static java.util.Collections.emptyList;

public class TransformerDemo {

    /***
     * Transformer is a functional interface that is the exact same thing as Function
     * It is being used to demonstrate how Functional Interfaces work
     * @param <T>
     * @param <R>
     */
    @FunctionalInterface
    public interface Transformer<T, R> {
        R transform(T t);

        default <V> Transformer<V, R> butFirst(Transformer<? super V, ? extends T> before) {
            Objects.requireNonNull(before);
            return (V v) -> transform(before.transform(v));
        }

        default <V> Transformer<T, V> afterThat(Transformer<? super R, ? extends V> after) {
            Objects.requireNonNull(after);
            return (T t) -> after.transform(transform(t));
        }
    }

    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person("Adam", "Wolf", 23),
                new Person("Billy", "Serge", 28),
                new Person("Catey", "Shaw", 28),
                new Person("Horace", "Grant", 52)
        );

        Transformer<Person, Artist> transformPersonIntoArtist = person ->
                new Artist(UUID.randomUUID().toString(),
                        person.getFirstName() + " " + person.getLastName(),
                        "Unknown",
                        emptyList()
                );
        Transformer<Artist, String> getFullNames = artist -> artist.getName();

        // Compose
        Transformer<Person, String> getFullNamesButFirstTransformToArtist = getFullNames.butFirst(transformPersonIntoArtist);

        // andThen
        Transformer<Person, String> transformToFullNames = transformPersonIntoArtist.afterThat(getFullNames);

        List<Artist> artists = transform(people, transformPersonIntoArtist);

        System.out.println(artists);
        System.out.println(fullNames(people, transformToFullNames));
    }

    private static List<Artist> transform(List<Person> people, Transformer<Person, Artist> transformer) {
        List<Artist> artists = new ArrayList<>();
        for (Person person : people) {
            artists.add(transformer.transform(person));
        }
        return artists;
    }

    private static List<String> fullNames(List<Person> people, Transformer<Person, String> transformer) {
        List<String> fullNames = new ArrayList<>();
        for (Person person : people) {
            fullNames.add(transformer.transform(person));
        }
        return fullNames;
    }
}
