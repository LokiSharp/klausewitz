package org.slk.clausewitz.hoi4.parser

import org.slk.clausewitz.hoi4.config.defaultDataDir
import org.slk.clausewitz.hoi4.config.unitsDir
import org.slk.clausewitz.hoi4.config.unitsFileList
import org.slk.clausewitz.hoi4.types.Battalion
import org.slk.clausewitz.hoi4.types.SubUnits
import org.slk.clausewitz.parser.parseClausewitzFile

class BattalionParser(
    private val dataDir: String = defaultDataDir
) {
    fun getBattalions(): MutableMap<String, Battalion> {
        val battalions: MutableMap<String, Battalion> = mutableMapOf()
        for (filename in unitsFileList) {
            val parse = parseClausewitzFile("$dataDir/$unitsDir/$filename") as SubUnits
            battalions.putAll(parse.sub_units)
        }

        return battalions
    }
}

