package gg.rsmod.plugins.content.area.alkharid.chat.shops

    on_npc_option(npc = Npcs.GEM_TRADER, option = "talk-to") { player.queue { dialog() } }

    on_npc_option(npc = Npcs.GEM_TRADER, option = "trade") { open_shop(player) }

suspend fun QueueTask.dialog() {
    chatNpc("Good day to you traveller. Would you be interested in buying some gems?", animation = 567)
    when (options("Yes please.", "No, thank you.")) {
        1 -> open_shop(player)
        2 -> {
            chatPlayer("No thank you.", animation = 567)
            chatNpc("Eh. suit yourself.", animation = 567)
        }
    }
}

fun open_shop(p: Player) { p.openShop("Gem Trader.") }