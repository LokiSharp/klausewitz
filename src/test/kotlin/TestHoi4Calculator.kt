package clausewitz.test

import moe.slk.clausewitz.hoi4.calculator.LandWarfareCalculator
import moe.slk.clausewitz.hoi4.config.*
import moe.slk.clausewitz.hoi4.types.Division
import org.junit.Assert
import org.junit.Test
import kotlin.math.roundToInt

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
    fun testGetDamage() {
        val diceSize = 4
        val chanceToAvoidHit = 90
        val damageModifier = 0.05
        val n = 1
        for (i in 1..1000000) {
            val result = landWarfareCalculator.getDamage(diceSize, chanceToAvoidHit, damageModifier, n)
            Assert.assertTrue(result >= (1 * (100.0 - chanceToAvoidHit) / 100.0 * damageModifier) * n)
            Assert.assertTrue(result <= (diceSize * (100.0 - chanceToAvoidHit) / 100.0 * damageModifier) * n)
        }

    }

    @Test
    fun testCalcDamage() {
        val divisionA = Division(
            "Template A",
            "Test Template",
            soft_attack = 1000.0,
            ap_attack = 1.0,
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
        for (i in 0..1000000) {
            val resultAB = landWarfareCalculator.calcDamage(divisionA, divisionB, "Defense")
            Assert.assertEquals(
                resultAB.first,
                (divisionB.defense / 10).roundToInt()
                        * ((1.0 + LAND_COMBAT_ORG_ARMOR_ON_SOFT_DICE_SIZE) / 2 * (100.0 - BASE_CHANCE_TO_AVOID_HIT) / 100.0 * LAND_COMBAT_ORG_DAMAGE_MODIFIER)
                        + ((divisionA.soft_attack - divisionB.defense) / 10).roundToInt()
                        * ((1.0 + LAND_COMBAT_ORG_ARMOR_ON_SOFT_DICE_SIZE) / 2 * (100.0 - CHANCE_TO_AVOID_HIT_AT_NO_DEF) / 100.0 * LAND_COMBAT_ORG_DAMAGE_MODIFIER),
                1.5
            )
            Assert.assertEquals(
                resultAB.second,
                (divisionB.defense / 10).roundToInt()
                        * ((1.0 + LAND_COMBAT_STR_ARMOR_ON_SOFT_DICE_SIZE) / 2 * (100.0 - BASE_CHANCE_TO_AVOID_HIT) / 100.0 * LAND_COMBAT_STR_DAMAGE_MODIFIER)
                        + ((divisionA.soft_attack - divisionB.defense) / 10).roundToInt()
                        * ((1.0 + LAND_COMBAT_STR_ARMOR_ON_SOFT_DICE_SIZE) / 2 * (100.0 - CHANCE_TO_AVOID_HIT_AT_NO_DEF) / 100.0 * LAND_COMBAT_STR_DAMAGE_MODIFIER),
                1.0
            )
            val resultAC = landWarfareCalculator.calcDamage(divisionA, divisionC, "Defense")
            Assert.assertEquals(
                resultAC.first,
                (divisionA.soft_attack / 10).roundToInt()
                        * ((1.0 + LAND_COMBAT_ORG_ARMOR_ON_SOFT_DICE_SIZE) / 2 * (100.0 - BASE_CHANCE_TO_AVOID_HIT) / 100.0 * LAND_COMBAT_ORG_DAMAGE_MODIFIER)
                        + 0
                        * ((1.0 + LAND_COMBAT_ORG_ARMOR_ON_SOFT_DICE_SIZE) / 2 * (100.0 - CHANCE_TO_AVOID_HIT_AT_NO_DEF) / 100.0 * LAND_COMBAT_ORG_DAMAGE_MODIFIER),
                1.5
            )
            Assert.assertEquals(
                resultAC.second,
                (divisionA.soft_attack / 10).roundToInt()
                        * ((1.0 + LAND_COMBAT_STR_ARMOR_ON_SOFT_DICE_SIZE) / 2 * (100.0 - BASE_CHANCE_TO_AVOID_HIT) / 100.0 * LAND_COMBAT_STR_DAMAGE_MODIFIER)
                        + 0
                        * ((1.0 + LAND_COMBAT_STR_ARMOR_ON_SOFT_DICE_SIZE) / 2 * (100.0 - CHANCE_TO_AVOID_HIT_AT_NO_DEF) / 100.0 * LAND_COMBAT_STR_DAMAGE_MODIFIER),
                1.0
            )
        }

    }
}