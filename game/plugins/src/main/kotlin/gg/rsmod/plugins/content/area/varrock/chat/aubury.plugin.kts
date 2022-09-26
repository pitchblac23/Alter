package gg.rsmod.plugins.content.area.varrock.chat

//Npc = 2886 "aubury before quest"

on_npc_option(npc = Npcs.AUBURY_11435, option = "trade", lineOfSightDistance = 1) { open_shop(player) }

on_npc_option(npc = Npcs.AUBURY_11435, option = "talk-to", lineOfSightDistance = 1) { player.queue { dialog() } }

on_npc_option(npc = Npcs.AUBURY_11435, option = "teleport", lineOfSightDistance = 1) { teleport(player) }

suspend fun QueueTask.dialog() {
    chatNpc("Do you want to buy some runes?")
    when (options()) {
        1 -> about_your_cape()
        2 -> {
            chatPlayer("Yes please!")
            open_shop(player)
        }
        3 -> no_thank_you()
        4 -> teleport_me()
    }
}

suspend fun QueueTask.options(): Int = options("Can you tell me about your cape?", "Yes please!", "No thank you.", "Can you teleport me to the Rune Essence Mine?")

suspend fun QueueTask.about_your_cape() {
    chatNpc("Certainly! Skillcapes are a symbol of achievement. Only<br>people who have mastered a skill and reached level 99<br>can get their hands on them and gain the benefits they<br>carry.", animation = 568)
    chatNpc("The Cape of Runecrafting has been upgraded with each<br>talisman, allowing you to access all Runecrafting altars.<br>Is there anything else I can help you with?", animation = 554)
    when (options("I'd like to view your store please.", "No thank you.")) {
        1 -> {
            chatPlayer("I'd like to view your store please.")
            open_shop(player)
        }
        2 -> no_thank_you()
    }
}

suspend fun QueueTask.no_thank_you() {
    chatPlayer("No thank you.", animation = 568)
    chatNpc("Well, if you find someone who does want runes, please<br><br>send them my way.", animation = 554)
}

suspend fun QueueTask.teleport_me() {
    chatPlayer("Can you teleport me to the Rune Essence Mine?", animation = 568)
    teleport(player)
}

fun open_shop(p: Player) { p.openShop("Aubury's Rune Shop.") }

fun teleport(p: Player) {
    p.queue {
        val npc = player.getInteractingNpc()
        player.lock = LockState.FULL
        npc.forceChat("Senventior Disthine Molenko")
        npc.graphic(108, 10)
        wait(3)
        player.graphic(109, 125)//this needs to be a projectile
        wait(2)
        player.graphic(110, 125)
        wait(2)
        player.moveTo(2912, 4833, 0)
        player.lock = LockState.NONE
    }
}