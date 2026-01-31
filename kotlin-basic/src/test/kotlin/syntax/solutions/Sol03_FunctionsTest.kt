package syntax.solutions.sol03

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Sol03_FunctionsTest {
    @Test
    fun testAll() {
        assertEquals(8, exercise1(3, 5))
        assertEquals(20, exercise2(4, 5))
        assertEquals("Hello, Kotlin!", exercise3("Kotlin"))
        assertEquals("Kim (25) from Seoul", exercise4())
        exercise5("Side Effect!")
        assertEquals("Side Effect!", sideEffectResult)
        assertEquals(15, exercise6(1, 2, 3, 4, 5))
        assertEquals("olleh", exercise7("hello"))
        assertEquals("Hello!", exercise8("Hello"))
    }
}
