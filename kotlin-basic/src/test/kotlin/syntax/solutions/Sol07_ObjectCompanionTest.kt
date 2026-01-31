package syntax.solutions.sol07

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class Sol07_ObjectCompanionTest {
    @Test
    fun testAll() {
        assertEquals("MyApp v1.0.0", exercise1())
        val (c, v) = exercise2()
        assertEquals(100, c)
        assertEquals("instance", v)
        assertEquals("App", exercise3().tag)
        val (n, e) = exercise4()
        assertEquals("kotlin", n)
        assertEquals("java@example.com", e)
        assertEquals("Hello!", exercise5())
        assertTrue(exercise6().contains("Kotlin is 10 years old"))
        assertEquals(listOf(1, 2, 3), exercise7())
    }
}
