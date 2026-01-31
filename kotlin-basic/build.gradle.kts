plugins {
    kotlin("jvm")
    application
}

application {
    mainClass.set("com.example.basic.MainKt")
}

dependencies {
    // 코루틴 (Phase 3 학습용)
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.8.0")

    // 리플렉션 (Phase 3 학습용)
    implementation(kotlin("reflect"))

    // Kotlin 테스트 기본 라이브러리
    testImplementation(kotlin("test"))

    // JUnit 5 (기본 테스트 프레임워크)
    testImplementation("org.junit.jupiter:junit-jupiter:5.10.1")

    // Kotest - Kotlin 전용 테스트 프레임워크
    // https://kotest.io/docs/quickstart
    testImplementation("io.kotest:kotest-runner-junit5:5.8.0")  // JUnit5 플랫폼에서 Kotest 실행
    testImplementation("io.kotest:kotest-assertions-core:5.8.0")  // Kotest assertion (shouldBe, shouldThrow 등)
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(17)
}
