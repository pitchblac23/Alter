package gg.rsmod.plugins.content.area.dwarven_mines.chats

on_npc_option(Npcs.BOOT, option = "talk-to") { player.queue { dialog() } }

suspend fun QueueTask.dialog() {
    chatNpc("Hello tall person.")
    when (options("Hello short person.", "Why are you called boot?")) {
        1 -> chatPlayer("Hello short person.")
        2 -> {
            chatPlayer("Why are you called Boot?")
            chatNpc("I'm called Boot, because when I was very young, I<br>used to sleep, in a large boot.")
            chatPlayer("yeah, great, I didn't want your life story.")
        }
    }
}