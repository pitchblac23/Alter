package gg.rsmod.plugins.content.skills.agility.shortcuts.contortion

on_obj_option(16529, "climb-into") { player.climbIntoUnderwallwest() }

on_obj_option(16530, "climb-into") { player.climbIntoUnderwalleast() }

fun Player.climbIntoUnderwallwest() {
    queue {
        if (player.getSkills().getCurrentLevel(Skills.AGILITY) >= 21) {
            lock()
            forceMove(this, anim = 2589, movement = ForcedMovement.of(player.tile, Tile(x = 3138, z = 3516), clientDuration1 = 0, clientDuration2 = 60, directionAngle = Direction.EAST.angle))
            wait(1)
            forceMove(this, anim = 2590, movement = ForcedMovement.of(player.tile, Tile(x = 3141, z = 3513), clientDuration1 = 0, clientDuration2 = 100, directionAngle = Direction.EAST.angle))
            forceMove(this, anim = 2591, movement = ForcedMovement.of(player.tile, Tile(x = 3142, z = 3513), clientDuration1 = 15, clientDuration2 = 33, directionAngle = Direction.EAST.angle))
            wait(1)
            unlock()
        } else { player.message("you need a agility level of 21 to use this shortcut.") }
    }
}

fun Player.climbIntoUnderwalleast() {
    queue {
        if (player.getSkills().getCurrentLevel(Skills.AGILITY) >= 21) {
            lock()
            forceMove(this, anim = 2589, movement = ForcedMovement.of(player.tile, Tile(x = 3141, z = 3513), clientDuration1 = 0, clientDuration2 = 60, directionAngle = Direction.WEST.angle))
            wait(1)
            forceMove(this, anim = 2590, movement = ForcedMovement.of(player.tile, Tile(x = 3138, z = 3516), clientDuration1 = 0, clientDuration2 = 100, directionAngle = Direction.WEST.angle))
            forceMove(this, anim = 2591, movement = ForcedMovement.of(player.tile, Tile(x = 3137, z = 3516), clientDuration1 = 15, clientDuration2 = 33, directionAngle = Direction.WEST.angle))
            wait(1)
            unlock()
        } else { player.message("you need a agility level of 21 to use this shortcut.") }
    }
}