package clausewitz.hoi4.builder

import clausewitz.config.defaultEquipments
import clausewitz.config.defaultTechnologies
import clausewitz.hoi4.parser.EquipmentsParser
import clausewitz.hoi4.types.Equipment
import clausewitz.hoi4.types.LandUnit
import clausewitz.hoi4.types.LandUnitStats

class LandUnitBuilder(
    val equipments: Map<String, Equipment> = EquipmentsParser().getEquipments(),
    val usedEquipments: Map<String, List<String>> = defaultEquipments,
    val usedTechnologies: Map<String, Map<String, Map<String, List<Any>>>> = defaultTechnologies
) {
    fun calculateStats(landUnitType: String, landUnit: LandUnit): LandUnit {
        val landUnitEquipmentsStats = LandUnitStats()
        for (equipmentName in usedEquipments[landUnitType] as List) {
            landUnitEquipmentsStats.maximum_speed.add((equipments[equipmentName] as Equipment).maximum_speed)
            landUnitEquipmentsStats.soft_attack.add((equipments[equipmentName] as Equipment).soft_attack)
            landUnitEquipmentsStats.hard_attack.add((equipments[equipmentName] as Equipment).hard_attack)
            landUnitEquipmentsStats.air_attack.add((equipments[equipmentName] as Equipment).air_attack)
            landUnitEquipmentsStats.defense.add((equipments[equipmentName] as Equipment).defense)
            landUnitEquipmentsStats.breakthrough.add((equipments[equipmentName] as Equipment).breakthrough)
            landUnitEquipmentsStats.armor_value.add((equipments[equipmentName] as Equipment).armor_value)
            landUnitEquipmentsStats.ap_attack.add((equipments[equipmentName] as Equipment).ap_attack)
            landUnitEquipmentsStats.hardness.add((equipments[equipmentName] as Equipment).hardness)
        }
        landUnit.maximum_speed = landUnitEquipmentsStats.maximum_speed.max()!!
        landUnit.soft_attack = landUnitEquipmentsStats.soft_attack.sum()
        landUnit.hard_attack = landUnitEquipmentsStats.hard_attack.sum()
        landUnit.air_attack = landUnitEquipmentsStats.air_attack.sum()
        landUnit.defense = landUnitEquipmentsStats.defense.sum()
        landUnit.breakthrough = landUnitEquipmentsStats.breakthrough.sum()
        landUnit.armor_value = landUnitEquipmentsStats.armor_value.sum()
        landUnit.ap_attack = landUnitEquipmentsStats.ap_attack.sum()
        landUnit.hardness = landUnitEquipmentsStats.hardness.sum()

        return landUnit
    }
}