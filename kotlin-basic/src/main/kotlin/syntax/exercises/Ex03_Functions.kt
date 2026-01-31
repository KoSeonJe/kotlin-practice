package syntax.exercises.ex03

/**
 * [실습 목적] Kotlin 함수 정의와 다양한 기능 이해
 * [학습 키워드] fun, 단일 표현식, 기본값, named argument, Unit
 * [Java 비교] 기본 파라미터 값 지원 → 오버로딩 감소
 */

// TODO 1: 기본 함수 정의
// 힌트: fun 함수명(파라미터): 반환타입 { }
fun exercise1(a: Int, b: Int): Int {
    // 두 수의 합 반환
    TODO("기본 함수 정의")
}

// TODO 2: 단일 표현식 함수
// 힌트: fun 함수명() = 표현식
fun exercise2(a: Int, b: Int): Int = TODO("단일 표현식 함수")
// a * b 반환하도록 수정

// TODO 3: 기본 파라미터 값
// 힌트: 파라미터: 타입 = 기본값
fun exercise3(name: String, greeting: String = "Hello"): String {
    // "$greeting, $name!" 형식으로 반환
    TODO("기본 파라미터 값")
}

// TODO 4: Named arguments
// 힌트: 함수호출(파라미터명 = 값)
fun createUser(name: String, age: Int, city: String): String {
    return "$name ($age) from $city"
}

fun exercise4(): String {
    // createUser를 named arguments로 호출
    // name = "Kim", age = 25, city = "Seoul" 순서 바꿔서 호출해보기
    TODO("Named arguments")
}

// TODO 5: Unit 반환 타입 (void와 유사)
// 힌트: Unit은 생략 가능
var sideEffectResult = ""
fun exercise5(message: String) {
    // sideEffectResult에 message 저장 (반환값 없음)
    TODO("Unit 반환 타입")
}

// TODO 6: vararg (가변 인자)
// 힌트: vararg 키워드, 배열처럼 사용
fun exercise6(vararg numbers: Int): Int {
    // 모든 숫자의 합 반환
    TODO("vararg 사용")
}

// TODO 7: 지역 함수 (함수 내부 함수)
// 힌트: 함수 안에 함수 정의 가능
fun exercise7(text: String): String {
    // 내부에 reverse 함수 정의하여 text 뒤집기
    // 힌트: fun reverse(s: String): String = s.reversed()
    TODO("지역 함수")
}

// TODO 8: 확장 함수 기초 맛보기
// 힌트: fun 타입.함수명() (자세한 건 Ex11에서)
fun String.addExclamation(): String {
    // this(문자열 자신)에 "!" 붙여서 반환
    TODO("확장 함수 기초")
}

fun exercise8(text: String): String = text.addExclamation()

