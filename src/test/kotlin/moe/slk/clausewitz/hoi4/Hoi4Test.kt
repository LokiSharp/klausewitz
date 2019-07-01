package moe.slk.clausewitz.hoi4

import moe.slk.clausewitz.hoi4.builder.DivisionBuilder
import moe.slk.clausewitz.hoi4.calculator.LandWarfareCalculator
import moe.slk.clausewitz.hoi4.types.DivisionTemplate
import org.junit.Assert.assertNotNull
import org.junit.Test

class Hoi4Test {
    private val divisionBuilder = DivisionBuilder()
    private val landWarfareCalculator = LandWarfareCalculator()

    @Test
    fun hoi4() {
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
        assertNotNull(resultAB)
        assertNotNull(resultAC)
    }
}