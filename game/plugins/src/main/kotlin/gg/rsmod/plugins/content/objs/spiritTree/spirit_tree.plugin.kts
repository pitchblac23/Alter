package gg.rsmod.plugins.content.objs.spiritTree

/**
 * @author DaGreenRs <dagreenrs@gmail.com>
 */

val SPIRIT_TREES = arrayOf(Objs.SPIRIT_TREE_26260, Objs.SPIRIT_TREE_26261, Objs.SPIRIT_TREE_26263, Objs.SPIRIT_TREE_35950)

on_login {
    //Unlock grand trees
    player.setVarp(111, 9)//Quest Tree Gnome Village
    player.setVarp(150, 160)//Quest The Grand Tree
    player.setVarbit(598, 2)
}

SPIRIT_TREES.forEach { tree ->
    on_obj_option(tree, "Travel") {TreeTele(player) }

    on_obj_option(tree, option = "talk-to") {
        if (tree == 26260 || tree == 26261) {
            player.queue(TaskPriority.STRONG) {
                chatNpc("You friend of gnome people, you friend of mine.<br><br>Would you like me to take you somewhere?", npc = 4982)
                when (options("No thanks, old tree.", "Where can I go?")) {
                    1 -> chatPlayer("No thanks, old tree.")
                    2 -> {
                        chatPlayer("Where can I go?")
                        chatNpc("You can travel to the trees which are related to me.", npc = 4982)
                        TreeTele(player)
                    }
                }
            }
        } else {
            player.queue(TaskPriority.STRONG) {
                chatNpc("Hello gnome friend. Where would you like to go?", npc = 4981)
                TreeTele(player)
            }
        }
    }
}

fun spiritTreeTele(player: Player, endTile : Tile) {
    player.queue(TaskPriority.STRONG) {
        player.closeInterface(InterfaceDestination.MAIN_SCREEN)
        player.lock = LockState.DELAY_ACTIONS
        itemMessage(message = "You place your hands on the dry tough bark of the<br>spirit tree, and feel a surge of energy run through<br>your veins.", item = 6063, amountOrZoom = 400)
        player.animate(id = 828)
        wait(1)
        player.moveTo(endTile)
        wait(1)
        player.unlock()
        itemMessageBox(message = "You place your hands on the dry tough bark of the<br>spirit tree, and feel a surge of energy run through<br>your veins.", item = 6063, amountOrZoom = 400)
    }
}

fun TreeTele (player: Player) {
    player.queue(TaskPriority.STRONG) {
        when (interfaceOptions("Tree Gnome Village", "Gnome Stronghold", "Battlefield of Khazard", "Grand Exchange", "Feldip Hills", "Prifddinas", "<col=777777>Port Sarim</col>", "<col=777777>Etceteria</col>", "<col=777777>Brimhaven</col>", "<col=777777>Hosidius</col>", "<col=777777>Farming Guild</col>", "<col=777777>Your house</col>", "Cancel", title = "Spirit Tree Locations")) {
            0 -> spiritTreeTele(player, Tile(2542, 3170, 0))
            1 -> spiritTreeTele(player, Tile(2461, 3444, 0))
            2 -> spiritTreeTele(player, Tile(2555, 3259, 0))
            3 -> spiritTreeTele(player, Tile(3185, 3508, 0))
            4 -> spiritTreeTele(player, Tile(2488, 2850, 0))
            5 -> spiritTreeTele(player, Tile(3274, 6123, 0))
            12 -> player.closeInterface(InterfaceDestination.MAIN_SCREEN)
        }
    }
}