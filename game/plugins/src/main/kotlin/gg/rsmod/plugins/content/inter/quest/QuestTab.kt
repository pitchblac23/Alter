package gg.rsmod.plugins.content.inter.quest

import gg.rsmod.game.model.entity.Player
import gg.rsmod.plugins.api.ext.runClientScript
import gg.rsmod.plugins.api.ext.setComponentText

/**
 * @author Tom <rspsmods@gmail.com>
 */
object QuestTab {
    const val QUEST_SETTINGS_INTERFACE_ID = 134
}

fun search(p: Player) {
    p.runClientScript(600, 0, 1, 15, 30408716)
    p.setComponentText(interfaceId = 134, component = 12, text = "Quest List")
}