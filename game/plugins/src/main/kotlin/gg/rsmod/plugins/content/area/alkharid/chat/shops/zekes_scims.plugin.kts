package gg.rsmod.plugins.content.area.alkharid.chat.shops

    on_npc_option(npc = Npcs.ZEKE, option = "talk-to") { player.queue { dialog() } }

    on_npc_option(npc = Npcs.ZEKE, option = "trade") { open_shop(player) }

suspend fun QueueTask.dialog() {
    chatNpc("A thousand greetings, sir.", animation = 567)
    when (options("Do you want to trade?", "Nice cloak.", "Could you sell me a dragon scimitar?")) {
        1 -> {
            chatPlayer("Do you want to trade?", animation = 567)
            chatNpc("Yes, certainly. I deal in scimitars.", animation = 567)
            open_shop(player)
        }
        2 -> {
            chatPlayer("Nice cloak.", animation = 567)
            chatNpc("Thank you.", animation = 567)
        }
        3 -> {
            chatPlayer("Could you sell me a dragon scimitar?", animation = 567)
            chatNpc("a dragon scimitar? A DRAGON scimitar?", animation = 567)
            chatNpc("No way, man!", animation = 567)
            chatNpc("The banana-brained nitwits who make them would never dream of selling any to me.", animation = 567)
            chatNpc("Seriously, you'll be a monkey's uncle before you'll ever hold a dragon scimitar.", animation = 567)
            chatPlayer("Hmmm, funny you should say that...", animation = 567)
            chatNpc("Perhaps you'd like to take a look at my stock?", animation = 567)
            when (options("Yes please, Zeke.", "Not today, thank you.")) {
                1 -> open_shop(player)
                2 -> chatPlayer("Not today, thank you.", animation = 567)
            }
        }
    }
}

fun open_shop(p: Player) { p.openShop("Zeke's Superior Scimitars.") }