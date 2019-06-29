package moe.slk.clausewitz.hoi4.types

data class DivisionTemplate(
    var name: String = "",
    var division_names_group: String = "",
    var regiments: Map<String, Int> = mapOf(),
    var supports: List<String> = listOf()
)