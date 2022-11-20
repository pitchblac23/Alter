package gg.rsmod.plugins.content.skills.agility.shortcuts.climb

/**This is for testing objects without having to have a file*/

arrayOf(Objs.STILE_7527, Objs.STILE, Objs.STILE_19222).forEach { stile ->
    on_obj_option(obj = stile, option = "climb-over") {
        player.message("place holder for Stiles")
    }
}

on_obj_option(obj = Objs.STILE_19222, "Leave") {
    player.message("place holder for leave option")
}

val tilesNorth = listOf(
    Tile(x = 3196, z = 3277),
    Tile(x = 3196, z = 3278),
    Tile(x = 3198, z = 3277),
    Tile(x = 3198, z = 3278),
    Tile(x = 3197, z = 3278)
)
val tilesSouth = listOf(
    Tile(x = 3196, z = 3276),
    Tile(x = 3196, z = 3275),
    Tile(x = 3197, z = 3275),
    Tile(x = 3198, z = 3275),
    Tile(x = 3198, z = 3276)
)

on_obj_option(Objs.STILE_12982, option = "Climb-over") {
    if (player.getInteractingGameObj().tile == Tile(3197, 3276)) {
        player.queue {
            if (player.tile in tilesNorth) {
                player.lock()
                player.walkTo(3197, 3277, MovementQueue.StepType.FORCED_WALK, false)
                waitTile(Tile(3197, 3277))
                player.forceMove(this, 839, 30, ForcedMovement.of(player.tile, Tile(x = player.tile.x, z = player.tile.z - 1), clientDuration1 = 30, clientDuration2 = 64, directionAngle = Direction.SOUTH.angle))
                waitTile(Tile(3197, 3276))
                player.walkTo(3197, 3275, MovementQueue.StepType.FORCED_WALK, false)
                wait(1)
                player.unlock()
            } else if (player.tile in tilesSouth) {
                player.lock()
                player.walkTo(3197, 3276, MovementQueue.StepType.FORCED_WALK, false)
                waitTile(Tile(3197, 3276))
                player.forceMove(this, 839, 30, ForcedMovement.of(player.tile, Tile(x = player.tile.x, z = player.tile.z + 1), clientDuration1 = 30, clientDuration2 = 64, directionAngle = Direction.NORTH.angle))
                waitTile(Tile(3197, 3277))
                player.walkTo(3197, 3278, MovementQueue.StepType.FORCED_WALK, false)
                wait(1)
                player.unlock()
            }
        }
    }
}