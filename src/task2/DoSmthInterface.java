package task2;

@FunctionalInterface
public interface DoSmthInterface<T> {
    String doSmth(T t);

    default void sayHello() {
        System.out.println("Hello!");
    }

    static void staticMethod(Integer integer) {
        System.out.println(integer + " * " + integer + " = " + integer * integer);
    }
}
