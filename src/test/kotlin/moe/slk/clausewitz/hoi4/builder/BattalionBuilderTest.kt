package moe.slk.clausewitz.hoi4.builder

import org.junit.Assert.assertEquals
import org.junit.Test

class BattalionBuilderTest {
    private val battalionBuilder = BattalionBuilder()

    @Test
    fun calculateStatsWithInfantry() {
        for (i in 0..100) {
            val battalionType = "infantry"
            val result = battalionBuilder.calculateStats(battalionType)

            with(result) {
                assertEquals(sprite, "infantry")
                assertEquals(map_icon_category, "infantry")
                assertEquals(priority, 600.0, 0.00001)
                assertEquals(ai_priority, 200.0, 0.00001)
                assertEquals(active, false)
                assertEquals(group, "infantry")
                assertEquals(type, listOf("infantry"))
                assertEquals(
                    categories,
                    listOf("category_front_line", "category_light_infantry", "category_all_infantry", "category_army")
                )
                assertEquals(combat_width, 2.0, 0.00001)
                assertEquals(need, mapOf("infantry_equipment" to 100L))
                assertEquals(manpower, 1000.0, 0.00001)
                assertEquals(training_time, 90.0, 0.00001)
                assertEquals(can_be_parachuted, false)
                assertEquals(hardness, 0.0, 0.00001)

                assertEquals(maximum_speed, 4.0, 0.00001)
                assertEquals(max_strength, 25.0, 0.00001)
                assertEquals(max_organisation, 60.0, 0.00001)
                assertEquals(default_morale, 0.3, 0.00001)
                assertEquals(recon, 0.0, 0.00001)
                assertEquals(suppression, 1.0, 0.00001)
                assertEquals(weight, 0.5, 0.00001)
                assertEquals(supply_consumption, 0.07, 0.00001)
                assertEquals(reliability_factor, 0.0, 0.00001)
                assertEquals(casualty_trickleback, 0.0, 0.00001)
                assertEquals(experience_loss_factor, 0.0, 0.00001)
                assertEquals(equipment_capture_factor, 0.0, 0.00001)
                assertEquals(entrenchment, 0.0, 0.00001)
                assertEquals(soft_attack, 13.8, 0.00001)
                assertEquals(hard_attack, 3.0, 0.00001)
                assertEquals(air_attack, 0.0, 0.00001)
                assertEquals(defense, 40.8, 0.00001)
                assertEquals(breakthrough, 6.0, 0.00001)
                assertEquals(armor_value, 0.0, 0.00001)
                assertEquals(ap_attack, 30.0, 0.00001)

                assertEquals(essential, listOf<String>())
                assertEquals(transport, "")
            }
        }
    }

    @Test
    fun calculateStatsWithMechanized() {
        for (i in 0..100) {
            val battalionType = "mechanized"
            val result = battalionBuilder.calculateStats(battalionType)

            with(result) {
                assertEquals(sprite, "mechanized")
                assertEquals(map_icon_category, "infantry")
                assertEquals(priority, 610.0, 0.00001)
                assertEquals(ai_priority, 200.0, 0.00001)
                assertEquals(active, true)
                assertEquals(group, "mobile")
                assertEquals(type, listOf("mechanized"))
                assertEquals(categories, listOf("category_front_line", "category_all_infantry", "category_army"))
                assertEquals(combat_width, 2.0, 0.00001)
                assertEquals(need, mapOf("mechanized_equipment" to 50L, "infantry_equipment" to 100L))
                assertEquals(manpower, 1200.0, 0.00001)
                assertEquals(training_time, 120.0, 0.00001)
                assertEquals(can_be_parachuted, false)
                assertEquals(hardness, 0.84, 0.00001)

                assertEquals(maximum_speed, 12.0, 0.00001)
                assertEquals(max_strength, 30.0, 0.00001)
                assertEquals(max_organisation, 60.0, 0.00001)
                assertEquals(default_morale, 0.3, 0.00001)
                assertEquals(recon, 0.0, 0.00001)
                assertEquals(suppression, 1.0, 0.00001)
                assertEquals(weight, 1.0, 0.00001)
                assertEquals(supply_consumption, 0.18, 0.00001)
                assertEquals(reliability_factor, 0.0, 0.00001)
                assertEquals(casualty_trickleback, 0.0, 0.00001)
                assertEquals(experience_loss_factor, 0.0, 0.00001)
                assertEquals(equipment_capture_factor, 0.0, 0.00001)
                assertEquals(entrenchment, 0.0, 0.00001)
                assertEquals(soft_attack, 17.4, 0.00001)
                assertEquals(hard_attack, 11.3, 0.00001)
                assertEquals(air_attack, 0.0, 0.00001)
                assertEquals(defense, 81.6, 0.00001)
                assertEquals(breakthrough, 13.2, 0.00001)
                assertEquals(armor_value, 20.0, 0.00001)
                assertEquals(ap_attack, 93.0, 0.00001)

                assertEquals(essential, listOf("infantry_equipment", "mechanized_equipment"))
                assertEquals(transport, "mechanized_equipment")
            }
        }
    }

    @Test
    fun calculateStatsWithModernArmor() {
        for (i in 0..100) {
            val battalionType = "modern_armor"
            val result = battalionBuilder.calculateStats(battalionType)

            with(result) {
                assertEquals(sprite, "medium_armor")
                assertEquals(map_icon_category, "armored")
                assertEquals(priority, 2510.0, 0.00001)
                assertEquals(ai_priority, 3510.0, 0.00001)
                assertEquals(active, true)
                assertEquals(group, "armor")
                assertEquals(type, listOf("armor"))
                assertEquals(
                    categories,
                    listOf("category_tanks", "category_front_line", "category_all_armor", "category_army")
                )
                assertEquals(combat_width, 2.0, 0.00001)
                assertEquals(need, mapOf("modern_tank_equipment" to 50L))
                assertEquals(manpower, 500.0, 0.00001)
                assertEquals(training_time, 180.0, 0.00001)
                assertEquals(can_be_parachuted, false)
                assertEquals(hardness, 0.98, 0.00001)

                assertEquals(maximum_speed, 10.0, 0.00001)
                assertEquals(max_strength, 2.0, 0.00001)
                assertEquals(max_organisation, 10.0, 0.00001)
                assertEquals(default_morale, 0.3, 0.00001)
                assertEquals(recon, 0.0, 0.00001)
                assertEquals(suppression, 0.0, 0.00001)
                assertEquals(weight, 1.5, 0.00001)
                assertEquals(supply_consumption, 0.25, 0.00001)
                assertEquals(reliability_factor, 0.0, 0.00001)
                assertEquals(casualty_trickleback, 0.0, 0.00001)
                assertEquals(experience_loss_factor, 0.0, 0.00001)
                assertEquals(equipment_capture_factor, 0.0, 0.00001)
                assertEquals(entrenchment, 0.0, 0.00001)

                assertEquals(soft_attack, 40.0, 0.00001)
                assertEquals(hard_attack, 32.0, 0.00001)
                assertEquals(air_attack, 0.0, 0.00001)
                assertEquals(defense, 10.0, 0.00001)
                assertEquals(breakthrough, 84.0, 0.00001)
                assertEquals(armor_value, 130.0, 0.00001)
                assertEquals(ap_attack, 131.0, 0.00001)

                assertEquals(essential, listOf<String>())
                assertEquals(transport, "")
            }
        }
    }
}