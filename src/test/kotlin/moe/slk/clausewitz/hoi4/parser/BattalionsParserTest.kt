package moe.slk.clausewitz.hoi4.parser

import moe.slk.clausewitz.hoi4.types.Battalion
import org.junit.Assert.assertNotNull
import org.junit.Test

class BattalionsParserTest {

    @Test
    fun getBattalions() {
        val battalions: MutableMap<String, Battalion> = BattalionsParser().getBattalions()
        assertNotNull(battalions)
    }

    @Test
    fun getBattalionsToJSON() {
        val battalionsJSON = BattalionsParser().getBattalionsToJSON()
        assertNotNull(battalionsJSON)
    }
}