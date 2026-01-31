package syntax.solutions.sol01

const val MAX_COUNT = 100

fun exercise1(): String {
    val message = "Hello, Kotlin!"
    return message
}

fun exercise2(): Int {
    var number = 10
    number = 20
    return number
}

fun exercise3(): Double {
    val pi: Double = 3.14
    return pi
}

class UserProfile {
    private lateinit var _name: String

    fun initialize(userName: String) {
        _name = userName
    }

    fun fetchName(): String = _name
}

fun exercise5(): Int = MAX_COUNT

