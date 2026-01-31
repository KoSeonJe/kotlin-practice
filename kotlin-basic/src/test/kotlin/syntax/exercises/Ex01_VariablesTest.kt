package syntax.exercises.ex01

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Ex01_VariablesTest {

    @Test
    fun `exercise1 - 불변 변수 선언`() {
        // [학습 목표] val 키워드를 사용한 불변 변수 선언과 타입 추론 이해
        assertEquals("Hello, Kotlin!", exercise1())
    }

    @Test
    fun `exercise2 - 가변 변수 선언 및 수정`() {
        // [학습 목표] var 키워드를 사용한 가변 변수 선언과 값 재할당 이해
        assertEquals(20, exercise2())
    }

    @Test
    fun `exercise3 - 명시적 타입 선언`() {
        // [학습 목표] 변수 선언 시 타입을 명시적으로 지정하는 문법 이해
        assertEquals(3.14, exercise3())
    }

    @Test
    fun `exercise4 - 지연 초기화(lateinit)`() {
        // [학습 목표] lateinit을 사용하여 초기화를 나중으로 미루는 방법 이해
        val profile = UserProfile()
        profile.initialize("Kotlin")
        assertEquals("Kotlin", profile.getName())
    }

    @Test
    fun `exercise5 - 컴파일 타임 상수`() {
        // [학습 목표] const val을 이용한 컴파일 타임 상수의 특징과 제약 이해
        assertEquals(100, exercise5())
    }
}