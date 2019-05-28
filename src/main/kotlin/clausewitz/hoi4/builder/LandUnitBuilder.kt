package clausewitz.hoi4.builder

import clausewitz.config.defaultEquipments
import clausewitz.config.defaultTechnologies
import clausewitz.hoi4.types.LandUnit

class LandUnitBuilder(
    val equipments: Map<String, List<String>> = defaultEquipments,
    val technologies: Map<String, Map<String, Map<String, List<Any>>>> = defaultTechnologies
) {
    fun calculateStats(landUnit: LandUnit) {
        println(landUnit)
    }
}