package clausewitz.test

import clausewitz.hoi4.builder.BattalionBuilder
import org.junit.Assert
import org.junit.Test

class TestHoi4BattalionBuilder {
    private val battalionBuilder = BattalionBuilder()

    @Test
    fun testBattalionBuilderWithInfantry() {
        val battalionType = "infantry"
        Assert.assertNotNull(battalionBuilder.usedEquipments)
        Assert.assertNotNull(battalionBuilder.usedTechnologies)
        val result = battalionBuilder.calculateStats(battalionType)
        Assert.assertNotNull(result)
    }

    @Test
    fun testBattalionBuilderWithMotorized() {
        val battalionType = "motorized"
        Assert.assertNotNull(battalionBuilder.usedEquipments)
        Assert.assertNotNull(battalionBuilder.usedTechnologies)
        val result = battalionBuilder.calculateStats(battalionType)
        Assert.assertNotNull(result)
    }

    @Test
    fun testBattalionBuilderWithModern_armor() {
        val battalionType = "modern_armor"
        Assert.assertNotNull(battalionBuilder.usedEquipments)
        Assert.assertNotNull(battalionBuilder.usedTechnologies)
        val result = battalionBuilder.calculateStats(battalionType)
        Assert.assertNotNull(result)
    }
}