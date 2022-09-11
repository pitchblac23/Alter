package gg.rsmod.plugins.content.area.lumbridge.chat.shops

arrayOf(Npcs.SHOP_KEEPER, Npcs.SHOP_ASSISTANT).forEach { shop ->
    on_npc_option(shop, "trade") { player.openShop("Lumbridge General Store") }

    on_npc_option(shop, "talk-to") { player.queue { dialog() } }
}

suspend fun QueueTask.dialog() {
    chatNpc("Can I help you at all?")
    when (options("Yes please. What are you selling?", "No thanks.")) {
        1 -> {
            chatPlayer("Yeas please. What are you selling?")
            player.openShop("Lumbridge General Store")
        }
        2 -> {
            chatPlayer("No thanks.")
        }
    }
}