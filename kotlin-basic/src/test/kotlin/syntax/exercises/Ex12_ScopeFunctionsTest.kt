package syntax.exercises.ex12

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class Ex12_ScopeFunctionsTest {
    @Test
    fun `exercise1 - let 사용법`() {
        // [학습 목표] it으로 객체 참조, 마지막 식 반환, 주로 null 체크와 변환에 사용되는 let 이해
        assertEquals("Hello, Kotlin!", exercise1("Kotlin"))
        assertEquals("Hello, Guest!", exercise1(null))
    }

    @Test
    fun `exercise2 - let 변환`() {
        // [학습 목표] 임시 변수 선언 없이 컬렉션 등을 다른 형태로 변환하는 let 활용법 이해
        assertEquals(listOf(1, 1, 3, 4, 5), exercise2(listOf(3, 1, 4, 1, 5)))
    }

    @Test
    fun `exercise3 - run 사용법`() {
        // [학습 목표] this로 객체 참조, 마지막 식 반환, 객체 설정과 결과 계산을 동시에 하는 run 이해
        assertTrue(exercise3().contains(":"))
    }

    @Test
    fun `exercise4 - with 사용법`() {
        // [학습 목표] 인자로 받은 객체의 컨텍스트 안에서 여러 작업을 수행하는 with 이해
        assertEquals("Hello World", exercise4(StringBuilder()))
    }

    @Test
    fun `exercise5 - apply 사용법`() {
        // [학습 목표] this로 객체 참조, 객체 자신 반환, 객체 초기화에 특화된 apply 이해
        val person = exercise5()
        assertEquals("Kim", person.name)
        assertEquals(30, person.age)
        assertEquals("Seoul", person.city)
    }

    @Test
    fun `exercise6 - also 사용법`() {
        // [학습 목표] it으로 객체 참조, 객체 자신 반환, 데이터 흐름 중간에 로깅 등 부수 효과를 넣는 also 이해
        loggedValue = ""
        val result = exercise6("hello")
        assertEquals("OLLEH", result)
        assertEquals("HELLO", loggedValue)
    }

    @Test
    fun `exercise7 - 스코프 함수 체이닝`() {
        // [학습 목표] 여러 스코프 함수를 조합하여 복잡한 객체 생성/변환 과정을 표현하는 법 이해
        val (order, summary) = exercise7()
        assertEquals(1, order.id)
        assertEquals(2, order.items.size)
        assertEquals("Order #1: 2 items", summary)
    }

    @Test
    fun `exercise8 - takeIf와 takeUnless`() {
        // [학습 목표] 조건에 따라 객체 자체를 반환하거나 null을 반환하여 분기 처리하는 법 이해
        assertEquals(5, exercise8(5))
        assertEquals(null, exercise8(-5))
    }

    @Test
    fun `exercise9 - let vs run 비교`() {
        // [학습 목표] it 참조(let)와 this 참조(run)의 가독성 차이와 적절한 사용 상황 이해
        val (letResult, runResult) = exercise9()
        assertEquals(2, letResult)
        assertEquals(3, runResult)
    }

    @Test
    fun `exercise10 - Builder 패턴 대체`() {
        // [학습 목표] apply를 사용하여 복잡한 빌더 클래스 없이 객체를 생성하는 Kotlin 방식 이해
        val email = exercise10()
        assertEquals("user@test.com", email.to)
        assertEquals("Hello", email.subject)
    }
}