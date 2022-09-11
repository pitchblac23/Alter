package gg.rsmod.plugins.content.area.varrock.chat

on_npc_option(npc = Npcs.GYPSY, option = "talk-to") { player.queue { dialog() } }

suspend fun QueueTask.dialog() {
    when (options("The Demon Slayer Quest", "The Recipe For Disaster Quest")) {
        1 -> {
            chatNpc("Greetings young one.", animation = 588)
            chatNpc("You're a hero now. That was a good bit of demonslaying.", animation = 588)
            when (options("How do you know I killed it?", "Thanks.", "stop calling me that!")) {
                1 -> {
                    chatPlayer("How do you know i killed it?", animation = 588)
                    chatNpc("you forget. I'm good at knowing things.", animation = 588)
                }
                2 -> {
                    chatPlayer("Thanks.", animation = 588)
                }
                3 -> {
                    chatPlayer("Stop calling me that!", animation = 588)
                    chatNpc("In the scheme of things you are very young.", animation = 588)
                    when (options("Ok but how old are you?", "Oh if it's in the scheme of things that's ok.")) {
                        1 -> {
                            chatPlayer("Ok, but how old are you?", animation = 588)
                            chatNpc("Count the number of legs on the stools in the Blue Moon inn, and multiply that number by seven.", animation = 588)
                            chatPlayer("Er, yeah, whatever.", animation = 588)
                        }
                        2 -> {
                            chatPlayer("Oh if it's in the scheme of things that's ok.", animation = 588)
                            chatNpc("You show wisdom for one so young.", animation = 588)
                        }
                    }
                }
            }
        }
        2 -> {
            chatPlayer("There's just one thing I don't understand about that whole time travel culinaromancer thing...", animation = 588)
            chatNpc("Oh yes? What was that?", animation = 588)
            chatPlayer("Everything!", animation = 588)
            chatNpc("I wouldn't worry about it to much if I were you. The world is safe once more thanks to your assistance.", animation = 588)
            chatNpc("That's all that really matters.", animation = 588)
            chatPlayer("Yeah, I guess... I just wish things made sense is all...", animation = 588)
        }
    }
}