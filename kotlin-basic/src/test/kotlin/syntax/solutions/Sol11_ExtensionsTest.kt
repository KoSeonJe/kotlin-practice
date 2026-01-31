package syntax.solutions.sol11

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class Sol11_ExtensionsTest {
    @Test
    fun testAll() {
        assertEquals("[Hello]", exercise1())
        assertEquals(listOf(false, true, false, true), exercise2())
        assertEquals(2 to null, exercise3())
        assertEquals('n', exercise4())
        assertEquals(listOf("Hello", ""), exercise5())
        assertEquals("member: test", exercise6())
        assertTrue(exercise7())
        assertTrue(exercise8().contains("Hello, World!"))
        assertEquals("Parent", exercise9())
        assertEquals("Hello World", exercise10())
    }
}
