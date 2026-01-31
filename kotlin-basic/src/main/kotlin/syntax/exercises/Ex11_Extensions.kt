package syntax.exercises.ex11

/**
 * [실습 목적] 확장 함수와 확장 프로퍼티의 이해
 * [학습 키워드] fun Type.name(), val Type.prop, 확장 범위
 * [Java 비교] 상속 없이 기존 클래스에 메서드 추가 (유틸 클래스 대체)
 */

// TODO 1: 기본 확장 함수
// 힌트: fun 타입.함수명()
fun String.addBrackets(): String {
    // this(문자열 자신)에 대괄호 추가: "[this]"
    TODO("기본 확장 함수")
}

fun exercise1(): String {
    return "Hello".addBrackets()  // "[Hello]"
}

// TODO 2: 확장 함수에서 this 사용
// 힌트: this는 수신 객체 (receiver)
fun Int.isEven(): Boolean {
    // this가 짝수인지 확인
    TODO("this 사용")
}

fun exercise2(): List<Boolean> {
    return listOf(1, 2, 3, 4).map { it.isEven() }  // [false, true, false, true]
}

// TODO 3: 제네릭 확장 함수
// 힌트: fun <T> Type<T>.함수명()
fun <T> List<T>.secondOrNull(): T? {
    // 두 번째 요소 반환, 없으면 null
    TODO("제네릭 확장")
}

fun exercise3(): Pair<Int?, Int?> {
    val list1 = listOf(1, 2, 3)
    val list2 = listOf(1)
    return list1.secondOrNull() to list2.secondOrNull()  // (2, null)
}

// TODO 4: 확장 프로퍼티
// 힌트: val 타입.프로퍼티명: 반환타입 get() = ...
val String.lastChar: Char
    get() = TODO("확장 프로퍼티")  // 마지막 문자 반환

fun exercise4(): Char {
    return "Kotlin".lastChar  // 'n'
}

// TODO 5: nullable 타입에 대한 확장
// 힌트: fun Type?.함수명()
fun String?.orEmpty(): String {
    // null이면 빈 문자열, 아니면 자신 반환
    TODO("nullable 확장")
}

fun exercise5(): List<String> {
    val s1: String? = "Hello"
    val s2: String? = null
    return listOf(s1.orEmpty(), s2.orEmpty())  // ["Hello", ""]
}

// TODO 6: 확장 함수 우선순위
// 힌트: 멤버 함수가 확장 함수보다 우선
class MyString(val value: String) {
    fun get(): String = "member: $value"
}

// 이 확장 함수는 호출되지 않음 (멤버가 우선)
fun MyString.get(): String = "extension: $value"

fun exercise6(): String {
    return MyString("test").get()  // "member: test"
}

// TODO 7: companion object 확장
// 힌트: fun 클래스.Companion.함수명()
class MyClass {
    companion object
}

fun MyClass.Companion.create(value: Int): MyClass {
    // 새 MyClass 인스턴스 반환 (실제로는 할 일 없음)
    TODO("companion 확장")
}

fun exercise7(): Boolean {
    val instance = MyClass.create(42)
    return instance is MyClass
}

// TODO 8: 수신 객체 지정 람다
// 힌트: 람다 내부에서 this로 수신 객체 참조
fun buildString(action: StringBuilder.() -> Unit): String {
    val sb = StringBuilder()
    sb.action()
    return sb.toString()
}

fun exercise8(): String {
    // buildString을 사용하여 "Hello, World!" 생성
    TODO("수신 객체 지정 람다")
}

// TODO 9: 확장 함수와 상속
// 힌트: 확장 함수는 정적으로 결정됨 (오버라이드 불가)
open class Parent
class Child : Parent()

fun Parent.greet() = "Parent"
fun Child.greet() = "Child"

fun exercise9(): String {
    val instance: Parent = Child()
    return instance.greet()  // 정적 타입 기준: "Parent"
}

// TODO 10: 여러 확장 함수 체이닝
// 힌트: 각 확장 함수가 같은 타입 반환
fun String.removeSpaces(): String = TODO("공백 제거")
fun String.capitalizeWords(): String = TODO("각 단어 첫 글자 대문자")

fun exercise10(): String {
    return "hello world".capitalizeWords()  // "Hello World"
}

