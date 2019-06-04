package moe.slk.clausewitz.hoi4.builder

import moe.slk.clausewitz.hoi4.config.defaultDataDir
import moe.slk.clausewitz.hoi4.types.Division
import moe.slk.clausewitz.hoi4.types.DivisionStatus
import moe.slk.clausewitz.hoi4.types.DivisionTemplate

class DivisionBuilder(
    dataDir: String = defaultDataDir
) {
    private val battalionBuilder = BattalionBuilder(dataDir = dataDir)

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

        return division.calculateStats(divisionStats)
    }
}
