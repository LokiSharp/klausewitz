package clausewitz.test

import moe.slk.clausewitz.hoi4.builder.BattalionBuilder
import org.junit.Assert
import org.junit.Test

class TestHoi4BattalionBuilder {
    private val battalionBuilder = BattalionBuilder()

    @Test
    fun testBattalionBuilderWithInfantry() {
        for (i in 0..100) {
            val battalionType = "infantry"
            val result = battalionBuilder.calculateStats(battalionType)

            with(result) {
                Assert.assertEquals(sprite, "infantry")
                Assert.assertEquals(map_icon_category, "infantry")
                Assert.assertEquals(priority, 600.0, 0.00001)
                Assert.assertEquals(ai_priority, 200.0, 0.00001)
                Assert.assertEquals(active, false)
                Assert.assertEquals(group, "infantry")
                Assert.assertEquals(type, listOf("infantry"))
                Assert.assertEquals(
                    categories,
                    listOf("category_front_line", "category_light_infantry", "category_all_infantry", "category_army")
                )
                Assert.assertEquals(combat_width, 2.0, 0.00001)
                Assert.assertEquals(need, mapOf("infantry_equipment" to 100L))
                Assert.assertEquals(manpower, 1000.0, 0.00001)
                Assert.assertEquals(training_time, 90.0, 0.00001)
                Assert.assertEquals(can_be_parachuted, false)
                Assert.assertEquals(hardness, 0.0, 0.00001)

                Assert.assertEquals(maximum_speed, 4.0, 0.00001)
                Assert.assertEquals(max_strength, 25.0, 0.00001)
                Assert.assertEquals(max_organisation, 60.0, 0.00001)
                Assert.assertEquals(default_morale, 0.3, 0.00001)
                Assert.assertEquals(recon, 0.0, 0.00001)
                Assert.assertEquals(suppression, 1.0, 0.00001)
                Assert.assertEquals(weight, 0.5, 0.00001)
                Assert.assertEquals(supply_consumption, 0.07, 0.00001)
                Assert.assertEquals(reliability_factor, 0.0, 0.00001)
                Assert.assertEquals(casualty_trickleback, 0.0, 0.00001)
                Assert.assertEquals(experience_loss_factor, 0.0, 0.00001)
                Assert.assertEquals(equipment_capture_factor, 0.0, 0.00001)
                Assert.assertEquals(entrenchment, 0.0, 0.00001)
                Assert.assertEquals(soft_attack, 13.8, 0.00001)
                Assert.assertEquals(hard_attack, 3.0, 0.00001)
                Assert.assertEquals(air_attack, 0.0, 0.00001)
                Assert.assertEquals(defense, 40.8, 0.00001)
                Assert.assertEquals(breakthrough, 6.0, 0.00001)
                Assert.assertEquals(armor_value, 0.0, 0.00001)
                Assert.assertEquals(ap_attack, 30.0, 0.00001)

                Assert.assertEquals(essential, "")
                Assert.assertEquals(transport, "")
            }
        }
    }

