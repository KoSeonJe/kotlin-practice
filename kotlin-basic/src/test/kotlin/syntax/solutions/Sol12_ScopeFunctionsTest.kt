package syntax.solutions.sol12

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class Sol12_ScopeFunctionsTest {
    @Test
    fun testAll() {
        assertEquals("Hello, Kotlin!", exercise1("Kotlin"))
        assertEquals("Hello, Guest!", exercise1(null))
        assertEquals(listOf(1, 1, 3, 4, 5), exercise2(listOf(3, 1, 4, 1, 5)))
        assertTrue(exercise3().contains("localhost:8080"))
        assertEquals("Hello World", exercise4(StringBuilder()))
        val p = exercise5()
        assertEquals("Kim", p.name)
        
        loggedValue = ""
        assertEquals("OLLEH", exercise6("hello"))
        assertEquals("HELLO", loggedValue)
        
        val (o, s) = exercise7()
        assertEquals(1, o.id)
        assertEquals("Order #1: 2 items", s)
        
        assertEquals(5, exercise8(5))
        assertEquals(null, exercise8(-5))
        
        assertEquals(2 to 3, exercise9())
        assertEquals("user@test.com", exercise10().to)
    }
}
