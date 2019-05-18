package clausewitz.hoi4

import clausewitz.config.dir
import clausewitz.config.equipmentFileList
import clausewitz.config.unitsFileList
import clausewitz.parser.parseClausewitzFile


fun getLandUnits(): MutableMap<String, SubUnit> {
    val landUnits: MutableMap<String, SubUnit> = mutableMapOf()
    for (filename in unitsFileList) {
        val parse = parseClausewitzFile("$dir/common/units/$filename") as SubUnits
        landUnits.putAll(parse.sub_units)
    }

    return landUnits
}

fun getEquipments(): MutableMap<String, Equipment> {
    val equipments: MutableMap<String, Equipment> = mutableMapOf()
    for (filename in equipmentFileList) {
        val parse = parseClausewitzFile("$dir/common/units/equipment/$filename") as Equipments
        var base = Equipment()
        for (equipment in parse.equipments) {
            if (equipment.key.last().isDigit()) {
                val target = equipment.value.copy()
                val targetFields = target.javaClass.declaredFields
                val baseFields = base.javaClass.declaredFields
                for (index in 0 until equipment.value.javaClass.declaredFields.size) {
                    val targetField = targetFields[index]
                    val baseField = baseFields[index]
                    targetField.isAccessible = true
                    baseField.isAccessible = true
                    val checkField = targetField.get(equipment.value)
                    if (
                        checkField == "" ||
                        checkField == 0.0 ||
                        checkField == null ||
                        checkField == false
                    ) {
                        targetField.set(
                            target,
                            baseField.get(base)
                        )
                    }
                }
                equipments.put(equipment.key, target)
            } else {
                base = equipment.value
            }
        }
    }

    return equipments
}
