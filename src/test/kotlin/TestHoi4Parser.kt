package clausewitz.test

import org.junit.Assert
import org.junit.Test
import org.slk.clausewitz.hoi4.parser.BattalionParser
import org.slk.clausewitz.hoi4.parser.EquipmentsParser
import org.slk.clausewitz.hoi4.types.Battalion
import org.slk.clausewitz.hoi4.types.Equipment

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

