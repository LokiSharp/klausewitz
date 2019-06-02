package clausewitz.test

import moe.slk.clausewitz.hoi4.builder.DivisionBuilder
import moe.slk.clausewitz.hoi4.types.DivisionTemplate
import org.junit.Assert
import org.junit.Test

class TestHoi4DivisionBuilder {
    private val divisionBuilder = DivisionBuilder()

    @Test
    fun testDivisionBuilderWithTemplate1() {
        val divisionTemplate = DivisionTemplate(
            "Template1",
            "Test Template",
            mutableMapOf(
                "infantry" to 11,
                "artillery_brigade" to 6
            ),
            mutableListOf(
                "engineer", "recon", "artillery", "anti_air", "anti_tank"
            )
        )
        val result = divisionBuilder.calculateStats(divisionTemplate)
        Assert.assertNotNull(result)
    }

    @Test
    fun testDivisionBuilderWithTemplate2() {
        val divisionTemplate = DivisionTemplate(
            "Template2",
            "Test Template",
            mutableMapOf(
                "mechanized" to 8,
                "modern_armor" to 6,
                "modern_sp_artillery_brigade" to 4
            ),
            mutableListOf(
                "engineer", "recon", "artillery", "anti_air", "anti_tank"
            )
        )
        val result = divisionBuilder.calculateStats(divisionTemplate)
        Assert.assertNotNull(result)
    }

    @Test
    fun testDivisionBuilderWithTemplate3() {
        val divisionTemplate = DivisionTemplate(
            "Template3",
            "Test Template",
            mutableMapOf(
                "infantry" to 10,
                "artillery_brigade" to 6,
                "heavy_tank_destroyer_brigade" to 1
            ),
            mutableListOf(
                "engineer", "recon", "artillery", "anti_air", "anti_tank"
            )
        )
        val result = divisionBuilder.calculateStats(divisionTemplate)
        Assert.assertNotNull(result)
    }
}