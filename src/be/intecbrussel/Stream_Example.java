package be.intecbrussel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Stream_Example {
    public static void main(String[] args) {

//First code
        int[] tenNumbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        IntStream.of(tenNumbers).map(number -> number * 5)
                .filter(number -> number > 50)
                .forEach(n -> System.out.print(n + " "));

        System.out.println(" ");

//Second code
        double[] halfOfNumbers = IntStream.of(tenNumbers).mapToDouble(number -> number / 2.0).toArray();
        DoubleStream.of(halfOfNumbers).forEach(number -> System.out.print(number + " "));

        System.out.println(" ");

//Third code
        String[] cars = {"mercedes", "audi", "opel", "toyota", "lamborgini"};

        String str = java.util.stream.Stream.of(cars).map(car -> car.toUpperCase())
                .limit(2)
                .reduce("", (str1, str2) -> str1 + str2 + " ");
        System.out.print(str);

        System.out.println(" ");

//Fourth code
        int sum = IntStream.of(tenNumbers)
                .skip(2)
                .sum();
        System.out.println(sum);
        System.out.println(" ");

// Fifth code
        String[] StringNumbers = {"3", "5", "k", "70", "24", "33", "100"};

        int[] IntNumbers = java.util.stream.Stream.of(StringNumbers)
                .mapToInt(value -> convertToInt(value))
                .toArray();

        Arrays.stream(IntNumbers).forEach(number -> System.out.print(number + " "));
    }

    private static int convertToInt(String value) {
        int result = 0;
        try {
            result = Integer.parseInt(value);
        } catch (NumberFormatException nfe) {
            nfe.printStackTrace();
        }
        return result;
    }
}
