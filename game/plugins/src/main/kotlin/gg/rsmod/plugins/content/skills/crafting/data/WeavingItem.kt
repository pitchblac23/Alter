package gg.rsmod.plugins.content.skills.crafting.data

import gg.rsmod.plugins.api.cfg.Items

/**
 * @author Triston Plummer ("Dread')
 * @editor Pitch Blac23
 */

enum class Weaving(val id: Int, val toWeave: Int, val amount: Int, val level: Int, val craftXp: Double = 0.0, val animation: Int) {
    STRIP_OF_CLOTH(id = Items.STRIP_OF_CLOTH, toWeave = Items.BALL_OF_WOOL, amount = 4, level = 10, craftXp = 12.0, animation = 894),
    EMPTY_SACK(id = Items.EMPTY_SACK, toWeave = Items.JUTE_FIBRE, amount = 4, level = 21, craftXp = 38.0, animation = 894),
    DRIFT_NET(id = Items.DRIFT_NET, toWeave = Items.JUTE_FIBRE, amount = 2, level = 26, craftXp = 55.0, animation = 894),
    BASKET(id = Items.BASKET, toWeave = Items.WILLOW_BRANCH, amount = 6, level = 36, craftXp = 56.0, animation = 894),
    ;

    companion object {
        /**
         * The cached array of enum definitions
         */
        val values = enumValues<Weaving>()
    }
}