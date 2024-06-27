plugins {
    kotlin("jvm") version "1.9.23"
    id("org.jetbrains.compose") version "1.6.2"
}

group = "ru.herobrine1st.practice"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    google()
}

dependencies {
    implementation(compose.runtime)
    implementation(compose.foundation)
    implementation(compose.material3)
    implementation(compose.materialIconsExtended)
    implementation(compose.ui)
    implementation(compose.desktop.currentOs)
}

compose.desktop {
    application {
        mainClass = "ru.herobrine1st.practice.MainKt"
    }
}

kotlin {
    jvmToolchain(17)
}