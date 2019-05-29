package clausewitz.hoi4.builder

import clausewitz.config.defaultEquipments
import clausewitz.config.defaultTechnologies
import clausewitz.hoi4.parser.EquipmentsParser
import clausewitz.hoi4.parser.LandUnitsParser
import clausewitz.hoi4.types.Equipment
import clausewitz.hoi4.types.LandUnit
import clausewitz.hoi4.types.LandUnitStats
import clausewitz.hoi4.types.TechnologieModifier

class LandUnitBuilder(
    val landUnits: Map<String, LandUnit> = LandUnitsParser().getLandUnits(),
    val equipments: Map<String, Equipment> = EquipmentsParser().getEquipments(),
    val usedEquipments: Map<String, List<String>> = defaultEquipments,
    val usedTechnologies: Map<String, TechnologieModifier> = defaultTechnologies
) {
    fun calculateStats(landUnitType: String): LandUnit {
        val landUnit = landUnits[landUnitType] as LandUnit
        val landUnitEquipmentsStats = LandUnitStats()
        for (equipmentName in usedEquipments[landUnitType] as List) {
            val equipment = equipments[equipmentName] as Equipment
            landUnitEquipmentsStats.maximum_speed.add(if (equipment.maximum_speed == 0.0) 4.0 else equipment.maximum_speed)
            landUnitEquipmentsStats.soft_attack.add(equipment.soft_attack)
            landUnitEquipmentsStats.hard_attack.add(equipment.hard_attack)
            landUnitEquipmentsStats.air_attack.add(equipment.air_attack)
            landUnitEquipmentsStats.defense.add(equipment.defense)
            landUnitEquipmentsStats.breakthrough.add(equipment.breakthrough)
            landUnitEquipmentsStats.armor_value.add(equipment.armor_value)
            landUnitEquipmentsStats.ap_attack.add(equipment.ap_attack)
            landUnitEquipmentsStats.hardness.add(equipment.hardness)
        }
        landUnit.maximum_speed = (1 + landUnit.maximum_speed) * landUnitEquipmentsStats.maximum_speed.max()!!
        landUnit.soft_attack = (1 + landUnit.soft_attack) * landUnitEquipmentsStats.soft_attack.sum()
        landUnit.hard_attack = (1 + landUnit.hard_attack) * landUnitEquipmentsStats.hard_attack.sum()
        landUnit.air_attack = (1 + landUnit.air_attack) * landUnitEquipmentsStats.air_attack.sum()
        landUnit.defense = (1 + landUnit.defense) * landUnitEquipmentsStats.defense.sum()
        landUnit.breakthrough = (1 + landUnit.breakthrough) * landUnitEquipmentsStats.breakthrough.sum()
        landUnit.armor_value = (1 + landUnit.armor_value) * landUnitEquipmentsStats.armor_value.sum()
        landUnit.ap_attack = (1 + landUnit.ap_attack) * landUnitEquipmentsStats.ap_attack.sum()
        landUnit.hardness = (1 + landUnit.hardness) * landUnitEquipmentsStats.hardness.sum()

        return landUnit
    }
}