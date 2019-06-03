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

        val divisionStats = DivisionStatus()

        for (regiment in division_template.regiments) {

            with(divisionStats) {
                val battalion = battalionBuilder.calculateStats(regiment.key)
                for (i in (1..regiment.value)) {
                    maximum_speed.add(battalion.maximum_speed)
                    max_strength.add(battalion.max_strength)
                    max_organisation.add(battalion.max_organisation)
                    default_morale.add(battalion.default_morale)
                    recon.add(battalion.recon)
                    suppression.add(battalion.suppression)
                    weight.add(battalion.weight)
                    supply_consumption.add(battalion.supply_consumption)
                    reliability_factor.add(battalion.reliability_factor)
                    casualty_trickleback.add(battalion.casualty_trickleback)
                    experience_loss_factor.add(battalion.experience_loss_factor)
                    soft_attack.add(battalion.soft_attack)
                    hard_attack.add(battalion.hard_attack)
                    air_attack.add(battalion.air_attack)
                    defense.add(battalion.defense)
                    breakthrough.add(battalion.breakthrough)
                    armor_value.add(battalion.armor_value)
                    ap_attack.add(battalion.ap_attack)
                    entrenchment.add(battalion.entrenchment)
                    equipment_capture_factor.add(battalion.equipment_capture_factor)
                    combat_width.add(battalion.combat_width)
                    manpower.add(battalion.manpower)
                    training_time.add(battalion.training_time)
                    hardness.add(battalion.hardness)
                    for (unitNeed in battalion.need) {
                        need.merge(unitNeed.key, unitNeed.value) { t, u -> t + u }
                    }
                    priority.merge(regiment.key, battalion.priority) { t, u -> t + u }
                }
            }
            with(divisionStats) {
                for (support in division_template.supports) {
                    val battalion = battalionBuilder.calculateStats(support)
                    max_strength.add(battalion.max_strength)
                    max_organisation.add(battalion.max_organisation)
                    default_morale.add(battalion.default_morale)
                    recon.add(battalion.recon)
                    suppression.add(battalion.suppression)
                    weight.add(battalion.weight)
                    supply_consumption.add(battalion.supply_consumption)
                    reliability_factor.add(battalion.reliability_factor)
                    casualty_trickleback.add(battalion.casualty_trickleback)
                    experience_loss_factor.add(battalion.experience_loss_factor)
                    soft_attack.add(battalion.soft_attack)
                    hard_attack.add(battalion.hard_attack)
                    air_attack.add(battalion.air_attack)
                    defense.add(battalion.defense)
                    breakthrough.add(battalion.breakthrough)
                    armor_value.add(battalion.armor_value)
                    ap_attack.add(battalion.ap_attack)
                    entrenchment.add(battalion.entrenchment)
                    equipment_capture_factor.add(battalion.equipment_capture_factor)
                    combat_width.add(battalion.combat_width)
                    manpower.add(battalion.manpower)
                    training_time.add(battalion.training_time)
                    hardness.add(battalion.hardness)
                    for (unitNeed in battalion.need) {
                        need.merge(unitNeed.key, unitNeed.value) { t, u -> t + u }
                    }
                    divisionStats.priority[support] = battalion.priority
                }
            }
        }
        with(division) {
            maximum_speed = divisionStats.maximum_speed.min()!!
            max_strength = divisionStats.max_strength.sum()
            max_organisation = divisionStats.max_organisation.average()
            default_morale = divisionStats.default_morale.average()
            recon = divisionStats.recon.sum()
            suppression = divisionStats.suppression.sum()
            weight = divisionStats.weight.sum()
            supply_consumption = divisionStats.supply_consumption.sum()
            reliability_factor = divisionStats.reliability_factor.sum()
            casualty_trickleback = divisionStats.casualty_trickleback.sum()
            experience_loss_factor = divisionStats.experience_loss_factor.sum()
            soft_attack = divisionStats.soft_attack.sum()
            hard_attack = divisionStats.hard_attack.sum()
            air_attack = divisionStats.air_attack.sum()
            defense = divisionStats.defense.sum()
            breakthrough = divisionStats.breakthrough.sum()
            armor_value = divisionStats.armor_value.max()!! * 0.3 + divisionStats.armor_value.average() * 0.7
            ap_attack = divisionStats.ap_attack.max()!! * 0.4 + divisionStats.ap_attack.average() * 0.6
            entrenchment = divisionStats.entrenchment.sum()
            equipment_capture_factor = divisionStats.equipment_capture_factor.sum()
            combat_width = divisionStats.combat_width.sum()
            manpower = divisionStats.manpower.sum()
            training_time = divisionStats.training_time.max()!!
            hardness = divisionStats.hardness.average()
            need = divisionStats.need
            priority = divisionStats.priority
        }
        return division
    }
}
