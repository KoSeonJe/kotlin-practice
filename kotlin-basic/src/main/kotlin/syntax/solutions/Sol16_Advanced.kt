package syntax.solutions.sol16

import kotlin.reflect.full.memberProperties

// === Part 1: 연산자 오버로딩 ===

data class Vector(val x: Int, val y: Int) {
    operator fun plus(other: Vector): Vector = Vector(x + other.x, y + other.y)
    operator fun times(scalar: Int): Vector = Vector(x * scalar, y * scalar)
}

fun exercise1(): Vector = Vector(1, 2) + Vector(3, 4)

data class Money(val amount: Int) : Comparable<Money> {
    override operator fun compareTo(other: Money): Int = amount.compareTo(other.amount)
}

fun exercise2(): List<Boolean> {
    val m1 = Money(100)
    val m2 = Money(200)
    val isLess = m1 < m2
    val isGreater = m1 > m2
    val isEqual = m1 == Money(100)
    return listOf(isLess, isGreater, isEqual)
}

class Greeter(val greeting: String) {
    operator fun invoke(name: String): String = "$greeting, $name!"
}

fun exercise3(): String = Greeter("Hello")("Kotlin")

class Matrix(private val data: Array<IntArray>) {
    operator fun get(row: Int, col: Int): Int = data[row][col]
    operator fun set(row: Int, col: Int, value: Int) { data[row][col] = value }
}

fun exercise4(): Int {
    val matrix = Matrix(arrayOf(intArrayOf(1, 2), intArrayOf(3, 4)))
    matrix[0, 1] = 10
    return matrix[0, 1]
}

// === Part 2: infix 함수 ===

infix fun Int.power(exp: Int): Int {
    var result = 1
    repeat(exp) { result *= this }
    return result
}

fun exercise5(): Int = 2 power 10

// === Part 3: Type Alias ===

typealias StringMap = Map<String, String>
typealias Predicate<T> = (T) -> Boolean

fun exercise6(): Pair<String, Boolean> {
    val map: StringMap = mapOf("key" to "value")
    val isEven: Predicate<Int> = { it % 2 == 0 }
    return map["key"]!! to isEven(4)
}

// === Part 4: Value Class ===

@JvmInline
value class UserId(val id: Long)

@JvmInline
value class OrderId(val id: Long)

fun processUser(userId: UserId): String = "User: ${userId.id}"
fun processOrder(orderId: OrderId): String = "Order: ${orderId.id}"

fun exercise7(): Pair<String, String> =
    processUser(UserId(123)) to processOrder(OrderId(456))

// === Part 5: DSL ===

class HtmlBuilder {
    private val elements = mutableListOf<String>()

    fun p(text: String) { elements.add("<p>$text</p>") }

    fun div(block: HtmlBuilder.() -> Unit) {
        elements.add("<div>")
        this.block()
        elements.add("</div>")
    }

    fun build(): String = elements.joinToString("\n")
}

fun html(block: HtmlBuilder.() -> Unit): String = HtmlBuilder().apply(block).build()

fun exercise8(): String = html {
    p("Hello")
    div {
        p("World")
    }
}

// === Part 6: 리플렉션 ===

data class Person(val name: String, val age: Int)

fun exercise9(): List<String> = Person::class.memberProperties.map { it.name }

// === Part 7: Java 상호운용 ===

class JavaInterop {
    companion object {
        @JvmField
        val CONSTANT = "Kotlin Constant"

        @JvmStatic
        fun staticMethod(): String = "Called from Java"
    }
}

fun exercise10(): Pair<String, String> = JavaInterop.CONSTANT to JavaInterop.staticMethod()

