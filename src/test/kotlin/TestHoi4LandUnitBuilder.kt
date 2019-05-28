package clausewitz.test

import clausewitz.hoi4.builder.LandUnitBuilder
import clausewitz.hoi4.types.LandUnit
import org.junit.Assert
import org.junit.Test

class TestHoi4LandUnitBuilder {
    @Test
    fun testLandUnitBuilder() {
        val landUnit = LandUnit("test", "test")
        val landUnitBuilder = LandUnitBuilder()
        Assert.assertNotNull(landUnitBuilder.equipments)
        Assert.assertNotNull(landUnitBuilder.technologies)
        landUnitBuilder.calculateStats(landUnit)
    }
}