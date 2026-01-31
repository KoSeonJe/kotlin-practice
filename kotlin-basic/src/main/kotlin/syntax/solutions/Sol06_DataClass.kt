package syntax.solutions.sol06

data class User(val id: Int, val name: String, val email: String)

fun exercise1(): String {
    val user = User(1, "Test", "test@test.com")
    return user.toString()
}

fun exercise2(): Boolean {
    val user1 = User(1, "Test", "test@test.com")
    val user2 = User(1, "Test", "test@test.com")
    return user1 == user2
}

fun exercise3(original: User, newEmail: String): User = original.copy(email = newEmail)

fun exercise4(user: User): String {
    val (id, name, email) = user
    return "User #$id: $name ($email)"
}

fun exercise5(user: User): List<Any> =
    listOf(user.component1(), user.component2(), user.component3())

fun exercise6(): Int {
    val user1 = User(1, "Kim", "kim@test.com")
    val user2 = User(1, "Kim", "kim@test.com")
    val set = setOf(user1, user2)
    return set.size
}

data class Product(val id: Int, val name: String) {
    var viewCount: Int = 0
}

fun exercise7(): Boolean {
    val p1 = Product(1, "Laptop")
    val p2 = Product(1, "Laptop")
    p1.viewCount = 100
    p2.viewCount = 200
    return p1 == p2
}

interface Identifiable {
    val id: Int
}

data class Article(override val id: Int, val title: String) : Identifiable

fun exercise8(item: Identifiable): Int = item.id

