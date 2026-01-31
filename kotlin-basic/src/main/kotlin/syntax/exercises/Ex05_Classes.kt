package syntax.exercises.ex05

/**
 * [실습 목적] Kotlin 클래스 정의와 프로퍼티 시스템 이해
 * [학습 키워드] class, constructor, init, 프로퍼티, field, 접근 제한자
 * [Java 비교] 기본 public, 주 생성자가 헤더에 위치, getter/setter 자동 생성
 */

// TODO 1: 기본 클래스 정의
// 힌트: class 이름(val 프로퍼티)
// 주 생성자에 val/var로 프로퍼티 선언
class Person1(val name: String, val age: Int)

fun exercise1(): String {
    // Person1 인스턴스 생성하고 "name is age years old" 형식 반환
    TODO("기본 클래스")
}

// TODO 2: init 블록
// 힌트: init { } 블록은 인스턴스 생성 시 실행
class Person2(name: String, age: Int) {
    val upperName: String = "TODO"  // TODO: name.uppercase()로 변경
    val isAdult: Boolean = false    // TODO: age >= 18로 변경

    init {
        // TODO: 위 프로퍼티 초기값을 수정하세요
        // upperName = name.uppercase()
        // isAdult = age >= 18
    }
}

fun exercise2(): Pair<String, Boolean> {
    val person = Person2("kotlin", 20)
    return person.upperName to person.isAdult
}

// TODO 3: 커스텀 getter/setter
// 힌트: get() = ..., set(value) { field = value }
class Temperature {
    var celsius: Double = 0.0

    // TODO: fahrenheit 프로퍼티 정의
    // getter: celsius * 9/5 + 32
    // setter: celsius = (value - 32) * 5/9
    val fahrenheit: Double
        get() = TODO("커스텀 getter")
}

fun exercise3(): Double {
    val temp = Temperature()
    temp.celsius = 100.0
    return temp.fahrenheit  // 212.0이어야 함
}

// TODO 4: 보조 생성자
// 힌트: constructor(...) : this(...)
class Rectangle(val width: Int, val height: Int) {
    // TODO: 정사각형용 보조 생성자 (한 변의 길이만 받음)
    // constructor(size: Int) : this(size, size)

    fun area() = width * height
}

fun exercise4(): Int {
    // 정사각형 생성하여 넓이 반환
    TODO("보조 생성자")
}

// TODO 5: 접근 제한자
// 힌트: private, protected, internal, public(기본)
class BankAccount(initialBalance: Int) {
    // TODO: balance를 private으로 선언
    // TODO: deposit, withdraw 메서드 구현

    fun getBalance(): Int = TODO("접근 제한자")

    fun deposit(amount: Int) {
        TODO("deposit 구현")
    }

    fun withdraw(amount: Int): Boolean {
        // 잔액 부족하면 false 반환
        TODO("withdraw 구현")
    }
}

fun exercise5(): Int {
    val account = BankAccount(1000)
    account.deposit(500)
    account.withdraw(200)
    return account.getBalance()  // 1300
}

// TODO 6: 중첩 클래스와 내부 클래스
// 힌트: class 안의 class, inner class
class Outer(val value: Int) {
    // TODO: Nested 클래스 (외부 참조 없음)
    class Nested {
        fun getValue() = 10  // 외부 value 접근 불가
    }

    // TODO: Inner 클래스 (inner 키워드로 외부 참조 가능)
    inner class Inner {
        fun getValue() = value  // 외부 value 접근 가능
    }
}

fun exercise6(): Pair<Int, Int> {
    val outer = Outer(20)
    val nested = Outer.Nested()
    val inner = outer.Inner()
    return nested.getValue() to inner.getValue()  // (10, 20)
}

