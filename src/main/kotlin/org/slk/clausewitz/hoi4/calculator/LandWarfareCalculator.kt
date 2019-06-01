package org.slk.clausewitz.hoi4.calculator

import org.slk.clausewitz.hoi4.types.Division
import kotlin.math.roundToInt
import kotlin.random.Random

class LandWarfareCalculator {
    val LAND_COMBAT_ORG_DICE_SIZE: Int = 4
    val LAND_COMBAT_STR_DICE_SIZE: Int = 2

    val LAND_COMBAT_ORG_ARMOR_ON_SOFT_DICE_SIZE: Int = 6
    val LAND_COMBAT_STR_ARMOR_ON_SOFT_DICE_SIZE: Int = 2

    val LAND_COMBAT_STR_DAMAGE_MODIFIER: Double = 0.05
    val LAND_COMBAT_ORG_DAMAGE_MODIFIER: Double = 0.05

    val LAND_COMBAT_STR_ARMOR_DEFLECTION_FACTOR: Double = 0.5
    val LAND_COMBAT_ORG_ARMOR_DEFLECTION_FACTOR: Double = 0.5
    val BASE_CHANCE_TO_AVOID_HIT: Int = 90
    val CHANCE_TO_AVOID_HIT_AT_NO_DEF: Int = 60

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

        var org_soft_dice_size = LAND_COMBAT_ORG_DICE_SIZE
        val org_hard_dice_size = LAND_COMBAT_ORG_DICE_SIZE
        var org_damage_modifier = LAND_COMBAT_ORG_DAMAGE_MODIFIER
        val org_chance_to_avoid_hit_at_def = BASE_CHANCE_TO_AVOID_HIT
        val org_chance_to_avoid_hit_at_no_def = CHANCE_TO_AVOID_HIT_AT_NO_DEF

        var str_soft_dice_size = LAND_COMBAT_STR_DICE_SIZE
        val str_hard_dice_size = LAND_COMBAT_STR_DICE_SIZE
        var str_damage_modifier = LAND_COMBAT_STR_DAMAGE_MODIFIER
        val str_chance_to_avoid_hit_at_def = BASE_CHANCE_TO_AVOID_HIT
        val str_chance_to_avoid_hit_at_no_def = CHANCE_TO_AVOID_HIT_AT_NO_DEF
        if (divisionA.armor_value >= divisionB.ap_attack) {
            org_soft_dice_size = LAND_COMBAT_ORG_ARMOR_ON_SOFT_DICE_SIZE
            str_soft_dice_size = LAND_COMBAT_STR_ARMOR_ON_SOFT_DICE_SIZE
        }

        if (divisionB.armor_value >= divisionA.ap_attack) {
            org_damage_modifier = org_damage_modifier * LAND_COMBAT_ORG_ARMOR_DEFLECTION_FACTOR
            str_damage_modifier = str_damage_modifier * LAND_COMBAT_STR_ARMOR_DEFLECTION_FACTOR
        }
        val soft_hits = (atkSa * (1 - divisionB.hardness)).roundToInt()
        val hard_hits = (atkHa * divisionB.hardness).roundToInt()
        val total_hits = soft_hits + hard_hits
        val (hits_at_def, hits_at_no_def) = getHits(total_hits, def)

        var org_damage = 0.0
        var str_damage = 0.0

        if (total_hits > 0) {
            val soft_hits_at_def = hits_at_def * soft_hits / total_hits
            val hard_hits_at_def = hits_at_def * hard_hits / total_hits
            val soft_hits_at_no_def = hits_at_no_def * soft_hits / total_hits
            val hard_hits_at_no_def = hits_at_no_def * hard_hits / total_hits

            val org_soft_damage_at_def = getDamage(
                org_soft_dice_size,
                org_chance_to_avoid_hit_at_def,
                org_damage_modifier,
                soft_hits_at_def
            )

            val org_hard_damage_at_def = getDamage(
                org_hard_dice_size,
                org_chance_to_avoid_hit_at_def,
                org_damage_modifier,
                hard_hits_at_def
            )
            val org_soft_damage_at_no_def = getDamage(
                org_soft_dice_size,
                org_chance_to_avoid_hit_at_no_def,
                org_damage_modifier,
                soft_hits_at_no_def
            )
            val org_hard_damage_at_no_def = getDamage(
                org_hard_dice_size,
                org_chance_to_avoid_hit_at_no_def,
                org_damage_modifier,
                hard_hits_at_no_def
            )

            val str_soft_damage_at_def = getDamage(
                str_soft_dice_size,
                str_chance_to_avoid_hit_at_def,
                str_damage_modifier,
                soft_hits_at_def
            )
            val str_hard_damage_at_def = getDamage(
                str_hard_dice_size,
                str_chance_to_avoid_hit_at_def,
                str_damage_modifier,
                hard_hits_at_def
            )
            val str_soft_damage_at_no_def = getDamage(
                str_soft_dice_size,
                str_chance_to_avoid_hit_at_no_def,
                str_damage_modifier,
                soft_hits_at_no_def
            )
            val str_hard_damage_at_no_def = getDamage(
                str_hard_dice_size,
                str_chance_to_avoid_hit_at_no_def,
                str_damage_modifier,
                hard_hits_at_no_def
            )

            org_damage =
                org_soft_damage_at_def + org_hard_damage_at_def + org_soft_damage_at_no_def + org_hard_damage_at_no_def

            str_damage =
                str_soft_damage_at_def + str_hard_damage_at_def + str_soft_damage_at_no_def + str_hard_damage_at_no_def
        }
        return Pair(org_damage, str_damage)
    }
}