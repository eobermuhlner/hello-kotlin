package ch.obermuhlner.hello.java;

import ch.obermuhlner.hello.kotlin.HelloKotlin;
import ch.obermuhlner.hello.kotlin.PersonExample;
import ch.obermuhlner.hello.kotlin.VectorExample;

public class HelloJava {
    public static void main(String[] args) {
        System.out.println("Hello Java");

        HelloKotlin.exampleForLoop();

        exampleDataClass();
        exampleOperators();
    }

    private static void exampleDataClass() {
        PersonExample james = new PersonExample("James", 25);
        System.out.println("james = " + james);
        System.out.println("james equals another james " + james.equals(new PersonExample("James", 26)));
    }

    private static void exampleOperators() {
        VectorExample v1 = new VectorExample(1.0, 2.0);
        VectorExample v2 = new VectorExample(2.0, 3.0);
        VectorExample v3 = v1.plus(v2);
        VectorExample v4 = v1.times(3.0);

        System.out.println(v1 + " + " + v2 + " = " + v3);
        System.out.println(v1 + " * 3 = " + v4);

    }

}
