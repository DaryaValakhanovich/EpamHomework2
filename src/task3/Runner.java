package task3;

public class Runner {
    public static void main(String[] args) {
        ThreeFunction<Integer> multiply = (Integer i1, Integer i2, Integer i3) -> i1 * i2 * i3;
        int number1 = 2, number2 = 7, number3 = 4;
        System.out.println("Multiply of " + number1 + ", " + number2 + " and " + number3 + ": "
                + multiply.execute(2, 7, 4));
        ThreeFunction<String> stringFunction =
                (String s1, String s2, String s3) -> s1.toUpperCase() + " " + s2.toLowerCase() + " " + s3;
        System.out.println("Some strings: " + stringFunction.execute("Qwe", "Asd", "Zxc"));
    }
}
