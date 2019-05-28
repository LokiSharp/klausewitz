package clausewitz.hoi4.builder

import clausewitz.hoi4.parser.EquipmentsParser
import clausewitz.hoi4.parser.LandUnitsParser
import clausewitz.hoi4.types.DivisionTemplate
import clausewitz.hoi4.types.Equipment
import clausewitz.hoi4.types.LandUnit
import clausewitz.hoi4.types.LandUnitStatus

class DivisionBuilder {
    val landUnits: Map<String, LandUnit> = LandUnitsParser().getLandUnits()
    val equipments: Map<String, Equipment> = EquipmentsParser().getEquipments()
    val landUnitStatus: Map<String, LandUnitStatus> = mapOf()

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
