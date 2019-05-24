package clausewitz.test

import clausewitz.hoi4.builder.DivisionBuilder
import org.junit.Assert
import org.junit.Test

class TestHoi4Builder {
    @Test
    fun testDivisionBuilder() {
        val division_builder = DivisionBuilder()
        Assert.assertNotNull(division_builder.landUnits)
        Assert.assertNotNull(division_builder.equipments)
    }
}