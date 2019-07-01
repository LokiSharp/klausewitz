package moe.slk.clausewitz.hoi4.builder

import moe.slk.clausewitz.hoi4.types.DivisionTemplate
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Test

class DivisionBuilderTest {
    private val divisionBuilder = DivisionBuilder()

    @Test
    fun calculateStatsWithTemplate1() {
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
        with(result) {
            assertEquals(combat_width, 40.0, 0.1)
            assertEquals(manpower, 15700.0, 0.1)
            assertEquals(training_time, 120.0, 0.1)
            assertEquals(hardness, 0.0, 0.01)
            assertNotNull(need)
            assertNotNull(priority)
            assertEquals(fuel_consumption, 0.0, 0.1)

            assertEquals(maximum_speed, 4.0, 0.1)
            assertEquals(max_strength, 283.2, 0.1)
            assertEquals(max_organisation, 31.8, 0.1)
            assertEquals(default_morale, 0.21, 0.01)
            assertEquals(recon, 1.0, 0.1)
            assertEquals(suppression, 11.0, 0.1)
            assertEquals(weight, 9.0, 0.1)
            assertEquals(supply_consumption, 2.35, 0.01)
            assertEquals(reliability_factor, 0.0, 0.1)
            assertEquals(casualty_trickleback, 0.0, 0.1)
            assertEquals(experience_loss_factor, 0.0, 0.1)
            assertEquals(equipment_capture_factor, 0.0, 0.1)
            assertEquals(entrenchment, 5.0, 0.1)

            assertEquals(soft_attack, 483.0, 0.1)
            assertEquals(hard_attack, 81.4, 0.1)
            assertEquals(air_attack, 35.2, 0.1)
            assertEquals(defense, 626.4, 0.1)
            assertEquals(breakthrough, 129.4, 0.1)
            assertEquals(armor_value, 0.0, 0.1)
            assertEquals(ap_attack, 70.5, 0.1)

            assertEquals(template, divisionTemplate)
            assertEquals(build_cost, 2255.0, 0.1)
        }
    }

    @Test
    fun calculateStatsWithTemplate2() {
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
        for (i in 0..100) {
            val result = divisionBuilder.calculateStats(divisionTemplate)
            with(result) {
                assertEquals(combat_width, 40.0, 0.1)
                assertEquals(manpower, 16300.0, 0.1)
                assertEquals(training_time, 180.0, 0.1)
                assertEquals(hardness, 0.88, 0.01)
                assertNotNull(need)
                assertNotNull(priority)
                assertEquals(fuel_consumption, 59.2, 0.1)

                assertEquals(maximum_speed, 10.0, 0.1)
                assertEquals(max_strength, 259.0, 0.1)
                assertEquals(max_organisation, 25.2, 0.1)
                assertEquals(default_morale, 0.23, 0.01)
                assertEquals(recon, 1.0, 0.1)
                assertEquals(suppression, 8.0, 0.1)
                assertEquals(weight, 23.5, 0.1)
                assertEquals(supply_consumption, 5.32, 0.01)
                assertEquals(reliability_factor, 0.0, 0.1)
                assertEquals(casualty_trickleback, 0.0, 0.1)
                assertEquals(experience_loss_factor, 0.0, 0.1)
                assertEquals(equipment_capture_factor, 0.0, 0.1)
                assertEquals(entrenchment, 5.0, 0.1)

                assertEquals(soft_attack, 744.8, 0.1)
                assertEquals(hard_attack, 330.8, 0.1)
                assertEquals(air_attack, 35.2, 0.1)
                assertEquals(defense, 814.4, 0.1)
                assertEquals(breakthrough, 641.0, 0.1)
                assertEquals(armor_value, 78.5, 0.1)
                assertEquals(ap_attack, 101.4, 0.1)

                assertEquals(template, divisionTemplate)
                assertEquals(build_cost, 18753.0, 0.1)
            }
        }
    }

    @Test
    fun calculateStatsWithTemplate3() {
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
        for (i in 0..100) {
            val result = divisionBuilder.calculateStats(divisionTemplate)
            with(result) {
                assertEquals(combat_width, 40.0, 0.1)
                assertEquals(manpower, 15200.0, 0.1)
                assertEquals(training_time, 180.0, 0.1)
                assertEquals(hardness, 0.05, 0.01)
                assertNotNull(need)
                assertNotNull(priority)
                assertEquals(fuel_consumption, 2.2, 0.1)

                assertEquals(maximum_speed, 4.0, 0.1)
                assertEquals(max_strength, 258.8, 0.1)
                assertEquals(max_organisation, 29.0, 0.1)
                assertEquals(default_morale, 0.21, 0.01)
                assertEquals(recon, 1.0, 0.1)
                assertEquals(suppression, 10.0, 0.1)
                assertEquals(weight, 10.0, 0.1)
                assertEquals(supply_consumption, 2.58, 0.01)
                assertEquals(reliability_factor, 0.0, 0.1)
                assertEquals(casualty_trickleback, 0.0, 0.1)
                assertEquals(experience_loss_factor, 0.0, 0.1)
                assertEquals(equipment_capture_factor, 0.0, 0.1)
                assertEquals(entrenchment, 5.0, 0.1)

                assertEquals(soft_attack, 479.2, 0.1)
                assertEquals(hard_attack, 138.4, 0.1)
                assertEquals(air_attack, 35.2, 0.1)
                assertEquals(defense, 592.6, 0.1)
                assertEquals(breakthrough, 125.2, 0.1)
                assertEquals(armor_value, 43.1, 0.1)
                assertEquals(ap_attack, 84.1, 0.1)

                assertEquals(template, divisionTemplate)
                assertEquals(build_cost, 2785.0, 0.1)
            }
        }
    }
}