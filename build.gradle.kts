plugins {
    java
    kotlin("jvm") version "1.3.60"
    application
}

application {
    mainClassName = "ch.obermuhlner.hello.kotlin.HelloKotlinKt"
}

dependencies {
    compile(kotlin("stdlib"))
}

repositories {
    mavenCentral()
}


