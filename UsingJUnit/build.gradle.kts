dependencies {
    // Другие зависимости проекта
    testImplementation('org.junit.jupiter:junit-jupiter:5.6.2')
}

test {
    useJUnitPlatform() // Указываем, что будем использовать платформу JUnit 5
}
