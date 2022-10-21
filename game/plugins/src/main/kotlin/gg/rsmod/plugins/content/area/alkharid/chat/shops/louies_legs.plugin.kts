package gg.rsmod.plugins.content.area.alkharid.chat.shops

    on_npc_option(npc = Npcs.LOUIE_LEGS, option = "talk-to") { player.queue { dialog() } }

    on_npc_option(npc = Npcs.LOUIE_LEGS, option = "trade") { open_shop(player) }

suspend fun QueueTask.dialog() {
    chatNpc("Hey, wanna buy some armour?", animation = 567)
    when (options("What have you got?", "No, thank you.")) {
        1 -> chatPlayer("No, thank you.", animation = 588)
        2 -> {
            chatPlayer("What have you got?", animation = 567)
            chatNpc("I provide items to help you keep your legs!", animation = 567)
            open_shop(player)
        }
    }
}

fun open_shop(p: Player) { p.openShop("Louie's Armoured Legs Bazaar.") }