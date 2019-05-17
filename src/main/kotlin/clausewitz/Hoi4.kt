package clausewitz


import clausewitz.hoi4.Equipment
import clausewitz.hoi4.SubUnit
import clausewitz.hoi4.getEquipments
import clausewitz.hoi4.getLandUnits

fun main(args: Array<String>) {
    val landUnits: MutableMap<String, SubUnit> = getLandUnits()
    println(landUnits)
    val equipments: MutableMap<String, Equipment> = getEquipments()
    println(equipments)
}

