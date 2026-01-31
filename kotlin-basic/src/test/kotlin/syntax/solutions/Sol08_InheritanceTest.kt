package syntax.solutions.sol08

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class Sol08_InheritanceTest {
    @Test
    fun testAll() {
        assertEquals("Buddy: Woof!", exercise1())
        assertTrue(exercise2() in 78.5..78.6)
        assertEquals("Flying!" to "Swimming!", exercise3())
        assertEquals("[LOG] Hello", exercise4())
        assertEquals("Data: test", exercise5(Result.Success("test")))
        assertEquals(2, exercise6(UiState.Content(listOf("a", "b"))))
        assertTrue(exercise7().contains("Hello from A") && exercise7().contains("Hello from B"))
    }
}
