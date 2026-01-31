package syntax.exercises.ex09

/**
 * [실습 목적] Kotlin 컬렉션과 함수형 프로그래밍 기초 이해
 * [학습 키워드] listOf, mutableListOf, map, filter, reduce, groupBy
 * [Java 비교] 불변/가변 컬렉션 명확 구분, it 키워드
 */

// TODO 1: 불변 vs 가변 리스트
// 힌트: listOf (불변), mutableListOf (가변)
fun exercise1(): Pair<Int, Int> {
    // 불변 리스트 [1, 2, 3] 생성
    // 가변 리스트로 변환 후 4 추가
    // (원본 크기, 새 리스트 크기) 반환
    TODO("불변/가변 리스트")
}

// TODO 2: map 변환
// 힌트: list.map { 변환식 }
fun exercise2(numbers: List<Int>): List<Int> {
    // 각 숫자를 2배로 변환
    TODO("map")
}

// TODO 3: filter 필터링
// 힌트: list.filter { 조건 }
fun exercise3(numbers: List<Int>): List<Int> {
    // 짝수만 필터링
    TODO("filter")
}

// TODO 4: map + filter 조합
// 힌트: 체이닝
fun exercise4(names: List<String>): List<String> {
    // 5글자 이상인 이름만 대문자로 변환
    TODO("map + filter")
}

// TODO 5: reduce와 fold
// 힌트: reduce는 첫 요소부터, fold는 초기값 지정
fun exercise5(numbers: List<Int>): Pair<Int, Int> {
    // reduce로 합계 계산
    // fold로 곱 계산 (초기값 1)
    TODO("reduce/fold")
}

// TODO 6: groupBy
// 힌트: list.groupBy { 키 }
data class Student(val name: String, val grade: Int)

fun exercise6(students: List<Student>): Map<Int, List<String>> {
    // grade별로 그룹화하고, 각 그룹에서 이름만 추출
    TODO("groupBy")
}

// TODO 7: flatMap
// 힌트: 중첩 리스트 평탄화
fun exercise7(nestedList: List<List<Int>>): List<Int> {
    // 중첩 리스트를 평탄화
    TODO("flatMap")
}

// TODO 8: 컬렉션 집합 연산
// 힌트: union, intersect, subtract
fun exercise8(a: Set<Int>, b: Set<Int>): Triple<Set<Int>, Set<Int>, Set<Int>> {
    // (합집합, 교집합, 차집합) 반환
    TODO("집합 연산")
}

// TODO 9: associate와 associateBy
// 힌트: list.associateBy { key } / list.associate { key to value }
fun exercise9(words: List<String>): Pair<Map<Int, String>, Map<String, Int>> {
    // 1. 길이를 키로, 단어를 값으로 (마지막 단어가 우선)
    // 2. 단어를 키로, 길이를 값으로
    TODO("associate")
}

// TODO 10: partition
// 힌트: 조건에 따라 두 그룹으로 분리
fun exercise10(numbers: List<Int>): Pair<List<Int>, List<Int>> {
    // (음수 리스트, 양수 리스트) 반환 (0은 양수에)
    TODO("partition")
}

// TODO 11: take, drop, chunked
// 힌트: 부분 추출
fun exercise11(numbers: List<Int>): Triple<List<Int>, List<Int>, List<List<Int>>> {
    // 앞에서 3개, 뒤에서 3개 제외, 2개씩 묶기
    TODO("take/drop/chunked")
}

// TODO 12: 시퀀스 (지연 평가)
// 힌트: asSequence()로 변환, 대용량 데이터에 효율적
fun exercise12(numbers: List<Int>): Int {
    // 시퀀스로 변환하여 처리
    // 100 이상인 숫자 중 첫 번째 찾기
    TODO("sequence")
}

