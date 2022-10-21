package gg.rsmod.plugins.content.objs

/**This is for testing objects without having to have a file*/
//TODO: add some of this to main files

on_obj_option(obj = Objs.CELL_DOOR_9563, option = "Open") { player.message("The door is securely locked.") }

on_obj_option(obj = Objs.CAGE_20873, option = "Unlock") { player.message("You can't unlock the pillory, you'll let all the criminals out!") }

arrayOf(Objs.GATE_20847, Objs.GATE_20848).forEach { gate ->
    on_obj_option(gate, "Open") {
        player.queue { messageBox("The gate is securely locked.") }
    }
}

on_obj_option(Objs.PUMP, option = "Operate") {
    val obj = player.getInteractingGameObj()

    player.queue {
        wait(2)
        player.walkTo(x = 1950, z = 4961, MovementQueue.StepType.FORCED_WALK, detectCollision = false)
        wait(2)
        world.remove(obj)
        player.message("You start pumping.")
        player.animate(Animation.PUMP_FURNACE)
        player.unlock()
    }

    world.queue {
        wait(20)
        world.spawn(DynamicObject(obj, Objs.PUMP))
    }
}

on_obj_option(Objs.GROUP_STORAGE_43489, option = "open") { player.openInterface(interfaceId = 724, dest = InterfaceDestination.MAIN_SCREEN) }

on_button(707, 3) { player.openInterface(7, dest = InterfaceDestination.CLAN_CHAT) }

on_command("login") {
    player.openInterface(interfaceId = 110, dest = InterfaceDestination.WALKABLE)
    player.openInterface(interfaceId = 378, dest = InterfaceDestination.OVERLAY)
}

on_button(interfaceId = 378, 78) {
    player.closeInterface(interfaceId = 378)
    player.closeInterface(interfaceId = 110)
}

//player.message("You stop pumping.")
//world.spawn(DynamicObject(obj, Objs.PUMP))