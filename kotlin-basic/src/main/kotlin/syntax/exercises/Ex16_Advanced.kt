package syntax.exercises.ex16

import kotlin.reflect.full.memberProperties

/**
 * [실습 목적] 고급 주제: 연산자 오버로딩, DSL, Type Alias, Value Class, Java 상호운용
 * [학습 키워드] operator, infix, typealias, @JvmInline, value class, @JvmStatic
 * [Java 비교] Java는 연산자 오버로딩 불가, Kotlin만의 DSL 구축 가능
 */

// === Part 1: 연산자 오버로딩 ===

// TODO 1: plus 연산자 오버로딩
// 힌트: operator fun plus(other: Type): Type
data class Vector(val x: Int, val y: Int) {
    operator fun plus(other: Vector): Vector {
        TODO("plus 연산자")
        // Vector(x + other.x, y + other.y)
    }

    operator fun times(scalar: Int): Vector {
        TODO("times 연산자")
        // Vector(x * scalar, y * scalar)
    }
}

fun exercise1(): Vector {
    val v1 = Vector(1, 2)
    val v2 = Vector(3, 4)
    return v1 + v2  // Vector(4, 6)
}

// TODO 2: 비교 연산자
// 힌트: operator fun compareTo(other: Type): Int
data class Money(val amount: Int) : Comparable<Money> {
    override operator fun compareTo(other: Money): Int {
        TODO("compareTo")
        // amount.compareTo(other.amount)
    }
}

fun exercise2(): List<Boolean> {
    val m1 = Money(100)
    val m2 = Money(200)
    TODO("비교 연산자 테스트")
    // return listOf(m1 < m2, m1 > m2, m1 == Money(100))  // [true, false, true]
}

// TODO 3: invoke 연산자
// 힌트: operator fun invoke(...): ...
class Greeter(val greeting: String) {
    operator fun invoke(name: String): String {
        TODO("invoke 연산자")
        // "$greeting, $name!"
    }
}

fun exercise3(): String {
    val greeter = Greeter("Hello")
    return greeter("Kotlin")  // "Hello, Kotlin!"
}

// TODO 4: get/set 연산자 (인덱싱)
// 힌트: operator fun get(index: Int), operator fun set(index: Int, value: T)
class Matrix(private val data: Array<IntArray>) {
    operator fun get(row: Int, col: Int): Int {
        TODO("get 연산자")
        // data[row][col]
    }

    operator fun set(row: Int, col: Int, value: Int) {
        TODO("set 연산자")
        // data[row][col] = value
    }
}

fun exercise4(): Int {
    val matrix = Matrix(arrayOf(intArrayOf(1, 2), intArrayOf(3, 4)))
    matrix[0, 1] = 10
    return matrix[0, 1]  // 10
}

// === Part 2: infix 함수 ===

// TODO 5: infix 함수
// 힌트: infix fun Type.name(param): ReturnType
infix fun Int.power(exp: Int): Int {
    TODO("infix 함수")
    // this의 exp 제곱 (간단히 반복 곱셈)
}

fun exercise5(): Int {
    return 2 power 10  // 1024
}

// === Part 3: Type Alias ===

// TODO 6: typealias
// 힌트: typealias NewName = ExistingType
typealias StringMap = Map<String, String>
typealias Predicate<T> = (T) -> Boolean

fun exercise6(): Pair<String, Boolean> {
    val map: StringMap = mapOf("key" to "value")
    val isEven: Predicate<Int> = { it % 2 == 0 }
    TODO("typealias 사용")
    // (map["key"]!!, isEven(4)) 반환
}

// === Part 4: Value Class ===

// TODO 7: value class (인라인 클래스)
// 힌트: @JvmInline value class - 런타임 오버헤드 없이 타입 안전성
@JvmInline
value class UserId(val id: Long)

@JvmInline
value class OrderId(val id: Long)

fun processUser(userId: UserId): String = "User: ${userId.id}"
fun processOrder(orderId: OrderId): String = "Order: ${orderId.id}"

fun exercise7(): Pair<String, String> {
    val userId = UserId(123)
    val orderId = OrderId(456)
    // 컴파일 에러: processUser(orderId)  // 타입 불일치!
    TODO("value class")
    // (processUser(userId), processOrder(orderId)) 반환
}

// === Part 5: DSL 기초 ===

// TODO 8: 람다 with receiver를 이용한 DSL
// 힌트: fun build(block: Builder.() -> Unit)
class HtmlBuilder {
    private val elements = mutableListOf<String>()

    fun p(text: String) {
        elements.add("<p>$text</p>")
    }

    fun div(block: HtmlBuilder.() -> Unit) {
        elements.add("<div>")
        this.block()
        elements.add("</div>")
    }

    fun build(): String = elements.joinToString("\n")
}

fun html(block: HtmlBuilder.() -> Unit): String {
    return HtmlBuilder().apply(block).build()
}

fun exercise8(): String {
    TODO("DSL 사용")
    // html {
    //     p("Hello")
    //     div {
    //         p("World")
    //     }
    // }
}

// === Part 6: 리플렉션 기초 ===

// TODO 9: KClass 참조
// 힌트: ::class, KClass
data class Person(val name: String, val age: Int)

fun exercise9(): List<String> {
    val klass = Person::class
    TODO("리플렉션")
    // klass.memberProperties.map { it.name } 반환
}

// === Part 7: Java 상호운용 어노테이션 ===

// TODO 10: @JvmStatic, @JvmField
// 힌트: Java에서 정적 메서드/필드처럼 접근 가능
class JavaInterop {
    companion object {
        @JvmField
        val CONSTANT = "Kotlin Constant"

        @JvmStatic
        fun staticMethod(): String = "Called from Java"
    }
}

fun exercise10(): Pair<String, String> {
    TODO("Java 상호운용")
    // (JavaInterop.CONSTANT, JavaInterop.staticMethod()) 반환
}

