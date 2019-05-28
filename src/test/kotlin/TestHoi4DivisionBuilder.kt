package clausewitz.test

import clausewitz.hoi4.builder.DivisionBuilder
import clausewitz.hoi4.types.DivisionTemplate
import org.junit.Assert
import org.junit.Test

class TestHoi4DivisionBuilder {
    @Test
    fun testDivisionBuilder() {
        val divisionBuilder = DivisionBuilder()
        Assert.assertNotNull(divisionBuilder.landUnits)
        Assert.assertNotNull(divisionBuilder.equipments)
        val divisionTemplate = DivisionTemplate(
            "test",
            "test",
            mutableMapOf(
                "infantry" to 11,
                "artillery_brigade" to 6
            ),
            mutableListOf(
                "engineer",
                "recon"
            )
        )
        divisionBuilder.calculateStats(divisionTemplate)
    }
}