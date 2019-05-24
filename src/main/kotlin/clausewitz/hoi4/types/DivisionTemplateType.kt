package clausewitz.hoi4.types

data class DivisionTemplateType(
    var name: String,
    var division_names_group: String,
    var regiments: List<String>,
    var supports: List<String>
)