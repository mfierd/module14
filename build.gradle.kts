plugins {
    java
}

group = "mfierd"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter:5.10.0")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
    implementation("org.seleniumhq.selenium:selenium-java:4.12.1")
    implementation("io.github.bonigarcia:webdrivermanager:5.6.3")
    testImplementation("org.testng:testng:7.9.0")
}

tasks.test {
    useJUnitPlatform()
}
