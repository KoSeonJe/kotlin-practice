package syntax.exercises.ex02

/**
 * [실습 목적] Kotlin의 Null 안전성 시스템 이해
 * [학습 키워드] ?, ?., ?:, !!, let
 * [Java 비교] Optional 대신 언어 차원 null 안전성, NPE 컴파일 타임 방지
 */

// TODO 1: Nullable 타입 선언
// 힌트: 타입 뒤에 ? 붙이기
fun exercise1(input: String?): Int {
    // input이 null이면 0, 아니면 문자열 길이 반환
    // Safe call (?.) 사용
    TODO("Nullable 타입과 safe call")
}

// TODO 2: Elvis 연산자
// 힌트: ?: 는 null일 때 기본값 제공
fun exercise2(name: String?): String {
    // name이 null이면 "Unknown" 반환, 아니면 name 반환
    TODO("Elvis 연산자")
}

// TODO 3: Safe call 체이닝
// 힌트: ?. 연속 사용
data class Address(val city: String?)
data class Company(val address: Address?)
data class Employee(val company: Company?)

fun exercise3(employee: Employee?): String {
    // employee?.company?.address?.city 가져오기
    // null이면 "No City" 반환
    TODO("Safe call 체이닝")
}

// TODO 4: let을 이용한 null 체크
// 힌트: ?.let { } 패턴
fun exercise4(value: String?): String {
    // value가 null이 아니면 대문자로 변환하여 반환
    // null이면 "EMPTY" 반환
    TODO("let을 이용한 null 체크")
}

// TODO 5: Non-null assertion (!!)
// 힌트: !!는 null이 아님을 단언, null이면 NPE 발생
// 주의: 실무에서는 사용 자제
fun exercise5(value: String?): Int {
    // value가 null이 아님을 확신할 때 길이 반환
    // 이 함수는 null이 들어오면 NPE 발생해도 됨
    TODO("Non-null assertion")
}

// TODO 6: 스마트 캐스트
// 힌트: null 체크 후 자동으로 non-null 타입으로 캐스트
fun exercise6(value: String?): String {
    // if로 null 체크 후 value 사용 (?.없이)
    // null이면 "NULL" 반환
    TODO("스마트 캐스트")
}
