package clausewitz.hoi4.builder

import clausewitz.hoi4.parser.getEquipments
import clausewitz.hoi4.parser.getLandUnits
import clausewitz.hoi4.types.Equipment
import clausewitz.hoi4.types.SubUnit

class DivisionBuilder {
    val landUnits: MutableMap<String, SubUnit> = getLandUnits()
    val equipments: MutableMap<String, Equipment> = getEquipments()

    fun calculate_stats() {

    }
}
