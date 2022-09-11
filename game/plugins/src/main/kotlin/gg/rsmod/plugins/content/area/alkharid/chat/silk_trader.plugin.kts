package gg.rsmod.plugins.content.area.alkharid.chat

on_npc_option(npc = Npcs.SILK_TRADER, option = "talk-to") { player.queue { dialog() } }

suspend fun QueueTask.dialog() {
    chatNpc("Do you want to buy any fine silks?", animation = 567)
    when (options("How much are they?", "No. silk doesn't suit me.")) {
        1 -> {
            chatPlayer("How much are they?", animation = 567)
            chatNpc("3 gp.", animation = 567)
            when (options("No. That's to much for me.", "Okay, that sounds good.")) {
                1 -> {
                    chatPlayer("No. That's to much for me.", animation = 567)
                    chatNpc("2 gp and that's as low as I'll go.", animation = 567)
                    chatNpc("I'm not selling it for any less. You'll probably go and sell it in varrock for a profit, anyway.", animation = 567)
                    when (options("2 gp sounds good.", "No, really. I don't want ")) {
                        1 -> {
                            chatPlayer("2 gp sounds good.", animation = 567)
                            if (player.inventory.getItemCount(Items.COINS_995) >= 2) {
                                player.inventory.remove(Items.COINS_995, 2)
                                player.inventory.add(Items.SILK, 1)
                                itemMessageBox("you buy some silk for 2 gp.", item = 950)
                            } else
                                chatPlayer("Oh dear, I don't have enough money.", animation = 554)
                                chatNpc("Well, come back when you do have some money!", animation = 567)
                        }
                        2 -> {
                            chatPlayer("No, really. I don't want it.", animation = 567)
                            chatNpc("Okay, but that's the best price you're going to get.", animation = 567)
                        }
                    }
                }
                2 -> {
                    chatPlayer("Okay, that sounds good.", animation = 567)
                    if (player.inventory.getItemCount(Items.COINS_995) >= 3) {
                        player.inventory.remove(Items.COINS_995, 3)
                        player.inventory.add(Items.SILK, 1)
                        itemMessageBox("you buy some silk for 3 gp.", item = 950)
                    } else
                        chatPlayer("Oh dear, I don't have enough money.", animation = 554)
                        chatNpc("Well, come back when you do have some money!", animation = 567)
                }
            }
        }
        2 -> chatPlayer("No. silk doesn't suit me.", animation = 567)
    }
}