package ch.obermuhlner.hello.java;

import ch.obermuhlner.hello.kotlin.HelloKotlinKt;
import ch.obermuhlner.hello.kotlin.Person;
import ch.obermuhlner.hello.kotlin.Vector;

public class HelloJava {
    public static void main(String[] args) {
        System.out.println("Hello Java");

        HelloKotlinKt.exampleForLoop();

        exampleDataClass();
        exampleOperators();
    }

    private static void exampleDataClass() {
        Person james = new Person("James", 25);
        System.out.println("james = " + james);
        System.out.println("james equals another james " + james.equals(new Person("James", 26)));
    }

    private static void exampleOperators() {
        Vector v1 = new Vector(1.0, 2.0);
        Vector v2 = new Vector(2.0, 3.0);
        Vector v3 = v1.plus(v2);
        Vector v4 = v1.times(3.0);

        System.out.println(v1 + " + " + v2 + " = " + v3);
        System.out.println(v1 + " * 3 = " + v4);

    }

}
