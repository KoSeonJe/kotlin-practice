package syntax.solutions.sol04

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Sol04_ControlFlowTest {
    @Test
    fun testAll() {
        assertEquals(5, exercise1(5, 3))
        assertEquals("월요일", exercise2(1))
        assertEquals("A", exercise3(95))
        assertEquals("문자열: hello", exercise4("hello"))
        assertEquals("greater", exercise5(5, 3))
        assertEquals(listOf(2, 4, 6, 8, 10), exercise6())
        assertEquals("a, b, c", exercise7(listOf("a", "b", "c")))
        assertEquals(listOf("0: a", "1: b"), exercise8(listOf("a", "b")))
        assertEquals(15, exercise9(5))
        assertEquals(listOf(1 to 1, 1 to 2, 2 to 1), exercise10())
    }
}
