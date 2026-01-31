package syntax.solutions.sol08

import kotlin.math.PI

open class Animal(val name: String) {
    open fun sound(): String = "..."
}

class Dog(name: String) : Animal(name) {
    override fun sound(): String = "Woof!"
}

fun exercise1(): String {
    val dog = Dog("Buddy")
    return "${dog.name}: ${dog.sound()}"
}

abstract class Shape {
    abstract fun area(): Double
}

class Circle(val radius: Double) : Shape() {
    override fun area(): Double = PI * radius * radius
}

fun exercise2(): Double = Circle(5.0).area()

interface Flyable { fun fly(): String }
interface Swimmable { fun swim(): String }

class Duck : Flyable, Swimmable {
    override fun fly(): String = "Flying!"
    override fun swim(): String = "Swimming!"
}

fun exercise3(): Pair<String, String> {
    val duck = Duck()
    return duck.fly() to duck.swim()
}

interface Printable {
    val prefix: String get() = ">"
    fun print(message: String): String = "$prefix $message"
}

class ConsolePrinter : Printable {
    override val prefix: String = "[LOG]"
}

fun exercise4(): String = ConsolePrinter().print("Hello")

sealed class Result {
    data class Success(val data: String) : Result()
    data class Error(val message: String) : Result()
    data object Loading : Result()
}

fun exercise5(result: Result): String = when (result) {
    is Result.Success -> "Data: ${result.data}"
    is Result.Error -> "Error: ${result.message}"
    is Result.Loading -> "Loading..."
}

sealed interface UiState {
    data class Content(val items: List<String>) : UiState
    data class Error(val throwable: Throwable) : UiState
    data object Empty : UiState
}

fun exercise6(state: UiState): Int = when (state) {
    is UiState.Content -> state.items.size
    is UiState.Error -> -1
    is UiState.Empty -> 0
}

interface A { fun greet(): String = "Hello from A" }
interface B { fun greet(): String = "Hello from B" }

class C : A, B {
    override fun greet(): String = "A: ${super<A>.greet()}, B: ${super<B>.greet()}"
}

fun exercise7(): String = C().greet()

