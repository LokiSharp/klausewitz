package clausewitz.test


import clausewitz.hoi4.Equipment
import clausewitz.hoi4.SubUnit
import clausewitz.hoi4.getEquipments
import clausewitz.hoi4.getLandUnits
import org.junit.Assert
import org.junit.Test


class TestHoi4 {

    private val landUnits: MutableMap<String, SubUnit> = getLandUnits()
    private val equipments: MutableMap<String, Equipment> = getEquipments()

    @Test
    fun testMain() {
        Assert.assertNotNull(landUnits)
        Assert.assertNotNull(equipments)
    }
}

