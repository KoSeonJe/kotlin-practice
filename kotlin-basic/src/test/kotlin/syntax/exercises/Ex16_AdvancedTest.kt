package syntax.exercises.ex16

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class Ex16_AdvancedTest {
    @Test
    fun `exercise1 - plus 연산자 오버로딩`() {
        // [학습 목표] operator 키워드로 + 등 연산자를 객체에 맞게 직접 정의하는 법 이해
        assertEquals(Vector(4, 6), exercise1())
    }

    @Test
    fun `exercise2 - 비교 연산자 오버로딩`() {
        // [학습 목표] compareTo를 통해 <, > 등 비교 연산자를 객체에 적용하는 법 이해
        assertEquals(listOf(true, false, true), exercise2())
    }

    @Test
    fun `exercise3 - invoke 연산자`() {
        // [학습 목표] 객체를 함수처럼 호출할 수 있게 해주는 invoke 특수 메서드 이해
        assertEquals("Hello, Kotlin!", exercise3())
    }

    @Test
    fun `exercise4 - get, set 연산자`() {
        // [학습 목표] 배열처럼 [index] 문법으로 객체의 데이터에 접근하고 수정하는 법 이해
        assertEquals(10, exercise4())
    }

    @Test
    fun `exercise5 - infix 함수`() {
        // [학습 목표] 점(.)과 괄호를 생략하고 `a power b`와 같이 자연어처럼 호출하는 중위 함수 이해
        assertEquals(1024, exercise5())
    }

    @Test
    fun `exercise6 - Type Alias`() {
        // [학습 목표] 복잡한 타입 이름에 별칭을 부여하여 가독성을 높이는 법 이해
        val (value, isEven) = exercise6()
        assertEquals("value", value)
        assertTrue(isEven)
    }

    @Test
    fun `exercise7 - Value Class`() {
        // [학습 목표] 런타임 오버헤드 없이 타입 안전성을 제공하는 인라인 클래스 이해
        val (user, order) = exercise7()
        assertTrue(user.contains("123") && order.contains("456"))
    }

    @Test
    fun `exercise8 - DSL 기초`() {
        // [학습 목표] 수신 객체 지정 람다를 활용하여 선언적이고 읽기 좋은 도구 지향 언어 작성법 이해
        val result = exercise8()
        assertTrue(result.contains("<p>Hello</p>") && result.contains("<div>"))
    }

    @Test
    fun `exercise9 - 리플렉션 기초`() {
        // [학습 목표] 런타임에 클래스의 구조(프로퍼티 목록 등)를 분석하는 법 이해
        val props = exercise9()
        assertTrue("name" in props && "age" in props)
    }

    @Test
    fun `exercise10 - Java 상호운용 어노테이션`() {
        // [학습 목표] @JvmStatic 등을 사용하여 Java 코드에서 Kotlin 코드를 자연스럽게 호출하도록 돕는 법 이해
        val (constant, method) = exercise10()
        assertEquals("Kotlin Constant", constant)
        assertTrue(method.contains("Java"))
    }
}