package clausewitz.test

import clausewitz.hoi4.types.Battalion
import org.junit.Assert
import org.junit.Test

class TestHoi4Type {
    @Test
    fun testUnitType() {
        val unit = Battalion(
            sprite = "Test",
            map_icon_category = "Test",
            group = "Test",
            type = listOf("Test"),
            categories = listOf("Test"),
            need = mapOf(Pair("Test", 1L))
        )
        Assert.assertNotNull(unit)
    }
}