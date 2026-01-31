package syntax.solutions.sol13

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Sol13_GenericsTest {
    @Test
    fun testAll() {
        assertEquals("Hello" to 42, exercise1())
        assertEquals(listOf("Hello", 42, 3.14), exercise2())
        assertEquals(listOf(10.0, 6.28, 20.0), exercise3())
        assertEquals("Value: 42", exercise4())
        assertEquals("Hello", exercise5())
        assertEquals("Hello", exercise6())
        assertEquals(3, exercise7(listOf(1, 2, 3)))
        assertEquals(listOf(true, false, true), exercise8())
        assertEquals(2 to null, exercise9())
        assertEquals(listOf("a", "b", "c"), exercise10())
    }
}
