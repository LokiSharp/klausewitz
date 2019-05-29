package clausewitz.hoi4.builder

import clausewitz.hoi4.types.Division
import clausewitz.hoi4.types.DivisionStatus
import clausewitz.hoi4.types.DivisionTemplate

class DivisionBuilder {
    private val landUnitBuilder = LandUnitBuilder()
    fun calculateStats(division_template: DivisionTemplate): Division {
        val division = Division(
            name = division_template.name,
            division_names_group = division_template.division_names_group
        )

        val divisionStatus = DivisionStatus()

        for (regiment in division_template.regiments) {
            val landUnit = landUnitBuilder.calculateStats(regiment.key)
            for (i in (1..regiment.value)) {
                divisionStatus.maximum_speed.add(landUnit.maximum_speed)
                divisionStatus.max_strength.add(landUnit.max_strength)
                divisionStatus.max_organisation.add(landUnit.max_organisation)
                divisionStatus.default_morale.add(landUnit.default_morale)
                divisionStatus.recon.add(landUnit.recon)
                divisionStatus.suppression.add(landUnit.suppression)
                divisionStatus.weight.add(landUnit.weight)
                divisionStatus.supply_consumption.add(landUnit.supply_consumption)
                divisionStatus.reliability_factor.add(landUnit.reliability_factor)
                divisionStatus.casualty_trickleback.add(landUnit.casualty_trickleback)
                divisionStatus.experience_loss_factor.add(landUnit.experience_loss_factor)
                divisionStatus.soft_attack.add(landUnit.soft_attack)
                divisionStatus.hard_attack.add(landUnit.hard_attack)
                divisionStatus.air_attack.add(landUnit.air_attack)
                divisionStatus.defense.add(landUnit.defense)
                divisionStatus.breakthrough.add(landUnit.breakthrough)
                divisionStatus.armor_value.add(landUnit.armor_value)
                divisionStatus.ap_attack.add(landUnit.ap_attack)
                divisionStatus.entrenchment.add(landUnit.entrenchment)
                divisionStatus.equipment_capture_factor.add(landUnit.equipment_capture_factor)
                divisionStatus.combat_width.add(landUnit.combat_width)
                divisionStatus.manpower.add(landUnit.manpower)
                divisionStatus.training_time.add(landUnit.training_time)
                divisionStatus.hardness.add(landUnit.hardness)
                for (unitNeed in landUnit.need) {
                    divisionStatus.need.merge(unitNeed.key, unitNeed.value) { t, u -> t + u }
                }
                divisionStatus.priority.merge(regiment.key, landUnit.priority) { t, u -> t + u }
            }
        }

        for (support in division_template.supports) {
            val landUnit = landUnitBuilder.calculateStats(support)
            divisionStatus.max_strength.add(landUnit.max_strength)
            divisionStatus.max_organisation.add(landUnit.max_organisation)
            divisionStatus.default_morale.add(landUnit.default_morale)
            divisionStatus.recon.add(landUnit.recon)
            divisionStatus.suppression.add(landUnit.suppression)
            divisionStatus.weight.add(landUnit.weight)
            divisionStatus.supply_consumption.add(landUnit.supply_consumption)
            divisionStatus.reliability_factor.add(landUnit.reliability_factor)
            divisionStatus.casualty_trickleback.add(landUnit.casualty_trickleback)
            divisionStatus.experience_loss_factor.add(landUnit.experience_loss_factor)
            divisionStatus.soft_attack.add(landUnit.soft_attack)
            divisionStatus.hard_attack.add(landUnit.hard_attack)
            divisionStatus.air_attack.add(landUnit.air_attack)
            divisionStatus.defense.add(landUnit.defense)
            divisionStatus.breakthrough.add(landUnit.breakthrough)
            divisionStatus.armor_value.add(landUnit.armor_value)
            divisionStatus.ap_attack.add(landUnit.ap_attack)
            divisionStatus.entrenchment.add(landUnit.entrenchment)
            divisionStatus.equipment_capture_factor.add(landUnit.equipment_capture_factor)
            divisionStatus.combat_width.add(landUnit.combat_width)
            divisionStatus.manpower.add(landUnit.manpower)
            divisionStatus.training_time.add(landUnit.training_time)
            divisionStatus.hardness.add(landUnit.hardness)
            for (unitNeed in landUnit.need) {
                divisionStatus.need.merge(unitNeed.key, unitNeed.value) { t, u -> t + u }
            }
            divisionStatus.priority.merge(support, landUnit.priority) { t, u -> t + u }
        }
        division.maximum_speed = divisionStatus.maximum_speed.min()!!
        division.max_strength = divisionStatus.max_strength.sum()
        division.max_organisation = divisionStatus.max_organisation.sum()
        division.default_morale = divisionStatus.default_morale.sum()
        division.recon = divisionStatus.recon.sum()
        division.suppression = divisionStatus.suppression.sum()
        division.weight = divisionStatus.weight.sum()
        division.supply_consumption = divisionStatus.supply_consumption.sum()
        division.reliability_factor = divisionStatus.reliability_factor.sum()
        division.casualty_trickleback = divisionStatus.casualty_trickleback.sum()
        division.experience_loss_factor = divisionStatus.experience_loss_factor.sum()
        division.soft_attack = divisionStatus.soft_attack.sum()
        division.hard_attack = divisionStatus.hard_attack.sum()
        division.air_attack = divisionStatus.air_attack.sum()
        division.defense = divisionStatus.defense.sum()
        division.breakthrough = divisionStatus.breakthrough.sum()
        division.armor_value = divisionStatus.armor_value.sum()
        division.ap_attack = divisionStatus.ap_attack.sum()
        division.entrenchment = divisionStatus.entrenchment.sum()
        division.equipment_capture_factor = divisionStatus.equipment_capture_factor.sum()
        division.combat_width = divisionStatus.combat_width.sum()
        division.manpower = divisionStatus.manpower.sum()
        division.training_time = divisionStatus.training_time.max()!!
        division.hardness = divisionStatus.hardness.sum()
        division.need = divisionStatus.need
        division.priority = divisionStatus.priority
        return division
    }
}
