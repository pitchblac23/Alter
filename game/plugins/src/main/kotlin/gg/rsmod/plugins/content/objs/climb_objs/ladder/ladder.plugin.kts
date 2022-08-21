package gg.rsmod.plugins.content.objs.climb_objs.ladder

/**Climbing up a ladder.*/

arrayOf(Objs.LADDER_12964, Objs.LADDER_12965, Objs.LADDER_16683, Objs.LADDER_16684).forEach { ladder_up ->
    on_obj_option(obj = ladder_up, option = "climb-up") {
        climbupladder(player)
    }
}

on_obj_option(obj = Objs.LADDER_6436, option = "climb-up") {
    player.queue {
        player.animate(828)
        player.lock()
        wait(2)
        player.moveTo(3118, 3243, 0)
        player.unlock()
    }
}

on_obj_option(obj = Objs.LADDER_2148, option = "climb-up") {
    player.queue {
        player.animate(828)
        player.lock()
        wait(2)
        player.moveTo(3105, 3162, 0)
        player.unlock()
    }
}

/**Interacting with multilevel ladder*/
arrayOf(Objs.LADDER_12965, Objs.LADDER_16684).forEach { ladder ->
    on_obj_option(obj = ladder, option = "climb") {
        player.queue {
            when (options("Climb Up.", "Climb Down.", title = "Climb up or down the ladder?")) {
                1 -> climbupladder(player)
                2 -> climbdownladder(player)
            }
        }
    }
}

/**Climbing down a ladder.*/
arrayOf(Objs.LADDER_12965, Objs.LADDER_12966, Objs.LADDER_16679, Objs.LADDER_16684).forEach { ladder_down ->
    on_obj_option(obj = ladder_down, option = "climb-down") {
        climbdownladder(player)
    }
}

on_obj_option(obj = Objs.LADDER_2147, option = "climb-down") {
    player.queue {
        player.animate(-1)//need correct animation
        player.lock()
        wait(2)
        player.moveTo(3104, 9576, 0)
        player.unlock()
    }
}

fun climbupladder(player : Player) {
    player.queue {
        player.animate(828)
        player.lock()
        wait(2)
        player.moveTo(player.tile.x, player.tile.z, player.tile.height + 1)
        player.unlock()
    }
}

fun climbdownladder(player : Player) {
    player.queue {
        player.animate(828)
        player.lock()
        wait(2)
        player.moveTo(player.tile.x, player.tile.z, player.tile.height - 1)
        player.unlock()
    }
}