package syntax.exercises.ex07

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class Ex07_ObjectCompanionTest {
    @Test
    fun `exercise1 - object 싱글톤`() {
        // [학습 목표] object 키워드로 별도의 인스턴스 생성 없이 전역에서 유일하게 사용되는 싱글톤 선언 이해
        val result = exercise1()
        assertTrue(result.contains("MyApp") && result.contains("1.0.0"))
    }

    @Test
    fun `exercise2 - companion object`() {
        // [학습 목표] 클래스 내부에 정의하여 Java의 static 멤버처럼 사용할 수 있는 동반 객체 이해
        val (constant, value) = exercise2()
        assertEquals(100, constant)
        assertEquals("instance", value)
    }

    @Test
    fun `exercise3 - named companion object`() {
        // [학습 목표] 동반 객체에 이름을 부여하여 명시적으로 참조하는 방법 이해
        assertTrue(exercise3() is Logger)
    }

    @Test
    fun `exercise4 - 팩토리 패턴 활용`() {
        // [학습 목표] 생성자를 private으로 막고 동반 객체를 통해 인스턴스를 생성하는 팩토리 패턴 이해
        val (name, email) = exercise4()
        assertEquals("kotlin", name)
        assertEquals("java@example.com", email)
    }

    @Test
    fun `exercise5 - object 표현식(익명 객체)`() {
        // [학습 목표] 인터페이스나 클래스를 즉석에서 상속/구현하는 이름 없는 객체 생성법 이해
        assertEquals("Hello!", exercise5())
    }

    @Test
    fun `exercise6 - 다중 인터페이스 구현 익명 객체`() {
        // [학습 목표] 여러 인터페이스를 한꺼번에 구현하는 익명 객체 생성 및 활용 이해
        val result = exercise6()
        assertTrue(result.contains("is") && result.contains("years old"))
    }

    @Test
    fun `exercise7 - companion object 인터페이스 구현`() {
        // [학습 목표] 동반 객체도 인터페이스를 구현하여 제네릭 팩토리 등으로 활용될 수 있음을 이해
        val ids = exercise7()
        assertEquals(3, ids.size)
        assertTrue(ids[0] < ids[1] && ids[1] < ids[2])
    }
}