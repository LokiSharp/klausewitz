package clausewitz.hoi4.types


data class Equipments(
    val equipments: Map<String, Equipment>
)

data class Equipment(
    val year: Long? = null,
    val archetype: String = "",
    val priority: Double = 0.0,
    val visual_level: Double = 0.0,

    val is_archetype: Boolean = false,
    val picture: String = "",
    val type: List<String>? = null,
    val group_by: String = "",
    val interface_category: String = "",
    val reliability: Double = 0.0,

    val defense: Double = 0.0,
    val breakthrough: Double = 0.0,
    val hardness: Double = 0.0,
    val armor_value: Double = 0.0,

    val soft_attack: Double = 0.0,
    val hard_attack: Double = 0.0,
    val ap_attack: Double = 0.0,
    val air_attack: Double = 0.0,

    val lend_lease_cost: Double = 0.0,

    val build_cost_ic: Double = 0.0,
    val resources: Map<String, Long>? = null
)