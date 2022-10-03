package gg.rsmod.plugins.content.area.world_chats

arrayOf(Npcs.MAN_3108, Npcs.MAN_3107, Npcs.MAN_3106).forEach { men ->
    on_npc_option(npc = men, option = "talk-to") { player.queue { chat() } }
}

suspend fun QueueTask.chat() {
    chatPlayer("Hello, how's it going?", animation = 567)
    when (world.random(23)) {
        0 -> chatNpc("Not too bad thanks.", animation = 567)
        1 -> {
            chatNpc("I'm fine, how are you?", animation = 567)
            chatPlayer("Very well thank you.", animation = 567)
        }
        2 -> chatNpc("I think we need a new king. The one we've got isn't<br>very good.", animation = 589)
        3 -> chatNpc("Get out of my way, I'm in a hurry!", animation = 614)
        4 -> chatNpc("Do I know you? I'm in a hurry!", animation = 575)
        5 -> chatNpc("None of your business.", animation = 614)
        6 -> {
            chatNpc("Not too bad, but I'm a little worried about the increase<br>of goblins these days.", animation = 589)
            chatPlayer("Don't worry, I'll kill them.", animation = 567)
        }
        7 -> chatNpc("I'm busy right now.", animation = 588)
        8 -> {
            chatNpc("Who are you?", animation = 575)
            chatPlayer("I'm a bold adventurer.", animation = 567)
            chatNpc("Ah, a very noble profession.", animation = 567)
        }
        9 -> chatNpc("No I don't have any spare change.", animation = 575)
        10 -> {
            chatNpc("How can I help you?", animation = 588)
            when (options("Do you wish to trade?", "I'm in search of a quest.", "I'm in search of enemies to kill.")) {
                1 -> {
                    chatPlayer("Do you wish to trade?", animation = 588)
                    chatNpc("No, I have nothing I wish to get rid of. If you want to<br>do some trading, there are plenty of shops and market<br>stalls around though.", animation = 590)
                }
                2 -> {
                    chatPlayer("I'm in search of a quest.", animation = 567)
                    chatNpc("I'm sorry I can't help you there.", animation = 588)
                }
                3 -> {
                    chatPlayer("I'm in search of enemies to kill.", animation = 588)
                    chatNpc("I've heard there are many fearsome creatures that<br>dwell under the ground...", animation = 589)
                }
            }
        }
        11 -> chatNpc("I'm very well thank you.")
        12 -> chatNpc("I'm a little worried - I've heard there's lots of people<br>going about, killing citizens at random.", animation = 589)
        13 -> chatNpc("That is classified information.", animation = 588)
        14 -> chatNpc("Hello there! Nice weather we've been having.", animation = 567)
        15 -> chatNpc("No, I don't want to buy anything!", animation = 614)
        16 -> chatNpc("Hello.", animation = 567)
        17 -> {
            chatPlayer("I'm in search of enemies to kill.", animation = 588)
            chatNpc("I've heard there are many fearsome creatures that<br>dwell under the ground...", animation = 589)
        }
        18 -> {
            chatPlayer("Do you wish to trade?", animation = 567)
            chatNpc("No, I have nothing I wish to get rid of. If you want to<br>do some trading, there are plenty of shops and market<br>stalls around though.", animation = 590)
        }
        19 -> {
            chatPlayer("I'm in search of a quest.", animation = 567)
            chatNpc("I'm sorry I can't help you there.", animation = 588)
        }
        20 -> {
            chatNpc("Have this flier...", animation = 588)
            player.inventory.add(956, 1)
        }
        21 -> {
            val npc = player.getInteractingNpc()
            chatNpc("Are you asking for a fight?", animation = 614)
            npc.attack(player)
        }
        22 -> chatNpc("Yo, wassup!")
    }
}