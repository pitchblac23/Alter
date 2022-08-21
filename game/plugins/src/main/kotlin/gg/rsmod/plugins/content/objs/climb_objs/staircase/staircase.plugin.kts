package gg.rsmod.plugins.content.objs.climb_objs.staircase

/**Climbing up stairs.*/
arrayOf(Objs.STAIRCASE_16671,Objs.STAIRCASE_16672).forEach { stair_up ->
    on_obj_option(obj = stair_up, option = "climb-up")
    {
        climbupstairs(player)
    }
}

on_obj_option(obj = Objs.STAIRCASE_12536, option ="climb-up") {
    player.moveTo(3104, 3161, 1)
}

on_obj_option(obj = Objs.STAIRCASE_15645, option ="climb-up") {
    player.moveTo(3102, 3266, player.tile.height + 1)
}

/**Climbing up long stairs.*/
arrayOf(Objs.STAIRCASE_16670).forEach { stair_up ->
    on_obj_option(obj = stair_up, option = "climb-up")
    {
        climbuplongstairs(player)
    }
}

/**Interacting with multilevel stairs*/
arrayOf(Objs.STAIRCASE_12537).forEach {staircase ->
    on_obj_option(obj = staircase, option = "climb")
    {
        player.queue {
            when (options("Up", "Down", title = "Which way do you want to go?")) {
                1 -> climbupstairs(player)
                2 -> climbdownstairs(player)
            }
        }
    }
}

arrayOf(Objs.STAIRCASE_16672).forEach {staircase ->
    on_obj_option(obj = staircase, option = "climb")
    {
        player.queue {
            when (options("Climb up the stairs.", "Climb down the stairs.", title = "Climb up or down the stairs?")) {
                1 -> climbupstairs(player)
                2 -> climbdownstairs(player)
            }
        }
    }
}

/**Climbing down the stairs.*/
arrayOf(Objs.STAIRCASE_16673, Objs.STAIRCASE_12538, Objs.STAIRCASE_16672).forEach {stair_down ->
    on_obj_option(obj = stair_down, option ="climb-down") {
        climbdownstairs(player)
    }
}

on_obj_option(obj = Objs.STAIRCASE_15648, option ="climb-down") {
    player.moveTo(3098, 3266, player.tile.height - 1)
}

/**Climbing down long stairs.*/
arrayOf(Objs.STAIRCASE_16669).forEach {stair_down ->
    on_obj_option(obj = stair_down, option ="climb-down") {
        climbdownlongstairs(player)
    }
}


fun climbupstairs(player: Player) {
    player.moveTo(player.tile.x, player.tile.z, player.tile.height + 1)
}

fun climbuplongstairs(player: Player) {
    player.moveTo(player.tile.x +4, player.tile.z, player.tile.height + 1)
}

fun climbdownstairs(player: Player) {
    player.moveTo(player.tile.x, player.tile.z, player.tile.height - 1)
}

fun climbdownlongstairs(player: Player) {
    player.moveTo(player.tile.x -4, player.tile.z, player.tile.height - 1)
}
