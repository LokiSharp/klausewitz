package clausewitz.test

import moe.slk.clausewitz.hoi4.builder.DivisionBuilder
import moe.slk.clausewitz.hoi4.types.DivisionTemplate
import org.junit.Assert
import org.junit.Test

class TestHoi4DivisionBuilder {
    private val divisionBuilder = DivisionBuilder()

    @Test
    fun testDivisionBuilderWithTemplate1() {
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
            Assert.assertEquals(combat_width, 40.0, 0.1)
            Assert.assertEquals(manpower, 15700.0, 0.1)
            Assert.assertEquals(training_time, 120.0, 0.1)
            Assert.assertEquals(hardness, 0.0, 0.01)
            Assert.assertNotNull(need)
            Assert.assertNotNull(priority)
            Assert.assertEquals(fuel_consumption, 0.0, 0.1)

            Assert.assertEquals(maximum_speed, 4.0, 0.1)
            Assert.assertEquals(max_strength, 283.2, 0.1)
            Assert.assertEquals(max_organisation, 31.8, 0.1)
            Assert.assertEquals(default_morale, 0.21, 0.01)
            Assert.assertEquals(recon, 1.0, 0.1)
            Assert.assertEquals(suppression, 11.0, 0.1)
            Assert.assertEquals(weight, 9.0, 0.1)
            Assert.assertEquals(supply_consumption, 2.35, 0.01)
            Assert.assertEquals(reliability_factor, 0.0, 0.1)
            Assert.assertEquals(casualty_trickleback, 0.0, 0.1)
            Assert.assertEquals(experience_loss_factor, 0.0, 0.1)
            Assert.assertEquals(equipment_capture_factor, 0.0, 0.1)
            Assert.assertEquals(entrenchment, 5.0, 0.1)

            Assert.assertEquals(soft_attack, 483.0, 0.1)
            Assert.assertEquals(hard_attack, 81.4, 0.1)
            Assert.assertEquals(air_attack, 35.2, 0.1)
            Assert.assertEquals(defense, 626.4, 0.1)
            Assert.assertEquals(breakthrough, 129.4, 0.1)
            Assert.assertEquals(armor_value, 0.0, 0.1)
            Assert.assertEquals(ap_attack, 70.5, 0.1)

            Assert.assertEquals(template, divisionTemplate)
            Assert.assertEquals(build_cost, 2255.0, 0.1)
        }
    }

    @Test
    fun testDivisionBuilderWithTemplate2() {
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
                Assert.assertEquals(combat_width, 40.0, 0.1)
                Assert.assertEquals(manpower, 16300.0, 0.1)
                Assert.assertEquals(training_time, 180.0, 0.1)
                Assert.assertEquals(hardness, 0.88, 0.01)
                Assert.assertNotNull(need)
                Assert.assertNotNull(priority)
                Assert.assertEquals(fuel_consumption, 59.2, 0.1)

                Assert.assertEquals(maximum_speed, 10.0, 0.1)
                Assert.assertEquals(max_strength, 259.0, 0.1)
                Assert.assertEquals(max_organisation, 25.2, 0.1)
                Assert.assertEquals(default_morale, 0.23, 0.01)
                Assert.assertEquals(recon, 1.0, 0.1)
                Assert.assertEquals(suppression, 8.0, 0.1)
                Assert.assertEquals(weight, 23.5, 0.1)
                Assert.assertEquals(supply_consumption, 5.32, 0.01)
                Assert.assertEquals(reliability_factor, 0.0, 0.1)
                Assert.assertEquals(casualty_trickleback, 0.0, 0.1)
                Assert.assertEquals(experience_loss_factor, 0.0, 0.1)
                Assert.assertEquals(equipment_capture_factor, 0.0, 0.1)
                Assert.assertEquals(entrenchment, 5.0, 0.1)

                Assert.assertEquals(soft_attack, 744.8, 0.1)
                Assert.assertEquals(hard_attack, 330.8, 0.1)
                Assert.assertEquals(air_attack, 35.2, 0.1)
                Assert.assertEquals(defense, 814.4, 0.1)
                Assert.assertEquals(breakthrough, 641.0, 0.1)
                Assert.assertEquals(armor_value, 78.5, 0.1)
                Assert.assertEquals(ap_attack, 101.4, 0.1)

                Assert.assertEquals(template, divisionTemplate)
                Assert.assertEquals(build_cost, 18753.0, 0.1)
            }
        }
    }

    @Test
    fun testDivisionBuilderWithTemplate3() {
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
                Assert.assertEquals(combat_width, 40.0, 0.1)
                Assert.assertEquals(manpower, 15200.0, 0.1)
                Assert.assertEquals(training_time, 180.0, 0.1)
                Assert.assertEquals(hardness, 0.05, 0.01)
                Assert.assertNotNull(need)
                Assert.assertNotNull(priority)
                Assert.assertEquals(fuel_consumption, 2.2, 0.1)

                Assert.assertEquals(maximum_speed, 4.0, 0.1)
                Assert.assertEquals(max_strength, 258.8, 0.1)
                Assert.assertEquals(max_organisation, 29.0, 0.1)
                Assert.assertEquals(default_morale, 0.21, 0.01)
                Assert.assertEquals(recon, 1.0, 0.1)
                Assert.assertEquals(suppression, 10.0, 0.1)
                Assert.assertEquals(weight, 10.0, 0.1)
                Assert.assertEquals(supply_consumption, 2.58, 0.01)
                Assert.assertEquals(reliability_factor, 0.0, 0.1)
                Assert.assertEquals(casualty_trickleback, 0.0, 0.1)
                Assert.assertEquals(experience_loss_factor, 0.0, 0.1)
                Assert.assertEquals(equipment_capture_factor, 0.0, 0.1)
                Assert.assertEquals(entrenchment, 5.0, 0.1)

                Assert.assertEquals(soft_attack, 479.2, 0.1)
                Assert.assertEquals(hard_attack, 138.4, 0.1)
                Assert.assertEquals(air_attack, 35.2, 0.1)
                Assert.assertEquals(defense, 592.6, 0.1)
                Assert.assertEquals(breakthrough, 125.2, 0.1)
                Assert.assertEquals(armor_value, 43.1, 0.1)
                Assert.assertEquals(ap_attack, 84.1, 0.1)

                Assert.assertEquals(template, divisionTemplate)
                Assert.assertEquals(build_cost, 2785.0, 0.1)
            }
        }
    }
}