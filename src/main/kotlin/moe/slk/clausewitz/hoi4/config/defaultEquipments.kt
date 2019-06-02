package moe.slk.clausewitz.hoi4.config

val defaultEquipments: Map<String, List<String>> = mapOf(
    "infantry" to listOf("infantry_equipment_3"),
    "bicycle_battalion" to listOf("infantry_equipment_3"),
    "marine" to listOf("infantry_equipment_3"),
    "mountaineers" to listOf("infantry_equipment_3"),
    "paratrooper" to listOf("infantry_equipment_3"),
    "motorized" to listOf("infantry_equipment_3", "motorized_equipment_1"),
    "mechanized" to listOf("infantry_equipment_3", "mechanized_equipment_3"),
    "cavalry" to listOf("infantry_equipment_3"),
    "artillery_brigade" to listOf("artillery_equipment_3"),
    "anti_air_brigade" to listOf("anti_air_equipment_3"),
    "anti_tank_brigade" to listOf("anti_tank_equipment_3"),
    "rocket_artillery_brigade" to listOf("rocket_artillery_equipment_2"),
    "motorized_rocket_brigade" to listOf("motorized_rocket_equipment_1"),
    "artillery" to listOf("artillery_equipment_3"),
    "anti_air" to listOf("anti_air_equipment_3"),
    "anti_tank" to listOf("anti_tank_equipment_3"),
    "rocket_artillery" to listOf("rocket_artillery_equipment_2"),
    "engineer" to listOf("infantry_equipment_3", "support_equipment_1"),
    "recon" to listOf("infantry_equipment_3"),

    "light_armor" to listOf("light_tank_equipment_3"),
    "medium_armor" to listOf("medium_tank_equipment_3"),
    "heavy_armor" to listOf("heavy_tank_equipment_3"),
    "super_heavy_armor" to listOf("super_heavy_tank_equipment_1"),
    "modern_armor" to listOf("modern_tank_equipment_1"),

    "light_tank_destroyer_brigade" to listOf("light_tank_destroyer_equipment_3"),
    "medium_tank_destroyer_brigade" to listOf("medium_tank_destroyer_equipment_3"),
    "heavy_tank_destroyer_brigade" to listOf("heavy_tank_destroyer_equipment_3"),
    "super_heavy_tank_destroyer_brigade" to listOf("super_heavy_tank_destroyer_equipment_1"),
    "modern_tank_destroyer_brigade" to listOf("modern_tank_destroyer_equipment_1"),

    "light_sp_artillery_brigade" to listOf("light_tank_artillery_equipment_3"),
    "medium_sp_artillery_brigade" to listOf("medium_tank_artillery_equipment_3"),
    "heavy_sp_artillery_brigade" to listOf("heavy_tank_artillery_equipment_3"),
    "super_heavy_sp_artillery_brigade" to listOf("super_heavy_tank_artillery_equipment_1"),
    "modern_sp_artillery_brigade" to listOf("modern_tank_artillery_equipment_1"),

    "light_sp_anti_air_brigade" to listOf("light_tank_aa_equipment_3"),
    "medium_sp_anti_air_brigade" to listOf("medium_tank_aa_equipment_3"),
    "heavy_sp_anti_air_brigade" to listOf("heavy_tank_aa_equipment_3"),
    "super_sp_anti_air_brigade" to listOf("super_heavy_tank_aa_equipment_1"),
    "modern_sp_anti_air_brigade" to listOf("modern_tank_aa_equipment_1")
)