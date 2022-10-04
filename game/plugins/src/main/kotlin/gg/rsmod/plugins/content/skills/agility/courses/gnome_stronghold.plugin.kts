package gg.rsmod.plugins.content.skills.agility.courses

/**TODO:
 * need to add in course completion count.
 * need to add in stages of completion for added exp.
 * make npc shout when doing course objs.
 */

val GnomeStronghold = AttributeKey<Int>("Gnome Stronghold")

//Stage 1
//Npc Shout "Okay get over that log, quick quick!"
on_obj_option(obj = Objs.LOG_BALANCE_23145, option = "Walk-across") {
    player.queue {
        player.lock()
        player.filterableMessage("you walk carefully across the slippery log...")
        wait(1)
        player.appearimate(763, 762, 762, 762, 762, 762, -1)
        player.walkTo(x = 2474, z = 3429, MovementQueue.StepType.FORCED_WALK, detectCollision = false)
        wait(8)
        player.filterableMessage("...You make it safely to the other side.")
        player.appearimate(808, 823, 819, 820, 821, 822, 824)
        player.unlock()
        player.addXp(Skills.AGILITY, 7.5)
    }
}

//Stage 2
//Npc Shout "Move it, move it, move it!"
on_obj_option(obj = Objs.OBSTACLE_NET_23134, option = "Climb-over") {
    if (player.tile.z == 3426) {
        player.queue {
            player.lock()
            player.filterableMessage("You climb the netting...")
            wait(1)
            player.animate(828)
            wait(1)
            player.moveTo(x = player.tile.x, z = 3424, 1)
            player.unlock()
            player.addXp(Skills.AGILITY, 7.5)
        }
    } else { player.message("You can not do that from here.") }
}

//Stage 3
//Npc Shout "That's it - straight up"
on_obj_option(obj = Objs.TREE_BRANCH_23559, option = "Climb") {
    player.queue {
        player.lock()
        player.filterableMessage("You climb the tree...")
        wait(1)
        player.animate(828)
        wait(1)
        player.moveTo(x = 2473, z = 3420, height = 2)
        player.filterableMessage("...To the platform above.")
        player.unlock()
        player.addXp(Skills.AGILITY, 5.0)
    }
}

//Stage 4
//Npc Shout "Come on scaredy cat, get across that rope!"
on_obj_option(obj = Objs.BALANCING_ROPE_23557, option = "Walk-on"){
    player.queue {
        wait(1)
        player.filterableMessage("You carefully cross the tightrope.")
        player.lock()
        player.appearimate(763, 762, 762, 762, 762, 762, -1)
        player.walkTo(x = 2483, z = 3420, stepType = MovementQueue.StepType.FORCED_WALK, detectCollision = false)
        wait(7)
        player.appearimate(808, 823, 819, 820, 821, 822, 824)
        player.unlock()
        player.addXp(Skills.AGILITY, 7.5)
    }
}

//Stage 5
on_obj_option(obj = Objs.TREE_BRANCH_23560, option = "Climb-down"){
    player.queue {
        player.lock()
        player.message("You climb down the tree...")
        wait(1)
        player.animate(828)
        wait(1)
        player.moveTo(x = 2485, z = 3419)
        player.message("You land on the ground.")
        player.unlock()
        player.addXp(Skills.AGILITY, 5.0)
    }
}

//Stage 6
//Npc Shout "My Granny can move faster than you."
on_obj_option(obj = Objs.OBSTACLE_NET_23135, option = "Climb-over") {
    if (player.tile.z == 3425) {
        player.queue {
            player.lock()
            player.filterableMessage("You climb the netting...")
            wait(2)
            player.animate(828)
            wait(2)
            player.animate(-1)
            player.moveTo(x = player.tile.x, z = player.tile.z +3)
            player.unlock()
            player.addXp(Skills.AGILITY, 7.5)
        }
    } else { player.message("You can not do that from here.") }
}

//Stage 7
arrayOf(Objs.OBSTACLE_PIPE_23138, Objs.OBSTACLE_PIPE_23139).forEach { pipe ->
    on_obj_option(pipe, option = "Squeeze-through") {
        if (player.getInteractingGameObj().tile == Tile(2484, 3435) || player.getInteractingGameObj().tile == Tile(2487, 3435)) { return@on_obj_option }

        player.queue {
            player.lock()
            if (player.getInteractingGameObj().tile == Tile(2484, 3431)) { player.walkTo(2484, 3430, MovementQueue.StepType.FORCED_WALK) }
            if (player.getInteractingGameObj().tile == Tile(2487, 3431)) { player.walkTo(2487, 3430, MovementQueue.StepType.FORCED_WALK) }
            wait(2)
            player.animate(749, 30)
            player.forceMove(this, ForcedMovement.of(player.tile, Tile(x = player.tile.x, z = player.tile.z +3), clientDuration1 = 33, clientDuration2 = 126, directionAngle = Direction.NORTH.angle))
            player.lock()
            wait(2)
            player.walkTo(player.tile.x, player.tile.z +1, MovementQueue.StepType.FORCED_WALK, detectCollision = false)
            wait(1)
            player.animate(749, 30)
            player.forceMove(this, ForcedMovement.of(player.tile, Tile(x = player.tile.x, z = player.tile.z +3), clientDuration1 = 33, clientDuration2 = 126, directionAngle = Direction.NORTH.angle))
            player.addXp(Skills.AGILITY, 7.5)

            //Course completion add
            player.addXp(Skills.AGILITY, 39.0)
            player.message("Your Gnome Stronghold Agility lap count is: <col=7f0000>${player.attr.get(GnomeStronghold)}</col>.")
        }
    }
}