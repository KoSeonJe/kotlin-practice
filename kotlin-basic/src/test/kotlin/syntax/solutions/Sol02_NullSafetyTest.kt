package syntax.solutions.sol02

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import kotlin.test.assertEquals

class Sol02_NullSafetyTest {
    @Test
    fun testAll() {
        assertEquals(5, exercise1("Hello"))
        assertEquals(0, exercise1(null))
        assertEquals("Kotlin", exercise2("Kotlin"))
        assertEquals("Unknown", exercise2(null))
        
        val emp = Employee(Company(Address("Seoul")))
        assertEquals("Seoul", exercise3(emp))
        
        assertEquals("HELLO", exercise4("hello"))
        assertEquals(4, exercise5("test"))
        assertThrows<NullPointerException> { exercise5(null) }
        assertEquals("smart", exercise6("smart"))
        assertEquals("NULL", exercise6(null))
    }
}
