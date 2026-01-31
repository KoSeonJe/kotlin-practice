package syntax.exercises.ex07

/**
 * [실습 목적] Object와 Companion Object를 통한 싱글톤과 정적 멤버 이해
 * [학습 키워드] object, companion object, @JvmStatic, 객체 표현식
 * [Java 비교] 싱글톤 언어 지원, static → companion object
 */

// TODO 1: object 선언 (싱글톤)
// 힌트: object 이름 { }
object AppConfig {
    // TODO: var version = "1.0.0"
    // TODO: fun getAppName() = "MyApp"
}

fun exercise1(): String {
    // "${AppConfig.getAppName()} v${AppConfig.version}" 반환
    TODO("object 싱글톤")
}

// TODO 2: companion object 기본
// 힌트: 클래스 내부에 companion object { }
class MyClass {
    companion object {
        // TODO: val CONSTANT = 100
        // TODO: fun create() = MyClass()
    }

    val value = "instance"
}

fun exercise2(): Pair<Int, String> {
    // (MyClass.CONSTANT, MyClass.create().value) 반환
    TODO("companion object")
}

// TODO 3: companion object에 이름 부여
// 힌트: companion object Name { }
class Logger {
    companion object Factory {
        // TODO: fun create(tag: String) = Logger()
    }

    var tag: String = "DEFAULT"
}

fun exercise3(): Logger {
    // Logger.Factory.create("App") 또는 Logger.create("App") 호출
    TODO("named companion object")
}

// TODO 4: companion object로 팩토리 패턴
// 힌트: 여러 생성 방식 제공
class User private constructor(val name: String, val email: String) {
    companion object {
        // TODO: 아래 함수들을 구현하세요
        fun fromEmail(email: String): User {
            TODO("fromEmail 구현 - 이메일의 @ 앞부분을 name으로")
        }
        fun fromName(name: String): User {
            TODO("fromName 구현 - name@example.com 형식의 email 생성")
        }
    }
}

fun exercise4(): Pair<String, String> {
    val user1 = User.fromEmail("kotlin@test.com")
    val user2 = User.fromName("java")
    return user1.name to user2.email
    // ("kotlin", "java@example.com") 예상
}

// TODO 5: object 표현식 (익명 객체)
// 힌트: object : Interface { }
interface Greeting {
    fun greet(): String
}

fun exercise5(): String {
    // object 표현식으로 Greeting 구현하여 "Hello!" 반환
    val greeter: Greeting = TODO("object 표현식")
    return greeter.greet()
}

// TODO 6: object 표현식으로 여러 인터페이스 구현
interface Named {
    val name: String
}

interface Aged {
    val age: Int
}

fun exercise6(): String {
    // Named와 Aged를 동시에 구현하는 익명 객체 생성
    // "$name is $age years old" 반환
    TODO("다중 인터페이스 구현")
}

// TODO 7: companion object가 인터페이스 구현
// 힌트: companion object : Interface
interface Factory<T> {
    fun create(): T
}

class Product(val id: Int) {
    companion object : Factory<Product> {
        private var nextId = 1
        override fun create(): Product = Product(nextId++)
    }
}

fun exercise7(): List<Int> {
    // Product.create() 3번 호출하여 id 리스트 반환
    TODO("companion object 인터페이스")
}

