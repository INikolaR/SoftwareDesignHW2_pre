plugins {
    id("java")
    application
}

group = "ru.hse._223"
version = "1.0-SNAPSHOT"



repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation("com.fasterxml.jackson.core:jackson-databind:2.16.1")
}

tasks.test {
    useJUnitPlatform()
}

application {
    mainClass.set("ru.hse._223.Main")
}