package gg.rsmod.plugins.content.inter.quest_tab

/**
 * Thanks to Bmyte for working quest tabs
 *
 * TO-DO
 * Fix any updates that might need with progress
 * */

val QUEST_TAB_MAP = mapOf<Int, Int>(
        548 to 50,
        161 to 53,
        164 to 52,
        165 to 52 //don't know about this or how to get to "fullscreen" to check
)

val QUEST_TAB_VARBIT = 8168

QUEST_TAB_MAP.keys.forEach{ interf ->
    on_button(interfaceId = interf, component = QUEST_TAB_MAP.getValue(interf)){
        openQuestTab(player)
    }
}

fun openQuestTab(player: Player){
    player.openInterface(InterfaceDestination.QUEST_ROOT)
    when(player.getVarbit(QUEST_TAB_VARBIT)){
        0 -> { // Character summary ->
        }
        1 -> { // Quests lists -> 399
            player.openInterface(629, 2, 399, type = 2)
            player.setInterfaceEvents(interfaceId = 399, component = 6, from = 0, to = 20, setting = 2)
            player.setInterfaceEvents(interfaceId = 399, component = 7, from = 0, to = 121, setting = 2)
            player.setInterfaceEvents(interfaceId = 399, component = 8, from = 0, to = 12, setting = 2)
        }
        2 -> { // Achievement diary ->
        }
        3 -> { // kourend favor -> 245
            player.openInterface(629, 2, 245, type = 1)
        }
        else -> { // all else fails show quests
            player.setVarbit(QUEST_TAB_VARBIT, 0)
            openQuestTab(player)
        }
    }
}

on_button(629, 4){// small diary button
    player.setVarbit(QUEST_TAB_VARBIT, 1)
    openQuestTab(player)
}

on_button(629, 5){// small minigames button
    player.setVarbit(QUEST_TAB_VARBIT, 2)
    openQuestTab(player)
}

on_button(629, 6){// small favour button
    player.setVarbit(QUEST_TAB_VARBIT, 3)
    openQuestTab(player)
}