package clausewitz.hoi4.builder

import clausewitz.hoi4.parser.EquipmentsParser
import clausewitz.hoi4.parser.LandUnitsParser
import clausewitz.hoi4.types.DivisionTemplate
import clausewitz.hoi4.types.Equipment
import clausewitz.hoi4.types.LandUnit

class DivisionBuilder {
    val landUnits: Map<String, LandUnit> = LandUnitsParser().getLandUnits()
    val equipments: Map<String, Equipment> = EquipmentsParser().getEquipments()

    fun calculateStats(division_template: DivisionTemplate) {
        println(landUnits)
        println(equipments)
        println(division_template)
        for (i in division_template.regiments) {
            println(i.key)
            println(landUnits[i.key])
        }

        for (i in division_template.supports) {
            println(i)
            println(landUnits[i])
        }
    }
}
