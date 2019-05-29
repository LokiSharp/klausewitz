package clausewitz.test

import clausewitz.hoi4.builder.LandUnitBuilder
import clausewitz.hoi4.parser.LandUnitsParser
import clausewitz.hoi4.types.LandUnit
import org.junit.Assert
import org.junit.Test

class TestHoi4LandUnitBuilder {
    @Test
    fun testLandUnitBuilder() {
        val landUnits: Map<String, LandUnit> = LandUnitsParser().getLandUnits()
        val landUnitType = "motorized"
        val landUnit = landUnits[landUnitType] as LandUnit
        val landUnitBuilder = LandUnitBuilder()
        Assert.assertNotNull(landUnitBuilder.usedEquipments)
        Assert.assertNotNull(landUnitBuilder.usedTechnologies)
        val result = landUnitBuilder.calculateStats(landUnitType, landUnit)
        Assert.assertNotNull(result)
    }
}