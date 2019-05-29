package clausewitz.hoi4.builder

import clausewitz.hoi4.types.Division
import clausewitz.hoi4.types.DivisionStatus
import clausewitz.hoi4.types.DivisionTemplate

class DivisionBuilder {
    private val battalionBuilder = BattalionBuilder()
    fun calculateStats(division_template: DivisionTemplate): Division {
        val division = Division(
            name = division_template.name,
            division_names_group = division_template.division_names_group
        )

        val divisionStats = DivisionStatus()

        for (regiment in division_template.regiments) {
            val battalion = battalionBuilder.calculateStats(regiment.key)
            for (i in (1..regiment.value)) {
                divisionStats.maximum_speed.add(battalion.maximum_speed)
                divisionStats.max_strength.add(battalion.max_strength)
                divisionStats.max_organisation.add(battalion.max_organisation)
                divisionStats.default_morale.add(battalion.default_morale)
                divisionStats.recon.add(battalion.recon)
                divisionStats.suppression.add(battalion.suppression)
                divisionStats.weight.add(battalion.weight)
                divisionStats.supply_consumption.add(battalion.supply_consumption)
                divisionStats.reliability_factor.add(battalion.reliability_factor)
                divisionStats.casualty_trickleback.add(battalion.casualty_trickleback)
                divisionStats.experience_loss_factor.add(battalion.experience_loss_factor)
                divisionStats.soft_attack.add(battalion.soft_attack)
                divisionStats.hard_attack.add(battalion.hard_attack)
                divisionStats.air_attack.add(battalion.air_attack)
                divisionStats.defense.add(battalion.defense)
                divisionStats.breakthrough.add(battalion.breakthrough)
                divisionStats.armor_value.add(battalion.armor_value)
                divisionStats.ap_attack.add(battalion.ap_attack)
                divisionStats.entrenchment.add(battalion.entrenchment)
                divisionStats.equipment_capture_factor.add(battalion.equipment_capture_factor)
                divisionStats.combat_width.add(battalion.combat_width)
                divisionStats.manpower.add(battalion.manpower)
                divisionStats.training_time.add(battalion.training_time)
                divisionStats.hardness.add(battalion.hardness)
                for (unitNeed in battalion.need) {
                    divisionStats.need.merge(unitNeed.key, unitNeed.value) { t, u -> t + u }
                }
                divisionStats.priority.merge(regiment.key, battalion.priority) { t, u -> t + u }
            }
        }

        for (support in division_template.supports) {
            val battalion = battalionBuilder.calculateStats(support)
            divisionStats.max_strength.add(battalion.max_strength)
            divisionStats.max_organisation.add(battalion.max_organisation)
            divisionStats.default_morale.add(battalion.default_morale)
            divisionStats.recon.add(battalion.recon)
            divisionStats.suppression.add(battalion.suppression)
            divisionStats.weight.add(battalion.weight)
            divisionStats.supply_consumption.add(battalion.supply_consumption)
            divisionStats.reliability_factor.add(battalion.reliability_factor)
            divisionStats.casualty_trickleback.add(battalion.casualty_trickleback)
            divisionStats.experience_loss_factor.add(battalion.experience_loss_factor)
            divisionStats.soft_attack.add(battalion.soft_attack)
            divisionStats.hard_attack.add(battalion.hard_attack)
            divisionStats.air_attack.add(battalion.air_attack)
            divisionStats.defense.add(battalion.defense)
            divisionStats.breakthrough.add(battalion.breakthrough)
            divisionStats.armor_value.add(battalion.armor_value)
            divisionStats.ap_attack.add(battalion.ap_attack)
            divisionStats.entrenchment.add(battalion.entrenchment)
            divisionStats.equipment_capture_factor.add(battalion.equipment_capture_factor)
            divisionStats.combat_width.add(battalion.combat_width)
            divisionStats.manpower.add(battalion.manpower)
            divisionStats.training_time.add(battalion.training_time)
            divisionStats.hardness.add(battalion.hardness)
            for (unitNeed in battalion.need) {
                divisionStats.need.merge(unitNeed.key, unitNeed.value) { t, u -> t + u }
            }
            divisionStats.priority.merge(support, battalion.priority) { t, u -> t + u }
        }
        division.maximum_speed = divisionStats.maximum_speed.min()!!
        division.max_strength = divisionStats.max_strength.sum()
        division.max_organisation = divisionStats.max_organisation.sum()
        division.default_morale = divisionStats.default_morale.sum()
        division.recon = divisionStats.recon.sum()
        division.suppression = divisionStats.suppression.sum()
        division.weight = divisionStats.weight.sum()
        division.supply_consumption = divisionStats.supply_consumption.sum()
        division.reliability_factor = divisionStats.reliability_factor.sum()
        division.casualty_trickleback = divisionStats.casualty_trickleback.sum()
        division.experience_loss_factor = divisionStats.experience_loss_factor.sum()
        division.soft_attack = divisionStats.soft_attack.sum()
        division.hard_attack = divisionStats.hard_attack.sum()
        division.air_attack = divisionStats.air_attack.sum()
        division.defense = divisionStats.defense.sum()
        division.breakthrough = divisionStats.breakthrough.sum()
        division.armor_value = divisionStats.armor_value.sum()
        division.ap_attack = divisionStats.ap_attack.sum()
        division.entrenchment = divisionStats.entrenchment.sum()
        division.equipment_capture_factor = divisionStats.equipment_capture_factor.sum()
        division.combat_width = divisionStats.combat_width.sum()
        division.manpower = divisionStats.manpower.sum()
        division.training_time = divisionStats.training_time.max()!!
        division.hardness = divisionStats.hardness.sum()
        division.need = divisionStats.need
        division.priority = divisionStats.priority
        return division
    }
}
