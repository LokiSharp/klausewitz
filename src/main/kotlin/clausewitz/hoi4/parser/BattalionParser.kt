package clausewitz.hoi4.parser

import clausewitz.config.unitsDir
import clausewitz.config.unitsFileList
import clausewitz.hoi4.types.Battalion
import clausewitz.hoi4.types.SubUnits
import clausewitz.parser.parseClausewitzFile

class BattalionParser {
    fun getBattalions(): MutableMap<String, Battalion> {
        val battalions: MutableMap<String, Battalion> = mutableMapOf()
        for (filename in unitsFileList) {
            val parse = parseClausewitzFile("$unitsDir/$filename") as SubUnits
            battalions.putAll(parse.sub_units)
        }

        return battalions
    }
}

