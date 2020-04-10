package task2;

import task1.Person;

import java.util.function.*;


public class Runner {
    public static void main(String[] args) {
        Supplier<Person> defaultPerson = () -> new Person("Jon", 20);
        Person myPerson = defaultPerson.get();
        System.out.println(myPerson);

        Consumer<Person> printName = (Person p) -> System.out.println("Age: " + p.getAge());
        printName.accept(myPerson);

        Function<Person, Employee> hireEmployee =
                (Person p) -> new Employee(p.getName(), p.getAge(), 0);
        Employee employee = hireEmployee.apply(myPerson);
        System.out.println(employee);

        UnaryOperator<Person> getOlderPerson = (Person p) -> new Person(p.getName(), p.getAge() + 1);
        System.out.println(getOlderPerson.apply(myPerson));

        Predicate<Person> isAdult = (Person p) -> p.getAge() >= 18;
        System.out.println("Is " + myPerson.getName() + " an adult? " + isAdult.test(myPerson));

        BinaryOperator<Integer> sumOfSquares = (Integer a, Integer b) -> a * a + b * b;
        System.out.println("Sum of squares: " + sumOfSquares.apply(3, 5));

        DoSmthInterface<Person> personDoSmth = (Person p) -> "This is " + p.getName();
        System.out.println(personDoSmth.doSmth(myPerson));

        DoSmthInterface<Person> personDoSmthElthe = new DoSmthInterface<Person>() {
            @Override
            public String doSmth(Person person) {
                sayHello();
                return "My name is " + person.getName();
            }
        };
        System.out.println(personDoSmthElthe.doSmth(myPerson));

        DoSmthInterface.staticMethod(9);
    }
}
