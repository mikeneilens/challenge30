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
    @Test
    fun `create booking for free desk returns booking with confirmed status`(){
        val repository = object:BookingRepository{
            override fun getFreeSpacesForSlot(spaceType: String, slot: Slot, location: Location): List<Space> = listOf()
            override fun getFreeSlotsForSpace(space: Space, bookingDate: String): List<Slot> = listOf()
            override fun saveBooking(booking: Booking): Booking = Booking(BookingStatus.Confirmed(1),booking.space,
            booking.slot,booking.customer,booking.bookingDate)
            override fun cancelBooking(booking: Booking) {}
        }
        val desk1 = Desk(1,"desk1",Location(1,"Victoria"))
        val booking = Booking(BookingStatus.Unconfirmed,desk1,Slot(1,"0900-1100"),"andy","20200717")
        val result = repository.saveBooking(booking)
        assertEquals(BookingStatus.Confirmed(1),result.bookingStatus)

    }
}