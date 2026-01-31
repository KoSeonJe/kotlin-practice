package syntax.exercises.ex15

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class Ex15_CoroutinesTest {
    @Test
    fun `exercise1 - suspend 함수 기초`() {
        // [학습 목표] 스레드를 차단하지 않고 일시 중단했다가 재개되는 비동기 함수 개념 이해
        assertEquals("Data loaded", exercise1())
    }

    @Test
    fun `exercise2 - launch 실행`() {
        // [학습 목표] 결과값을 반환하지 않는 비동기 작업을 독립적으로 실행(Fire and forget)하는 법 이해
        val result = exercise2()
        assertTrue(result.contains("Task 1") && result.contains("Task 2"))
    }

    @Test
    fun `exercise3 - async와 await`() {
        // [학습 목표] 비동기 작업의 결과를 기다려(Deferred) 값을 얻어오는 병렬 처리 방식 이해
        assertEquals(60, exercise3())
    }

    @Test
    fun `exercise4 - 병렬 실행 성능 비교`() {
        // [학습 목표] 순차 실행과 async를 통한 병렬 실행의 시간 효율성 차이 확인
        val (seq, par) = exercise4()
        assertTrue(seq > par)
    }

    @Test
    fun `exercise5 - Dispatchers 활용`() {
        // [학습 목표] CPU 작업(Default)이나 IO 작업 등 목적에 맞는 스레드 풀을 지정하는 법 이해
        val result = exercise5()
        assertTrue("Default" in result && "IO" in result)
    }

    @Test
    fun `exercise6 - 코루틴 취소`() {
        // [학습 목표] 실행 중인 작업을 안전하게 중단하고 자원을 정리하는 협력적 취소 이해
        assertEquals("Cancelled", exercise6())
    }

    @Test
    fun `exercise7 - 코루틴 스코프`() {
        // [학습 목표] 자식 코루틴이 모두 완료될 때까지 기다려주는 구조화된 동시성 이해
        assertEquals(listOf(2, 4, 6, 8, 10), exercise7())
    }

    @Test
    fun `exercise8 - Flow 기초`() {
        // [학습 목표] 시간에 따라 여러 데이터를 비동기적으로 스트림 형태로 내보내는 Flow 이해
        assertEquals(listOf(1, 2, 3), exercise8())
    }

    @Test
    fun `exercise9 - Flow 연산자`() {
        // [학습 목표] 비동기 데이터 스트림에 filter, map 등의 연산자를 적용하는 법 이해
        assertEquals(listOf(4, 16, 36), exercise9())
    }

    @Test
    fun `exercise10 - 코루틴 예외 처리`() {
        // [학습 목표] 비동기 작업 중 발생하는 예외를 안전하게 포착하고 처리하는 법 이해
        assertEquals("Error caught", exercise10())
    }
}