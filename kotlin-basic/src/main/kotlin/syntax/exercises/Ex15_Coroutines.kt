package syntax.exercises.ex15

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import kotlin.system.measureTimeMillis

/**
 * [실습 목적] 코루틴 기초와 비동기 프로그래밍 이해
 * [학습 키워드] suspend, launch, async, await, Dispatchers, Flow
 * [Java 비교] 비동기 프로그래밍 언어 차원 지원, 콜백 헬 해결
 */

// TODO 1: suspend 함수 기초
// 힌트: suspend fun - 일시 중단 가능한 함수
suspend fun fetchData(): String {
    delay(100)  // 비동기 대기
    TODO("suspend 함수")
    // "Data loaded" 반환
}

fun exercise1(): String = runBlocking {
    fetchData()
}

// TODO 2: launch - Fire and forget
// 힌트: launch { } - Job 반환, 결과 없음
fun exercise2(): List<String> = runBlocking {
    val results = mutableListOf<String>()

    TODO("launch 사용")
    // launch로 "Task 1", "Task 2" 순서대로 results에 추가
    // 각 작업 사이에 delay(50) 추가

    delay(200)  // 모든 작업 완료 대기
    results
}

// TODO 3: async/await - 결과 반환
// 힌트: async { } - Deferred 반환, await()로 결과 획득
suspend fun computeValue(x: Int): Int {
    delay(100)
    return x * 2
}

fun exercise3(): Int = runBlocking {
    TODO("async/await")
    // async로 computeValue(10)과 computeValue(20) 병렬 실행
    // 두 결과의 합 반환 (60)
}

// TODO 4: 병렬 실행 성능 비교
// 힌트: 순차 vs 병렬 실행 시간 차이
suspend fun slowTask(): Int {
    delay(100)
    return 1
}

fun exercise4(): Pair<Long, Long> = runBlocking {
    // 순차 실행 시간 측정
    val sequentialTime = measureTimeMillis {
        slowTask()
        slowTask()
        slowTask()
    }

    // 병렬 실행 시간 측정
    val parallelTime = measureTimeMillis {
        TODO("병렬 실행")
        // 3개의 slowTask를 async로 병렬 실행
    }

    sequentialTime to parallelTime
    // 순차: ~300ms, 병렬: ~100ms
}

// TODO 5: Dispatchers
// 힌트: Dispatchers.Default, Dispatchers.IO, Dispatchers.Main
fun exercise5(): List<String> = runBlocking {
    val results = mutableListOf<String>()

    TODO("Dispatchers")
    // withContext(Dispatchers.Default)로 CPU 작업
    // withContext(Dispatchers.IO)로 IO 작업
    // 각각 "Default", "IO"를 results에 추가

    results
}

// TODO 6: 코루틴 취소
// 힌트: job.cancel(), isActive 체크
fun exercise6(): String = runBlocking {
    var result = "Not cancelled"

    val job = launch {
        try {
            repeat(1000) {
                delay(10)
            }
            result = "Completed"
        } catch (e: CancellationException) {
            TODO("취소 처리")
            // result = "Cancelled"
        }
    }

    delay(50)
    job.cancel()
    job.join()

    result
}

// TODO 7: 코루틴 스코프
// 힌트: coroutineScope { } - 구조화된 동시성
suspend fun processItems(items: List<Int>): List<Int> = coroutineScope {
    TODO("코루틴 스코프")
    // items.map { async { it * 2 } }.awaitAll()
}

fun exercise7(): List<Int> = runBlocking {
    processItems(listOf(1, 2, 3, 4, 5))  // [2, 4, 6, 8, 10]
}

// TODO 8: Flow 기초
// 힌트: flow { emit() } - 콜드 스트림
fun numberFlow(): Flow<Int> = flow {
    TODO("Flow emit")
    // 1, 2, 3 순서대로 emit
}

fun exercise8(): List<Int> = runBlocking {
    val results = mutableListOf<Int>()
    numberFlow().collect { results.add(it) }
    results
}

// TODO 9: Flow 연산자
// 힌트: map, filter, take 등
fun exercise9(): List<Int> = runBlocking {
    TODO("Flow 연산자")
    // (1..10).asFlow()
    //   .filter { it % 2 == 0 }  // 짝수만
    //   .map { it * it }         // 제곱
    //   .take(3)                 // 처음 3개
    //   .toList()
    // [4, 16, 36]
}

// TODO 10: 예외 처리
// 힌트: try-catch, supervisorScope
fun exercise10(): String = runBlocking {
    TODO("예외 처리")
    // try-catch로 예외 잡기
    // 실패 시 "Error caught" 반환
}

