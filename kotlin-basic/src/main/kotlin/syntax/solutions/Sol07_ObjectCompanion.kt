package syntax.solutions.sol07

object AppConfig {
    var version = "1.0.0"
    fun getAppName() = "MyApp"
}

fun exercise1(): String = "${AppConfig.getAppName()} v${AppConfig.version}"

class MyClass {
    companion object {
        val CONSTANT = 100
        fun create() = MyClass()
    }

    val value = "instance"
}

fun exercise2(): Pair<Int, String> = MyClass.CONSTANT to MyClass.create().value

class Logger {
    companion object Factory {
        fun create(tag: String): Logger {
            val logger = Logger()
            logger.tag = tag
            return logger
        }
    }

    var tag: String = "DEFAULT"
}

fun exercise3(): Logger = Logger.create("App")

class User private constructor(val name: String, val email: String) {
    companion object {
        fun fromEmail(email: String): User {
            val name = email.substringBefore("@")
            return User(name, email)
        }

        fun fromName(name: String): User = User(name, "$name@example.com")
    }
}

fun exercise4(): Pair<String, String> {
    val user1 = User.fromEmail("kotlin@test.com")
    val user2 = User.fromName("java")
    return user1.name to user2.email
}

interface Greeting {
    fun greet(): String
}

fun exercise5(): String {
    val greeter: Greeting = object : Greeting {
        override fun greet() = "Hello!"
    }
    return greeter.greet()
}

interface Named { val name: String }
interface Aged { val age: Int }

fun exercise6(): String {
    val person = object : Named, Aged {
        override val name = "Kotlin"
        override val age = 10
    }
    return "${person.name} is ${person.age} years old"
}

interface Factory<T> {
    fun create(): T
}

class Product(val id: Int) {
    companion object : Factory<Product> {
        private var nextId = 1
        override fun create(): Product = Product(nextId++)
    }
}

fun exercise7(): List<Int> =
    listOf(Product.create().id, Product.create().id, Product.create().id)

