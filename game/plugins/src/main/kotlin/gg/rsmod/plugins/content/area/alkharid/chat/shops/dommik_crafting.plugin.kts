package gg.rsmod.plugins.content.area.alkharid.chat.shops

    on_npc_option(npc = Npcs.DOMMIK, option = "talk-to") { player.queue { dialog() } }

    on_npc_option(npc = Npcs.DOMMIK, option = "trade") { open_shop(player) }

suspend fun QueueTask.dialog() {
    chatNpc("Would you like to buy some crafting equipment?", animation = 567)
    when (options("No thanks, I've got all the Crafting equipment I need.", "Let's see what you've got, then.")) {
        1 -> {
            chatPlayer("No thanks, I've got all the Crafting equipment I need.", animation = 588)
            chatNpc("okay. Fare well on your travels.", animation = 588)
        }

        2 -> open_shop(player)
    }
}

fun open_shop(p: Player) { p.openShop("Dommik's Crafting Store.") }