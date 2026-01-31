package syntax.solutions.sol05

class Person1(val name: String, val age: Int)

fun exercise1(): String {
    val person = Person1("Kotlin", 10)
    return "${person.name} is ${person.age} years old"
}

class Person2(name: String, age: Int) {
    val upperName: String
    val isAdult: Boolean

    init {
        upperName = name.uppercase()
        isAdult = age >= 18
    }
}

fun exercise2(): Pair<String, Boolean> {
    val person = Person2("kotlin", 20)
    return person.upperName to person.isAdult
}

class Temperature {
    var celsius: Double = 0.0

    val fahrenheit: Double
        get() = celsius * 9 / 5 + 32
}

fun exercise3(): Double {
    val temp = Temperature()
    temp.celsius = 100.0
    return temp.fahrenheit
}

class Rectangle(val width: Int, val height: Int) {
    constructor(size: Int) : this(size, size)

    fun area() = width * height
}

fun exercise4(): Int {
    val square = Rectangle(5)
    return square.area()
}

class BankAccount(initialBalance: Int) {
    private var balance: Int = initialBalance

    fun getBalance(): Int = balance

    fun deposit(amount: Int) {
        balance += amount
    }

    fun withdraw(amount: Int): Boolean {
        return if (balance >= amount) {
            balance -= amount
            true
        } else {
            false
        }
    }
}

fun exercise5(): Int {
    val account = BankAccount(1000)
    account.deposit(500)
    account.withdraw(200)
    return account.getBalance()
}

class Outer(val value: Int) {
    class Nested {
        fun getValue() = 10
    }

    inner class Inner {
        fun getValue() = value
    }
}

fun exercise6(): Pair<Int, Int> {
    val outer = Outer(20)
    val nested = Outer.Nested()
    val inner = outer.Inner()
    return nested.getValue() to inner.getValue()
}

