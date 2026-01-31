package syntax.exercises.ex10

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class Ex10_LambdasTest {
    @Test
    fun `exercise1 - 기본 람다 표현식`() {
        // [학습 목표] { a, b -> a + b } 형태의 기본적인 람다 선언과 함수 타입 이해
        assertEquals(8, exercise1()(3, 5))
    }

    @Test
    fun `exercise2 - it 키워드`() {
        // [학습 목표] 람다 파라미터가 하나일 때 명시적 선언 대신 사용할 수 있는 it 예약어 이해
        assertEquals("HELLO", exercise2()("hello"))
    }

    @Test
    fun `exercise3 - 고차 함수(High-order function)`() {
        // [학습 목표] 함수를 파라미터로 받거나 반환하는 고차 함수의 개념과 활용 이해
        assertEquals(listOf(2, 4, 6), exercise3(listOf(1, 2, 3)) { it * 2 })
    }

    @Test
    fun `exercise4 - 함수 타입 변수`() {
        // [학습 목표] 함수를 변수에 저장하고 호출하는 일급 객체로서의 함수 특징 이해
        assertEquals(20, exercise4())
    }

    @Test
    fun `exercise5 - 후행 람다(Trailing Lambda)`() {
        // [학습 목표] 함수의 마지막 인자가 람다인 경우 소괄호 밖으로 빼내어 코드 가독성을 높이는 법 이해
        assertEquals(15, exercise5())
    }

    @Test
    fun `exercise6 - 람다에서의 변수 캡처`() {
        // [학습 목표] 람다 외부의 가변 변수를 수정할 수 있는 클로저(Closure) 특징 이해
        assertEquals(15, exercise6())
    }

    @Test
    fun `exercise7 - 함수 참조`() {
        // [학습 목표] 람다 대신 기존에 정의된 함수를 ::연산자로 직접 전달하는 법 이해
        assertEquals(listOf(2, 4, 6), exercise7())
    }

    @Test
    fun `exercise8 - 익명 함수`() {
        // [학습 목표] 람다와 비슷하지만 return 문을 명시적으로 사용할 수 있는 익명 함수 문법 이해
        assertEquals(listOf(2, 4), exercise8())
    }

    @Test
    fun `exercise9 - 람다에서 레이블 return`() {
        // [학습 목표] return@label을 사용하여 고차 함수 내에서 제어 흐름을 관리하는 법 이해
        assertEquals(10, testExercise9())
    }

    @Test
    fun `exercise10 - inline 함수`() {
        // [학습 목표] 람다 호출 오버헤드를 줄이기 위해 본문을 호출 지점에 복사해 넣는 inline 이해
        assertTrue(exercise10())
    }

    @Test
    fun `exercise11 - noinline과 crossinline`() {
        // [학습 목표] inline 함수에서 일부 람다를 인라인화하지 않거나 비지역 반환을 금지하는 법 이해
        assertTrue(exercise11())
    }
}