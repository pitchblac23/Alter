package gg.rsmod.plugins.content.area.dwarven_mines.chats

on_npc_option(Npcs.NURMOF, option = "talk-to") { player.queue { dialog() } }

on_npc_option(Npcs.NURMOF, option = "trade") { open_shop(player) }

suspend fun QueueTask.dialog() {
    chatNpc("Greetings and welcome to my pickaxe shop. Do you<br>want to buy my premium quality pickaxes?")
    when (options("Yes, please.", "No, thank you.", "Are your pickaxes better then other pickaxes, then?")) {
        1 -> open_shop(player)
        2 -> chatPlayer("No, thank you.")
        3 -> {
            chatPlayer("Are your pickaxes better then other pickaxes, then?")
            chatNpc("Of course they are! My pickaxes are made of highter<br>grade metal then your ordinary bronze pickaxes,<br>allowing you to mine that ore just a little bit faster than<br>normal.")
        }
    }
}

fun open_shop(p: Player) { p.openShop("Nurmof's Pickaxe Shop.") }