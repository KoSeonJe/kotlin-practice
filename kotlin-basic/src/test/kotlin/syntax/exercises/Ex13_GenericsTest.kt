package syntax.exercises.ex13

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class Ex13_GenericsTest {
    @Test
    fun `exercise1 - 기본 제네릭 클래스`() {
        // [학습 목표] <T>를 사용하여 다양한 타입을 안전하게 다루는 제네릭 클래스 정의 이해
        val (str, num) = exercise1()
        assertEquals("Hello", str)
        assertEquals(42, num)
    }

    @Test
    fun `exercise2 - 제네릭 함수`() {
        // [학습 목표] 함수 수준에서 타입을 파라미터화하여 재사용성을 높이는 법 이해
        assertEquals(listOf("Hello", 42, 3.14), exercise2())
    }

    @Test
    fun `exercise3 - 타입 제약(Upper Bound)`() {
        // [학습 목표] <T : Number>처럼 특정 타입을 상속받은 타입으로만 제한하는 법 이해
        assertEquals(listOf(10.0, 6.28, 20.0), exercise3())
    }

    @Test
    fun `exercise4 - 다중 제약(where)`() {
        // [학습 목표] where 절을 사용하여 여러 인터페이스를 동시에 구현한 타입만 허용하는 법 이해
        assertEquals("Value: 42", exercise4())
    }

    @Test
    fun `exercise5 - 공변성(out)`() {
        // [학습 목표] out 키워드를 사용하여 생산자 입장에서 하위 타입을 상위 타입으로 취급하는 법 이해
        assertEquals("Hello", exercise5())
    }

    @Test
    fun `exercise6 - 반공변성(in)`() {
        // [학습 목표] in 키워드를 사용하여 소비자 입장에서 상위 타입을 하위 타입으로 취급하는 법 이해
        assertEquals("Hello", exercise6())
    }

    @Test
    fun `exercise7 - 스타 프로젝션`() {
        // [학습 목표] 정확한 타입을 몰라도 모든 제네릭 타입을 안전하게 다루는 <*> 문법 이해
        assertEquals(3, exercise7(listOf(1, 2, 3)))
    }

    @Test
    fun `exercise8 - reified 타입 파라미터`() {
        // [학습 목표] 런타임에 소거되는 제네릭 타입을 유지하여 T::class 등을 사용할 수 있게 하는 법 이해
        assertEquals(listOf(true, false, true), exercise8())
    }

    @Test
    fun `exercise9 - 제네릭 확장 함수`() {
        // [학습 목표] 특정 제네릭 타입의 컬렉션 등에 공통적으로 적용되는 확장 기능 구현 이해
        val (first, second) = exercise9()
        assertEquals(2, first)
        assertEquals(null, second)
    }

    @Test
    fun `exercise10 - 타입 필터링`() {
        // [학습 목표] 혼합된 리스트에서 특정 타입의 요소만 안전하게 골라내는 법 이해
        assertEquals(listOf("a", "b", "c"), exercise10())
    }
}