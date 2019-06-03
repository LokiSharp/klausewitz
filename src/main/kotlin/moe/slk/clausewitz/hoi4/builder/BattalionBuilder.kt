package moe.slk.clausewitz.hoi4.builder

import moe.slk.clausewitz.hoi4.config.defaultDataDir
import moe.slk.clausewitz.hoi4.config.defaultEquipments
import moe.slk.clausewitz.hoi4.config.defaultTechnologies
import moe.slk.clausewitz.hoi4.parser.BattalionParser
import moe.slk.clausewitz.hoi4.parser.EquipmentsParser
import moe.slk.clausewitz.hoi4.types.Battalion
import moe.slk.clausewitz.hoi4.types.BattalionStats
import moe.slk.clausewitz.hoi4.types.Equipment
import moe.slk.clausewitz.hoi4.types.TechnologieModifier

class BattalionBuilder(
    private val dataDir: String = defaultDataDir,
    private val battalions: Map<String, Battalion> = BattalionParser(dataDir = dataDir).getBattalions(),
    private val equipments: Map<String, Equipment> = EquipmentsParser(dataDir = dataDir).getEquipments(),
    val usedEquipments: Map<String, List<String>> = defaultEquipments,
    val usedTechnologies: Map<String, TechnologieModifier> = defaultTechnologies
) {
    fun calculateStats(battalionType: String): Battalion {
        val battalion = battalions[battalionType] as Battalion
        val battalionEquipmentsStats = BattalionStats()
        for (equipmentName in usedEquipments[battalionType] as List) {
            val equipment = equipments[equipmentName] as Equipment
            with(battalionEquipmentsStats) {
                maximum_speed.add(if (equipment.maximum_speed == 0.0) 4.0 else equipment.maximum_speed)
                soft_attack.add(equipment.soft_attack)
                hard_attack.add(equipment.hard_attack)
                air_attack.add(equipment.air_attack)
                defense.add(equipment.defense)
                breakthrough.add(equipment.breakthrough)
                armor_value.add(equipment.armor_value)
                ap_attack.add(equipment.ap_attack)
                hardness.add(equipment.hardness)
            }
        }
        var technologieModifier = TechnologieModifier()
        if (usedTechnologies.contains(battalionType)) {
            technologieModifier = usedTechnologies[battalionType] as TechnologieModifier
        }
        with(battalion) {
            maximum_speed = (1 + maximum_speed) * battalionEquipmentsStats.maximum_speed.max()!!
            soft_attack =
                (1 + soft_attack + technologieModifier.soft_attack.sum()) * battalionEquipmentsStats.soft_attack.sum()
            hard_attack =
                (1 + hard_attack + technologieModifier.hard_attack.sum()) * battalionEquipmentsStats.hard_attack.sum()
            air_attack =
                (1 + air_attack + technologieModifier.air_attack.sum()) * battalionEquipmentsStats.air_attack.sum()
            defense =
                (1 + defense + technologieModifier.defense.sum()) * battalionEquipmentsStats.defense.sum()
            breakthrough =
                (1 + breakthrough + technologieModifier.breakthrough.sum()) * battalionEquipmentsStats.breakthrough.sum()
            armor_value =
                (1 + armor_value) * battalionEquipmentsStats.armor_value.sum() + technologieModifier.armor_value.sum()
            ap_attack =
                (1 + ap_attack + technologieModifier.ap_attack.sum()) * battalionEquipmentsStats.ap_attack.sum()
            hardness = (1 + hardness) * battalionEquipmentsStats.hardness.sum()
            max_organisation += technologieModifier.max_organisation.sum()
        }


        return battalion
    }
}