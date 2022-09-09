package gg.rsmod.plugins.content.objs.containers

/**
 * Open
 */
on_obj_option(obj = Objs.CLOSED_CHEST_375, option = "Open") {
    open(player, 378)
}

on_obj_option(obj = Objs.CHEST_26193, option = "Open") {
    player.queue {
        player.lock()
        wait(2)
        player.animate(Animation.OPEN_CONTAINER)
        wait(1)
        world.spawn(DynamicObject(player.getInteractingGameObj(), Objs.CHEST_2418))
        wait(1)
        player.openInterface(dest = InterfaceDestination.MAIN_SCREEN, interfaceId = 265)
        player.unlock()
    }
}

/**
 * Close
 */
on_obj_option(obj = Objs.OPEN_CHEST_378, option = "Shut") {
    close(player, 375)
}

on_obj_option(obj = Objs.CHEST_2418, option = "Shut") {
    close(player, 26193)
}

/**
 * Search
 */
arrayOf(Objs.OPEN_CHEST_378).forEach { search ->
    on_obj_option(obj = search, option = "Search") {
        player.message("You search the chest but find nothing.")
    }
}

on_obj_option(obj = Objs.CHEST_2418, option = "Deposit") {
    player.openInterface(dest = InterfaceDestination.MAIN_SCREEN, interfaceId = 265)
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