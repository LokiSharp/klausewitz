package clausewitz.test

import clausewitz.hoi4.getEquipments
import clausewitz.hoi4.getLandUnits
import clausewitz.hoi4.types.Equipment
import clausewitz.hoi4.types.SubUnit
import org.junit.Assert
import org.junit.Test

class TestHoi4 {
    @Test
    fun testGetLandUnits() {
        val landUnits: MutableMap<String, SubUnit> = getLandUnits()
        Assert.assertNotNull(landUnits)
    }

    @Test
    fun testGetEquipments() {
        val equipments: MutableMap<String, Equipment> = getEquipments()
        Assert.assertNotNull(equipments)
    }
}

