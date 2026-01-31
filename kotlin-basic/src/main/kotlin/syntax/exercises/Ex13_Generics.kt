package syntax.exercises.ex13

/**
 * [실습 목적] 제네릭과 Variance(공변/반공변)의 이해
 * [학습 키워드] <T>, out (공변), in (반공변), reified, where
 * [Java 비교] ? extends T → out T, ? super T → in T
 */

// TODO 1: 기본 제네릭 클래스
// 힌트: class Name<T>(val value: T)
class Box<T>(val value: T) {
    fun get(): T = value
}

fun exercise1(): Pair<String, Int> {
    // Box<String>과 Box<Int> 생성
    val stringBox = Box("Hello")
    val intBox = Box(42)
    TODO("기본 제네릭")
    // (stringBox.get(), intBox.get()) 반환
}

// TODO 2: 제네릭 함수
// 힌트: fun <T> name(param: T): T
fun <T> identity(value: T): T {
    TODO("제네릭 함수")
    // value 그대로 반환
}

fun exercise2(): List<Any> {
    return listOf(
        identity("Hello"),
        identity(42),
        identity(3.14)
    )
}

// TODO 3: 타입 제약 (upper bound)
// 힌트: <T : Number>
fun <T : Number> double(value: T): Double {
    TODO("타입 제약")
    // value.toDouble() * 2
}

fun exercise3(): List<Double> {
    return listOf(
        double(5),
        double(3.14),
        double(10L)
    )
}

// TODO 4: where 절로 다중 제약
// 힌트: where T : A, T : B
interface Printable {
    fun print(): String
}

fun <T> printIfPossible(value: T): String where T : Comparable<T>, T : Printable {
    TODO("다중 제약")
    // value.print() 반환
}

class PrintableInt(val value: Int) : Comparable<PrintableInt>, Printable {
    override fun compareTo(other: PrintableInt) = value.compareTo(other.value)
    override fun print() = "Value: $value"
}

fun exercise4(): String {
    return printIfPossible(PrintableInt(42))  // "Value: 42"
}

// TODO 5: out - 공변 (생산자)
// 힌트: Producer<out T> - T를 반환만 함
interface Producer<out T> {
    fun produce(): T
}

class StringProducer : Producer<String> {
    override fun produce() = "Hello"
}

fun exercise5(): String {
    // Producer<String>을 Producer<Any>에 할당 가능
    val producer: Producer<Any> = StringProducer()
    TODO("공변 out")
    // producer.produce() as String 반환
}

// TODO 6: in - 반공변 (소비자)
// 힌트: Consumer<in T> - T를 받기만 함
interface Consumer<in T> {
    fun consume(item: T)
}

class AnyConsumer : Consumer<Any> {
    var lastConsumed: Any? = null
    override fun consume(item: Any) {
        lastConsumed = item
    }
}

fun exercise6(): Any? {
    // Consumer<Any>를 Consumer<String>에 할당 가능
    val consumer: Consumer<String> = AnyConsumer()
    consumer.consume("Hello")
    TODO("반공변 in")
    // (consumer as AnyConsumer).lastConsumed 반환
}

// TODO 7: 스타 프로젝션
// 힌트: List<*> - 어떤 타입인지 모름
fun exercise7(list: List<*>): Int {
    TODO("스타 프로젝션")
    // list.size 반환
}

// TODO 8: reified 타입 파라미터
// 힌트: inline fun <reified T> - 런타임에 타입 정보 유지
inline fun <reified T> isType(value: Any): Boolean {
    TODO("reified")
    // value is T 반환
}

fun exercise8(): List<Boolean> {
    return listOf(
        isType<String>("Hello"),
        isType<Int>("Hello"),
        isType<Int>(42)
    )  // [true, false, true]
}

// TODO 9: 제네릭 확장 함수
// 힌트: fun <T> List<T>.함수명()
fun <T> List<T>.secondOrNull(): T? {
    TODO("제네릭 확장 함수")
    // 인덱스 1의 요소 또는 null
}

fun exercise9(): Pair<Int?, String?> {
    return listOf(1, 2, 3).secondOrNull() to listOf("a").secondOrNull()
}

// TODO 10: 타입 소거와 제한
// 힌트: 런타임에 제네릭 타입 정보 소거됨
inline fun <reified T> filterByType(list: List<Any>): List<T> {
    TODO("타입 필터링")
    // list.filterIsInstance<T>() 반환
}

fun exercise10(): List<String> {
    val mixed = listOf("a", 1, "b", 2, "c")
    return filterByType<String>(mixed)  // ["a", "b", "c"]
}

