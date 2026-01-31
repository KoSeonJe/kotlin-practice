package syntax.exercises.ex06

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class Ex06_DataClassTest {
    @Test
    fun `exercise1 - data class 자동 생성 메서드`() {
        // [학습 목표] data class 선언만으로 toString()이 자동 생성되는 특징 이해
        val result = exercise1()
        assertTrue(result.contains("User") && result.contains("id="))
    }

    @Test
    fun `exercise2 - 동등성(equals) 비교`() {
        // [학습 목표] == 연산자가 객체의 참조가 아닌 내부 데이터를 비교하는 equals()를 호출함을 이해
        assertTrue(exercise2())
    }

    @Test
    fun `exercise3 - copy()를 통한 불변성 유지`() {
        // [학습 목표] 객체의 불변성을 유지하면서 일부 프로퍼티만 변경된 새 객체를 생성하는 법 이해
        val original = User(1, "Test", "old@test.com")
        val copied = exercise3(original, "new@test.com")
        assertEquals("new@test.com", copied.email)
        assertEquals(1, copied.id)
    }

    @Test
    fun `exercise4 - 구조 분해 선언`() {
        // [학습 목표] 객체의 각 프로퍼티를 개별 변수로 한 번에 추출하는 문법 이해
        val user = User(42, "Kotlin", "kotlin@test.com")
        assertEquals("User #42: Kotlin (kotlin@test.com)", exercise4(user))
    }

    @Test
    fun `exercise5 - componentN 함수`() {
        // [학습 목표] 구조 분해의 기반이 되는 component1(), component2() 등의 자동 생성 메서드 이해
        val user = User(1, "Test", "test@test.com")
        assertEquals(listOf(1, "Test", "test@test.com"), exercise5(user))
    }

    @Test
    fun `exercise6 - 컬렉션에서의 활용`() {
        // [학습 목표] hashCode() 자동 생성으로 Set이나 Map에서 동등한 객체가 동일하게 취급됨을 이해
        assertEquals(1, exercise6())
    }

    @Test
    fun `exercise7 - 주 생성자 외부 프로퍼티`() {
        // [학습 목표] 클래스 본문에 정의된 프로퍼티는 자동 생성 메서드(equals 등) 대상에서 제외됨을 이해
        assertTrue(exercise7())
    }

    @Test
    fun `exercise8 - 인터페이스 구현`() {
        // [학습 목표] data class도 인터페이스를 구현하고 상위 타입으로 다뤄질 수 있음을 이해
        val article = Article(99, "Kotlin Guide")
        assertEquals(99, exercise8(article))
    }
}