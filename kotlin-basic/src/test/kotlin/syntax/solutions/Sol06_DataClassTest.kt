package syntax.solutions.sol06

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class Sol06_DataClassTest {
    @Test
    fun testAll() {
        assertTrue(exercise1().contains("User"))
        assertTrue(exercise2())
        val user = User(1, "Test", "old@test.com")
        assertEquals("new@test.com", exercise3(user, "new@test.com").email)
        assertEquals("User #1: Test (old@test.com)", exercise4(user))
        assertEquals(listOf(1, "Test", "old@test.com"), exercise5(user))
        assertEquals(1, exercise6())
        assertTrue(exercise7())
        assertEquals(99, exercise8(Article(99, "Test")))
    }
}
