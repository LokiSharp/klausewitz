package moe.slk.clausewitz.hoi4.calculator

import moe.slk.clausewitz.hoi4.config.*
import moe.slk.clausewitz.hoi4.types.Division
import kotlin.math.roundToInt
import kotlin.random.Random

class LandWarfareCalculator {

    fun getDamageOfAvoidHit(diceSize: Int, chanceToAvoidHit: Int, damageModifier: Double): Double {
        return Random.nextInt(1, diceSize) * (100.0 - chanceToAvoidHit) / 100.0 * damageModifier
    }

    fun getDamage(diceSize: Int, chanceToAvoidHit: Int, damageModifier: Double, n: Int): Double {
        var damage = 0.0
        for (i in 1..n) {
            damage += getDamageOfAvoidHit(diceSize, chanceToAvoidHit, damageModifier)
        }
        return damage
    }

    fun getHits(saOrHa: Int, defOrBt: Int): Pair<Int, Int> {
        var hitAtDef = 0
        var hitAtNoDef = 0
        if (saOrHa <= defOrBt) {
            hitAtDef = saOrHa
            hitAtNoDef = 0
        } else if (saOrHa > defOrBt) {
            hitAtDef = defOrBt
            hitAtNoDef = saOrHa - defOrBt
        }

        return Pair(hitAtDef, hitAtNoDef)
    }

    fun calcDamage(divisionA: Division, divisionB: Division, defType: String): Pair<Double, Double> {
        val atkSa = (divisionA.soft_attack / 10).roundToInt()
        val atkHa = (divisionA.hard_attack / 10).roundToInt()
        val def = ((if (defType == "Defense") divisionB.defense else divisionB.breakthrough) / 10).roundToInt()

        var orgSoftDiceSize = LAND_COMBAT_ORG_DICE_SIZE
        val orgHardDiceSize = LAND_COMBAT_ORG_DICE_SIZE
        var orgDamageModifier = LAND_COMBAT_ORG_DAMAGE_MODIFIER
        val orgChanceToAvoidHitAtDef = BASE_CHANCE_TO_AVOID_HIT
        val orgChanceToAvoidHitAtNoDef = CHANCE_TO_AVOID_HIT_AT_NO_DEF

        var strSoftDiceSize = LAND_COMBAT_STR_DICE_SIZE
        val strHardDiceSize = LAND_COMBAT_STR_DICE_SIZE
        var strDamageModifier = LAND_COMBAT_STR_DAMAGE_MODIFIER
        val strChanceToAvoidHitAtDef = BASE_CHANCE_TO_AVOID_HIT
        val strChanceToAvoidHitAtNoDef = CHANCE_TO_AVOID_HIT_AT_NO_DEF
        if (divisionA.armor_value >= divisionB.ap_attack) {
            orgSoftDiceSize = LAND_COMBAT_ORG_ARMOR_ON_SOFT_DICE_SIZE
            strSoftDiceSize = LAND_COMBAT_STR_ARMOR_ON_SOFT_DICE_SIZE
        }

        if (divisionB.armor_value >= divisionA.ap_attack) {
            orgDamageModifier *= LAND_COMBAT_ORG_ARMOR_DEFLECTION_FACTOR
            strDamageModifier *= LAND_COMBAT_STR_ARMOR_DEFLECTION_FACTOR
        }
        val softHits = (atkSa * (1 - divisionB.hardness)).roundToInt()
        val hardHits = (atkHa * divisionB.hardness).roundToInt()
        val totalHits = softHits + hardHits
        val (hits_at_def, hits_at_no_def) = getHits(totalHits, def)

        var orgDamage = 0.0
        var strDamage = 0.0

        if (totalHits > 0) {
            val softHitsStDef = hits_at_def * softHits / totalHits
            val hardHitsAtDef = hits_at_def * hardHits / totalHits
            val softHitsAtNoDef = hits_at_no_def * softHits / totalHits
            val hardHitsAtNoDef = hits_at_no_def * hardHits / totalHits

            val orgSoftDamageAtDef = getDamage(
                orgSoftDiceSize,
                orgChanceToAvoidHitAtDef,
                orgDamageModifier,
                softHitsStDef
            )

            val orgHardDamageAtDef = getDamage(
                orgHardDiceSize,
                orgChanceToAvoidHitAtDef,
                orgDamageModifier,
                hardHitsAtDef
            )
            val orgSoftDamageAtNoDef = getDamage(
                orgSoftDiceSize,
                orgChanceToAvoidHitAtNoDef,
                orgDamageModifier,
                softHitsAtNoDef
            )
            val orgHardDamageAtNoDef = getDamage(
                orgHardDiceSize,
                orgChanceToAvoidHitAtNoDef,
                orgDamageModifier,
                hardHitsAtNoDef
            )

            val strSoftDamageAtDef = getDamage(
                strSoftDiceSize,
                strChanceToAvoidHitAtDef,
                strDamageModifier,
                softHitsStDef
            )
            val strHardDamageAtDef = getDamage(
                strHardDiceSize,
                strChanceToAvoidHitAtDef,
                strDamageModifier,
                hardHitsAtDef
            )
            val strSoftDamageAtNoDef = getDamage(
                strSoftDiceSize,
                strChanceToAvoidHitAtNoDef,
                strDamageModifier,
                softHitsAtNoDef
            )
            val strHardDamageAtNoDef = getDamage(
                strHardDiceSize,
                strChanceToAvoidHitAtNoDef,
                strDamageModifier,
                hardHitsAtNoDef
            )

            orgDamage =
                orgSoftDamageAtDef + orgHardDamageAtDef + orgSoftDamageAtNoDef + orgHardDamageAtNoDef

            strDamage =
                strSoftDamageAtDef + strHardDamageAtDef + strSoftDamageAtNoDef + strHardDamageAtNoDef
        }
        return Pair(orgDamage, strDamage)
    }
}