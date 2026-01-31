package syntax.exercises.ex14

import kotlin.properties.Delegates
import kotlin.reflect.KProperty

/**
 * [실습 목적] 위임(Delegation) 패턴의 이해
 * [학습 키워드] by, lazy, observable, vetoable, 클래스 위임
 * [Java 비교] 위임 패턴 언어 차원 지원
 */

// TODO 1: lazy 위임
// 힌트: by lazy { } - 첫 접근 시 초기화
class ExpensiveResource {
    val data: String by lazy {
        println("Initializing...")  // 한 번만 출력
        "Expensive Data"
    }
}

fun exercise1(): Pair<String, String> {
    val resource = ExpensiveResource()
    TODO("lazy 위임")
    // (resource.data, resource.data) 반환 - 두 번째는 캐시된 값
}

// TODO 2: observable 위임
// 힌트: Delegates.observable(초기값) { prop, old, new -> }
class User {
    var name: String by Delegates.observable("Unknown") { _, old, new ->
        println("$old -> $new")
    }
}

fun exercise2(): String {
    val user = User()
    TODO("observable 위임")
    // user.name = "Kotlin" 후 user.name 반환
}

// TODO 3: vetoable 위임
// 힌트: Delegates.vetoable - false 반환 시 변경 거부
class PositiveNumber {
    var value: Int by Delegates.vetoable(0) { _, _, new ->
        TODO("vetoable 조건")  // new > 0이면 true
    }
}

fun exercise3(): Int {
    val num = PositiveNumber()
    num.value = 10  // 성공
    num.value = -5  // 거부됨
    return num.value  // 10
}

// TODO 4: 커스텀 위임 클래스
// 힌트: getValue, setValue 연산자 구현
class TrimmedString {
    private var value: String = ""

    operator fun getValue(thisRef: Any?, property: KProperty<*>): String {
        TODO("getValue")
        // value 반환
    }

    operator fun setValue(thisRef: Any?, property: KProperty<*>, newValue: String) {
        TODO("setValue")
        // value = newValue.trim()
    }
}

class Form {
    var input: String by TrimmedString()
}

fun exercise4(): String {
    val form = Form()
    form.input = "  Hello World  "
    return form.input  // "Hello World"
}

// TODO 5: Map 위임
// 힌트: val x by map - map["x"]를 자동으로 참조
class Config(map: Map<String, Any?>) {
    val host: String by map
    val port: Int by map
}

fun exercise5(): String {
    val configMap = mapOf("host" to "localhost", "port" to 8080)
    val config = Config(configMap)
    TODO("Map 위임")
    // "${config.host}:${config.port}" 반환
}

// TODO 6: 클래스 위임
// 힌트: class A : Interface by delegate
interface Printer {
    fun print(message: String): String
}

class ConsolePrinter : Printer {
    override fun print(message: String) = "Console: $message"
}

class LoggingPrinter(private val delegate: Printer) : Printer by delegate {
    // TODO: print 오버라이드하여 "[LOG] " 접두사 추가 후 delegate 호출
}

fun exercise6(): String {
    val printer = LoggingPrinter(ConsolePrinter())
    return printer.print("Hello")  // "[LOG] Console: Hello"
}

// TODO 7: 여러 인터페이스 위임
// 힌트: 각각 다른 객체에 위임
interface Reader {
    fun read(): String
}

interface Writer {
    fun write(data: String)
}

class FileReader : Reader {
    override fun read() = "File content"
}

class FileWriter : Writer {
    var lastWritten = ""
    override fun write(data: String) {
        lastWritten = data
    }
}

class FileHandler(
    reader: Reader,
    writer: Writer
) : Reader by reader, Writer by writer

fun exercise7(): Pair<String, String> {
    val reader = FileReader()
    val writer = FileWriter()
    val handler = FileHandler(reader, writer)

    handler.write("Hello")
    TODO("다중 위임")
    // (handler.read(), writer.lastWritten) 반환
}

// TODO 8: notNull 위임
// 힌트: Delegates.notNull<T>() - lateinit과 유사, 원시 타입도 가능
class Service {
    var id: Int by Delegates.notNull()

    fun isInitialized(): Boolean {
        return try {
            id
            true
        } catch (e: IllegalStateException) {
            false
        }
    }
}

fun exercise8(): Pair<Boolean, Boolean> {
    val service = Service()
    val before = service.isInitialized()
    service.id = 42
    val after = service.isInitialized()
    TODO("notNull 위임")
    // (before, after) 반환 - (false, true)
}

