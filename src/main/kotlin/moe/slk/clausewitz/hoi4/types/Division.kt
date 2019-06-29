package moe.slk.clausewitz.hoi4.types

data class Division(
    var name: String,
    var division_names_group: String,
    var priority: MutableMap<String, Double> = mutableMapOf(),
    var combat_width: Double = 0.0,
    var need: MutableMap<String, Long> = mutableMapOf(),
    var manpower: Double = 0.0,
    var training_time: Double = 0.0,
    var hardness: Double = 0.0,
    var fuel_consumption: Double = 0.0,

    var maximum_speed: Double = 0.0,
    var max_strength: Double = 0.0,
    var max_organisation: Double = 0.0,
    var default_morale: Double = 0.0,
    var recon: Double = 0.0,
    var suppression: Double = 0.0,
    var weight: Double = 0.0,
    var supply_consumption: Double = 0.0,
    var reliability_factor: Double = 0.0,
    var casualty_trickleback: Double = 0.0,
    var experience_loss_factor: Double = 0.0,
    var equipment_capture_factor: Double = 0.0,
    var entrenchment: Double = 0.0,

    var soft_attack: Double = 0.0,
    var hard_attack: Double = 0.0,
    var air_attack: Double = 0.0,
    var defense: Double = 0.0,
    var breakthrough: Double = 0.0,
    var armor_value: Double = 0.0,
    var ap_attack: Double = 0.0,

    var template: DivisionTemplate = DivisionTemplate(),
    var build_cost: Double = 0.0
) {
    fun calculateStats(divisionStats: DivisionStatus): Division {
        with(this) {
            combat_width = divisionStats.combat_width.sum()
            manpower = divisionStats.manpower.sum()
            training_time = divisionStats.training_time.max()!!
            hardness = divisionStats.hardness.average()
            need = divisionStats.need
            priority = divisionStats.priority
            fuel_consumption = divisionStats.fuel_consumption.sum()

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
            equipment_capture_factor = divisionStats.equipment_capture_factor.sum()
            entrenchment = divisionStats.entrenchment.sum()

            soft_attack = divisionStats.soft_attack.sum()
            hard_attack = divisionStats.hard_attack.sum()
            air_attack = divisionStats.air_attack.sum()
            defense = divisionStats.defense.sum()
            breakthrough = divisionStats.breakthrough.sum()
            armor_value = divisionStats.armor_value.max()!! * 0.3 + divisionStats.armor_value.average() * 0.7
            ap_attack = divisionStats.ap_attack.max()!! * 0.4 + divisionStats.ap_attack.average() * 0.6
        }
        return this
    }
}