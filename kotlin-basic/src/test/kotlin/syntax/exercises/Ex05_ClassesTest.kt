package syntax.exercises.ex05

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class Ex05_ClassesTest {
    @Test
    fun `exercise1 - 기본 클래스 정의`() {
        // [학습 목표] 주 생성자에 val/var를 선언하여 프로퍼티를 동시에 생성하는 문법 이해
        val result = exercise1()
        assertTrue(result.contains("is") && result.contains("years old"))
    }

    @Test
    fun `exercise2 - init 블록`() {
        // [학습 목표] 인스턴스화 시점에 실행되는 init 블록을 활용한 초기화 로직 작성 이해
        val (name, isAdult) = exercise2()
        assertEquals("KOTLIN", name)
        assertTrue(isAdult)
    }

    @Test
    fun `exercise3 - 커스텀 getter`() {
        // [학습 목표] get() 키워드를 사용하여 필드 없이 계산된 값을 반환하는 프로퍼티 작성법 이해
        assertEquals(212.0, exercise3())
    }

    @Test
    fun `exercise4 - 보조 생성자`() {
        // [학습 목표] constructor 키워드로 정의하고 주 생성자를 호출하는 보조 생성자 활용법 이해
        assertEquals(25, exercise4())
    }

    @Test
    fun `exercise5 - 접근 제한자`() {
        // [학습 목표] private 필드와 public 메서드를 통한 캡슐화와 데이터 은닉 이해
        assertEquals(1300, exercise5())
    }

    @Test
    fun `exercise6 - 중첩 클래스와 내부 클래스`() {
        // [학습 목표] Nested 클래스(정적)와 Inner 클래스(인스턴스 참조)의 차이점 이해
        val (nested, inner) = exercise6()
        assertEquals(10, nested)
        assertEquals(20, inner)
    }
}