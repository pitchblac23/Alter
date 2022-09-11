package gg.rsmod.plugins.content.area.alkharid.chat

on_npc_option(npc = Npcs.KARIM, option = "talk-to") { player.queue { dialog() } }

suspend fun QueueTask.dialog() {
    chatNpc("Would you like to buy a nice kebab? Only one gold.", animation = 567)
    when (options("I think I'll give it a miss.", "Yes please.")) {
        1 -> chatPlayer("I think I'll give it a miss.", animation = 567)
        2 -> {
            chatPlayer("Yes please.", animation = 567)
            if (player.inventory.getItemCount(Items.COINS_995) >= 1) {
                player.inventory.remove(Items.COINS_995, 1)
                player.inventory.add(Items.KEBAB, 1)
            } else
                chatPlayer("Oopz, I forgot to bring any money with me.", animation = 554)
                chatNpc("Come back when you have some.", animation = 554)
        }
    }
}