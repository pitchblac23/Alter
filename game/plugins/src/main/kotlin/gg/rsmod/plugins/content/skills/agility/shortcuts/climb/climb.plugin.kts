package gg.rsmod.plugins.content.skills.agility.shortcuts.climb

arrayOf(Objs.STILE, Objs.STILE_19222).forEach { stile ->
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
    Tile(x = 3197, z = 3278),
    Tile(x = 3062, z = 3283),
    Tile(x = 3062, z = 3284),
    Tile(x = 3063, z = 3284),
    Tile(x = 3064, z = 3284),
    Tile(x = 3064, z = 3283),
    Tile(x = 3043, z = 3306),
    Tile(x = 3042, z = 3306),
    Tile(x = 3042, z = 3305),
    Tile(x = 3042, z = 3304),
    Tile(x = 3043, z = 3304)
)
val tilesSouth = listOf(
    Tile(x = 3196, z = 3276),
    Tile(x = 3196, z = 3275),
    Tile(x = 3197, z = 3275),
    Tile(x = 3198, z = 3275),
    Tile(x = 3198, z = 3276),
    Tile(x = 3062, z = 3282),
    Tile(x = 3062, z = 3281),
    Tile(x = 3063, z = 3281),
    Tile(x = 3064, z = 3281),
    Tile(x = 3064, z = 3282),
    Tile(x = 3045, z = 3305),
    Tile(x = 3044, z = 3306)
)

arrayOf(Objs.STILE_12982, Objs.STILE_7527).forEach { stile ->
    on_obj_option(stile, option = "Climb-over") {
        player.queue {
            if (player.getInteractingGameObj().tile == Tile(3197, 3276)) {
                if (player.tile in tilesNorth) {
                    jumpStile(walkTo = Tile(3197, 3277), tile = Tile(3197, 3276), walkTo2 = Tile(3197, 3275), direction = Direction.SOUTH.angle)
                } else if (player.tile in tilesSouth) {
                    jumpStile(walkTo = Tile(3197, 3276), tile = Tile(3197, 3277), walkTo2 = Tile(3197, 3278), direction = Direction.NORTH.angle)
                }
            }
            else if (player.getInteractingGameObj().tile == Tile(3063, 3282)) {
                if (player.tile in tilesNorth) {
                    jumpStile(walkTo = Tile(3063, 3283), tile = Tile(3063, 3282), walkTo2 = Tile(3063, 3281), Direction.SOUTH.angle)
                } else if (player.tile in tilesSouth) {
                    jumpStile(walkTo = Tile(3063, 3282), tile = Tile(3063, 3283), walkTo2 = Tile(3063, 3284), Direction.NORTH.angle)
                }
            }
            else if (player.getInteractingGameObj().tile == Tile(3043, 3305)) {
                if (player.tile in tilesNorth) {
                    jumpStile(walkTo = Tile(3043, 3305), tile = Tile(3044, 3305), walkTo2 = Tile(3045, 3305), Direction.EAST.angle)
                } else if (player.tile in tilesSouth) {
                    jumpStile(walkTo = Tile(3044, 3305), tile = Tile(3043, 3305), walkTo2 = Tile(3042, 3305), Direction.WEST.angle)
                }
            }
        }
    }
}

suspend fun QueueTask.jumpStile(walkTo: Tile, tile: Tile, walkTo2: Tile, direction: Int) {
    player.lock()
    player.walkTo(walkTo, MovementQueue.StepType.FORCED_WALK, false)
    waitTile(walkTo)
    player.forceMove(this, 839, 30, ForcedMovement.of(player.tile, tile, clientDuration1 = 30, clientDuration2 = 64, directionAngle = direction))
    wait(1)
    player.walkTo(walkTo2, MovementQueue.StepType.FORCED_WALK, false)
    wait(1)
    player.unlock()
}