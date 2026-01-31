package syntax.solutions.sol03

fun exercise1(a: Int, b: Int): Int = a + b

fun exercise2(a: Int, b: Int): Int = a * b

fun exercise3(name: String, greeting: String = "Hello"): String = "$greeting, $name!"

fun createUser(name: String, age: Int, city: String): String = "$name ($age) from $city"

fun exercise4(): String = createUser(city = "Seoul", name = "Kim", age = 25)

var sideEffectResult = ""
fun exercise5(message: String) {
    sideEffectResult = message
}

fun exercise6(vararg numbers: Int): Int = numbers.sum()

fun exercise7(text: String): String {
    fun reverse(s: String): String = s.reversed()
    return reverse(text)
}

fun String.addExclamation(): String = this + "!"

fun exercise8(text: String): String = text.addExclamation()

