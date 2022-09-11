package gg.rsmod.plugins.content.objs

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