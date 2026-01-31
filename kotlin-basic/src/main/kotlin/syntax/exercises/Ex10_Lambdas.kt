package syntax.exercises.ex10

/**
 * [실습 목적] 람다와 고차 함수의 이해
 * [학습 키워드] ->, it, 함수 타입, 후행 람다, inline
 * [Java 비교] 람다가 일급 객체, 클로저에서 외부 변수 수정 가능
 */

// TODO 1: 기본 람다 표현식
// 힌트: { 파라미터 -> 본문 }
fun exercise1(): (Int, Int) -> Int {
    // 두 수를 더하는 람다 반환
    TODO("기본 람다")
}

// TODO 2: it 키워드
// 힌트: 파라미터가 하나일 때 it으로 참조
fun exercise2(): (String) -> String {
    // 문자열을 대문자로 변환하는 람다 반환
    TODO("it 키워드")
}

// TODO 3: 고차 함수 정의
// 힌트: 함수를 파라미터로 받는 함수
fun exercise3(list: List<Int>, transform: (Int) -> Int): List<Int> {
    // list의 각 요소에 transform 적용
    TODO("고차 함수")
}

// TODO 4: 함수 타입 변수
// 힌트: val f: (Type) -> ReturnType = { }
fun exercise4(): Int {
    // 함수 타입 변수 선언하고 호출
    // val multiply: (Int, Int) -> Int = { a, b -> a * b }
    TODO("함수 타입 변수")
}

// TODO 5: 후행 람다 (Trailing Lambda)
// 힌트: 마지막 파라미터가 람다일 때 괄호 밖으로
fun runOperation(a: Int, b: Int, operation: (Int, Int) -> Int): Int {
    return operation(a, b)
}

fun exercise5(): Int {
    // runOperation을 후행 람다 문법으로 호출
    // 5와 3의 곱 계산
    TODO("후행 람다")
}

// TODO 6: 람다에서 외부 변수 캡처
// 힌트: 클로저 - 외부 변수 수정 가능 (Java와 다름!)
fun exercise6(): Int {
    var counter = 0
    val numbers = listOf(1, 2, 3, 4, 5)
    // numbers.forEach로 counter에 합계 누적
    TODO("클로저")
}

// TODO 7: 함수 참조
// 힌트: ::함수명
fun double(x: Int): Int = x * 2

fun exercise7(): List<Int> {
    val numbers = listOf(1, 2, 3)
    // ::double 함수 참조 사용하여 map
    TODO("함수 참조")
}

// TODO 8: 익명 함수
// 힌트: fun(파라미터): 반환타입 { }
fun exercise8(): List<Int> {
    val numbers = listOf(1, 2, 3, 4, 5)
    // 익명 함수로 짝수 필터링
    // filter(fun(x: Int): Boolean { return x % 2 == 0 })
    TODO("익명 함수")
}

// TODO 9: 람다에서 return
// 힌트: 레이블 return, 비지역 반환
fun exercise9(numbers: List<Int>): Int {
    var sum = 0
    numbers.forEach { num ->
        if (num < 0) return@forEach  // continue처럼 동작
        sum += num
    }
    return sum
}

// 테스트용 - 위 함수 직접 호출
fun testExercise9(): Int {
    return exercise9(listOf(1, 2, -1, 3, -2, 4))  // 10 예상 (음수 제외)
}

// TODO 10: inline 함수
// 힌트: inline fun - 람다 오버헤드 제거
inline fun measureTime(block: () -> Unit): Long {
    val start = System.currentTimeMillis()
    block()
    return System.currentTimeMillis() - start
}

fun exercise10(): Boolean {
    val time = measureTime {
        Thread.sleep(10)  // 최소 10ms
    }
    TODO("inline 함수")
    // time >= 10이면 true 반환
}

// TODO 11: noinline과 crossinline
// 힌트: inline 함수에서 일부 람다만 인라인 제외
inline fun complexOperation(
    noinline notInlined: () -> Unit,  // 저장 가능
    crossinline inlined: () -> Unit   // 비지역 반환 불가
): () -> Unit {
    return {
        notInlined()
        inlined()
    }
}

fun exercise11(): Boolean {
    var called1 = false
    var called2 = false
    val combined = complexOperation(
        { called1 = true },
        { called2 = true }
    )
    combined()
    TODO("noinline/crossinline")
    // called1과 called2가 모두 true면 true 반환
}

