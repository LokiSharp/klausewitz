package clausewitz.test

import clausewitz.hoi4.builder.BattalionBuilder
import org.junit.Assert
import org.junit.Test

class TestHoi4BattalionBuilder {
    @Test
    fun testBattalionBuilder() {
        val battalionType = "motorized"
        val battalionBuilder = BattalionBuilder()
        Assert.assertNotNull(battalionBuilder.usedEquipments)
        Assert.assertNotNull(battalionBuilder.usedTechnologies)
        val result = battalionBuilder.calculateStats(battalionType)
        Assert.assertNotNull(result)
    }
}