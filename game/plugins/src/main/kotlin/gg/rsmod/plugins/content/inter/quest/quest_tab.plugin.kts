package gg.rsmod.plugins.content.inter.quest

/**
 * Thanks to Bmyte for working quest tabs
 *
 * TODO: Fix any updates that might need with progress
 */

val QUEST_TAB_MAP = mapOf<Int, Int>(
        548 to 50,
        161 to 53,
        164 to 52,
        165 to 52 //don't know about this or how to get to "fullscreen" to check
)

//val PLAYER_SUMMARY_FOCUS_TAB = 8168
// 0 = char sum
// 1 = quest
// 2 = achievement
// 3 = favor
// 4 = adventure paths
// 5 = leagues

QUEST_TAB_MAP.keys.forEach{ interf ->
    on_button(interfaceId = interf, component = QUEST_TAB_MAP.getValue(interf)){
        openQuestTab(player)
    }
}

/**
 * Quest setting button
 */
on_button(interfaceId = 399, component = 11) {
    player.openInterface(interfaceId = QuestTab.QUEST_SETTINGS_INTERFACE_ID, dest = InterfaceDestination.MAIN_SCREEN)
}

fun openQuestTab(player: Player){
    player.openInterface(InterfaceDestination.QUEST_ROOT)
    when(player.getVarbit(Varbits.PLAYER_SUMMARY_FOCUS_TAB)){
        0 -> { // Character summary ->
        }
        1 -> { // Quests lists -> 399
            player.openInterface(629, 2, 399, type = 2)
            player.setInterfaceEvents(interfaceId = 399, component = 6, from = 0, to = 20, setting = 2)
            player.setInterfaceEvents(interfaceId = 399, component = 7, from = 0, to = 121, setting = 2)
            player.setInterfaceEvents(interfaceId = 399, component = 8, from = 0, to = 12, setting = 2)
        }
        2 -> { // Achievement diary
        }
        3 -> { // kourend favor
            player.openInterface(629, 2, 245, type = 1)
        }
        else -> { // all else fails show quests
            player.setVarbit(Varbits.PLAYER_SUMMARY_FOCUS_TAB, 1)
            openQuestTab(player)
        }
    }
}