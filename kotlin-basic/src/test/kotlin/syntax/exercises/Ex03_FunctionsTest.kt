package syntax.exercises.ex03

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Ex03_FunctionsTest {
    @Test
    fun `exercise1 - 기본 함수 정의`() {
        // [학습 목표] fun 키워드, 파라미터 선언, 반환 타입 지정 등 기본적인 함수 구조 이해
        assertEquals(8, exercise1(3, 5))
    }

    @Test
    fun `exercise2 - 단일 표현식 함수`() {
        // [학습 목표] 중괄호와 return 생략 후 =으로 함수 본문을 정의하는 축약 문법 이해
        assertEquals(20, exercise2(4, 5))
    }

    @Test
    fun `exercise3 - 기본 파라미터 값`() {
        // [학습 목표] 함수 정의 시 파라미터에 기본값을 할당하여 오버로딩 효과를 내는 법 이해
        assertEquals("Hello, Kotlin!", exercise3("Kotlin"))
        assertEquals("Hi, World!", exercise3("World", "Hi"))
    }

    @Test
    fun `exercise4 - Named arguments`() {
        // [학습 목표] 함수 호출 시 파라미터 이름을 명시하여 인자 순서에 상관없이 호출하는 법 이해
        assertEquals("Kim (25) from Seoul", exercise4())
    }

    @Test
    fun `exercise5 - Unit 반환 타입`() {
        // [학습 목표] 반환값이 없는 함수(Java의 void)인 Unit의 특징 이해
        sideEffectResult = ""
        exercise5("Side Effect!")
        assertEquals("Side Effect!", sideEffectResult)
    }

    @Test
    fun `exercise6 - 가변 인자(vararg)`() {
        // [학습 목표] vararg 키워드를 사용하여 개수가 정해지지 않은 인자를 받는 법 이해
        assertEquals(15, exercise6(1, 2, 3, 4, 5))
        assertEquals(0, exercise6())
    }

    @Test
    fun `exercise7 - 지역 함수`() {
        // [학습 목표] 함수 내부에 다른 함수를 정의하여 캡슐화를 강화하는 법 이해
        assertEquals("olleh", exercise7("hello"))
    }

    @Test
    fun `exercise8 - 확장 함수 기초`() {
        // [학습 목표] 기존 클래스의 멤버처럼 호출할 수 있는 확장 함수의 기본 개념 이해
        assertEquals("Hello!", exercise8("Hello"))
    }
}