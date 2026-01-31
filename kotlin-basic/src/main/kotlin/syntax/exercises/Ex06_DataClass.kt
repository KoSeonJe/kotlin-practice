package syntax.exercises.ex06

/**
 * [실습 목적] Data Class의 자동 생성 기능과 활용법 이해
 * [학습 키워드] data class, copy(), 구조 분해, componentN()
 * [Java 비교] equals/hashCode/toString 자동 생성, Lombok이나 record 불필요
 */

// TODO 1: 기본 data class 정의
// 힌트: data class 이름(val 프로퍼티들)
data class User(
    val id: Int,
    val name: String,
    val email: String
)

fun exercise1(): String {
    // User 인스턴스 생성하고 toString() 결과 반환
    TODO("data class 생성")
}

// TODO 2: equals 자동 구현 확인
// 힌트: 같은 프로퍼티 값을 가진 두 인스턴스는 동등
fun exercise2(): Boolean {
    // 같은 값으로 두 User 인스턴스 생성하고 == 비교
    TODO("equals 확인")
}

// TODO 3: copy()를 이용한 불변 객체 수정
// 힌트: instance.copy(프로퍼티 = 새값)
fun exercise3(original: User, newEmail: String): User {
    // original의 email만 변경한 새 User 반환
    TODO("copy() 사용")
}

// TODO 4: 구조 분해 선언
// 힌트: val (a, b, c) = dataClassInstance
fun exercise4(user: User): String {
    // 구조 분해로 id, name, email 추출하여
    // "User #$id: $name ($email)" 형식 반환
    TODO("구조 분해")
}

// TODO 5: componentN() 함수
// 힌트: component1(), component2(), ...
fun exercise5(user: User): List<Any> {
    // componentN 함수들을 직접 호출하여 리스트로 반환
    // [id, name, email]
    TODO("componentN")
}

// TODO 6: 컬렉션에서 data class 활용
// 힌트: hashCode 자동 구현으로 Set, Map에서 정상 동작
fun exercise6(): Int {
    // 같은 User를 Set에 두 번 추가하면 크기는?
    val user1 = User(1, "Kim", "kim@test.com")
    val user2 = User(1, "Kim", "kim@test.com")
    val set = setOf(user1, user2)
    TODO("Set에서 중복 확인")
}

// TODO 7: data class와 일반 프로퍼티
// 힌트: 주 생성자 외부 프로퍼티는 equals/hashCode에 포함되지 않음
data class Product(val id: Int, val name: String) {
    var viewCount: Int = 0  // equals에 포함 안됨
}

fun exercise7(): Boolean {
    val p1 = Product(1, "Laptop")
    val p2 = Product(1, "Laptop")
    p1.viewCount = 100
    p2.viewCount = 200
    // p1 == p2?
    TODO("외부 프로퍼티와 equals")
}

// TODO 8: data class 상속 제한
// 힌트: data class는 open 불가, 하지만 interface 구현 가능
interface Identifiable {
    val id: Int
}

data class Article(
    override val id: Int,
    val title: String
) : Identifiable

fun exercise8(item: Identifiable): Int {
    // Identifiable로 받아서 id 반환
    TODO("interface 구현")
}

