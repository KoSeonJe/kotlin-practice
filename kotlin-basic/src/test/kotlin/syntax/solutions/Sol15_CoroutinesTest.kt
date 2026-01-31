package syntax.solutions.sol15

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class Sol15_CoroutinesTest {
    @Test
    fun testAll() {
        assertEquals("Data loaded", exercise1())
        val res = exercise2()
        assertTrue(res.contains("Task 1") && res.contains("Task 2"))
        assertEquals(60, exercise3())
        val (s, p) = exercise4()
        assertTrue(s > p)
        assertTrue("Default" in exercise5() && "IO" in exercise5())
        assertEquals("Cancelled", exercise6())
        assertEquals(listOf(2, 4, 6, 8, 10), exercise7())
        assertEquals(listOf(1, 2, 3), exercise8())
        assertEquals(listOf(4, 16, 36), exercise9())
        assertEquals("Error caught", exercise10())
    }
}
