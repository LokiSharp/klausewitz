package clausewitz.hoi4.parser

import clausewitz.config.unitsDir
import clausewitz.config.unitsFileList
import clausewitz.hoi4.types.LandUnit
import clausewitz.hoi4.types.SubUnits
import clausewitz.parser.parseClausewitzFile

class LandUnitsParser {
    fun getLandUnits(): MutableMap<String, LandUnit> {
        val landUnits: MutableMap<String, LandUnit> = mutableMapOf()
        for (filename in unitsFileList) {
            val parse = parseClausewitzFile("$unitsDir/$filename") as SubUnits
            landUnits.putAll(parse.sub_units)
        }

        return landUnits
    }
}

