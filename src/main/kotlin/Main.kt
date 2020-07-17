class Location(val id:Int,val name: String)

abstract class Space(val id: Int, val name: String,val location: Location) {
    abstract fun capacity(): Int
}

class Desk(id: Int, name: String, location: Location) : Space(id, name, location) {
    override fun capacity() = 1
}

class Room(id: Int, name: String, val capacity: Int, location: Location) : Space(id, name, location) {
    override fun capacity() = capacity
}

class DeskBank(id: Int, name: String, val desks: List<Desk>, location: Location) : Space(id, name, location) {
    override fun capacity() = desks.size
}

typealias SlotTime = String

data class Slot(val startDateTime: SlotTime, val endDateTime: SlotTime) {

}

data class Booking(val space: Space, val slot: Slot, val customer: String) {

}

interface BookingRepository{
    fun getFreeSpacesForSlot(spaceType:String,slot:Slot,location:Location):List<Space>
    fun getFreeSlotsForSpace(space:Space,startDateTime: SlotTime,endDateTime: SlotTime):List<Slot>
    fun saveBooking(booking:Booking)
    fun cancelBooking(booking:Booking)
}

