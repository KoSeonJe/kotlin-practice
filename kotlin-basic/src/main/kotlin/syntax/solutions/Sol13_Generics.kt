package syntax.solutions.sol13

class Box<T>(val value: T) {
    fun get(): T = value
}

fun exercise1(): Pair<String, Int> {
    val stringBox = Box("Hello")
    val intBox = Box(42)
    return stringBox.get() to intBox.get()
}

fun <T> identity(value: T): T = value

fun exercise2(): List<Any> = listOf(identity("Hello"), identity(42), identity(3.14))

fun <T : Number> double(value: T): Double = value.toDouble() * 2

fun exercise3(): List<Double> = listOf(double(5), double(3.14), double(10L))

interface Printable { fun print(): String }

fun <T> printIfPossible(value: T): String where T : Comparable<T>, T : Printable = value.print()

class PrintableInt(val value: Int) : Comparable<PrintableInt>, Printable {
    override fun compareTo(other: PrintableInt) = value.compareTo(other.value)
    override fun print() = "Value: $value"
}

fun exercise4(): String = printIfPossible(PrintableInt(42))

interface Producer<out T> { fun produce(): T }
class StringProducer : Producer<String> {
    override fun produce() = "Hello"
}

fun exercise5(): String {
    val producer: Producer<Any> = StringProducer()
    return producer.produce() as String
}

interface Consumer<in T> { fun consume(item: T) }
class AnyConsumer : Consumer<Any> {
    var lastConsumed: Any? = null
    override fun consume(item: Any) { lastConsumed = item }
}

fun exercise6(): Any? {
    val consumer: Consumer<String> = AnyConsumer()
    consumer.consume("Hello")
    return (consumer as AnyConsumer).lastConsumed
}

fun exercise7(list: List<*>): Int = list.size

inline fun <reified T> isType(value: Any): Boolean = value is T

fun exercise8(): List<Boolean> = listOf(isType<String>("Hello"), isType<Int>("Hello"), isType<Int>(42))

fun <T> List<T>.secondOrNull(): T? = if (size >= 2) this[1] else null

fun exercise9(): Pair<Int?, String?> =
    listOf(1, 2, 3).secondOrNull() to listOf("a").secondOrNull()

inline fun <reified T> filterByType(list: List<Any>): List<T> = list.filterIsInstance<T>()

fun exercise10(): List<String> = filterByType<String>(listOf("a", 1, "b", 2, "c"))

