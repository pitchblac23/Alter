package gg.rsmod.plugins.content.inter.quest

import gg.rsmod.game.model.entity.Player
import gg.rsmod.plugins.api.ext.*
import gg.rsmod.plugins.content.inter.quest.quest_guides.cooks_assistant
import gg.rsmod.plugins.content.inter.quest.quest_guides.sheep_shearer
import gg.rsmod.plugins.content.inter.quest.quest_guides.x_marks_the_spot

/**
 * @author Tom <rspsmods@gmail.com>
 * Thanks to @Gallus for the openGuide code
 */

object QuestTab {
    const val QUEST_SETTINGS_INTERFACE_ID = 134
}

fun search(p: Player) {
    p.runClientScript(600, 0, 1, 15, 30408716)
    p.setComponentText(interfaceId = 134, component = 12, text = "Quest List")
}

fun openGuide(player: Player) {
    val slot = player.getInteractingSlot()
    when (slot) {
        1 -> cooks_assistant(player)
        16 -> sheep_shearer(player)
        20 -> x_marks_the_spot(player)
        else -> player.message("${slot}")
    }
}