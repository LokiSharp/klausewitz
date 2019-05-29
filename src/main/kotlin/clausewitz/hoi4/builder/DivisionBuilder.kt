package clausewitz.hoi4.builder

import clausewitz.hoi4.types.DivisionStatus
import clausewitz.hoi4.types.DivisionTemplate

class DivisionBuilder {
    fun calculateStats(division_template: DivisionTemplate) {
        val divisionStatus = DivisionStatus(
            name = division_template.name,
            division_names_group = division_template.division_names_group
        )
        println(divisionStatus)
        println(division_template)
        for (i in division_template.regiments) {
            println(i.key)
        }

        for (i in division_template.supports) {
            println(i)
        }
    }
}
