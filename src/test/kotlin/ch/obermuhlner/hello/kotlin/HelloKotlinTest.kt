package ch.obermuhlner.hello.kotlin

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class HelloKotlinTest {

    @Test
    fun `vector x, y properties`() {
        val v = Vector(1.0, 2.0)

        assertEquals(1.0, v.x)
        assertEquals(2.0, v.y)
    }

    @Test
    fun `vector components`() {
        val v = Vector(1.0, 2.0)

        val (x, y) = v
        assertEquals(1.0, x)
        assertEquals(2.0, y)
    }

    @Test
    fun `vector +`() {
        val v1 = Vector(1.0, 2.0)
        val v2 = Vector(2.0, 3.0)

        val v3 = v1 + v2
        assertEquals(3.0, v3.x)
        assertEquals(5.0, v3.y)
    }
}

