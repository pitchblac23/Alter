package gg.rsmod.plugins.content.inter.quest

import gg.rsmod.plugins.content.inter.quest.QuestTab.QUEST_SETTINGS_INTERFACE_ID

/**
 * Quest setting button
 */
on_button(interfaceId = 399, component = 11) {
    player.openInterface(interfaceId = QUEST_SETTINGS_INTERFACE_ID, dest = InterfaceDestination.MAIN_SCREEN)
}
