package gg.rsmod.plugins.content.area.varrock.chat

on_npc_option(npc = Npcs.ZAFF, option = "talk-to") { player.queue { dialog() } }

on_npc_option(npc = Npcs.ZAFF, option = "trade") { open_shop(player) }

suspend fun QueueTask.dialog() {
    chatNpc("Would you like to buy or sell some staffs?", animation = 567)
    when (options("Yes please!", "No, thank you.")) {
        1 -> open_shop(player)
        2 -> {
            chatPlayer("No, thank you.", animation = 588)
            chatNpc("Well 'stick' your head in again if you change your mind.", animation = 588)
            chatPlayer("Huh, terrible pun! You just can't get the 'staff' these days!", animation = 588)
        }
    }
}

fun open_shop(p: Player) {
    p.openShop("Zaff's Superior Staffs!")
}