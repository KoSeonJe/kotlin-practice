package syntax.solutions.sol09

fun exercise1(): Pair<Int, Int> {
    val immutable = listOf(1, 2, 3)
    val mutable = immutable.toMutableList()
    mutable.add(4)
    return immutable.size to mutable.size
}

fun exercise2(numbers: List<Int>): List<Int> = numbers.map { it * 2 }

fun exercise3(numbers: List<Int>): List<Int> = numbers.filter { it % 2 == 0 }

fun exercise4(names: List<String>): List<String> =
    names.filter { it.length >= 5 }.map { it.uppercase() }

fun exercise5(numbers: List<Int>): Pair<Int, Int> {
    val sum = numbers.reduce { acc, n -> acc + n }
    val product = numbers.fold(1) { acc, n -> acc * n }
    return sum to product
}

data class Student(val name: String, val grade: Int)

fun exercise6(students: List<Student>): Map<Int, List<String>> =
    students.groupBy({ it.grade }, { it.name })

fun exercise7(nestedList: List<List<Int>>): List<Int> = nestedList.flatten()

fun exercise8(a: Set<Int>, b: Set<Int>): Triple<Set<Int>, Set<Int>, Set<Int>> =
    Triple(a union b, a intersect b, a subtract b)

fun exercise9(words: List<String>): Pair<Map<Int, String>, Map<String, Int>> {
    val byLength = words.associateBy { it.length }
    val toLength = words.associate { it to it.length }
    return byLength to toLength
}

fun exercise10(numbers: List<Int>): Pair<List<Int>, List<Int>> =
    numbers.partition { it < 0 }

fun exercise11(numbers: List<Int>): Triple<List<Int>, List<Int>, List<List<Int>>> =
    Triple(numbers.take(3), numbers.drop(3), numbers.chunked(2))

fun exercise12(numbers: List<Int>): Int =
    numbers.asSequence().filter { it >= 100 }.first()

