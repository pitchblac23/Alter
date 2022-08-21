package gg.rsmod.plugins.content.objs.climb_objs.staircase

/**Climbing up stairs.*/
arrayOf(Objs.STAIRCASE_16671,Objs.STAIRCASE_16672, Objs.STAIRCASE_12537).forEach { stair_up ->
    on_obj_option(obj = stair_up, option = "climb-up")
    {
        climbupstairs(player)
    }
}

on_obj_option(obj = Objs.STAIRCASE_12536, option ="climb-up") {
    player.moveTo(3104, 3161, 1)
}

on_obj_option(obj = Objs.STAIRCASE_15645, option ="climb-up") {
    player.moveTo(3102, 3266, 1)
}

on_obj_option(obj = Objs.STAIRCASE_18991, option ="climb-up") {
    player.moveTo(2968, 3215, 1)
}

on_obj_option(obj = Objs.STAIRCASE_23969, option ="climb-up") {
    player.moveTo(player.tile.x +3, player.tile.z -6400)
}

/*on_obj_option(obj = Objs.STAIRCASE_9582, option ="climb-up") {
    if (player.tile.x == 3025 && player.tile.z == 3248) {
        player.moveTo(3026, 3247, 1)
    } else if (player.tile.x == 3024 && player.tile.z == 3260) {
        player.moveTo(3025, 3261, 1)
    }
}

on_obj_option(obj = Objs.STAIRCASE_24075, option ="climb-up") {
    if (player.tile.x == 3036 && player.tile.z == 3363 || player.tile.x == 3036 && player.tile.z == 3362) {
        player.moveTo(3035, 3364, 1)
    } else if (player.tile.x == 3050 && player.tile.z == 3353 || player.tile.x == 3050 && player.tile.z == 3352) {
        player.moveTo(3049, 3354, 1)
    } else if (player.tile.x == 2973 && player.tile.z == 3386 || player.tile.x == 2974 && player.tile.z == 3386) {
        player.moveTo(2972, 3385, 1)
    }
}*/

/**Climbing up long stairs horizontal.*/
arrayOf(Objs.STAIRCASE_16670, Objs.STAIRCASE_24077).forEach { stair_up ->
    on_obj_option(obj = stair_up, option = "climb-up") {
        climbuplongstairsH(player)
    }
}

/**Climbing up long stairs vertical.*/
arrayOf(Objs.STAIRCASE_24079).forEach { stair_up ->
    on_obj_option(obj = stair_up, option = "climb-up") {
        climbuplongstairsV(player)
    }
}

/**Interacting with multilevel stairs*/
arrayOf(Objs.STAIRCASE_12537).forEach {staircase ->
    on_obj_option(obj = staircase, option = "climb") {
        player.queue {
            when (options("Up", "Down", title = "Which way do you want to go?")) {
                1 -> climbupstairs(player)
                2 -> climbdownstairs(player)
            }
        }
    }
}

arrayOf(Objs.STAIRCASE_16672).forEach {staircase ->
    on_obj_option(obj = staircase, option = "climb") {
        player.queue {
            when (options("Climb up the stairs.", "Climb down the stairs.", title = "Climb up or down the stairs?")) {
                1 -> climbupstairs(player)
                2 -> climbdownstairs(player)
            }
        }
    }
}

/**Climbing down the stairs.*/
arrayOf(Objs.STAIRCASE_16673, Objs.STAIRCASE_12538, Objs.STAIRCASE_12537, Objs.STAIRCASE_16672).forEach {stair_down ->
    on_obj_option(obj = stair_down, option ="climb-down") {
        climbdownstairs(player)
    }
}

on_obj_option(obj = Objs.STAIRCASE_15648, option ="climb-down") {
    player.moveTo(3098, 3266)
}

on_obj_option(obj = Objs.STAIRCASE_18992, option ="climb-down") {
    player.moveTo(2964, 3215)
}

on_obj_option(obj = Objs.STAIRCASE_16664, option ="climb-down") {
    player.moveTo(player.tile.x -3, player.tile.z +6400)
}

/*on_obj_option(obj = Objs.STAIRCASE_9584, option ="climb-down") {
    if (player.tile.x == 3025 && player.tile.z == 3261 && player.tile.height == 1) {
        player.moveTo(3024, 3260)
    } else if (player.tile.x == 3026 && player.tile.z == 3247 && player.tile.height == 1) {
        player.moveTo(3025, 3248)
    }
}

on_obj_option(obj = Objs.STAIRCASE_24076, option ="climb-down") {
    if (player.tile.x == 3035 && player.tile.z == 3364 && player.tile.height == 1) {
        player.moveTo(3036, 3363)
    } else if (player.tile.x == 3049 && player.tile.z == 3354 && player.tile.height == 1) {
        player.moveTo(3050, 3353)
    } else if (player.tile.x == 2972 && player.tile.z == 3385 && player.tile.height == 1) {
        player.moveTo(2973, 3386)
    }
}*/

/**Climbing down long stairs horizontal.*/
arrayOf(Objs.STAIRCASE_16669, Objs.STAIRCASE_24078).forEach {stair_down ->
    on_obj_option(obj = stair_down, option ="climb-down") {
        climbdownlongstairsH(player)
    }
}

/**Climbing down long stairs vertical.*/
arrayOf(Objs.STAIRCASE_24080).forEach {stair_down ->
    on_obj_option(obj = stair_down, option ="climb-down") {
        climbdownlongstairsV(player)
    }
}


fun climbupstairs(player: Player) {
    player.moveTo(player.tile.x, player.tile.z, player.tile.height + 1)
}

fun climbuplongstairsH(player: Player) {
    player.moveTo(player.tile.x +4, player.tile.z, player.tile.height + 1)
}

fun climbuplongstairsV(player: Player) {
    player.moveTo(player.tile.x, player.tile.z +4, player.tile.height + 1)
}

fun climbdownstairs(player: Player) {
    player.moveTo(player.tile.x, player.tile.z, player.tile.height - 1)
}

fun climbdownlongstairsH(player: Player) {
    player.moveTo(player.tile.x -4, player.tile.z, player.tile.height - 1)
}
fun climbdownlongstairsV(player: Player) {
    player.moveTo(player.tile.x, player.tile.z -4, player.tile.height - 1)
}
