package syntax.solutions.sol10

fun exercise1(): (Int, Int) -> Int = { a, b -> a + b }

fun exercise2(): (String) -> String = { it.uppercase() }

fun exercise3(list: List<Int>, transform: (Int) -> Int): List<Int> = list.map(transform)

fun exercise4(): Int {
    val multiply: (Int, Int) -> Int = { a, b -> a * b }
    return multiply(4, 5)
}

fun runOperation(a: Int, b: Int, operation: (Int, Int) -> Int): Int = operation(a, b)

fun exercise5(): Int = runOperation(5, 3) { a, b -> a * b }

fun exercise6(): Int {
    var counter = 0
    val numbers = listOf(1, 2, 3, 4, 5)
    numbers.forEach { counter += it }
    return counter
}

fun double(x: Int): Int = x * 2

fun exercise7(): List<Int> = listOf(1, 2, 3).map(::double)

fun exercise8(): List<Int> = listOf(1, 2, 3, 4, 5).filter(fun(x: Int): Boolean { return x % 2 == 0 })

fun exercise9(numbers: List<Int>): Int {
    var sum = 0
    numbers.forEach { num ->
        if (num < 0) return@forEach
        sum += num
    }
    return sum
}

inline fun measureTime(block: () -> Unit): Long {
    val start = System.currentTimeMillis()
    block()
    return System.currentTimeMillis() - start
}

fun exercise10(): Boolean {
    val time = measureTime { Thread.sleep(10) }
    return time >= 10
}

inline fun complexOperation(
    noinline notInlined: () -> Unit,
    crossinline inlined: () -> Unit
): () -> Unit = {
    notInlined()
    inlined()
}

fun exercise11(): Boolean {
    var called1 = false
    var called2 = false
    val combined = complexOperation({ called1 = true }, { called2 = true })
    combined()
    return called1 && called2
}

