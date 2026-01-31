package syntax.exercises.ex12

/**
 * [실습 목적] 스코프 함수(let, run, with, apply, also)의 이해와 적절한 사용
 * [학습 키워드] let, run, with, apply, also, this vs it
 * [Java 비교] Kotlin 고유 기능, 체이닝과 가독성 향상
 *
 * | 함수  | 객체 참조 | 반환값     | 주요 용도            |
 * |-------|----------|------------|---------------------|
 * | let   | it       | 람다 결과  | null 체크, 변환      |
 * | run   | this     | 람다 결과  | 설정 + 계산          |
 * | with  | this     | 람다 결과  | 그룹화된 함수 호출   |
 * | apply | this     | 객체 자신  | 객체 초기화          |
 * | also  | it       | 객체 자신  | 부수 효과 (로깅)     |
 */

// TODO 1: let - null 체크
// 힌트: ?.let { } 패턴
fun exercise1(name: String?): String {
    // name이 null이 아니면 "Hello, $name!" 반환
    // null이면 "Hello, Guest!" 반환
    TODO("let null 체크")
}

// TODO 2: let - 변환
// 힌트: 값 변환에 사용
fun exercise2(numbers: List<Int>): List<Int> {
    // 리스트를 받아서 let으로 필터링 후 정렬
    return numbers.let {
        TODO("let 변환")
    }
}

// TODO 3: run - 객체 설정 + 결과 반환
// 힌트: this로 참조, 마지막 표현식 반환
class Configuration {
    var host: String = ""
    var port: Int = 0
    fun connectionString() = "$host:$port"
}

fun exercise3(): String {
    // run으로 Configuration 설정하고 connectionString() 반환
    return Configuration().run {
        TODO("run 사용")
    }
}

// TODO 4: with - 그룹화된 호출
// 힌트: with(객체) { } 형태, 멤버 여러 번 호출 시 유용
fun exercise4(sb: StringBuilder): String {
    // with로 StringBuilder에 여러 작업 수행
    // "Hello", " ", "World" 순서로 append
    return with(sb) {
        TODO("with 사용")
    }
}

// TODO 5: apply - 객체 초기화
// 힌트: this로 참조, 객체 자신 반환
data class Person(var name: String = "", var age: Int = 0, var city: String = "")

fun exercise5(): Person {
    // apply로 Person 초기화
    return Person().apply {
        TODO("apply 사용")
        // name = "Kim", age = 30, city = "Seoul"
    }
}

// TODO 6: also - 부수 효과
// 힌트: it으로 참조, 객체 자신 반환, 로깅/디버깅에 유용
var loggedValue: String = ""

fun exercise6(value: String): String {
    // also로 로깅(loggedValue에 저장)하면서 체이닝
    return value
        .uppercase()
        .also { TODO("also 사용") }  // loggedValue = it
        .reversed()
}

// TODO 7: 스코프 함수 체이닝
// 힌트: 여러 스코프 함수 조합
data class Order(var id: Int = 0, var items: MutableList<String> = mutableListOf(), var total: Double = 0.0)

fun exercise7(): Pair<Order, String> {
    val order = Order()
        .apply {
            id = 1
            items.add("Laptop")
            items.add("Mouse")
        }
        .also {
            // 로깅 시뮬레이션
        }

    val summary = order.run {
        "Order #$id: ${items.size} items"
    }

    TODO("스코프 함수 체이닝")
    // (order, summary) 반환
}

// TODO 8: takeIf / takeUnless
// 힌트: 조건에 따라 객체 반환 또는 null
fun exercise8(number: Int): Int? {
    // number가 양수면 반환, 아니면 null
    return number.takeIf { TODO("takeIf") }
}

// TODO 9: let vs run 비교
// 힌트: let은 it, run은 this
class Counter(private var _count: Int = 0) {
    fun increment() { _count++ }
    fun value() = _count
}

fun exercise9(): Pair<Int, Int> {
    // let 사용: it으로 참조
    val letResult = Counter().let {
        it.increment()
        it.increment()
        it.value()
    }

    // run 사용: this로 참조
    val runResult = Counter().run {
        increment()
        increment()
        increment()
        value()
    }

    TODO("let vs run")
    // (letResult, runResult) 반환 - (2, 3)
}

// TODO 10: 실전 예제 - Builder 패턴 대체
// 힌트: apply로 간결하게
data class Email(
    var to: String = "",
    var subject: String = "",
    var body: String = "",
    var cc: MutableList<String> = mutableListOf()
)

fun exercise10(): Email {
    // apply를 사용하여 Email 객체 생성
    TODO("Builder 패턴 대체")
    // to = "user@test.com"
    // subject = "Hello"
    // body = "This is a test email"
    // cc에 "manager@test.com" 추가
}

