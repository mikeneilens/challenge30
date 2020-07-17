
abstract class Space(val id:Int, val name:String) {
    abstract fun capacity():Int
}

class Desk(id:Int, name:String):Space(id, name) {
    override fun capacity() = 1
}

class Room(id:Int, name:String, val capacity:Int):Space(id, name) {
    override fun capacity() = capacity
}

class DeskBank(id:Int, name:String, val desks:List<Desk>):Space(id, name) {
    override fun capacity() = desks.size
}

typealias SlotTime=String

data class Slot(val startDateTime:SlotTime, val endDateTime:SlotTime){

}

