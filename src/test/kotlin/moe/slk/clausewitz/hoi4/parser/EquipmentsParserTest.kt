package moe.slk.clausewitz.hoi4.parser

import moe.slk.clausewitz.hoi4.types.Equipment
import org.junit.Assert.assertNotNull
import org.junit.Test

class EquipmentsParserTest {

    @Test
    fun getEquipments() {
        val equipments: MutableMap<String, Equipment> = EquipmentsParser().getEquipments()
        assertNotNull(equipments)
    }
}