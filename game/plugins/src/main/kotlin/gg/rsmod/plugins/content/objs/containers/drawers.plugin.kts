package gg.rsmod.plugins.content.objs.containers

/**
 * Open
 */
on_obj_option(obj = Objs.DRAWERS_23966, option = "Open") {
    open(player, 23967)
}

on_obj_option(obj = Objs.DRAWERS_350, option = "Open") {
    open(player, 351)
}

on_obj_option(obj = Objs.DRAWERS, option = "Open") {
    open(player, 349)
}

/**
 * Close
 */
on_obj_option(obj = Objs.DRAWERS_23967, option = "Close") {
    close(player, 23966)
}

on_obj_option(obj = Objs.DRAWERS_351, option = "Shut") {
    close(player, 350)
}

on_obj_option(obj = Objs.DRAWERS_349, option = "Shut") {
    close(player, 348)
}

/**
 * Search
 */
arrayOf(Objs.DRAWERS_23967, Objs.DRAWERS_351, Objs.DRAWERS_349).forEach { search ->
    on_obj_option(obj = search, option = "Search") {
        player.message("The drawers are empty.")
    }
}

on_obj_option(obj = Objs.DRAWERS_40282, option = "Open") {
    player.message("I don't think the owner would be happy for you to look through their drawers.")
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