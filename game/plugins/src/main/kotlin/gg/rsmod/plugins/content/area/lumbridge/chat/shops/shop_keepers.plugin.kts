package gg.rsmod.plugins.content.area.lumbridge.chat.shops

val SHOP_KEEPERS = intArrayOf(Npcs.SHOP_KEEPER, Npcs.SHOP_ASSISTANT)

SHOP_KEEPERS.forEach { npc ->
    on_npc_option(npc, "trade") {
        player.openShop("Lumbridge General Store")
    }

    on_npc_option(npc, "talk-to") {
        player.queue {
            this.chatNpc(npc = npc, title = "Shop keeper", message = "Can I help you at all?")
            when(this.options("Yes please. What are you selling?", "No thanks.", title = "Select an Option")) {
                1 -> {
                    this.chatPlayer("Yeas please. What are you selling?")
                    this.player.openShop("Lumbridge General Store")
                }

                2 -> {
                    this.chatPlayer("No thanks.")
                }
            }
        }
    }
}