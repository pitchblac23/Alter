package gg.rsmod.plugins.content.objs

import gg.rsmod.plugins.content.objs.canoestation.Canoestation_plugin
import gg.rsmod.plugins.content.skills.fishing.data.FishingSpots

/**This is for testing objects without having to have a file*/
//TODO: add some of this to main files

on_obj_option(obj = Objs.CELL_DOOR_9563, option = "Open") {
    player.message("The door is securely locked.")
}

arrayOf(Objs.STILE_7527, Objs.STILE_12982, Objs.STILE, Objs.STILE_19222).forEach { stile ->
    on_obj_option(obj = stile, option = "climb-over") {
        player.message("place holder for Stiles")
    }
}

on_obj_option(obj = Objs.STILE_19222, "Leave") {
    player.message("place holder for leave option")
}

/* was orginal workings for stile needs redone for 1:1

on_obj_option(12982, "climb-over") {
    val stile = player.getInteractingGameObj()
    val endTile: Tile
    val directionAngle: Int
    val southOfStile = player.tile.z < stile.tile.z

    if (southOfStile) {
        endTile = stile.tile.step(Direction.NORTH, 2)
        directionAngle = Direction.NORTH.angle
    } else {
        endTile = stile.tile.step(Direction.SOUTH, 1)
        directionAngle = Direction.SOUTH.angle
    }

    val movement = ForcedMovement.of(player.tile, endTile, clientDuration1 = 33, clientDuration2 = 60, directionAngle = directionAngle)
    player.jumpStile(movement)
}

fun Player.jumpStile(movement: ForcedMovement) {
    queue {
        animate(839)
        forceMove(this, movement)
    }
}*/

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

on_obj_option(Objs.GROUP_STORAGE_43489, option = "open") {
    player.openInterface(interfaceId = 724, dest = InterfaceDestination.MAIN_SCREEN)
}

on_button(707, 3) {
    player.openInterface(7, dest = InterfaceDestination.CLAN_CHAT)
}


//player.message("You stop pumping.")
//world.spawn(DynamicObject(obj, Objs.PUMP))