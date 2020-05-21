plugins {
    java
    kotlin("jvm") version "1.3.60"
    application
}

application {
    mainClassName = "ch.obermuhlner.hello.kotlin.HelloKotlin"
}

tasks.named<Test>("test") {
    useJUnitPlatform()
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation(kotlin("script-runtime"))
    implementation(kotlin("compiler-embeddable"))
    implementation(kotlin("script-util"))

    runtime(kotlin("scripting-compiler-embeddable"))

    testImplementation("org.junit.jupiter", "junit-jupiter-api", "5.6.2")
    testRuntime("org.junit.jupiter", "junit-jupiter-engine", "5.6.2")
}

repositories {
    mavenCentral()
}


