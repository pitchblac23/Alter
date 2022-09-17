package gg.rsmod.plugins.content.skills.mining

import gg.rsmod.plugins.api.cfg.Animation
import gg.rsmod.plugins.api.cfg.Items

/**
 * @author Anthony Loukinas <anthony.loukinas@gmail.com>
 */
enum class PickaxeType(val item: Int, val level: Int, val animation: Int) {

    BRONZE(Items.BRONZE_PICKAXE, level = 1, Animation.MINING_BRONZE_PICKAXE),
    IRON(Items.IRON_PICKAXE, level = 1, Animation.MINING_IRON_PICKAXE),
    STEEL(Items.STEEL_PICKAXE, level = 6, Animation.MINING_STEEL_PICKAXE),
    BLACK(Items.BLACK_PICKAXE, level = 11, Animation.MINING_BLACK_PICKAXE),
    MITHRIL(Items.MITHRIL_PICKAXE, level = 21, Animation.MINING_MITHRIL_PICKAXE),
    ADAMANT(Items.ADAMANT_PICKAXE, level = 31, Animation.MINING_ADAMANT_PICKAXE),
    RUNE(Items.RUNE_PICKAXE, level = 41, Animation.MINING_RUNE_PICKAXE),
    GILDED(Items.GILDED_PICKAXE, level = 41, Animation.MINING_GUILDED_PICKAXE),
    THIRDAGE(Items._3RD_AGE_PICKAXE, level = 61, Animation.MINING_THIRDAGE_PICKAXE),
    DRAGON(Items.DRAGON_PICKAXE, level = 61, Animation.MINING_DRAGON_PICKAXE),
    DRAGON_OR(Items.DRAGON_PICKAXE_OR, level = 61, Animation.MINING_DRAGON_PICKAXE_O),
    DRAGON_U(Items.DRAGON_PICKAXE_12797, level = 61, Animation.MINING_DRAGON_PICKAXE_U),
    DRAGON_OR_TRAILBLAZER(Items.DRAGON_PICKAXE_OR_25376, level = 61, 625),
    INFERNAL(Items.INFERNAL_PICKAXE, level = 61, Animation.MINING_INFERNAL_PICKAXE),
    INFERNAL_PICKAXE_OR(Items.INFERNAL_PICKAXE_OR, level = 61, 625),
    CRYSTAL(Items.CRYSTAL_PICKAXE, level = 71, Animation.MINING_CRYSTAL_PICKAXE);

    companion object {
        val values = enumValues<PickaxeType>()
    }
}