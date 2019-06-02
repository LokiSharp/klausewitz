package moe.slk.clausewitz.hoi4.config

import moe.slk.clausewitz.hoi4.types.TechnologieModifier

val defaultTechnologies: Map<String, TechnologieModifier> = mapOf(
    "infantry" to TechnologieModifier(
        soft_attack = listOf(
            +0.05 * 3  // 改良步兵装备
        ),
        hard_attack = listOf(
            +0.25 * 2  // 步兵反坦克武器
        ),
        ap_attack = listOf(
            +1.0 * 2  // 步兵反坦克武器
        ),
        defense = listOf(
            +0.05 * 4  // 支援武器
        ),
        breakthrough = listOf(
            +0.05 * 4  // 支援武器
        )
    ),
    "marine" to TechnologieModifier(
        soft_attack = listOf(
            +0.05 * 3,  // 改良步兵装备
            +0.05,  // 海军陆战队
            +0.05  // 特种部队
        ),
        hard_attack = listOf(
            +0.25 * 2  // 步兵反坦克武器
        ),
        ap_attack = listOf(
            +1.0 * 2  // 步兵反坦克武器
        ),
        defense = listOf(
            +0.03 * 4,  // 支援武器
            +0.05  // 特种部队
        ),
        breakthrough = listOf(
            +0.03 * 4  // 支援武器
        ),
        max_organisation = listOf(
            5.0 * 2,  // 海军陆战队
            5.0 * 2  // 特种部队
        )
    ),
    "mountaineers" to TechnologieModifier(
        soft_attack = listOf(
            +0.05 * 3,  // 改良步兵装备
            +0.05,  // 山地步兵
            +0.05  // 特种部队
        ),
        hard_attack = listOf(
            +0.25 * 2  // 步兵反坦克武器
        ),
        ap_attack = listOf(
            +1.0 * 2  // 步兵反坦克武器
        ),
        defense = listOf(
            +0.03 * 4,  // 支援武器
            +0.05  // 特种部队
        ),
        breakthrough = listOf(
            +0.03 * 4  // 支援武器
        ),
        max_organisation = listOf(
            5.0 * 2,  // 山地步兵
            5.0 * 2  // 特种部队
        )
    ),
    "paratrooper" to TechnologieModifier(
        soft_attack = listOf(
            +0.05 * 3,  // 改良步兵装备
            +0.05,  // 伞兵
            +0.05  // 特种部队
        ),
        hard_attack = listOf(
            +0.25 * 2  // 步兵反坦克武器
        ),
        ap_attack = listOf(
            +1.0 * 2  // 步兵反坦克武器
        ),
        defense = listOf(
            +0.03 * 4,  // 支援武器
            +0.05  // 特种部队
        ),
        breakthrough = listOf(
            +0.03 * 4  // 支援武器
        ),
        max_organisation = listOf(
            5.0 * 2,  // 伞兵
            5.0 * 2  // 特种部队
        )
    ),
    "motorized" to TechnologieModifier(
        soft_attack = listOf(
            +0.05 * 2,  // 改良步兵装备
            +0.1  // 改良步兵装备
        ),
        hard_attack = listOf(
            +0.25 * 2  // 步兵反坦克武器
        ),
        ap_attack = listOf(
            +1.0 * 2  // 步兵反坦克武器
        ),
        armor_value = listOf(
            +1.0  // 机械化装备
        ),
        defense = listOf(
            +0.05 * 4  // 支援武器
        ),
        breakthrough = listOf(
            +0.05 * 4  // 支援武器
        )
    ),
    "mechanized" to TechnologieModifier(
        soft_attack = listOf(
            +0.05 * 2,  // 改良步兵装备
            +0.1,  // 改良步兵装备
            +0.15  // 机械化装备
        ),
        hard_attack = listOf(
            +0.25 * 2,  // 步兵反坦克武器
            +0.15  // 机械化装备
        ),
        ap_attack = listOf(
            +1.0 * 2  // 步兵反坦克武器
        ),
        defense = listOf(
            +0.05 * 4  // 支援武器
        ),
        breakthrough = listOf(
            +0.05 * 4  // 支援武器
        )
    ),
    "cavalry" to TechnologieModifier(
        soft_attack = listOf(
            +0.05 * 2,  // 改良步兵装备
            +0.1  // 改良步兵装备
        ),
        hard_attack = listOf(
            +0.25 * 2  // 步兵反坦克武器
        ),
        ap_attack = listOf(
            +1.0 * 2  // 步兵反坦克武器
        ),
        defense = listOf(
            +0.05 * 2  // 支援武器
        ),
        breakthrough = listOf(
            +0.05 * 2  // 支援武器
        )
    ),
    "artillery_brigade" to TechnologieModifier(
        soft_attack = listOf(
            +0.1 * 4  // 改良火炮
        )
    ),
    "anti_air_brigade" to TechnologieModifier(
        air_attack = listOf(
            +0.1 * 3  // 改良防空炮
        )
    ),
    "anti_tank_brigade" to TechnologieModifier(
        hard_attack = listOf(
            +0.1 * 3  // 改良反坦克炮
        ),
        ap_attack = listOf(
            +0.2,  // 改良反坦克炮
            +0.1 * 2  // 改良反坦克炮
        )
    ),
    "rocket_artillery_brigade" to TechnologieModifier(
        soft_attack = listOf(
            +0.15 * 2  // 火箭炮升级
        )
    ),
    "motorized_rocket_brigade" to TechnologieModifier(
        soft_attack = listOf(
            +0.15 * 2,  // 火箭炮升级
            +0.3  // 火箭炮升级
        )
    ),
    "artillery" to TechnologieModifier(
        soft_attack = listOf(
            +0.1 * 4  // 改良火炮
        )
    ),
    "anti_air" to TechnologieModifier(
        air_attack = listOf(
            +0.1 * 3  // 改良防空炮
        )
    ),
    "anti_tank" to TechnologieModifier(
        hard_attack = listOf(
            +0.1 * 3  // 改良反坦克炮
        ),
        ap_attack = listOf(
            +0.2,  // 改良反坦克炮
            +0.1 * 2  // 改良反坦克炮
        )
    ),
    "rocket_artillery" to TechnologieModifier(
        soft_attack = listOf(
            +0.15 * 2  // 火箭炮升级
        )
    )
)
