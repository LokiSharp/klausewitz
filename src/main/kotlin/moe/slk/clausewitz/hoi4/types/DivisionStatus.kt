package moe.slk.clausewitz.hoi4.types

data class DivisionStatus(
    val priority: MutableMap<String, Double> = mutableMapOf(),
    val combat_width: MutableList<Double> = mutableListOf(),
    val need: MutableMap<String, Long> = mutableMapOf(),
    val manpower: MutableList<Double> = mutableListOf(),
    val training_time: MutableList<Double> = mutableListOf(),
    val hardness: MutableList<Double> = mutableListOf(),
    val fuel_consumption: MutableList<Double> = mutableListOf(),

    val maximum_speed: MutableList<Double> = mutableListOf(),
    val max_strength: MutableList<Double> = mutableListOf(),
    val max_organisation: MutableList<Double> = mutableListOf(),
    val default_morale: MutableList<Double> = mutableListOf(),
    val recon: MutableList<Double> = mutableListOf(),
    val suppression: MutableList<Double> = mutableListOf(),
    val weight: MutableList<Double> = mutableListOf(),
    val supply_consumption: MutableList<Double> = mutableListOf(),
    val reliability_factor: MutableList<Double> = mutableListOf(),
    val casualty_trickleback: MutableList<Double> = mutableListOf(),
    val experience_loss_factor: MutableList<Double> = mutableListOf(),
    val equipment_capture_factor: MutableList<Double> = mutableListOf(),
    val entrenchment: MutableList<Double> = mutableListOf(),

    val soft_attack: MutableList<Double> = mutableListOf(),
    val hard_attack: MutableList<Double> = mutableListOf(),
    val air_attack: MutableList<Double> = mutableListOf(),
    val defense: MutableList<Double> = mutableListOf(),
    val breakthrough: MutableList<Double> = mutableListOf(),
    val armor_value: MutableList<Double> = mutableListOf(),
    val ap_attack: MutableList<Double> = mutableListOf()
) {
    operator fun plus(battalion: Battalion): DivisionStatus {
        with(this) {
            combat_width.add(battalion.combat_width)
            for (unitNeed in battalion.need) {
                need.merge(unitNeed.key, unitNeed.value) { t, u -> t + u }
            }
            manpower.add(battalion.manpower)
            training_time.add(battalion.training_time)
            hardness.add(battalion.hardness)
            fuel_consumption.add(battalion.fuel_consumption)

            if (battalion.group != "support") {
                maximum_speed.add(battalion.maximum_speed)
            }
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
            equipment_capture_factor.add(battalion.equipment_capture_factor)
            entrenchment.add(battalion.entrenchment)

            soft_attack.add(battalion.soft_attack)
            hard_attack.add(battalion.hard_attack)
            air_attack.add(battalion.air_attack)
            defense.add(battalion.defense)
            breakthrough.add(battalion.breakthrough)
            armor_value.add(battalion.armor_value)
            ap_attack.add(battalion.ap_attack)
        }
        return this
    }
}