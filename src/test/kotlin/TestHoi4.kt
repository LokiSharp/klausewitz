package clausewitz.test


import clausewitz.hoi4.Equipment
import clausewitz.hoi4.SubUnit
import clausewitz.hoi4.getEquipments
import clausewitz.hoi4.getLandUnits
import org.junit.Test


class TestHoi4 {
    @Test
    fun main() {
        val landUnits: MutableMap<String, SubUnit> = getLandUnits()
        println(landUnits)
        val equipments: MutableMap<String, Equipment> = getEquipments()
        println(equipments)
    }
}

