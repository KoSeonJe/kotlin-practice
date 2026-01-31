package syntax.solutions.sol05

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class Sol05_ClassesTest {
    @Test
    fun testAll() {
        assertTrue(exercise1().contains("Kotlin is 10 years old"))
        val (name, adult) = exercise2()
        assertEquals("KOTLIN", name)
        assertTrue(adult)
        assertEquals(212.0, exercise3())
        assertEquals(25, exercise4())
        assertEquals(1300, exercise5())
        val (nested, inner) = exercise6()
        assertEquals(10, nested)
        assertEquals(20, inner)
    }
}
