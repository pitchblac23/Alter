package gg.rsmod.plugins.content.area.lumbridge.chat.shops

on_npc_option(Npcs.BOB_10619, "trade") { player.openShop("Bob's Brilliant Axes.") }

/**TODO: Add Armor Repair*/
on_npc_option(Npcs.BOB_10619, option = "repair") { player.queue { chatNpc("You don't have anything I can repair.", animation = 575) } }

on_npc_option(Npcs.BOB_10619, "Talk-to") { player.queue { dialog() } }

suspend fun QueueTask.dialog() {
    when(options("Give me a quest!", "Have you anything to sell?", "Can you repair my items for me?", title = "Select an Option")) {
        1 -> {
            chatPlayer("Give me a quest!")
            chatNpc("Get yer own!")//, animation = //Anger)
        }
        2 -> {
            chatPlayer("Have you anything to sell?")
            chatNpc("Yes! I buy and sell axes! Take your pick (or axe)!")
            player.openShop("Bob's Brilliant Axes.")
        }
        3 -> {
            chatPlayer("Can you repair my items for me?")
            chatNpc("Of course I'll repair it, though the materials may cost<br><br>you. Just hand me the item and I'll have a look.")
        }
    }
}