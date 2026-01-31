package syntax.solutions.sol15

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import kotlin.system.measureTimeMillis

suspend fun fetchData(): String {
    delay(100)
    return "Data loaded"
}

fun exercise1(): String = runBlocking { fetchData() }

fun exercise2(): List<String> = runBlocking {
    val results = mutableListOf<String>()
    launch {
        delay(50)
        results.add("Task 1")
    }
    launch {
        delay(100)
        results.add("Task 2")
    }
    delay(200)
    results
}

suspend fun computeValue(x: Int): Int {
    delay(100)
    return x * 2
}

fun exercise3(): Int = runBlocking {
    val d1 = async { computeValue(10) }
    val d2 = async { computeValue(20) }
    d1.await() + d2.await()
}

suspend fun slowTask(): Int {
    delay(100)
    return 1
}

fun exercise4(): Pair<Long, Long> = runBlocking {
    val sequentialTime = measureTimeMillis {
        slowTask(); slowTask(); slowTask()
    }
    val parallelTime = measureTimeMillis {
        val d1 = async { slowTask() }
        val d2 = async { slowTask() }
        val d3 = async { slowTask() }
        d1.await(); d2.await(); d3.await()
    }
    sequentialTime to parallelTime
}

fun exercise5(): List<String> = runBlocking {
    val results = mutableListOf<String>()
    withContext(Dispatchers.Default) { results.add("Default") }
    withContext(Dispatchers.IO) { results.add("IO") }
    results
}

fun exercise6(): String = runBlocking {
    var result = "Not cancelled"
    val job = launch {
        try {
            repeat(1000) { delay(10) }
            result = "Completed"
        } catch (e: CancellationException) {
            result = "Cancelled"
        }
    }
    delay(50)
    job.cancel()
    job.join()
    result
}

suspend fun processItems(items: List<Int>): List<Int> = coroutineScope {
    items.map { async { it * 2 } }.awaitAll()
}

fun exercise7(): List<Int> = runBlocking { processItems(listOf(1, 2, 3, 4, 5)) }

fun numberFlow(): Flow<Int> = flow {
    emit(1); emit(2); emit(3)
}

fun exercise8(): List<Int> = runBlocking {
    val results = mutableListOf<Int>()
    numberFlow().collect { results.add(it) }
    results
}

fun exercise9(): List<Int> = runBlocking {
    (1..10).asFlow()
        .filter { it % 2 == 0 }
        .map { it * it }
        .take(3)
        .toList()
}

fun exercise10(): String = runBlocking {
    try {
        throw Exception("Test")
    } catch (e: Exception) {
        "Error caught"
    }
}

