package ch.obermuhlner.hello.java;

import ch.obermuhlner.hello.kotlin.VectorExample;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HelloJavaTest {

    @Test
    public void testVector() {
        VectorExample v = new VectorExample(1, 2);

        assertEquals(1.0, v.getX());
        assertEquals(2.0, v.getY());
    }
}
