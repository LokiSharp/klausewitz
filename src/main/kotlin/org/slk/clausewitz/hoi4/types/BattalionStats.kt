package org.slk.clausewitz.hoi4.types

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
)