package syntax.exercises.ex11

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class Ex11_ExtensionsTest {
    @Test
    fun `exercise1 - 기본 확장 함수`() {
        // [학습 목표] 클래스 외부에서 기존 클래스의 멤버처럼 동작하는 함수를 추가하는 법 이해
        assertEquals("[Hello]", exercise1())
    }

    @Test
    fun `exercise2 - 수신 객체 참조(this)`() {
        // [학습 목표] 확장 함수 내부에서 this를 통해 인스턴스(수신 객체)에 접근하는 법 이해
        assertEquals(listOf(false, true, false, true), exercise2())
    }

    @Test
    fun `exercise3 - 제네릭 확장 함수`() {
        // [학습 목표] 다양한 타입의 컬렉션 등에 공통적으로 적용할 수 있는 제네릭 확장 함수 작성법 이해
        val (first, second) = exercise3()
        assertEquals(2, first)
        assertEquals(null, second)
    }

    @Test
    fun `exercise4 - 확장 프로퍼티`() {
        // [학습 목표] 필드 없이 getter만으로 기존 클래스에 새로운 속성을 추가하는 법 이해
        assertEquals('n', exercise4())
    }

    @Test
    fun `exercise5 - Nullable 타입 확장`() {
        // [학습 목표] 수신 객체가 null일 수 있는 상황(Type?)을 처리하는 확장 함수 작성법 이해
        assertEquals(listOf("Hello", ""), exercise5())
    }

    @Test
    fun `exercise6 - 확장 함수 우선순위`() {
        // [학습 목표] 동일한 이름의 멤버 함수와 확장 함수가 있을 때 멤버 함수가 우선함을 이해
        assertEquals("member: test", exercise6())
    }

    @Test
    fun `exercise7 - companion object 확장`() {
        // [학습 목표] 클래스의 인스턴스가 아닌 클래스 자체에 정적 메서드를 추가하는 법 이해
        assertTrue(exercise7())
    }

    @Test
    fun `exercise8 - 수신 객체 지정 람다`() {
        // [학습 목표] DSL 구축의 기반이 되는, 특정 객체의 컨텍스트 안에서 실행되는 람다 이해
        assertEquals("Hello, World!", exercise8())
    }

    @Test
    fun `exercise9 - 확장 함수의 정적 바인딩`() {
        // [학습 목표] 확장 함수는 다형성이 적용되지 않고 정적 타입에 따라 호출됨을 이해
        assertEquals("Parent", exercise9())
    }

    @Test
    fun `exercise10 - 확장 함수 체이닝`() {
        // [학습 목표] 여러 확장 함수를 연결하여 가독성 좋은 파이프라인 코드를 작성하는 법 이해
        assertEquals("Hello World", exercise10())
    }
}