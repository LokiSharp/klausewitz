package moe.slk.clausewitz.hoi4.config

val defaultBattalionEquipments: Map<String, List<String>> = mapOf(
    "infantry" to listOf("infantry_equipment"),
    "bicycle_battalion" to listOf("infantry_equipment"),
    "marine" to listOf("infantry_equipment"),
    "mountaineers" to listOf("infantry_equipment"),
    "paratrooper" to listOf("infantry_equipment"),
    "motorized" to listOf("infantry_equipment", "motorized_equipment"),
    "mechanized" to listOf("infantry_equipment", "mechanized_equipment"),
    "cavalry" to listOf("infantry_equipment"),
    "artillery_brigade" to listOf("artillery_equipment"),
    "anti_air_brigade" to listOf("anti_air_equipment"),
    "anti_tank_brigade" to listOf("anti_tank_equipment"),
    "rocket_artillery_brigade" to listOf("rocket_artillery_equipment"),
    "motorized_rocket_brigade" to listOf("motorized_rocket_equipment"),
    "artillery" to listOf("artillery_equipment"),
    "anti_air" to listOf("anti_air_equipment"),
    "anti_tank" to listOf("anti_tank_equipment"),
    "rocket_artillery" to listOf("rocket_artillery_equipment"),
    "engineer" to listOf("infantry_equipment", "support_equipment"),
    "recon" to listOf("infantry_equipment"),

    "light_armor" to listOf("light_tank_equipment"),
    "medium_armor" to listOf("medium_tank_equipment"),
    "heavy_armor" to listOf("heavy_tank_equipment"),
    "super_heavy_armor" to listOf("super_heavy_tank_equipment"),
    "modern_armor" to listOf("modern_tank_equipment"),

    "light_tank_destroyer_brigade" to listOf("light_tank_destroyer_equipment"),
    "medium_tank_destroyer_brigade" to listOf("medium_tank_destroyer_equipment"),
    "heavy_tank_destroyer_brigade" to listOf("heavy_tank_destroyer_equipment"),
    "super_heavy_tank_destroyer_brigade" to listOf("super_heavy_tank_destroyer_equipment"),
    "modern_tank_destroyer_brigade" to listOf("modern_tank_destroyer_equipment"),

    "light_sp_artillery_brigade" to listOf("light_tank_artillery_equipment"),
    "medium_sp_artillery_brigade" to listOf("medium_tank_artillery_equipment"),
    "heavy_sp_artillery_brigade" to listOf("heavy_tank_artillery_equipment"),
    "super_heavy_sp_artillery_brigade" to listOf("super_heavy_tank_artillery_equipment"),
    "modern_sp_artillery_brigade" to listOf("modern_tank_artillery_equipment"),

    "light_sp_anti_air_brigade" to listOf("light_tank_aa_equipment"),
    "medium_sp_anti_air_brigade" to listOf("medium_tank_aa_equipment"),
    "heavy_sp_anti_air_brigade" to listOf("heavy_tank_aa_equipment"),
    "super_sp_anti_air_brigade" to listOf("super_heavy_tank_aa_equipment"),
    "modern_sp_anti_air_brigade" to listOf("modern_tank_aa_equipment")
)