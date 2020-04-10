package task1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Runner {
    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();
        people.add(new Person("Steve", 23));
        people.add(new Person("Mary", 29));
        people.add(new Person("Bob", 42));
        people.add(new Person("Kevin", 21));

        Comparator<Person> byNameComparator = Comparator.comparing(Person::getName);
        Comparator<Person> byAgeComparator = Comparator.comparing(Person::getAge);

        people.sort(byNameComparator);
        people.forEach(System.out::println);

        System.out.println();

        people.sort(byAgeComparator);
        people.forEach(System.out::println);
    }
}
