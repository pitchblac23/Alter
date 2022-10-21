package gg.rsmod.plugins.content.area.alkharid.chat.shops

    on_npc_option(npc = Npcs.RANAEL, option = "talk-to") { player.queue { dialog() } }

    on_npc_option(npc = Npcs.RANAEL, option = "trade") { open_shop(player) }

suspend fun QueueTask.dialog() {
    chatNpc("Do you want to buy armoured skirts? Designed especially for ladies who like to fight.", animation = 567)
    when (options("Yes please.", "No thank you, that's not my scene.")) {
        1 -> open_shop(player)
        2 -> chatPlayer("No thank you, that's not my scene.", animation = 588)
    }
}

fun open_shop(p: Player) { p.openShop("Ranael's Super Skirt Store.") }