package clausewitz.config

val defaultTechnologies: Map<String, Map<String, Map<String, List<Any>>>> = mapOf(
    "percent" to mapOf(
        "infantry" to mapOf(
            "soft_attack" to listOf(
                +0.05 * 3  // 改良步兵装备
            ),
            "hard_attack" to listOf(
                +0.25 * 2  // 步兵反坦克武器
            ),
            "ap_attack" to listOf(
                +1 * 2  // 步兵反坦克武器
            ),
            "defense" to listOf(
                +0.05 * 4  // 支援武器
            ),
            "breakthrough" to listOf(
                +0.05 * 4  // 支援武器
            )
        ),
        "marine" to mapOf(
            "soft_attack" to listOf(
                +0.05 * 3,  // 改良步兵装备
                +0.05,  // 海军陆战队
                +0.05  // 特种部队
            ),
            "hard_attack" to listOf(
                +0.25 * 2  // 步兵反坦克武器
            ),
            "ap_attack" to listOf(
                +1 * 2  // 步兵反坦克武器
            ),
            "defense" to listOf(
                +0.03 * 4,  // 支援武器
                +0.05  // 特种部队
            ),
            "breakthrough" to listOf(
                +0.03 * 4  // 支援武器
            )
        ),
        "mountaineers" to mapOf(
            "soft_attack" to listOf(
                +0.05 * 3,  // 改良步兵装备
                +0.05,  // 山地步兵
                +0.05  // 特种部队
            ),
            "hard_attack" to listOf(
                +0.25 * 2  // 步兵反坦克武器
            ),
            "ap_attack" to listOf(
                +1 * 2  // 步兵反坦克武器
            ),
            "defense" to listOf(
                +0.03 * 4,  // 支援武器
                +0.05  // 特种部队
            ),
            "breakthrough" to listOf(
                +0.03 * 4  // 支援武器
            )
        ),
        "paratrooper" to mapOf(
            "soft_attack" to listOf(
                +0.05 * 3,  // 改良步兵装备
                +0.05,  // 伞兵
                +0.05  // 特种部队
            ),
            "hard_attack" to listOf(
                +0.25 * 2  // 步兵反坦克武器
            ),
            "ap_attack" to listOf(
                +1 * 2  // 步兵反坦克武器
            ),
            "defense" to listOf(
                +0.03 * 4,  // 支援武器
                +0.05  // 特种部队
            ),
            "breakthrough" to listOf(
                +0.03 * 4  // 支援武器
            )
        ),
        "motorized" to mapOf(
            "soft_attack" to listOf(
                +0.05 * 2,  // 改良步兵装备
                +0.1  // 改良步兵装备
            ),
            "hard_attack" to listOf(
                +0.25 * 2  // 步兵反坦克武器
            ),
            "ap_attack" to listOf(
                +1 * 2  // 步兵反坦克武器
            ),
            "armor_value" to listOf(
                +1  // 机械化装备
            ),
            "defense" to listOf(
                +0.05 * 4  // 支援武器
            ),
            "breakthrough" to listOf(
                +0.05 * 4  // 支援武器
            )
        ),
        "mechanized" to mapOf(
            "soft_attack" to listOf(
                +0.05 * 2,  // 改良步兵装备
                +0.1,  // 改良步兵装备
                +0.15  // 机械化装备
            ),
            "hard_attack" to listOf(
                +0.25 * 2,  // 步兵反坦克武器
                +0.15  // 机械化装备
            ),
            "ap_attack" to listOf(
                +1 * 2  // 步兵反坦克武器
            ),
            "defense" to listOf(
                +0.05 * 4  // 支援武器
            ),
            "breakthrough" to listOf(
                +0.05 * 4  // 支援武器
            )
        ),
        "cavalry" to mapOf(
            "soft_attack" to listOf(
                +0.05 * 2,  // 改良步兵装备
                +0.1  // 改良步兵装备
            ),
            "hard_attack" to listOf(
                +0.25 * 2  // 步兵反坦克武器
            ),
            "ap_attack" to listOf(
                +1 * 2  // 步兵反坦克武器
            ),
            "defense" to listOf(
                +0.05 * 2  // 支援武器
            ),
            "breakthrough" to listOf(
                +0.05 * 2  // 支援武器
            )
        ),
        "artillery_brigade" to mapOf(
            "soft_attack" to listOf(
                +0.1 * 4  // 改良火炮
            )
        ),
        "anti_air_brigade" to mapOf(
            "air_attack" to listOf(
                +0.1 * 3  // 改良防空炮
            )
        ),
        "anti_tank_brigade" to mapOf(
            "hard_attack" to listOf(
                +0.1 * 3  // 改良反坦克炮
            ),
            "ap_attack" to listOf(
                +0.2,  // 改良反坦克炮
                +0.1 * 2  // 改良反坦克炮
            )
        ),
        "rocket_artillery_brigade" to mapOf(
            "soft_attack" to listOf(
                +0.15 * 2  // 火箭炮升级
            )
        ),
        "motorized_rocket_brigade" to mapOf(
            "soft_attack" to listOf(
                +0.15 * 2,  // 火箭炮升级
                +0.3  // 火箭炮升级
            )
        ),
        "artillery" to mapOf(
            "soft_attack" to listOf(
                +0.1 * 4  // 改良火炮
            )
        ),
        "anti_air" to mapOf(
            "air_attack" to listOf(
                +0.1 * 3  // 改良防空炮
            )
        ),
        "anti_tank" to mapOf(
            "hard_attack" to listOf(
                +0.1 * 3  // 改良反坦克炮
            ),
            "ap_attack" to listOf(
                +0.2,  // 改良反坦克炮
                +0.1 * 2  // 改良反坦克炮
            )
        ),
        "rocket_artillery" to mapOf(
            "soft_attack" to listOf(
                +0.15 * 2  // 火箭炮升级
            )
        )
    ),

    "base" to mapOf(
        "marine" to mapOf(
            "max_organisation" to listOf(
                5 * 2,  // 海军陆战队
                5 * 2  // 特种部队
            )
        ),
        "mountaineers" to mapOf(
            "max_organisation" to listOf(
                5 * 2,  // 山地步兵
                5 * 2  // 特种部队
            )
        ),
        "paratrooper" to mapOf(
            "max_organisation" to listOf(
                5 * 2,  // 伞兵
                5 * 2  // 特种部队
            )
        )
    )
)