package syntax.solutions.sol14

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue
import kotlin.test.assertFalse

class Sol14_DelegationTest {
    @Test
    fun testAll() {
        assertEquals("Expensive Data" to "Expensive Data", exercise1())
        assertEquals("Kotlin", exercise2())
        assertEquals(10, exercise3())
        assertEquals("Hello World", exercise4())
        assertEquals("localhost:8080", exercise5())
        assertEquals("[LOG] Console: Hello", exercise6())
        assertEquals("File content" to "Hello", exercise7())
        assertEquals(false to true, exercise8())
    }
}
