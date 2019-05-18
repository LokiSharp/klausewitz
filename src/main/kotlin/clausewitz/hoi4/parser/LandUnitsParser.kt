package clausewitz.hoi4.parser

import clausewitz.config.unitsDir
import clausewitz.config.unitsFileList
import clausewitz.hoi4.types.SubUnit
import clausewitz.hoi4.types.SubUnits
import clausewitz.parser.parseClausewitzFile


fun getLandUnits(): MutableMap<String, SubUnit> {
    val landUnits: MutableMap<String, SubUnit> = mutableMapOf()
    for (filename in unitsFileList) {
        val parse = parseClausewitzFile("$unitsDir/$filename") as SubUnits
        landUnits.putAll(parse.sub_units)
    }

    return landUnits
}
