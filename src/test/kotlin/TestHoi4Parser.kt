package clausewitz.test

import clausewitz.hoi4.parser.EquipmentsParser
import clausewitz.hoi4.parser.LandUnitsParser
import clausewitz.hoi4.types.Equipment
import clausewitz.hoi4.types.LandUnit
import org.junit.Assert
import org.junit.Test

class TestHoi4Parser {
    @Test
    fun testGetLandUnits() {
        val landUnits: MutableMap<String, LandUnit> = LandUnitsParser().getLandUnits()
        Assert.assertNotNull(landUnits)
    }

    @Test
    fun testGetEquipments() {
        val equipments: MutableMap<String, Equipment> = EquipmentsParser().getEquipments()
        Assert.assertNotNull(equipments)
    }
}

