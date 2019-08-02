package moe.slk.clausewitz.hoi4.builder

import moe.slk.clausewitz.hoi4.config.defaultBattalionEquipments
import moe.slk.clausewitz.hoi4.config.defaultDataDir
import moe.slk.clausewitz.hoi4.config.defaultEquipments
import moe.slk.clausewitz.hoi4.config.defaultTechnologies
import moe.slk.clausewitz.hoi4.parser.BattalionsParser
import moe.slk.clausewitz.hoi4.parser.EquipmentsParser
import moe.slk.clausewitz.hoi4.types.Battalion
import moe.slk.clausewitz.hoi4.types.BattalionStats
import moe.slk.clausewitz.hoi4.types.Equipment
import moe.slk.clausewitz.hoi4.types.TechnologiesModifier

class BattalionBuilder(
    private val dataDir: String = defaultDataDir,
    private val battalions: Map<String, Battalion> = BattalionsParser(dataDir = dataDir).getBattalions(),
    private val equipments: Map<String, Equipment> = EquipmentsParser(dataDir = dataDir).getEquipments(),
    private val usedEquipments: Map<String, String> = defaultEquipments,
    private val usedBattalionEquipments: Map<String, List<String>> = defaultBattalionEquipments,
    private val usedTechnologies: Map<String, TechnologiesModifier> = defaultTechnologies
) {
    fun calculateStats(battalionType: String): Battalion {
        val battalion = (battalions[battalionType] as Battalion).copy()
        var battalionEquipmentsStats = BattalionStats()
        for (equipmentType in usedBattalionEquipments[battalionType] as List) {
            val equipmentName = usedEquipments[equipmentType] as String
            val equipment = equipments[equipmentName] as Equipment
            battalionEquipmentsStats += equipment
        }
        var technologieModifier = TechnologiesModifier()
        if (usedTechnologies.contains(battalionType)) {
            technologieModifier = usedTechnologies[battalionType] as TechnologiesModifier
        }
        return battalion.calculateStats(battalionEquipmentsStats, technologieModifier)
    }
}