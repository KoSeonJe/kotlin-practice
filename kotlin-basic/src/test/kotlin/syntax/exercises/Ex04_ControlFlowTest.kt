package syntax.exercises.ex04

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Ex04_ControlFlowTest {
    @Test
    fun `exercise1 - if 표현식`() {
        // [학습 목표] Kotlin의 if-else가 구문(Statement)이 아닌 값을 반환하는 표현식(Expression)임을 이해
        assertEquals(5, exercise1(5, 3))
        assertEquals(7, exercise1(2, 7))
    }

    @Test
    fun `exercise2 - when 기본 사용`() {
        // [학습 목표] Java의 switch를 대체하는 강력한 when 조건문의 기본 사용법 이해
        assertEquals("월요일", exercise2(1))
        assertEquals("일요일", exercise2(7))
        assertEquals("Unknown", exercise2(0))
    }

    @Test
    fun `exercise3 - when 범위 조건`() {
        // [학습 목표] when 문에서 in 연산자와 범위를 사용하여 조건을 처리하는 법 이해
        assertEquals("A", exercise3(95))
        assertEquals("B", exercise3(85))
        assertEquals("F", exercise3(55))
    }

    @Test
    fun `exercise4 - when 타입 검사`() {
        // [학습 목표] is 키워드를 사용하여 객체의 타입을 검사하고 스마트 캐스트를 활용하는 법 이해
        assertEquals("문자열: hello", exercise4("hello"))
        assertEquals("정수: 42", exercise4(42))
        assertEquals("기타", exercise4(3.14))
    }

    @Test
    fun `exercise5 - when 조건 없는 형태`() {
        // [학습 목표] 인자 없는 when 문을 사용하여 여러 boolean 조건을 깔끔하게 처리하는 법 이해
        assertEquals("greater", exercise5(5, 3))
        assertEquals("less", exercise5(2, 7))
        assertEquals("equal", exercise5(4, 4))
    }

    @Test
    fun `exercise6 - for 범위 반복`() {
        // [학습 목표] ..연산자, step 등을 사용하여 숫자 범위를 반복하는 for 문 이해
        assertEquals(listOf(2, 4, 6, 8, 10), exercise6())
    }

    @Test
    fun `exercise7 - for 컬렉션 반복`() {
        // [학습 목표] 리스트 등 컬렉션의 요소를 순회하는 기본적인 for 문 사용법 이해
        assertEquals("a, b, c", exercise7(listOf("a", "b", "c")))
    }

    @Test
    fun `exercise8 - for with index`() {
        // [학습 목표] withIndex()를 사용하여 인덱스와 값을 동시에 꺼내어 반복하는 법 이해
        assertEquals(listOf("0: a", "1: b"), exercise8(listOf("a", "b")))
    }

    @Test
    fun `exercise9 - while 반복`() {
        // [학습 목표] 조건에 따른 기본적인 while 루프 사용법 이해
        assertEquals(15, exercise9(5))
        assertEquals(55, exercise9(10))
    }

    @Test
    fun `exercise10 - break와 label`() {
        // [학습 목표] 라벨(@)을 사용하여 중첩 루프에서 특정 루프를 탈출하는 법 이해
        val expected = listOf(1 to 1, 1 to 2, 2 to 1)
        assertEquals(expected, exercise10())
    }
}