package clausewitz.test

import clausewitz.hoi4.calculator.LandWarfareCalculator
import clausewitz.hoi4.types.Division
import org.junit.Assert
import org.junit.Test

class TestHoi4Calculator {
    private val landWarfareCalculator = LandWarfareCalculator()
    @Test
    fun testGetDamageOfAvoidHit() {
        val result = landWarfareCalculator.getDamageOfAvoidHit(4, 90, 0.05)
        Assert.assertNotNull(result)
    }

    @Test
    fun testGetHits() {
        val result = landWarfareCalculator.getHits(100, 10)
        Assert.assertNotNull(result)
    }

    @Test
    fun testCalcDamage() {
        val divisionA = Division(
            "Template A",
            "Test Template",
            soft_attack = 1000.0,
            priority = mutableMapOf("medium_armor" to 1.0)
        )
        val divisionB = Division(
            "Template B",
            "Test Template",
            defense = 500.0,
            priority = mutableMapOf("infantry" to 1.0)
        )
        val divisionC = Division(
            "Template C",
            "Test Template",
            defense = 2000.0,
            priority = mutableMapOf("infantry" to 1.0)
        )
        val resultAB = landWarfareCalculator.calcDamage(divisionA, divisionB, "Defense")
        Assert.assertNotNull(resultAB)
        val resultAC = landWarfareCalculator.calcDamage(divisionA, divisionC, "Defense")
        Assert.assertNotNull(resultAC)
    }
}