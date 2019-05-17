package clausewitz.hoi4

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

    val forest: Status = Status(),
    val hills: Status = Status(),
    val mountain: Status = Status(),
    val plains: Status = Status(),
    val jungle: Status = Status(),
    val marsh: Status = Status(),
    val desert: Status = Status(),
    val fort: Status = Status(),
    val river: Status = Status(),
    val amphibious: Status = Status()

)

data class Status(
    val attack: Double = 0.0,
    val movement: Double = 0.0,
    val defense: Double = 0.0
)

data class Equipments(
    val equipments: Map<String, Equipment>
)

data class Equipment(
    val year: Long? = null,
    val archetype: String? = null,
    val priority: Double? = null,
    val visual_level: Double? = null,

    val is_archetype: Boolean? = null,
    val picture: String? = null,
    val type: List<String>? = null,
    val group_by: String? = null,
    val interface_category: String? = null,
    val reliability: Double? = null,

    val defense: Double? = null,
    val breakthrough: Double? = null,
    val hardness: Double? = null,
    val armor_value: Double? = null,

    val soft_attack: Double? = null,
    val hard_attack: Double? = null,
    val ap_attack: Double? = null,
    val air_attack: Double? = null,

    val lend_lease_cost: Double? = null,

    val build_cost_ic: Double? = null,
    val resources: Map<String, Long>? = null
)