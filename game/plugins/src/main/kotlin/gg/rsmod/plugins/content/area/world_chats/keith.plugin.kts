package gg.rsmod.plugins.content.area.world_chats

on_npc_option(npc = Npcs.KEITH, option = "Talk-to") { player.queue { keith() } }

suspend fun QueueTask.keith() {
    chatPlayer("Hello. Who are you?")
    chatNpc("Hello there. The name's Keith. I'm the farmer here.")
    chatPlayer("You're pretty far out of the way here. How come?")
    chatNpc("It's a peaceful life. Out here I can avoid the drama and<br><br>politics of the big settlements.")
    chatPlayer("Aren't you worried about how close the lizardmen are<br><br>though?")
    chatNpc("The Shayzien troops keep them busy. They've not tried<br><br>coming up this way.")
    chatPlayer("Fair enough. I'll leave you to it.")
}