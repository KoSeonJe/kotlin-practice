package syntax.exercises.ex14

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class Ex14_DelegationTest {
    @Test
    fun `exercise1 - lazy 위임`() {
        // [학습 목표] 처음 접근할 때 단 한 번만 초기화되는 지연 초기화 프로퍼티 활용 이해
        val (first, second) = exercise1()
        assertEquals("Expensive Data", first)
        assertEquals("Expensive Data", second)
    }

    @Test
    fun `exercise2 - observable 위임`() {
        // [학습 목표] 값이 변경될 때마다 특정 콜백을 실행하여 변경을 감지하는 법 이해
        assertEquals("Kotlin", exercise2())
    }

    @Test
    fun `exercise3 - vetoable 위임`() {
        // [학습 목표] 값 변경 전 조건을 검사하여 변경을 허용하거나 거부하는 법 이해
        assertEquals(10, exercise3())
    }

    @Test
    fun `exercise4 - 커스텀 위임`() {
        // [학습 목표] ReadWriteProperty 등을 사용하여 직접 위임 로직(예: trim 처리)을 구현하는 법 이해
        assertEquals("Hello World", exercise4())
    }

    @Test
    fun `exercise5 - Map 위임`() {
        // [학습 목표] Map의 키와 프로퍼티 이름을 연결하여 동적으로 값을 읽고 쓰는 법 이해
        assertEquals("localhost:8080", exercise5())
    }

    @Test
    fun `exercise6 - 클래스 위임(by delegate)`() {
        // [학습 목표] 상속 대신 위임을 사용하여 코드를 재사용하고 기능을 확장(데코레이터 패턴)하는 법 이해
        assertEquals("[LOG] Console: Hello", exercise6())
    }

    @Test
    fun `exercise7 - 다중 위임`() {
        // [학습 목표] 여러 인터페이스 구현을 각각 다른 객체에 위임하여 복합 객체를 구성하는 법 이해
        val (read, written) = exercise7()
        assertEquals("File content", read)
        assertEquals("Hello", written)
    }

    @Test
    fun `exercise8 - notNull 위임`() {
        // [학습 목표] lateinit과 유사하지만 원시 타입에도 적용 가능하고 초기화 여부를 체크할 수 있는 위임 이해
        val (before, after) = exercise8()
        assertFalse(before)
        assertTrue(after)
    }
}