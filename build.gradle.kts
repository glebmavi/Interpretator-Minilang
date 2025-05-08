plugins {
    application
    kotlin("jvm") version "2.1.10"
    antlr
}

group = "co.glebmavi"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    antlr("org.antlr:antlr4:4.10")
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(21)
}

tasks.generateGrammarSource {
    outputDirectory = file("${getLayout().buildDirectory}/generated/sources/main/java/antlr")

    arguments = listOf("-package", "co.glebmavi", "-visitor")
}

sourceSets {
    main {
        java {
            srcDir(tasks.generateGrammarSource)
        }
    }
}

application {
    mainClass.set("co.glebmavi.MainKt")
}