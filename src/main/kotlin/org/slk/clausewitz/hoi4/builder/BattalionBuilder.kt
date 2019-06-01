package org.slk.clausewitz.hoi4.builder

import org.slk.clausewitz.config.defaultEquipments
import org.slk.clausewitz.config.defaultTechnologies
import org.slk.clausewitz.hoi4.parser.BattalionParser
import org.slk.clausewitz.hoi4.parser.EquipmentsParser
import org.slk.clausewitz.hoi4.types.Battalion
import org.slk.clausewitz.hoi4.types.BattalionStats
import org.slk.clausewitz.hoi4.types.Equipment
import org.slk.clausewitz.hoi4.types.TechnologieModifier

class BattalionBuilder(
    val battalions: Map<String, Battalion> = BattalionParser().getBattalions(),
    val equipments: Map<String, Equipment> = EquipmentsParser().getEquipments(),
    val usedEquipments: Map<String, List<String>> = defaultEquipments,
    val usedTechnologies: Map<String, TechnologieModifier> = defaultTechnologies
) {
    fun calculateStats(battalionType: String): Battalion {
        val battalion = battalions[battalionType] as Battalion
        val battalionEquipmentsStats = BattalionStats()
        for (equipmentName in usedEquipments[battalionType] as List) {
            val equipment = equipments[equipmentName] as Equipment
            battalionEquipmentsStats.maximum_speed.add(if (equipment.maximum_speed == 0.0) 4.0 else equipment.maximum_speed)
            battalionEquipmentsStats.soft_attack.add(equipment.soft_attack)
            battalionEquipmentsStats.hard_attack.add(equipment.hard_attack)
            battalionEquipmentsStats.air_attack.add(equipment.air_attack)
            battalionEquipmentsStats.defense.add(equipment.defense)
            battalionEquipmentsStats.breakthrough.add(equipment.breakthrough)
            battalionEquipmentsStats.armor_value.add(equipment.armor_value)
            battalionEquipmentsStats.ap_attack.add(equipment.ap_attack)
            battalionEquipmentsStats.hardness.add(equipment.hardness)
        }
        var technologieModifier = TechnologieModifier()
        if (usedTechnologies.contains(battalionType)) {
            technologieModifier = usedTechnologies[battalionType] as TechnologieModifier
        }
        battalion.maximum_speed = (1 + battalion.maximum_speed) * battalionEquipmentsStats.maximum_speed.max()!!
        battalion.soft_attack =
            (1 + battalion.soft_attack + technologieModifier.soft_attack.sum()) * battalionEquipmentsStats.soft_attack.sum()
        battalion.hard_attack =
            (1 + battalion.hard_attack + technologieModifier.hard_attack.sum()) * battalionEquipmentsStats.hard_attack.sum()
        battalion.air_attack =
            (1 + battalion.air_attack + technologieModifier.air_attack.sum()) * battalionEquipmentsStats.air_attack.sum()
        battalion.defense =
            (1 + battalion.defense + technologieModifier.defense.sum()) * battalionEquipmentsStats.defense.sum()
        battalion.breakthrough =
            (1 + battalion.breakthrough + technologieModifier.breakthrough.sum()) * battalionEquipmentsStats.breakthrough.sum()
        battalion.armor_value =
            (1 + battalion.armor_value) * battalionEquipmentsStats.armor_value.sum() + technologieModifier.armor_value.sum()
        battalion.ap_attack =
            (1 + battalion.ap_attack + technologieModifier.ap_attack.sum()) * battalionEquipmentsStats.ap_attack.sum()
        battalion.hardness = (1 + battalion.hardness) * battalionEquipmentsStats.hardness.sum()
        battalion.max_organisation = battalion.max_organisation + technologieModifier.max_organisation.sum()

        return battalion
    }
}