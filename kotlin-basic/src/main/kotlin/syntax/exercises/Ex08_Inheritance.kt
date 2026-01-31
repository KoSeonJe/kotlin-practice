package syntax.exercises.ex08

/**
 * [실습 목적] Kotlin 상속과 인터페이스 시스템 이해
 * [학습 키워드] open, abstract, override, interface, sealed class
 * [Java 비교] 클래스 기본 final, extends/implements → :
 */

// TODO 1: open 클래스와 상속
// 힌트: class는 기본 final, open으로 상속 허용
open class Animal(val name: String) {
    open fun sound(): String = "..."
}

class Dog(name: String) : Animal(name) {
    // TODO: sound() 오버라이드하여 "Woof!" 반환
}

fun exercise1(): String {
    val dog = Dog("Buddy")
    return "${dog.name}: ${dog.sound()}"
}

// TODO 2: abstract 클래스
// 힌트: 인스턴스화 불가, 추상 멤버 정의
abstract class Shape {
    abstract fun area(): Double
    fun describe(): String = "This is a ${this::class.simpleName}"
}

class Circle(val radius: Double) : Shape() {
    // TODO: area() 구현 (π * r²)
    override fun area(): Double = TODO("Circle area")
}

fun exercise2(): Double {
    val circle = Circle(5.0)
    return circle.area()  // 약 78.54
}

// TODO 3: 인터페이스 구현
// 힌트: interface, 다중 구현 가능
interface Flyable {
    fun fly(): String
}

interface Swimmable {
    fun swim(): String
}

class Duck : Flyable, Swimmable {
    // TODO: fly()와 swim() 구현
    override fun fly(): String = TODO("fly")
    override fun swim(): String = TODO("swim")
}

fun exercise3(): Pair<String, String> {
    val duck = Duck()
    return duck.fly() to duck.swim()
}

// TODO 4: 인터페이스 기본 구현
// 힌트: interface에서도 기본 메서드 구현 가능
interface Printable {
    val prefix: String get() = ">"  // 기본 구현
    fun print(message: String): String = "$prefix $message"
}

class ConsolePrinter : Printable {
    // TODO: prefix를 "[LOG]"로 오버라이드
}

fun exercise4(): String {
    val printer = ConsolePrinter()
    return printer.print("Hello")  // "[LOG] Hello"
}

// TODO 5: sealed class
// 힌트: 상속 계층 제한, when과 함께 사용
sealed class Result {
    data class Success(val data: String) : Result()
    data class Error(val message: String) : Result()
    data object Loading : Result()
}

fun exercise5(result: Result): String {
    // when으로 모든 케이스 처리
    // Success -> "Data: ${data}"
    // Error -> "Error: ${message}"
    // Loading -> "Loading..."
    TODO("sealed class when")
}

// TODO 6: sealed interface
// 힌트: sealed interface도 가능 (Kotlin 1.5+)
sealed interface UiState {
    data class Content(val items: List<String>) : UiState
    data class Error(val throwable: Throwable) : UiState
    data object Empty : UiState
}

fun exercise6(state: UiState): Int {
    // Content -> items 개수
    // Error -> -1
    // Empty -> 0
    TODO("sealed interface")
}

// TODO 7: 다이아몬드 문제 해결
// 힌트: super<Interface>.method()
interface A {
    fun greet(): String = "Hello from A"
}

interface B {
    fun greet(): String = "Hello from B"
}

class C : A, B {
    // TODO: greet() 오버라이드하여 A와 B의 greet 모두 호출
    // "A: ${super<A>.greet()}, B: ${super<B>.greet()}"
    override fun greet(): String = TODO("다이아몬드 해결")
}

fun exercise7(): String {
    return C().greet()
}

