package moe.slk.clausewitz.hoi4.parser

import moe.slk.clausewitz.hoi4.types.Battalion
import org.junit.Assert.assertNotNull
import org.junit.Test

class BattalionParserTest {

    @Test
    fun getBattalions() {
        val battalions: MutableMap<String, Battalion> = BattalionParser().getBattalions()
        assertNotNull(battalions)
    }
}