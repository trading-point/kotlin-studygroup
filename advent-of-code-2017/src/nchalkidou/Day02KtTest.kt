package nchalkidou

import org.junit.Test
import kotlin.test.*

class Day02KtTest {
    @Test
    fun test_checkSumWithDiff() {
        var testInput = listOf("""5 1 9 5""", """7 5 3""", """2 4 6 8""")
        assertEquals(18, checkSumWithDiff(testInput))
    }

    @Test
    fun test_checkSumWithDevide() {
        var testInput = listOf("""5 9 2 8""", """9 4 7 3""", """3 8 6 5""")
        assertEquals(9, checkSumWithDevide(testInput))
    }
}