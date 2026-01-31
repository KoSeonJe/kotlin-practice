package syntax.exercises.ex01

/**
 * [실습 목적] 변수 선언과 타입 시스템 이해
 * [학습 키워드] val, var, 타입 추론, const val
 * [Java 비교] final → val, 세미콜론 생략, 타입 추론 기본 지원
 */

// TODO 1: 불변 변수 선언
// 힌트: val 키워드 사용, 타입 추론 활용
fun exercise1(): String {
    // "Hello, Kotlin!" 문자열을 불변 변수에 저장하고 반환
    TODO("불변 변수 선언")
}

// TODO 2: 가변 변수 선언 및 수정
// 힌트: var 키워드 사용
fun exercise2(): Int {
    // 초기값 10으로 가변 변수 선언 후 20으로 변경하여 반환
    TODO("가변 변수 선언 및 수정")
}

// TODO 3: 명시적 타입 선언
// 힌트: 변수명: 타입 = 값
fun exercise3(): Double {
    // Double 타입을 명시적으로 선언하여 3.14 저장 후 반환
    TODO("명시적 타입 선언")
}

// TODO 4: 지연 초기화 (lateinit)
// 힌트: lateinit var, 나중에 초기화되는 변수
class UserProfile {
    // name 프로퍼티를 lateinit으로 선언
    // TODO: lateinit var name: String

    fun initialize(userName: String) {
        // TODO: name 초기화
    }

    fun getName(): String {
        // TODO: name 반환
        TODO("lateinit 사용")
    }
}

// TODO 5: 상수 선언 (const val)
// 힌트: const val은 컴파일 타임 상수, 최상위 또는 object 내부에서만 사용
// 아래 주석을 해제하고 완성하세요
// const val MAX_COUNT = ???

fun exercise5(): Int {
    // MAX_COUNT 상수값 반환 (100으로 정의)
    TODO("const val 사용")
}
