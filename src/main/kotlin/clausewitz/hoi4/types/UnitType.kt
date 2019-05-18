package clausewitz.hoi4.types

data class SubUnits(
    val sub_units: Map<String, SubUnit>
)

data class SubUnit(
    val sprite: String,
    val map_icon_category: String,
    val priority: Double = 0.0,
    val ai_priority: Double = 0.0,
    val active: Boolean = false,
    val group: String,
    val type: List<String>,
    val categories: List<String>,
    val combat_width: Double = 0.0,
    val need: Map<String, Long>,
    val manpower: Double = 0.0,
    val max_organisation: Double = 0.0,
    val default_morale: Double = 0.0,
    val max_strength: Double = 0.0,
    val training_time: Double = 0.0,
    val weight: Double = 0.0,
    val supply_consumption: Double = 0.0,
    val can_be_parachuted: Boolean = false,
    val defense: Double = 0.0,
    val breakthrough: Double = 0.0,
    val soft_attack: Double = 0.0,
    val hard_attack: Double = 0.0,
    val ap_attack: Double = 0.0,
    val essential: String = "",
    val suppression: Double = 0.0,
    val transport: String = "",
    val hardness: Double = 0.0,

    val forest: TerrainModifier = TerrainModifier(),
    val hills: TerrainModifier = TerrainModifier(),
    val mountain: TerrainModifier = TerrainModifier(),
    val plains: TerrainModifier = TerrainModifier(),
    val jungle: TerrainModifier = TerrainModifier(),
    val marsh: TerrainModifier = TerrainModifier(),
    val desert: TerrainModifier = TerrainModifier(),
    val fort: TerrainModifier = TerrainModifier(),
    val river: TerrainModifier = TerrainModifier(),
    val amphibious: TerrainModifier = TerrainModifier()

)

data class TerrainModifier(
    val attack: Double = 0.0,
    val movement: Double = 0.0,
    val defense: Double = 0.0
)
