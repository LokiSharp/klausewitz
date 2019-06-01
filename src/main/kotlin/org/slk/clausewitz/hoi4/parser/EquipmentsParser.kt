package org.slk.clausewitz.hoi4.parser

import org.slk.clausewitz.config.equipmentDir
import org.slk.clausewitz.config.equipmentFileList
import org.slk.clausewitz.hoi4.types.Equipment
import org.slk.clausewitz.hoi4.types.Equipments
import org.slk.clausewitz.parser.parseClausewitzFile

class EquipmentsParser {
    fun getEquipments(): MutableMap<String, Equipment> {
        val equipments: MutableMap<String, Equipment> = mutableMapOf()
        for (filename in equipmentFileList) {
            val parse = parseClausewitzFile("$equipmentDir/$filename") as Equipments
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
}

