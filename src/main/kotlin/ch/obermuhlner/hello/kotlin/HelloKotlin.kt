@file:JvmName("HelloKotlin")

package ch.obermuhlner.hello.kotlin

import kotlin.math.sin
import kotlin.math.sqrt
import kotlin.properties.Delegates

fun main(args: Array<String>) {
    println("Hello Kotlin")

    exampleVariables()
    exampleNullSafe()
    exampleFunctionParameters()
    exampleForLoop()
    exampleSimpleLambda()
    exampleClass()
    exampleDataClass()
    exampleProperties()
    exampleOperators()
    exampleExtensionFunction()
    exampleWhen()
    exampleScopeFunctions()
    examplePropertyDelegate()

    // Additional topics:
    // - types: Unit, Nothing, Any
    // - collections (mutable and immutable)
    // - generics
    // - sealed classes
    // - delegation
    // - delegated properties
    // - coroutines
    // - decomposition
    // - scope functions (let, run, with, apply, also)
}

//----------------------------------------------------------------------------------------------

fun exampleVariables() {
    val alpha: Int = 99
    var beta = alpha + 1

    val str = "Hello"
}

//----------------------------------------------------------------------------------------------

fun exampleNullSafe() {
    var alpha: Int = 99
    var beta: Int? = null
    var gamma: Int
    val str: String? = null

    //gamma = alpha + beta

    if (beta != null) {
        gamma = beta
    } else {
        gamma = alpha
    }

    gamma = beta ?: -1 // assigns -1

    //gamma =  beta!! // throws NPE

    //beta = str.length

    beta = str?.length // assigns null

    //beta = str!!.length // throws NPE
}

//----------------------------------------------------------------------------------------------

fun message(greeting: String = "Hello", name: String = "guest") = "$greeting $name"

fun exampleFunctionParameters() {
    println(message()) // "Hello guest"
    println(message("Goodbye")) // "Goodbye guest"
    println(message(greeting = "Goodbye", name = "Eric")) // "Goodbye Eric"
}

//----------------------------------------------------------------------------------------------

fun exampleForLoop() {
    val greekLetters = listOf("alpha", "beta", "gamma")
    var joinedGreekLetters = ""

    for (greekLetter in greekLetters) {
        println("Greek Letter: $greekLetter") // string with variables
        joinedGreekLetters += greekLetter
    }

    println("Joined Greek Letters: $joinedGreekLetters")
}

//----------------------------------------------------------------------------------------------

fun measure(block : () -> Unit) {
    val start = System.nanoTime()
    block()
    val end = System.nanoTime()
    val delta = end - start

    println("Elapsed $delta nanoseconds")
}

fun exampleSimpleLambda() {
    // lambda as argument in function call
    measure({
        for (i in 0..10000) {
            sin(1.23)
        }
    })

    // last lambda argument may be written outside of brackets
    measure() {
        for (i in 0..10000) {
            sin(1.23)
        }
    }

    // allowed to omit empty brackets in function call
    measure {
        for (i in 0..10000) {
            sin(1.23)
        }
    }
}

//----------------------------------------------------------------------------------------------

abstract class Animal {
    abstract fun makeSound(): String
}

// class is final per default. Use `open` or `sealed`
class Dog: Animal() {
    override fun makeSound() = "Woof"
}


open class Cat(private val sound: String): Animal() { // primary constructor may declare fields

    constructor(): this("Miaow") // secondary constructor must call primary constructor

    override fun makeSound() = sound
}

class Tiger: Cat("Raow")

fun exampleClass() {
    val animal: Animal = Cat()
    println(animal.makeSound())
}

//----------------------------------------------------------------------------------------------

data class Person (val name: String, val age: Int)
// data class declares public fields in constructor
// implements hashCode() and equals() and toString()
// implements componentN() for decomposition

fun exampleDataClass() {
    val jim = Person("Jim", 18)
    val joe = Person("Joe", 40)

    println(jim)
    println(joe)
    println(jim.age + joe.age)

    for ((name, age) in listOf(jim, joe)) {
        println("name = $name, age = $age")
    }
}

//----------------------------------------------------------------------------------------------

class PropertiesExamples {
    var size = 0 // backing field of type Int
        set(value) {
            if (value >= 0) {
                field = value // access to backing field
            }
        }

    val isEmpty get() = size == 0 // no backing field

    lateinit var name: String

    fun initialize() {
        name = "Hello"
    }

}

