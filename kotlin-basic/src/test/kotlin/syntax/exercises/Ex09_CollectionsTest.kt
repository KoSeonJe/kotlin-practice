package syntax.exercises.ex09

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Ex09_CollectionsTest {
    @Test
    fun `exercise1 - 불변 vs 가변 리스트`() {
        // [학습 목표] 읽기 전용(listOf)과 수정 가능(mutableListOf) 컬렉션의 차이 및 변환법 이해
        val (original, modified) = exercise1()
        assertEquals(3, original)
        assertEquals(4, modified)
    }

    @Test
    fun `exercise2 - map 변환`() {
        // [학습 목표] 컬렉션의 각 요소를 특정 규칙에 따라 새로운 형태로 변환하는 map 연산 이해
        assertEquals(listOf(2, 4, 6), exercise2(listOf(1, 2, 3)))
    }

    @Test
    fun `exercise3 - filter 필터링`() {
        // [학습 목표] 조건에 맞는 요소만 걸러내어 새로운 컬렉션을 만드는 filter 연산 이해
        assertEquals(listOf(2, 4), exercise3(listOf(1, 2, 3, 4, 5)))
    }

    @Test
    fun `exercise4 - 컬렉션 체이닝`() {
        // [학습 목표] 여러 연산(filter, map 등)을 연속적으로 연결하여 복잡한 데이터를 처리하는 법 이해
        assertEquals(listOf("JOHNSON", "WILLIAMS"), exercise4(listOf("Kim", "Johnson", "Lee", "Williams")))
    }

    @Test
    fun `exercise5 - reduce와 fold`() {
        // [학습 목표] 컬렉션의 요소를 하나로 합치는 집계 연산(누적합 등) 이해
        val (sum, product) = exercise5(listOf(1, 2, 3, 4))
        assertEquals(10, sum)
        assertEquals(24, product)
    }

    @Test
    fun `exercise6 - groupBy`() {
        // [학습 목표] 특정 키를 기준으로 컬렉션을 그룹화하여 Map으로 만드는 법 이해
        val students = listOf(Student("Kim", 1), Student("Lee", 2), Student("Park", 1))
        val result = exercise6(students)
        assertEquals(listOf("Kim", "Park"), result[1])
        assertEquals(listOf("Lee"), result[2])
    }

    @Test
    fun `exercise7 - flatMap`() {
        // [학습 목표] 중첩된 컬렉션을 단일 컬렉션으로 평탄화하고 변환하는 법 이해
        assertEquals(listOf(1, 2, 3, 4), exercise7(listOf(listOf(1, 2), listOf(3, 4))))
    }

    @Test
    fun `exercise8 - 집합 연산`() {
        // [학습 목표] 합집합(union), 교집합(intersect), 차집합(subtract) 등 집합 연산 이해
        val (union, intersect, subtract) = exercise8(setOf(1, 2, 3), setOf(2, 3, 4))
        assertEquals(setOf(1, 2, 3, 4), union)
        assertEquals(setOf(2, 3), intersect)
        assertEquals(setOf(1), subtract)
    }

    @Test
    fun `exercise9 - associate`() {
        // [학습 목표] 요소를 키/값 쌍으로 만들어 Map을 생성하는 다양한 방법 이해
        val (byLength, toLength) = exercise9(listOf("a", "bb", "ccc"))
        assertEquals("a", byLength[1])
        assertEquals(2, toLength["bb"])
    }

    @Test
    fun `exercise10 - partition`() {
        // [학습 목표] 조건에 따라 컬렉션을 두 그룹(참/거짓)으로 한 번에 분리하는 법 이해
        val (neg, pos) = exercise10(listOf(-2, -1, 0, 1, 2))
        assertEquals(listOf(-2, -1), neg)
        assertEquals(listOf(0, 1, 2), pos)
    }

    @Test
    fun `exercise11 - 부분 추출`() {
        // [학습 목표] take, drop, chunked 등을 사용하여 컬렉션의 일부만 다루는 법 이해
        val (take, drop, chunked) = exercise11(listOf(1, 2, 3, 4, 5, 6))
        assertEquals(listOf(1, 2, 3), take)
        assertEquals(listOf(4, 5, 6), drop)
        assertEquals(listOf(listOf(1, 2), listOf(3, 4), listOf(5, 6)), chunked)
    }

    @Test
    fun `exercise12 - Sequence(지연 평가)`() {
        // [학습 목표] 대량 데이터 처리 시 성능 향상을 위해 필요한 시점까지 연산을 미루는 시퀀스 이해
        assertEquals(120, exercise12(listOf(50, 80, 120, 150)))
    }
}