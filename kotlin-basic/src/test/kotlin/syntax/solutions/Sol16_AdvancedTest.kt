package syntax.solutions.sol16

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class Sol16_AdvancedTest {
    @Test
    fun testAll() {
        assertEquals(Vector(4, 6), exercise1())
        assertEquals(listOf(true, false, true), exercise2())
        assertEquals("Hello, Kotlin!", exercise3())
        assertEquals(10, exercise4())
        assertEquals(1024, exercise5())
        val (v, e) = exercise6()
        assertEquals("value", v)
        assertTrue(e)
        assertEquals("User: 123" to "Order: 456", exercise7())
        assertTrue(exercise8().contains("<p>Hello</p>"))
        assertTrue("name" in exercise9() && "age" in exercise9())
        assertEquals("Kotlin Constant" to "Called from Java", exercise10())
    }
}
