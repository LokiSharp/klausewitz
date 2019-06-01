package clausewitz.test

import org.junit.Assert
import org.junit.Test
import org.slk.clausewitz.hoi4.builder.DivisionBuilder
import org.slk.clausewitz.hoi4.calculator.LandWarfareCalculator
import org.slk.clausewitz.hoi4.types.DivisionTemplate

class TestHoi4 {
    private val divisionBuilder = DivisionBuilder()
    private val landWarfareCalculator = LandWarfareCalculator()

    @Test
    fun testHoi4() {
        val divisionTemplateA = DivisionTemplate(
            "TemplateA",
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
        val divisionTemplateB = DivisionTemplate(
            "TemplateB",
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
        val divisionTemplateC = DivisionTemplate(
            "TemplateC",
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

        val divisionA = divisionBuilder.calculateStats(divisionTemplateA)
        val divisionB = divisionBuilder.calculateStats(divisionTemplateB)
        val divisionC = divisionBuilder.calculateStats(divisionTemplateC)
        val resultAB = landWarfareCalculator.calcDamage(divisionA, divisionB, "Defense")
        val resultAC = landWarfareCalculator.calcDamage(divisionA, divisionC, "Defense")
        Assert.assertNotNull(resultAB)
        Assert.assertNotNull(resultAC)
    }
}