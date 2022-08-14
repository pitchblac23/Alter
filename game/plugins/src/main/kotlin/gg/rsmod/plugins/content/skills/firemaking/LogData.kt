package gg.rsmod.plugins.content.skills.firemaking

import gg.rsmod.plugins.api.cfg.Items

/**
 * @author Fritz <frikkipafi@gmail.com>
 */
enum class LogData(val log: Int, val level: Int, val xp: Double, val pyroXp: Double) {

        NORMAL(Items.LOGS, 1, 40.0, 41.0),
        ACHEY(Items.ACHEY_TREE_LOGS, 1, 40.0, 41.0),
        OAK(Items.OAK_LOGS, 15, 60.0, 61.5),
        WILLOW(Items.WILLOW_LOGS, 30, 90.0, 92.3),
        TEAK(Items.TEAK_LOGS, 35, 105.0, 107.6),
        ARCTIC_PINE(Items.ARCTIC_PINE_LOGS, 42, 125.0, 128.1),
        MAPLE(Items.MAPLE_LOGS, 45, 135.0, 138.4),
        MAHOGANY(Items.MAHOGANY_LOGS, 50, 157.5, 161.4),
        YEW(Items.YEW_LOGS, 60, 202.5, 207.6),
        BLISTERWOOD(Items.BLISTERWOOD_LOGS, 62, 96.0, 98.4),
        MAGIC(Items.MAGIC_LOGS, 75, 303.8, 311.4),
        REDWOOD(Items.REDWOOD_LOGS, 90, 350.0, 358.8)
    }


