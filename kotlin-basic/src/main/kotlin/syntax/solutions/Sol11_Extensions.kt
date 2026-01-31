package syntax.solutions.sol11

fun String.addBrackets(): String = "[$this]"

fun exercise1(): String = "Hello".addBrackets()

fun Int.isEven(): Boolean = this % 2 == 0

fun exercise2(): List<Boolean> = listOf(1, 2, 3, 4).map { it.isEven() }

fun <T> List<T>.secondOrNull(): T? = if (size >= 2) this[1] else null

fun exercise3(): Pair<Int?, Int?> =
    listOf(1, 2, 3).secondOrNull() to listOf(1).secondOrNull()

val String.lastChar: Char
    get() = this[length - 1]

fun exercise4(): Char = "Kotlin".lastChar

fun String?.orEmpty(): String = this ?: ""

fun exercise5(): List<String> {
    val s1: String? = "Hello"
    val s2: String? = null
    return listOf(s1.orEmpty(), s2.orEmpty())
}

class MyString(val value: String) {
    fun get(): String = "member: $value"
}

fun exercise6(): String = MyString("test").get()

class MyClass { companion object }

fun MyClass.Companion.create(value: Int): MyClass = MyClass()

fun exercise7(): Boolean = MyClass.create(42) is MyClass

fun buildString(action: StringBuilder.() -> Unit): String {
    val sb = StringBuilder()
    sb.action()
    return sb.toString()
}

fun exercise8(): String = buildString {
    append("Hello")
    append(", ")
    append("World!")
}

open class Parent
class Child : Parent()

fun Parent.greet() = "Parent"
fun Child.greet() = "Child"

fun exercise9(): String {
    val instance: Parent = Child()
    return instance.greet()  // "Parent" - 정적 타입 기준
}

fun String.removeSpaces(): String = this.replace(" ", "")

fun String.capitalizeWords(): String =
    split(" ").joinToString(" ") { it.replaceFirstChar { c -> c.uppercase() } }

fun exercise10(): String = "hello world".capitalizeWords()

