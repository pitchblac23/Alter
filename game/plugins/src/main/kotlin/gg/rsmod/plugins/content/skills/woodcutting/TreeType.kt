package gg.rsmod.plugins.content.skills.woodcutting

/**
 * @author Tom <rspsmods@gmail.com>
 */
enum class TreeType(val level: Int, val xp: Double, val burnXp: Double, val log: Int, val depleteChance: Int, val respawnTime: IntRange) {

    TREE(level = 1, xp = 25.0, burnXp = 20.0, log = 1511, depleteChance = 0, respawnTime = 15..25),
    ACHEY(level = 1, xp = 25.0, burnXp = 20.0, log = 2862, depleteChance = 0, respawnTime = 15..25),
    OAK(level = 15, xp = 37.5, burnXp = 30.0, log = 1521, depleteChance = 8, respawnTime = 15..25),
    WILLOW(level = 30, xp = 67.5, burnXp = 45.0, log = 1519, depleteChance = 8, respawnTime = 22..68),
    TEAK(level = 35, xp = 85.0, burnXp = 52.5, log = 6333, depleteChance = 8, respawnTime = 22..68),
    JUNIPER(level = 42, xp = 35.0, burnXp = 0.0, log = 13355, depleteChance = 8, respawnTime = 22..68),
    MAPLE(level = 45, xp = 100.0, burnXp = 67.5, log = 1517, depleteChance = 8, respawnTime = 22..68),
    HOLLOW(level = 45, xp = 82.0, burnXp = 0.0, log = 3239, depleteChance = 8, respawnTime = 22..68),
    MAHOGANY(level = 50, xp = 125.0, burnXp = 78.75, log = 6332, depleteChance = 8, respawnTime = 22..68),
    ARCTIC_PINE(level = 54, xp = 40.0, burnXp = 62.5, log = 10810, depleteChance = 8, respawnTime = 22..68),
    YEW(level = 60, xp = 175.0, burnXp = 101.25, log = 1515, depleteChance = 8, respawnTime = 22..68),
    MAGIC(level = 75, xp = 250.0, burnXp = 151.9, log = 1513, depleteChance = 8, respawnTime = 22..68),
    REDWOOD(level = 90, xp = 380.0, burnXp = 175.0, log = 19669, depleteChance = 11, respawnTime = 50..100),;
}