package moe.slk.clausewitz.hoi4.types

data class BattalionStats(
    val maximum_speed: MutableList<Double> = mutableListOf(),
    val soft_attack: MutableList<Double> = mutableListOf(),
    val hard_attack: MutableList<Double> = mutableListOf(),
    val air_attack: MutableList<Double> = mutableListOf(),
    val defense: MutableList<Double> = mutableListOf(),
    val breakthrough: MutableList<Double> = mutableListOf(),
    val armor_value: MutableList<Double> = mutableListOf(),
    val hardness: MutableList<Double> = mutableListOf(),
    val ap_attack: MutableList<Double> = mutableListOf()
) {
    operator fun plus(equipment: Equipment): BattalionStats {
        with(this) {
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
        return this
    }
}