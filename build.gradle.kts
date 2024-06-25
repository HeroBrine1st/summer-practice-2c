plugins {
    kotlin("jvm") version "1.9.23"
    application
}

group = "ru.herobrine1st.practice"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}

application {
    mainClass = "ru.herobrine1st.practice.MainKt"
}

kotlin {
    jvmToolchain(17)
}