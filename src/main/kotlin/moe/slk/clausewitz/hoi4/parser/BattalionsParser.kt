package moe.slk.clausewitz.hoi4.parser

import com.google.gson.GsonBuilder
import moe.slk.clausewitz.hoi4.config.defaultDataDir
import moe.slk.clausewitz.hoi4.config.unitsDir
import moe.slk.clausewitz.hoi4.config.unitsFileList
import moe.slk.clausewitz.hoi4.types.Battalion
import moe.slk.clausewitz.hoi4.types.SubUnits
import moe.slk.clausewitz.parser.parseClausewitzFile

class BattalionsParser(
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

    fun getBattalionsToJSON(): String {
        return GsonBuilder().create().toJson(this.getBattalions())
    }
}

