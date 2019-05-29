package clausewitz.hoi4.types

data class TechnologieModifier(
    val soft_attack: List<Double> = listOf(0.0),
    val hard_attack: List<Double> = listOf(0.0),
    val ap_attack: List<Double> = listOf(0.0),
    val air_attack: List<Double> = listOf(0.0),
    val armor_value: List<Double> = listOf(0.0),
    val defense: List<Double> = listOf(0.0),
    val breakthrough: List<Double> = listOf(0.0),
    val max_organisation: List<Double> = listOf(0.0)
)