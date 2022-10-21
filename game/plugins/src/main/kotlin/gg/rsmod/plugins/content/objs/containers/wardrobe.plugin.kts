package gg.rsmod.plugins.content.objs.containers

/**
 * Open
 */
on_obj_option(obj = Objs.WARDROBE, option = "Open") { open(player, 389) }

/**
 * Close
 */
on_obj_option(obj = Objs.WARDROBE_389, option = "Close") { close(player, 388) }

/**
 * Search
 */
on_obj_option(obj = Objs.WARDROBE_389, option = "Search") { player.message("The wardrobe is empty.") }

fun open(player: Player, container: Int) {
    val obj = player.getInteractingGameObj()

    player.queue {
        player.lock()
        wait(2)
        player.animate(Animation.OPEN_WARDROBE)
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