    @Test
    fun testBattalionBuilderWithMechanized() {
        for (i in 0..100) {
            val battalionType = "mechanized"
            val result = battalionBuilder.calculateStats(battalionType)

            with(result) {
                Assert.assertEquals(sprite, "mechanized")
                Assert.assertEquals(map_icon_category, "infantry")
                Assert.assertEquals(priority, 610.0, 0.00001)
                Assert.assertEquals(ai_priority, 200.0, 0.00001)
                Assert.assertEquals(active, true)
                Assert.assertEquals(group, "mobile")
                Assert.assertEquals(type, listOf("mechanized"))
                Assert.assertEquals(categories, listOf("category_front_line", "category_all_infantry", "category_army"))
                Assert.assertEquals(combat_width, 2.0, 0.00001)
                Assert.assertEquals(need, mapOf("mechanized_equipment" to 50L, "infantry_equipment" to 100L))
                Assert.assertEquals(manpower, 1200.0, 0.00001)
                Assert.assertEquals(training_time, 120.0, 0.00001)
                Assert.assertEquals(can_be_parachuted, false)
                Assert.assertEquals(hardness, 0.84, 0.00001)

                Assert.assertEquals(maximum_speed, 12.0, 0.00001)
                Assert.assertEquals(max_strength, 30.0, 0.00001)
                Assert.assertEquals(max_organisation, 60.0, 0.00001)
                Assert.assertEquals(default_morale, 0.3, 0.00001)
                Assert.assertEquals(recon, 0.0, 0.00001)
                Assert.assertEquals(suppression, 1.0, 0.00001)
                Assert.assertEquals(weight, 1.0, 0.00001)
                Assert.assertEquals(supply_consumption, 0.18, 0.00001)
                Assert.assertEquals(reliability_factor, 0.0, 0.00001)
                Assert.assertEquals(casualty_trickleback, 0.0, 0.00001)
                Assert.assertEquals(experience_loss_factor, 0.0, 0.00001)
                Assert.assertEquals(equipment_capture_factor, 0.0, 0.00001)
                Assert.assertEquals(entrenchment, 0.0, 0.00001)
                Assert.assertEquals(soft_attack, 17.4, 0.00001)
                Assert.assertEquals(hard_attack, 11.3, 0.00001)
                Assert.assertEquals(air_attack, 0.0, 0.00001)
                Assert.assertEquals(defense, 81.6, 0.00001)
                Assert.assertEquals(breakthrough, 13.2, 0.00001)
                Assert.assertEquals(armor_value, 20.0, 0.00001)
                Assert.assertEquals(ap_attack, 93.0, 0.00001)

                Assert.assertEquals(essential, "")
                Assert.assertEquals(transport, "mechanized_equipment")
            }
        }
    }

    @Test
    fun testBattalionBuilderWithModern_armor() {
        for (i in 0..100) {
            val battalionType = "modern_armor"
            val result = battalionBuilder.calculateStats(battalionType)

            with(result) {
                Assert.assertEquals(sprite, "medium_armor")
                Assert.assertEquals(map_icon_category, "armored")
                Assert.assertEquals(priority, 2510.0, 0.00001)
                Assert.assertEquals(ai_priority, 3510.0, 0.00001)
                Assert.assertEquals(active, true)
                Assert.assertEquals(group, "armor")
                Assert.assertEquals(type, listOf("armor"))
                Assert.assertEquals(
                    categories,
                    listOf("category_tanks", "category_front_line", "category_all_armor", "category_army")
                )
                Assert.assertEquals(combat_width, 2.0, 0.00001)
                Assert.assertEquals(need, mapOf("modern_tank_equipment" to 50L))
                Assert.assertEquals(manpower, 500.0, 0.00001)
                Assert.assertEquals(training_time, 180.0, 0.00001)
                Assert.assertEquals(can_be_parachuted, false)
                Assert.assertEquals(hardness, 0.98, 0.00001)

                Assert.assertEquals(maximum_speed, 10.0, 0.00001)
                Assert.assertEquals(max_strength, 2.0, 0.00001)
                Assert.assertEquals(max_organisation, 10.0, 0.00001)
                Assert.assertEquals(default_morale, 0.3, 0.00001)
                Assert.assertEquals(recon, 0.0, 0.00001)
                Assert.assertEquals(suppression, 0.0, 0.00001)
                Assert.assertEquals(weight, 1.5, 0.00001)
                Assert.assertEquals(supply_consumption, 0.25, 0.00001)
                Assert.assertEquals(reliability_factor, 0.0, 0.00001)
                Assert.assertEquals(casualty_trickleback, 0.0, 0.00001)
                Assert.assertEquals(experience_loss_factor, 0.0, 0.00001)
                Assert.assertEquals(equipment_capture_factor, 0.0, 0.00001)
                Assert.assertEquals(entrenchment, 0.0, 0.00001)

                Assert.assertEquals(soft_attack, 40.0, 0.00001)
                Assert.assertEquals(hard_attack, 32.0, 0.00001)
                Assert.assertEquals(air_attack, 0.0, 0.00001)
                Assert.assertEquals(defense, 10.0, 0.00001)
                Assert.assertEquals(breakthrough, 84.0, 0.00001)
                Assert.assertEquals(armor_value, 130.0, 0.00001)
                Assert.assertEquals(ap_attack, 131.0, 0.00001)

                Assert.assertEquals(essential, "")
                Assert.assertEquals(transport, "")
            }
        }
    }
}