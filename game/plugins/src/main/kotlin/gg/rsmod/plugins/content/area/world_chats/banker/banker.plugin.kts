package gg.rsmod.plugins.content.area.world_chats.banker

import gg.rsmod.game.message.impl.ResumePauseButtonMessage
import gg.rsmod.plugins.content.inter.bank.openBank

arrayOf(Npcs.BANKER_2897, Npcs.BANKER_2898, Npcs.BANKER_1633, Npcs.BANKER_1634,
        Npcs.BANKER_1613, Npcs.BANKER_1618).forEach { banker ->

    on_npc_option(npc = banker, option = "talk-to", lineOfSightDistance = 2) { player.queue { dialog() } }

    on_npc_option(npc = banker, option = "bank", lineOfSightDistance = 2) { player.openBank() }

    on_npc_option(npc = banker, option = "collect", lineOfSightDistance = 2) { open_collect(player) }
}

suspend fun QueueTask.dialog() {
    chatNpc("Good day, how may I help you?")
    when (options("I'd like to access my bank account, please.", "I'd like to check my PIN settings.", "I'd like to collect items.", "I'd like to buy more bank slots.", "What is this place?")) {
        1 -> player.openBank()
        2 -> open_pin(player)
        3 -> open_collect(player)
        4 -> more_bank_slots()
        5 -> {
            chatPlayer("What is this place?")
            chatNpc("This is a branch of the Bank of Gielinor. We have<br><br>branches in many towns.", animation = 568)
            chatPlayer("And what do you do?", animation = 554)
            chatNpc("We will look after your items and money for you.<br>Leave your valuables with us if you want to keep them<br>safe.", animation = 569)
        }
    }
}

// TODO: 7/26/2022 add working bank slots
suspend fun QueueTask.more_bank_slots() {
    chatPlayer("I'd like to buy more bank slots.")
    chatNpc("I can sell you up to 360 additional bank slots in sets of<br>40. How many are you interested in buying?", animation = 568)
    player.setInterfaceUnderlay(color = -1, transparency = -1)
    player.openInterface(interfaceId = 187, dest = InterfaceDestination.MAIN_SCREEN)
    player.runClientScript(217,"How many do you wish to purchase?", "40 slots (1,000,000 coins)|80 slots (3,000,000 coins)|120 slots (8,000,000 coins)|160 slots (18,000,000 coins)|200 slots (38,000,000 coins)|240 slots (88,000,000 coins)|280 slots (188,000,000 coins)|320 slots (388,000,000 coins)|360 slots (888,000,000 coins)|(Cancel)")
    player.setInterfaceEvents(interfaceId = 187, component = 3, 0, 9, setting = 1)
    //chatPlayer("Actually, I've changed my mind.", animation = 554)
    waitReturnValue()

    val choice = (requestReturnValue as ResumePauseButtonMessage).slot
    player.message("you chose: $choice")
}

fun open_collect(p: Player) {
    p.setInterfaceUnderlay(color = -1, transparency = -1)
    p.openInterface(interfaceId = 402, dest = InterfaceDestination.MAIN_SCREEN)
}

fun open_pin(p: Player) {
    p.setInterfaceUnderlay(color = -1, transparency = -1)
    p.openInterface(interfaceId = 14, dest = InterfaceDestination.MAIN_SCREEN)
}