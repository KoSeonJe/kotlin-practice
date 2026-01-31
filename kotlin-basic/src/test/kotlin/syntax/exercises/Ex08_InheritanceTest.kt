package syntax.exercises.ex08

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class Ex08_InheritanceTest {
    @Test
    fun `exercise1 - open 클래스와 상속`() {
        // [학습 목표] Kotlin은 기본이 final이며, 상속을 위해 클래스와 메서드에 open을 붙여야 함을 이해
        assertEquals("Buddy: Woof!", exercise1())
    }

    @Test
    fun `exercise2 - abstract 클래스`() {
        // [학습 목표] 직접 인스턴스화할 수 없는 추상 클래스와 추상 메서드 정의 및 구현 이해
        val area = exercise2()
        assertTrue(area in 78.5..78.6)
    }

    @Test
    fun `exercise3 - 인터페이스 구현`() {
        // [학습 목표] 다중 구현이 가능한 인터페이스와 `:`를 사용한 상속/구현 문법 이해
        val (fly, swim) = exercise3()
        assertTrue(fly.isNotEmpty() && swim.isNotEmpty())
    }

    @Test
    fun `exercise4 - 인터페이스 기본 구현`() {
        // [학습 목표] 인터페이스 내에서 메서드와 프로퍼티의 기본 동작을 정의하는 법 이해
        assertEquals("[LOG] Hello", exercise4())
    }

    @Test
    fun `exercise5 - sealed class`() {
        // [학습 목표] 상속받는 자식 클래스 종류를 제한하여 when 문에서 else 없이 완벽하게 분기 처리하는 법 이해
        assertEquals("Data: test", exercise5(Result.Success("test")))
        assertEquals("Error: fail", exercise5(Result.Error("fail")))
        assertEquals("Loading...", exercise5(Result.Loading))
    }

    @Test
    fun `exercise6 - sealed interface`() {
        // [학습 목표] 클래스 계층이 아닌 행동 중심의 계층도 sealed로 제한할 수 있음을 이해
        assertEquals(2, exercise6(UiState.Content(listOf("a", "b"))))
        assertEquals(-1, exercise6(UiState.Error(Exception())))
        assertEquals(0, exercise6(UiState.Empty))
    }

    @Test
    fun `exercise7 - 다이아몬드 문제 해결`() {
        // [학습 목표] 여러 상위 인터페이스에 중복된 메서드가 있을 때 super<Type>으로 특정 부모를 호출하는 법 이해
        val result = exercise7()
        assertTrue(result.contains("Hello from A") && result.contains("Hello from B"))
    }
}