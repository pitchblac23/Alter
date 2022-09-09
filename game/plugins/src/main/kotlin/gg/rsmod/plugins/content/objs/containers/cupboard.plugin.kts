package gg.rsmod.plugins.content.objs.containers

/**
 * Open
 */
on_obj_option(obj = Objs.CUPBOARD_2271, option = "Open") {
    open(player, 2272)
}

/**
 * Close
 */
on_obj_option(obj = Objs.CUPBOARD_2272, option = "Shut") {
    close(player, 2271)
}

/**
 * Search
 */
on_obj_option(obj = Objs.CUPBOARD_2272, option = "Search") {
    player.queue {
        if (player.inventory.contains(item = Items.PORTRAIT)) {
            messageBox("There is just a load of junk in here.")
        } else {
            messageBox("You find a small portrait in here which you take.")
            player.inventory.add(item = Items.PORTRAIT)
        }
    }
}

fun open(player: Player, container: Int) {
    val obj = player.getInteractingGameObj()

    player.queue {
        player.lock()
        wait(2)
        player.animate(Animation.OPEN_CONTAINER)
        wait(1)
        world.spawn(DynamicObject(obj, container))
        player.unlock()
    }
}

fun close(player: Player, container: Int) {
    val obj = player.getInteractingGameObj()

    player.queue {
        player.lock()
        wait(2)
        player.animate(Animation.CLOSE_CONTAINER)
        wait(1)
        world.spawn(DynamicObject(obj, container))
        player.unlock()
    }
}