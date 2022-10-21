package gg.rsmod.plugins.content.skills.agility.shortcuts.climb

on_obj_option(Objs.ROCKS_16549, "Climb") {
    if (player.getSkills().getCurrentLevel(Skills.AGILITY) <= 37) {
        player.filterableMessage("You need an agility level of 38 to negotiate these rocks.")
    } else {
        player.queue {
            player.walkTo(x = 3306, 3315, MovementQueue.StepType.FORCED_WALK)
            wait(4)
            player.lock()
            player.walkTo(player.tile.x - 1, player.tile.z, MovementQueue.StepType.FORCED_WALK, detectCollision = false)
            wait(1)
            player.forceMove(this, 1148, 0, ForcedMovement.of(player.tile, Tile(x = player.tile.x - 3, z = player.tile.z), clientDuration1 = 33, clientDuration2 = 126, directionAngle = Direction.EAST.angle))
            player.unlock()
        }
    }
}

on_obj_option(Objs.ROCKS_16550, "Climb") {
    if (player.getSkills().getCurrentLevel(Skills.AGILITY) <= 37) {
        player.filterableMessage("You need an agility level of 38 to negotiate these rocks.")
    } else {
        player.queue {
            player.walkTo(x = 3302, z = 3315, MovementQueue.StepType.FORCED_WALK)
            wait(2)
            player.lock()
            player.appearimate(738, 737, 737, 737, 737, 737, 737)
            player.walkTo(player.tile.x + 3, player.tile.z, MovementQueue.StepType.FORCED_WALK, detectCollision = false)
            wait(4)
            player.appearimate(808, 823, 819, 820, 821, 822, 824)
            player.walkTo(player.tile.x + 1, player.tile.z, MovementQueue.StepType.FORCED_WALK, detectCollision = false)
            player.unlock()
        }
    }
}