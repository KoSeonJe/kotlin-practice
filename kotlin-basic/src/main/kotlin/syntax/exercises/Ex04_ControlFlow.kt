package syntax.exercises.ex04

/**
 * [실습 목적] Kotlin 조건문과 반복문의 표현식 특성 이해
 * [학습 키워드] if 표현식, when, for, in, .., until, downTo, step
 * [Java 비교] if는 값 반환, switch → 강력한 when
 */

// TODO 1: if 표현식
// 힌트: if-else가 값을 반환할 수 있음
fun exercise1(a: Int, b: Int): Int {
    // if 표현식으로 둘 중 큰 값 반환
    TODO("if 표현식")
}

// TODO 2: when 기본 사용
// 힌트: when(값) { 조건 -> 결과 }
fun exercise2(day: Int): String {
    // 1=월요일, 2=화요일, ... 7=일요일, 그 외="Unknown"
    TODO("when 기본")
}

// TODO 3: when 범위 조건
// 힌트: in 1..10, in 11..20
fun exercise3(score: Int): String {
    // 90-100: "A", 80-89: "B", 70-79: "C", 60-69: "D", 나머지: "F"
    TODO("when 범위")
}

// TODO 4: when 타입 검사 (is)
// 힌트: is String, is Int
fun exercise4(value: Any): String {
    // String이면 "문자열: $value"
    // Int면 "정수: $value"
    // 그 외 "기타"
    TODO("when 타입 검사")
}

// TODO 5: when 조건 없는 형태
// 힌트: when { 조건식 -> 결과 }
fun exercise5(x: Int, y: Int): String {
    // x > y면 "greater", x < y면 "less", 같으면 "equal"
    TODO("when 조건 없음")
}

// TODO 6: for 범위 반복
// 힌트: for (i in 1..5), until, downTo, step
fun exercise6(): List<Int> {
    // 1부터 10까지 짝수만 리스트로 반환
    // 힌트: mutableListOf, step 2
    TODO("for 범위")
}

// TODO 7: for 컬렉션 반복
// 힌트: for (item in list)
fun exercise7(items: List<String>): String {
    // 모든 item을 ", "로 연결하여 반환
    TODO("for 컬렉션")
}

// TODO 8: for with index
// 힌트: for ((index, value) in list.withIndex())
fun exercise8(items: List<String>): List<String> {
    // "0: item1", "1: item2" 형식으로 변환
    TODO("for with index")
}

// TODO 9: while 반복
// 힌트: while(조건) { }
fun exercise9(n: Int): Int {
    // 1부터 n까지의 합 계산 (while 사용)
    TODO("while")
}

// TODO 10: break와 continue with label
// 힌트: label@, break@label
fun exercise10(): List<Pair<Int, Int>> {
    // 외부 루프 1..3, 내부 루프 1..3
    // 두 수의 합이 4 이상이면 내부 루프 탈출
    // (1,1), (1,2), (1,3), (2,1), (3,1) 반환
    TODO("break with label")
}

