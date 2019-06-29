package moe.slk.clausewitz.hoi4.builder

import moe.slk.clausewitz.hoi4.config.defaultBattalionEquipments
import moe.slk.clausewitz.hoi4.config.defaultDataDir
import moe.slk.clausewitz.hoi4.config.defaultEquipments
import moe.slk.clausewitz.hoi4.config.defaultTechnologies
import moe.slk.clausewitz.hoi4.parser.BattalionParser
import moe.slk.clausewitz.hoi4.parser.EquipmentsParser
import moe.slk.clausewitz.hoi4.types.*

class DivisionBuilder(
    dataDir: String = defaultDataDir,
    battalions: Map<String, Battalion> = BattalionParser(dataDir = dataDir).getBattalions(),
    private val equipments: Map<String, Equipment> = EquipmentsParser(dataDir = dataDir).getEquipments(),
    private val usedEquipments: Map<String, String> = defaultEquipments,
    usedBattalionEquipments: Map<String, List<String>> = defaultBattalionEquipments,
    usedTechnologies: Map<String, TechnologiesModifier> = defaultTechnologies
) {
    private val battalionBuilder = BattalionBuilder(
        dataDir,
        battalions,
        equipments,
        usedEquipments,
        usedBattalionEquipments,
        usedTechnologies
    )

    fun calculateStats(division_template: DivisionTemplate): Division {
        val division = Division(
            name = division_template.name,
            division_names_group = division_template.division_names_group
        )

        var divisionStats = DivisionStatus()

        for (regiment in division_template.regiments) {
            val battalion = battalionBuilder.calculateStats(regiment.key)
            for (i in (1..regiment.value)) {
                divisionStats += battalion
                divisionStats.priority.merge(regiment.key, battalion.priority) { t, u -> t + u }
            }
        }

        for (support in division_template.supports) {
            val battalion = battalionBuilder.calculateStats(support)
            divisionStats += battalion
            divisionStats.priority[support] = battalion.priority
        }

        val divisionStat = division.calculateStats(divisionStats)
        divisionStat.template = division_template
        for (e in divisionStats.need) {
            val equipmentName = usedEquipments[e.key] as String
            val equipment = equipments[equipmentName] as Equipment
            divisionStat.build_cost += equipment.build_cost_ic * e.value
        }

        return divisionStat
    }
}
