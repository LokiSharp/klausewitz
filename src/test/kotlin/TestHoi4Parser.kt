package clausewitz.test

import clausewitz.hoi4.parser.BattalionParser
import clausewitz.hoi4.parser.EquipmentsParser
import clausewitz.hoi4.types.Battalion
import clausewitz.hoi4.types.Equipment
import org.junit.Assert
import org.junit.Test

class TestHoi4Parser {
    @Test
    fun testGetBattalions() {
        val battalions: MutableMap<String, Battalion> = BattalionParser().getBattalions()
        Assert.assertNotNull(battalions)
    }

    @Test
    fun testGetEquipments() {
        val equipments: MutableMap<String, Equipment> = EquipmentsParser().getEquipments()
        Assert.assertNotNull(equipments)
    }
}

