package syntax.solutions.sol09

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Sol09_CollectionsTest {
    @Test
    fun testAll() {
        assertEquals(3 to 4, exercise1())
        assertEquals(listOf(2, 4, 6), exercise2(listOf(1, 2, 3)))
        assertEquals(listOf(2, 4), exercise3(listOf(1, 2, 3, 4, 5)))
        assertEquals(listOf("JOHNSON"), exercise4(listOf("Kim", "Johnson", "Lee")))
        assertEquals(10 to 24, exercise5(listOf(1, 2, 3, 4)))
        
        val students = listOf(Student("Kim", 1), Student("Lee", 2), Student("Park", 1))
        val grouped = exercise6(students)
        assertEquals(listOf("Kim", "Park"), grouped[1])
        
        assertEquals(listOf(1, 2, 3, 4), exercise7(listOf(listOf(1, 2), listOf(3, 4))))
        val (u, i, s) = exercise8(setOf(1, 2, 3), setOf(2, 3, 4))
        assertEquals(setOf(1, 2, 3, 4), u)
        assertEquals(setOf(2, 3), i)
        
        val (byL, toL) = exercise9(listOf("a", "bb", "ccc"))
        assertEquals("a", byL[1])
        assertEquals(2, toL["bb"])
        
        val (neg, pos) = exercise10(listOf(-1, 0, 1))
        assertEquals(listOf(-1), neg)
        assertEquals(listOf(0, 1), pos)
        
        val (t, d, c) = exercise11(listOf(1, 2, 3, 4, 5, 6))
        assertEquals(3, t.size)
        assertEquals(3, d.size)
        assertEquals(3, c.size)
        
        assertEquals(120, exercise12(listOf(50, 80, 120, 150)))
    }
}
