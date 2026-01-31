package syntax.solutions.sol01

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Sol01_VariablesTest {
    @Test
    fun testAll() {
        assertEquals("Hello, Kotlin!", exercise1())
        assertEquals(20, exercise2())
        assertEquals(3.14, exercise3())
        val profile = UserProfile()
        profile.initialize("Kotlin")
        assertEquals("Kotlin", profile.fetchName())
        assertEquals(100, exercise5())
    }
}
