package syntax.solutions.sol12

fun exercise1(name: String?): String =
    name?.let { "Hello, $it!" } ?: "Hello, Guest!"

fun exercise2(numbers: List<Int>): List<Int> =
    numbers.let { it.sorted() }

class Configuration {
    var host: String = ""
    var port: Int = 0
    fun connectionString() = "$host:$port"
}

fun exercise3(): String = Configuration().run {
    host = "localhost"
    port = 8080
    connectionString()
}

fun exercise4(sb: StringBuilder): String = with(sb) {
    append("Hello")
    append(" ")
    append("World")
    toString()
}

data class Person(var name: String = "", var age: Int = 0, var city: String = "")

fun exercise5(): Person = Person().apply {
    name = "Kim"
    age = 30
    city = "Seoul"
}

var loggedValue: String = ""

fun exercise6(value: String): String =
    value.uppercase().also { loggedValue = it }.reversed()

data class Order(var id: Int = 0, var items: MutableList<String> = mutableListOf(), var total: Double = 0.0)

fun exercise7(): Pair<Order, String> {
    val order = Order().apply {
        id = 1
        items.add("Laptop")
        items.add("Mouse")
    }
    val summary = order.run { "Order #$id: ${items.size} items" }
    return order to summary
}

fun exercise8(number: Int): Int? = number.takeIf { it > 0 }

class Counter(private var _count: Int = 0) {
    fun increment() { _count++ }
    fun value() = _count
}

fun exercise9(): Pair<Int, Int> {
    val letResult = Counter().let {
        it.increment()
        it.increment()
        it.value()
    }
    val runResult = Counter().run {
        increment()
        increment()
        increment()
        value()
    }
    return letResult to runResult
}

data class Email(
    var to: String = "",
    var subject: String = "",
    var body: String = "",
    var cc: MutableList<String> = mutableListOf()
)

fun exercise10(): Email = Email().apply {
    to = "user@test.com"
    subject = "Hello"
    body = "This is a test email"
    cc.add("manager@test.com")
}

