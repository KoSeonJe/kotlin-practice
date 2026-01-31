package syntax.solutions.sol10

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class Sol10_LambdasTest {
    @Test
    fun testAll() {
        assertEquals(8, exercise1()(3, 5))
        assertEquals("HELLO", exercise2()("hello"))
        assertEquals(listOf(2, 4, 6), exercise3(listOf(1, 2, 3)) { it * 2 })
        assertEquals(20, exercise4())
        assertEquals(15, exercise5())
        assertEquals(15, exercise6())
        assertEquals(listOf(2, 4, 6), exercise7())
        assertEquals(listOf(2, 4), exercise8())
        assertEquals(10, exercise9(listOf(1, 2, -1, 3, -2, 4)))
        assertTrue(exercise10())
        assertTrue(exercise11())
    }
}
