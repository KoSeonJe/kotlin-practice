package syntax.solutions.sol14

import kotlin.properties.Delegates
import kotlin.reflect.KProperty

class ExpensiveResource {
    val data: String by lazy {
        println("Initializing...")
        "Expensive Data"
    }
}

fun exercise1(): Pair<String, String> {
    val resource = ExpensiveResource()
    return resource.data to resource.data
}

class User {
    var name: String by Delegates.observable("Unknown") { _, old, new ->
        println("$old -> $new")
    }
}

fun exercise2(): String {
    val user = User()
    user.name = "Kotlin"
    return user.name
}

class PositiveNumber {
    var value: Int by Delegates.vetoable(0) { _, _, new -> new > 0 }
}

fun exercise3(): Int {
    val num = PositiveNumber()
    num.value = 10
    num.value = -5
    return num.value
}

class TrimmedString {
    private var value: String = ""

    operator fun getValue(thisRef: Any?, property: KProperty<*>): String = value

    operator fun setValue(thisRef: Any?, property: KProperty<*>, newValue: String) {
        value = newValue.trim()
    }
}

class Form {
    var input: String by TrimmedString()
}

fun exercise4(): String {
    val form = Form()
    form.input = "  Hello World  "
    return form.input
}

class Config(map: Map<String, Any?>) {
    val host: String by map
    val port: Int by map
}

fun exercise5(): String {
    val configMap = mapOf("host" to "localhost", "port" to 8080)
    val config = Config(configMap)
    return "${config.host}:${config.port}"
}

interface Printer { fun print(message: String): String }
class ConsolePrinter : Printer {
    override fun print(message: String) = "Console: $message"
}

class LoggingPrinter(private val delegate: Printer) : Printer by delegate {
    override fun print(message: String): String = "[LOG] ${delegate.print(message)}"
}

fun exercise6(): String = LoggingPrinter(ConsolePrinter()).print("Hello")

interface Reader { fun read(): String }
interface Writer { fun write(data: String) }

class FileReader : Reader { override fun read() = "File content" }
class FileWriter : Writer {
    var lastWritten = ""
    override fun write(data: String) { lastWritten = data }
}

class FileHandler(reader: Reader, writer: Writer) : Reader by reader, Writer by writer

fun exercise7(): Pair<String, String> {
    val reader = FileReader()
    val writer = FileWriter()
    val handler = FileHandler(reader, writer)
    handler.write("Hello")
    return handler.read() to writer.lastWritten
}

class Service {
    var id: Int by Delegates.notNull()

    fun isInitialized(): Boolean = try { id; true } catch (e: IllegalStateException) { false }
}

fun exercise8(): Pair<Boolean, Boolean> {
    val service = Service()
    val before = service.isInitialized()
    service.id = 42
    val after = service.isInitialized()
    return before to after
}

