package gg.rsmod.plugins.content.area.alkharid.chat.shops

arrayOf(Npcs.SHOP_KEEPER_2817, Npcs.SHOP_ASSISTANT_2818).forEach { shop ->
    on_npc_option(npc = shop, option = "talk-to") { player.queue { dialog() } }

    on_npc_option(npc = shop, option = "trade") { open_shop(player) }
}

suspend fun QueueTask.dialog() {
    chatNpc("Can I help you at all?", animation = 567)
    when (options("Yes please. What are you selling?", "No thanks.")) {
        1 -> open_shop(player)
        2 -> chatPlayer("No thanks.", animation = 588)
    }
}

fun open_shop(p: Player) { p.openShop("Al-Kharid General Store") }