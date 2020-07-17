import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MainTest {
    @Test
    fun `desk bank containing 2 desks returns a capacity of 2`() {
        val desk1 = Desk(1,"desk1",Location(1,"Victoria"))
        val desk2 = Desk(2,"desk2",Location(1,"Victoria"))
        val deskBank = DeskBank(1,"desk2", listOf(desk1, desk2),Location(1,"Victoria"))
        assertEquals(2,deskBank.capacity())
    }
}