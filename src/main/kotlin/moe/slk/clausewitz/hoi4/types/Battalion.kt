package moe.slk.clausewitz.hoi4.types

data class Battalion(
    var sprite: String = "",
    var map_icon_category: String = "",
    var priority: Double = 0.0,
    var ai_priority: Double = 0.0,
    var active: Boolean = false,
    var group: String = "",
    var type: List<String> = listOf(),
    var categories: List<String> = listOf(),
    var combat_width: Double = 0.0,
    var need: Map<String, Long> = mutableMapOf(),
    var manpower: Double = 0.0,
    var training_time: Double = 0.0,
    var can_be_parachuted: Boolean = false,
    var hardness: Double = 0.0,

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

    var essential: String = "",
    var transport: String = "",

    var forest: TerrainModifier = TerrainModifier(),
    var hills: TerrainModifier = TerrainModifier(),
    var mountain: TerrainModifier = TerrainModifier(),
    var plains: TerrainModifier = TerrainModifier(),
    var jungle: TerrainModifier = TerrainModifier(),
    var marsh: TerrainModifier = TerrainModifier(),
    var desert: TerrainModifier = TerrainModifier(),
    var fort: TerrainModifier = TerrainModifier(),
    var river: TerrainModifier = TerrainModifier(),
    var amphibious: TerrainModifier = TerrainModifier()

) {
    fun calculateStats(battalionEquipmentsStats: BattalionStats, technologieModifier: TechnologieModifier): Battalion {
        with(this) {
            maximum_speed =
                (1 + technologieModifier.maximum_speed.sum()) * battalionEquipmentsStats.maximum_speed.max()!!
            soft_attack =
                (1 + soft_attack + technologieModifier.soft_attack.sum()) * battalionEquipmentsStats.soft_attack.sum()
            hard_attack =
                (1 + hard_attack + technologieModifier.hard_attack.sum()) * battalionEquipmentsStats.hard_attack.sum()
            air_attack =
                (1 + air_attack + technologieModifier.air_attack.sum()) * battalionEquipmentsStats.air_attack.sum()
            defense =
                (1 + defense + technologieModifier.defense.sum()) * battalionEquipmentsStats.defense.sum()
            breakthrough =
                (1 + breakthrough + technologieModifier.breakthrough.sum()) * battalionEquipmentsStats.breakthrough.sum()
            armor_value =
                (1 + armor_value) * battalionEquipmentsStats.armor_value.sum() + technologieModifier.armor_value.sum()
            ap_attack =
                (1 + ap_attack + technologieModifier.ap_attack.sum()) * battalionEquipmentsStats.ap_attack.sum()
            hardness = (1 + hardness) * battalionEquipmentsStats.hardness.sum()
            max_organisation += technologieModifier.max_organisation.sum()
        }
        return this
    }
}

