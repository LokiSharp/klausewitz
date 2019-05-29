package clausewitz.test

import clausewitz.hoi4.builder.LandUnitBuilder
import org.junit.Assert
import org.junit.Test

class TestHoi4LandUnitBuilder {
    @Test
    fun testLandUnitBuilder() {
        val landUnitType = "motorized"
        val landUnitBuilder = LandUnitBuilder()
        Assert.assertNotNull(landUnitBuilder.usedEquipments)
        Assert.assertNotNull(landUnitBuilder.usedTechnologies)
        val result = landUnitBuilder.calculateStats(landUnitType)
        Assert.assertNotNull(result)
    }
}