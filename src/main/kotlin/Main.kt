class Location(val id: Int, val name: String)

abstract class Space(val id: Int, val name: String, val location: Location) {
    abstract fun capacity(): Int
    abstract fun slotDurationHours(): Int
    abstract val slots: List<Slot>
}

class Desk(id: Int, name: String, location: Location) : Space(id, name, location) {
    override fun capacity() = 1
    override fun slotDurationHours() = 2
    override val slots: List<Slot> = deskSlots
}

class Room(id: Int, name: String, val capacity: Int, location: Location) : Space(id, name, location) {
    override fun capacity() = capacity
    override fun slotDurationHours() = 4
    override val slots: List<Slot> = roomSlots
}

class DeskBank(id: Int, name: String, val desks: List<Desk>, location: Location) : Space(id, name, location) {
    override fun capacity() = desks.size
    override fun slotDurationHours() = 2
    override val slots: List<Slot> = deskSlots
}

data class Slot(val slotNumber: Int, val slotDescription: String) {

}

val deskSlots: List<Slot> = listOf(Slot(1, "0900 to 1100"), Slot(2, "1100 to 1300"))
val roomSlots: List<Slot> = listOf(Slot(1, "0900 to 1300"), Slot(2, "1300 to 1700"))

data class Booking(val space: Space, val slot: Slot, val customer: String,val bookingDate:String) {

}

interface BookingRepository {
    fun getFreeSpacesForSlot(spaceType: String, slot: Slot, location: Location): List<Space>
    fun getFreeSlotsForSpace(space: Space, startDateTime: String, endDateTime: String): List<Slot>
    fun saveBooking(booking: Booking)
    fun cancelBooking(booking: Booking)
}

