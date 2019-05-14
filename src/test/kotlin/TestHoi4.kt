package clausewitz.test


import clausewitz.hoi4.SubUnit
import clausewitz.hoi4.SubUnits
import clausewitz.parser.parseClausewitzFile

fun main(args: Array<String>) {
    val dir = System.getProperty("user.dir") + "/data/hoi4"
    val units_file_list = listOf(
        "anti_tank.txt", "anti_tank_brigade.txt", "anti-air.txt",
        "anti-air_brigade.txt", "artillery.txt",
        "artillery_brigade.txt", "cavalry.txt", "engineer.txt", "field_hospital.txt", "heavy_armor.txt",
        "infantry.txt", "light_armor.txt", "logistics.txt", "maintenance.txt", "medium_armor.txt",
        "military_police.txt",
        "modern_armor.txt", "recon.txt", "signal.txt", "sp_anti-air_brigade.txt", "sp_artillery_brigade.txt",
        "super_heavy_armor.txt", "tank_destroyer_brigade.txt"
    )

    val landunits: MutableMap<String, SubUnit> = mutableMapOf()
    for (filename in units_file_list) {
        val parse =
            parseClausewitzFile("$dir/common/units/$filename") as SubUnits
        landunits.putAll(parse.sub_units)
    }
    println(landunits)
}

