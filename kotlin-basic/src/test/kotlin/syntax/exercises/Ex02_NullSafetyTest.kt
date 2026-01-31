package syntax.exercises.ex02

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import kotlin.test.assertEquals

class Ex02_NullSafetyTest {

    @Test
    fun `exercise1 - Nullable 타입과 Safe Call`() {
        // [학습 목표] 타입 뒤에 ?를 붙여 null 허용을 선언하고 ?.로 안전하게 접근하는 법 이해
        assertEquals(5, exercise1("Hello"))
        assertEquals(0, exercise1(null))
    }

    @Test
    fun `exercise2 - Elvis 연산자`() {
        // [학습 목표] ?: 연산자를 사용하여 null일 경우의 기본값을 지정하는 법 이해
        assertEquals("Kotlin", exercise2("Kotlin"))
        assertEquals("Unknown", exercise2(null))
    }

    @Test
    fun `exercise3 - Safe Call 체이닝`() {
        // [학습 목표] 복잡한 객체 구조에서 ?.를 연쇄적으로 사용하여 NPE를 방지하는 법 이해
        val emp1 = Employee(Company(Address("Seoul")))
        val emp2 = Employee(Company(null))
        val emp3: Employee? = null
        
        assertEquals("Seoul", exercise3(emp1))
        assertEquals("No City", exercise3(emp2))
        assertEquals("No City", exercise3(emp3))
    }

    @Test
    fun `exercise4 - let을 이용한 null 체크`() {
        // [학습 목표] ?.let 블록을 사용하여 객체가 null이 아닐 때만 특정 로직을 수행하는 패턴 이해
        assertEquals("HELLO", exercise4("hello"))
        assertEquals("EMPTY", exercise4(null))
    }

    @Test
    fun `exercise5 - Non-null assertion`() {
        // [학습 목표] !! 연산자로 null이 아님을 강제 단언할 때의 동작과 위험성 이해
        assertEquals(4, exercise5("test"))
        assertThrows<NullPointerException> {
            exercise5(null)
        }
    }

    @Test
    fun `exercise6 - 스마트 캐스트`() {
        // [학습 목표] null 체크 후 컴파일러가 자동으로 non-null 타입으로 취급해주는 스마트 캐스트 이해
        assertEquals("smart", exercise6("smart"))
        assertEquals("NULL", exercise6(null))
    }
}