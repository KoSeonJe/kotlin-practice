package syntax.solutions.sol04

fun exercise1(a: Int, b: Int): Int = if (a > b) a else b

fun exercise2(day: Int): String = when (day) {
    1 -> "월요일"
    2 -> "화요일"
    3 -> "수요일"
    4 -> "목요일"
    5 -> "금요일"
    6 -> "토요일"
    7 -> "일요일"
    else -> "Unknown"
}

fun exercise3(score: Int): String = when (score) {
    in 90..100 -> "A"
    in 80..89 -> "B"
    in 70..79 -> "C"
    in 60..69 -> "D"
    else -> "F"
}

fun exercise4(value: Any): String = when (value) {
    is String -> "문자열: $value"
    is Int -> "정수: $value"
    else -> "기타"
}

fun exercise5(x: Int, y: Int): String = when {
    x > y -> "greater"
    x < y -> "less"
    else -> "equal"
}

fun exercise6(): List<Int> {
    val result = mutableListOf<Int>()
    for (i in 2..10 step 2) {
        result.add(i)
    }
    return result
}

fun exercise7(items: List<String>): String = items.joinToString(", ")

fun exercise8(items: List<String>): List<String> {
    val result = mutableListOf<String>()
    for ((index, value) in items.withIndex()) {
        result.add("$index: $value")
    }
    return result
}

fun exercise9(n: Int): Int {
    var sum = 0
    var i = 1
    while (i <= n) {
        sum += i
        i++
    }
    return sum
}

fun exercise10(): List<Pair<Int, Int>> {
    val result = mutableListOf<Pair<Int, Int>>()
    outer@ for (i in 1..3) {
        for (j in 1..3) {
            if (i + j >= 4) break
            result.add(i to j)
        }
    }
    return result
}

