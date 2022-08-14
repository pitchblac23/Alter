package gg.rsmod.plugins.content.skills.mining

import gg.rsmod.plugins.api.cfg.Items

/**
 * @author Anthony Loukinas <anthony.loukinas@gmail.com>
 */

enum class OreType(val level: Int, val xp: Double, val ore: Int, val respawnTime: IntRange) {
    RUNE_ESSENCE(level = 1, xp = 5.0, ore = 1436, respawnTime = 0..0),
    CLAY(level = 1, xp = 5.0, ore = 434, respawnTime = 2..3),
    COPPER(level = 1, xp = 17.5, ore = 436, respawnTime = 4..6),
    TIN(level = 1, xp = 17.5, ore = 438, respawnTime = 4..6),
    BLURITE(level = 10, xp = 17.5, ore = 668, respawnTime = 25..30),
    LIMESTONE(level = 10, xp = 26.5, ore = 3211, respawnTime = 0..0), // WIP
    IRON(level = 15, xp = 35.0, ore = 440, respawnTime = 6..9),
    SILVER(level = 20, xp = 40.0, ore = 442, respawnTime = 55..60),
    VOLCANIC_ASH(level = 22, xp = 10.0, ore = 21622, respawnTime = 25..30),
    COAL(level = 30, xp = 50.0, ore = 453, respawnTime = 25..30),
    PURE_ESSENCE(level = 30, xp = 5.0, ore = 7936, respawnTime = 0..0),

    // motherload mine

    SANDSTONE1(level = 35, xp = 30.0, ore = 6971, respawnTime = 6..8),
    SANDSTONE2(level = 35, xp = 40.0, ore = 6973, respawnTime = 6..8),
    SANDSTONE3(level = 35, xp = 50.0, ore = 6975, respawnTime = 6..8),
    SANDSTONE4(level = 35, xp = 60.0, ore = 6977, respawnTime = 6..8),

    DENSE_ESSENCE(level = 38, xp = 12.0, ore = 13445, respawnTime = 0..0),
    DAEYALT_ESSENCE(level = 38, xp = 12.0, ore = 13445, respawnTime = 0..0),

    GOLD(level = 40, xp = 65.0, ore = 444, respawnTime = 55..65),

    GEMSTONE1(level = 40, xp = 65.0, ore = 1625, respawnTime = 100..105),
    GEMSTONE2(level = 40, xp = 65.0, ore = 1627, respawnTime = 100..105),
    GEMSTONE3(level = 40, xp = 65.0, ore = 1629, respawnTime = 100..105),
    GEMSTONE4(level = 40, xp = 65.0, ore = 1623, respawnTime = 100..105),
    GEMSTONE5(level = 40, xp = 65.0, ore = 1621, respawnTime = 100..105),
    GEMSTONE6(level = 40, xp = 65.0, ore = 1619, respawnTime = 100..105),
    GEMSTONE7(level = 40, xp = 65.0, ore = 1617, respawnTime = 100..105),

    VOLCANIC_SULPHUR(level = 42, xp = 25.0, ore = 13571, respawnTime = 20..25),
    // lovakengj blast mine
    GRANITE1(level = 45, xp = 50.0, ore = 6979, respawnTime = 6..8),
    GRANITE2(level = 45, xp = 60.0, ore = 6981, respawnTime = 6..8),
    GRANITE3(level = 45, xp = 75.0, ore = 6983, respawnTime = 6..8),
    // volcanic mine
    MITHRIL(level = 55, xp = 80.0, ore = 447, respawnTime = 120..150),
    LOVAKITE(level = 65, xp = 10.0, ore = 13356, respawnTime = 30..45),
    ADAMANTITE(level = 70, xp = 95.0, ore = 449, respawnTime = 240..260),
    // We need to see about these SALTs, we are replacing the node with a blank node (vein)
    TE_SALT(level = 72, xp = 5.0, ore = 22593, respawnTime = 5..10),
    EFH_SALT(level = 72, xp = 5.0, ore = 25595, respawnTime = 5..10),
    URT_SALT(level = 72, xp = 5.0, ore = 25597, respawnTime = 5..10),
    BASALT(level = 72, xp = 5.0, ore = 22603, respawnTime = 5..10),
    RUNITE(level = 85, xp = 125.0, ore = 451, respawnTime = 720..750),
    AMETHYST(level = 92, xp = 240.0, ore = Items.AMETHYST, respawnTime = 0..0);//need better ore id maybe?
}