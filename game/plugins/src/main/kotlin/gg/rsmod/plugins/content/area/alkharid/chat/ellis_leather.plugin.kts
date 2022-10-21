package gg.rsmod.plugins.content.area.alkharid.chat

on_npc_option(npc = Npcs.ELLIS, option = "talk-to") { player.queue { dialog() } }

on_npc_option(npc = Npcs.ELLIS, option = "trade") {
    player.setInterfaceUnderlay(-1, -1)
    player.openInterface(324, InterfaceDestination.MAIN_SCREEN)
}

suspend fun QueueTask.dialog() {
    chatNpc("Greetings friend. I am a manufacturer of leather.", animation = DEFAULT)
    if (player.inventory.getItemCount(Items.COWHIDE) >= 1) {
        chatNpc("I see you have brought me a hide. Would you like me to tan it for you?", animation = 567)
        when (options("Yes please.", "No thanks.")) {
            1 -> {
                chatPlayer("Yes please.", animation = 567)
                player.setInterfaceUnderlay(-1, -1)
                player.openInterface(324, InterfaceDestination.MAIN_SCREEN)
            }
            2 -> {
                chatPlayer("No thanks.", animation = 567)
                chatNpc("Very well, sir, as you wish.", animation = 567)
            }
        }
    } else
    when (options("Can I buy some leather then?", "Leather is rather weak stuff.")) {
        1 -> {
            chatNpc("Can I buy some leather then?", animation = 567)
            chatNpc("I make leather from animal hides. bring me some cowhides and one gold coin per hide, and I'll tan them into soft leather for you.", animation = 567)
        }
        2 -> {
            chatPlayer("Leather is rather weak stuff.", animation = 567)
            chatNpc("Normal leather may be quite weak, but it's very cheap I make it from cowhides for only 1 gp per hide and it's so easy to craft that anyone can work with it.", animation = 567)
            chatNpc("Alternatively you could try hard leather. It's not so easy to craft, but I only charge 3 gp per cowhide to prepare it, and it makes much sturdier armor.", animation = 567)
            chatNpc("I can also tan snake hides and dragonhides, suitable for crafting into highest quality armor for rangers.", animation = 567)
            chatPlayer("Thanks, I'll bear it in mind.", animation = 567)
        }
    }
}