package moe.slk.clausewitz.hoi4.calculator

import moe.slk.clausewitz.hoi4.config.*
import moe.slk.clausewitz.hoi4.types.Division
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Test
import kotlin.math.roundToInt

class LandWarfareCalculatorTest {
    private val landWarfareCalculator = LandWarfareCalculator()
    @Test
    fun getDamageOfAvoidHit() {
        val result = landWarfareCalculator.getDamageOfAvoidHit(4, 90, 0.05)
        assertNotNull(result)
    }

    @Test
    fun getDamage() {
        val result = landWarfareCalculator.getHits(100, 10)
        assertNotNull(result)
    }

    @Test
    fun getHits() {
        val diceSize = 4
        val chanceToAvoidHit = 90
        val damageModifier = 0.05
        val n = 1
        val damageList = mutableListOf<Double>()
        for (i in 1..1000000) {
            val result = landWarfareCalculator.getDamage(diceSize, chanceToAvoidHit, damageModifier, n)
            damageList.add(result)
        }
        assertEquals(
            damageList.average(),
            ((1.0 + diceSize) / 2 * (100.0 - chanceToAvoidHit) / 100.0 * damageModifier) * n,
            0.0001
        )
    }

    @Test
    fun calcDamage() {
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

        val orgListAB = mutableListOf<Double>()
        val strListAB = mutableListOf<Double>()
        for (i in 0..1000000) {
            val resultAB = landWarfareCalculator.calcDamage(divisionA, divisionB, "Defense")
            orgListAB.add(resultAB.first)
            strListAB.add(resultAB.second)
        }
        assertEquals(
            orgListAB.average(),
            (divisionB.defense / 10).roundToInt()
                    * ((1.0 + LAND_COMBAT_ORG_ARMOR_ON_SOFT_DICE_SIZE) / 2 * (100.0 - BASE_CHANCE_TO_AVOID_HIT) / 100.0 * LAND_COMBAT_ORG_DAMAGE_MODIFIER)
                    + ((divisionA.soft_attack - divisionB.defense) / 10).roundToInt()
                    * ((1.0 + LAND_COMBAT_ORG_ARMOR_ON_SOFT_DICE_SIZE) / 2 * (100.0 - CHANCE_TO_AVOID_HIT_AT_NO_DEF) / 100.0 * LAND_COMBAT_ORG_DAMAGE_MODIFIER),
            0.001
        )
        assertEquals(
            strListAB.average(),
            (divisionB.defense / 10).roundToInt()
                    * ((1.0 + LAND_COMBAT_STR_ARMOR_ON_SOFT_DICE_SIZE) / 2 * (100.0 - BASE_CHANCE_TO_AVOID_HIT) / 100.0 * LAND_COMBAT_STR_DAMAGE_MODIFIER)
                    + ((divisionA.soft_attack - divisionB.defense) / 10).roundToInt()
                    * ((1.0 + LAND_COMBAT_STR_ARMOR_ON_SOFT_DICE_SIZE) / 2 * (100.0 - CHANCE_TO_AVOID_HIT_AT_NO_DEF) / 100.0 * LAND_COMBAT_STR_DAMAGE_MODIFIER),
            0.001
        )

        val orgListAC = mutableListOf<Double>()
        val strListAC = mutableListOf<Double>()
        for (i in 0..1000000) {
            val resultAC = landWarfareCalculator.calcDamage(divisionA, divisionC, "Defense")
            orgListAC.add(resultAC.first)
            strListAC.add(resultAC.second)
        }
        assertEquals(
            orgListAC.average(),
            (divisionA.soft_attack / 10).roundToInt()
                    * ((1.0 + LAND_COMBAT_ORG_ARMOR_ON_SOFT_DICE_SIZE) / 2 * (100.0 - BASE_CHANCE_TO_AVOID_HIT) / 100.0 * LAND_COMBAT_ORG_DAMAGE_MODIFIER)
                    + 0
                    * ((1.0 + LAND_COMBAT_ORG_ARMOR_ON_SOFT_DICE_SIZE) / 2 * (100.0 - CHANCE_TO_AVOID_HIT_AT_NO_DEF) / 100.0 * LAND_COMBAT_ORG_DAMAGE_MODIFIER),
            0.001
        )
        assertEquals(
            strListAC.average(),
            (divisionA.soft_attack / 10).roundToInt()
                    * ((1.0 + LAND_COMBAT_STR_ARMOR_ON_SOFT_DICE_SIZE) / 2 * (100.0 - BASE_CHANCE_TO_AVOID_HIT) / 100.0 * LAND_COMBAT_STR_DAMAGE_MODIFIER)
                    + 0
                    * ((1.0 + LAND_COMBAT_STR_ARMOR_ON_SOFT_DICE_SIZE) / 2 * (100.0 - CHANCE_TO_AVOID_HIT_AT_NO_DEF) / 100.0 * LAND_COMBAT_STR_DAMAGE_MODIFIER),
            0.001
        )
    }
}