fun exampleProperties() {
    val p = PropertiesExamples()

    p.size = -1
    println("size = ${p.size}")
    println("isEmpty = ${p.isEmpty}")

    p.size = 2
    println("isEmpty = ${p.isEmpty}")

    //println("name = ${p.name}") // Exception in thread "main" kotlin.UninitializedPropertyAccessException: lateinit property name has not been initialized
    p.initialize()
    println("name = ${p.name}")
}

//----------------------------------------------------------------------------------------------

data class Vector (val x: Double, val y: Double) : Comparable<Vector> {
    val length get() = sqrt(x*x + y*y) // property with other getter allowed

    operator fun plus(v: Vector): Vector {
        return Vector(x+v.x, y+v.y)
    }
    operator fun times(factor: Double): Vector {
        return Vector(x*factor, y*factor)
    }
    operator fun get(index: Int): Double {
        return when(index) {
            0 -> x
            1 -> y
            else -> 0.0
        }
    }
    override fun compareTo(other: Vector): Int {
        return length.compareTo(other.length)
    }
}

fun exampleOperators() {
    val v1 = Vector(1.0, 2.0)
    val v2 = Vector(3.0, 4.0)
    val v3 = v1 + v2
    val v4 = v1 * 3.0

    println("$v1 + $v2 = $v3")
    println("$v1 * 3 = $v4")

    println("length v4 = ${v4.length}")

    println("v1 greater v2 = " + (v1 > v2))

    val v1_0 = v1[0]
    val v1_1 = v1[1]
    println("v1[0] = $v1_0")
    println("v1[1] = $v1_1")

    val (x, y) = v1
    println("x = $x")
    println("y = $y")
}

//----------------------------------------------------------------------------------------------

fun String.bracket() = "($this)"

operator fun Vector.times(factor: Int) = this * factor.toDouble()

fun exampleExtensionFunction() {
    val str = "hello";

    println(str.bracket())

    val v1 = Vector(1.0, 2.0)
    val v2 = v1 * 3

    println(v2)
}

//----------------------------------------------------------------------------------------------

fun simpleWhen(value: Int): String {
    return when (value) {
        0 -> "zero"
        1 -> "one"
        2, 3 -> "two or three"
        in 4..10 -> "four to ten"
        else -> "weird!"
    }
}

fun castingWhen(obj: Any): Any {
    return when (obj) {
        is Int -> obj + 2
        is Double -> sqrt(obj)
        is String -> obj.bracket()
        else -> "Unknown: $obj"
    }
}

fun noArgumentWhen(value1: Int, value2: Int): Int {
    return when {
        value1 < 10 -> -1
        value1 == value2 -> 99
        else -> 0
    }
}

fun exampleWhen() {
    for (i in 0..11) {
        println("$i -> ${simpleWhen(i)}")
    }

    println(castingWhen(99))
    println(castingWhen(2.0))
    println(castingWhen("Hello"))
    println(castingWhen(Person("Jim", 19)))

    println(noArgumentWhen(5, 5))
    println(noArgumentWhen(55, 55))
}

//----------------------------------------------------------------------------------------------

data class MutablePerson(var name: String, var age: Int) {
    constructor(): this("Unknown", 0)
}

fun exampleScopeFunctions() {
    // run, with, apply -> this

    val johnny1 = MutablePerson().apply {
        name = "Johnny"
        age = 1
    }

    // let, also -> it

    val johnny2 = MutablePerson().let {
        it.name = "Johnny"
        it.age = 2
    }
}

//----------------------------------------------------------------------------------------------

fun examplePropertyDelegate() {
    // delegate property by lazy
    val lazyString: String by lazy {
        println("Creating long string...")
        "Took a long time to create this string"
    }
    println(lazyString)
    println(lazyString)

    // delegate property by observable
    var observedString: String by Delegates.observable("initial") { property, old, new ->
        println("Observing: $old -> $new")
    }
    observedString = "hello"

    // delegate property by vetoable
    var vetoableString: String by Delegates.vetoable("initial") { property, old, new ->
        new.startsWith("sudo")
    }
    vetoableString = "not working"
    println(vetoableString)
    vetoableString = "sudo this is working"
    println(vetoableString)

    // delegate property by map
    val map: MutableMap<String, Any?> = mutableMapOf("name" to "Eric", "age" to 53)
    val name: String by map
    var age: Int by map
    println("name = $name")
    println("age = $age")
    age = 99
    println("age = $age")
    println(map)
}
