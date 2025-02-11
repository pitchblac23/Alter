package gg.rsmod.plugins.content.area.edgeville.chat

on_npc_option(npc = Npcs.MONK_2579, option = "talk-to") { player.queue { dialog() } }

suspend fun QueueTask.dialog() {
    chatNpc("Greetings traveller.", animation = 588)
    when (options("Can you heal me? I'm injured.", "Isn't this place built a bit out of the way?", "How do I get further into the monastery?")) {
        1 -> {
            val player = player
            chatPlayer("Can you heal me? I'm injured.", animation = 554)
            chatNpc("Ok.", animation = 588)
            heal(player)
            player.message("You feel a little better.")
        }
        2 -> {
            chatPlayer("Isn't this place built a bit out of the way?", animation = 554)
            chatNpc("We like it that way actually! We get disturbed less. We<br>still get rather a large amount of travellers looking for<br>sanctuary and healing here as it is!", animation = 590)
        }
        3 -> {
            chatPlayer("How do I get further into the monastery?", animation = 554)
            chatNpc("You'll need to talk to Abbot Langley about that. He's<br>usually to be found walking the halls of the monastery.", animation = 589)
        }
    }
}

fun heal(p: Player) {
    if (p.getSkills().getCurrentLevel(Skills.HITPOINTS) < p.getSkills().getBaseLevel(Skills.HITPOINTS)) {
        p.getSkills().setCurrentLevel(Skills.HITPOINTS, p.getSkills().getBaseLevel(Skills.HITPOINTS))
    }
}