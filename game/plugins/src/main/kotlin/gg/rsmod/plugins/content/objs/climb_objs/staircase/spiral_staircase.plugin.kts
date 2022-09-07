package gg.rsmod.plugins.content.objs.climb_objs.staircase

//TODO: some spiral stairs may need corrections

/**Spiral Staircase Up*/
arrayOf(Objs.STAIRCASE_12537, Objs.STAIRCASE_11889).forEach { spiral_up ->
    on_obj_option(obj = spiral_up, option = "climb-up")
    { climbupspiralstairs(player) }
}

on_obj_option(obj = Objs.STAIRCASE_9582, option = "climb-up") {
    if (player.tile.x == 3025 && player.tile.z == 3248) {
        climbspiralwestup(player)
    } else if (player.tile.x == 3024 && player.tile.z == 3260 ||
        player.tile.x == 2932 && player.tile.z == 3281) {
        climbspiralsouthup(player)

    } else if (player.tile.x == 3023 && player.tile.z == 3260 ||
        player.tile.x == 2931 && player.tile.z == 3281) {
        player.moveTo(player.tile.x + 2, player.tile.z + 1, player.tile.height + 1)

    } else if (player.tile.x == 3025 && player.tile.z == 3249) {
        player.moveTo(player.tile.x +1, player.tile.z -2, player.tile.height +1)
    }
}

on_obj_option(obj = Objs.STAIRCASE_24075, option = "climb-up") {
    if (player.tile.x == 3036 && player.tile.z == 3363 ||
        player.tile.x == 3050 && player.tile.z == 3353) {
        climbspiraleastup(player)
    }
    else if (player.tile.x == 2973 && player.tile.z == 3386) {
        climbspiralnorthup(player)
    }
    else if (player.tile.x == 3036 && player.tile.z == 3362 ||
        player.tile.x == 3050 && player.tile.z == 3352) {
        player.moveTo(player.tile.x -1, player.tile.z +2, player.tile.height +1)
    }
    else if (player.tile.x == 2974 && player.tile.z == 3386) {
        player.moveTo(player.tile.x -2, player.tile.z -1, player.tile.height +1)
    }
}

on_obj_option(obj = Objs.STAIRCASE_12536, option ="climb-up") {
    player.moveTo(3104, 3161, 1)
}

on_obj_option(obj = Objs.STAIRCASE_16672, option = "Climb-up") {
    if (player.tile.x == 3206 && player.tile.z == 3208 && player.tile.height == 1) {
        climbspiraleastup(player)
    } else { climbupspiralstairs(player) }
}

on_obj_option(obj = Objs.STAIRCASE_16671, option ="climb-up") {
    if (player.tile.x == 3206 && player.tile.z == 3208) {
        climbspiraleastup(player)
    } else if (player.tile.x == 3205 && player.tile.z == 3209) {
        climbupspiralstairs(player)
    } else {
        player.moveTo(x = 2898, z = 3427, player.tile.height + 1)
    }
}

on_obj_option(obj = Objs.STAIRCASE_11888, option = "Climb-up") {
    if (player.tile.x == 2909 && player.tile.z == 3334) {
        player.moveTo(player.tile.x -1, player.tile.z +2, player.tile.height +1)
    }
    else { climbspiraleastup(player) }
}

/**Interacting with multilevel spiral stairs*/
on_obj_option(obj = Objs.STAIRCASE_16672, option = "climb") {
    player.queue {
        when (options("Climb up the stairs.", "Climb down the stairs.", title = "Climb up or down the stairs?")) {
            1 -> if (player.tile.x == 3206 && player.tile.z == 3208 && player.tile.height == 1) {
                climbspiraleastup(player)
            } else { climbupspiralstairs(player) }
            2 -> if (player.tile.x == 3206 && player.tile.z == 3208 && player.tile.height == 1) {
                climbdownspiralstairs(player)
            } else { climbspiraleastdown(player) }
        }
    }
}

on_obj_option(obj = Objs.STAIRCASE_12537, option = "climb") {
    player.queue {
        when (options("Up", "Down", title = "Which way do you want to go?")) {
            1 -> climbupspiralstairs(player)
            2 -> climbdownspiralstairs(player)
        }
    }
}

on_obj_option(obj = Objs.STAIRCASE_11889, option = "climb") {
    player.queue {
        when (options("Climb up", "Climb down")) {
            1 -> climbupspiralstairs(player)
            2 -> climbspiraleastdown(player)
        }
    }
}

/**Spiral Staircase down*/
arrayOf(Objs.STAIRCASE_11890, Objs.STAIRCASE_12537, Objs.STAIRCASE_12538).forEach { spiral_down ->
    on_obj_option(obj = spiral_down, option = "climb-down")
    { climbdownspiralstairs(player) }
}

on_obj_option(obj = Objs.STAIRCASE_9584, option = "climb-down") {
    if (player.tile.x == 3025 && player.tile.z == 3261 && player.tile.height == 1 ||
        player.tile.x == 2933 && player.tile.z == 3282 && player.tile.height == 1 ) {
        climbspiralsouthdown(player)

    } else if (player.tile.x == 3026 && player.tile.z == 3247 && player.tile.height == 1) {
        climbspiralwestdown(player)
    }
}

on_obj_option(obj = Objs.STAIRCASE_24076, option = "climb-down") {
    if (player.tile.x == 3035 && player.tile.z == 3364 && player.tile.height == 1 ||
        player.tile.x == 3049 && player.tile.z == 3354 && player.tile.height == 1) {
        climbspiraleastdown(player)
    }
    else if (player.tile.x == 2972 && player.tile.z == 3385 && player.tile.height == 1) {
        climbspiralnorthdown(player)
    }
}

on_obj_option(obj = Objs.STAIRCASE_11889, option ="climb-down") {
    climbspiraleastdown(player)
}

on_obj_option(obj = Objs.STAIRCASE_16673, option ="climb-down") {
    if (player.tile.x == 2898 && player.tile.z == 3427 && player.tile.height == 1) {
        climbspiralwestdown(player)

    } else if (player.tile.x == 3205 && player.tile.z == 3209 && player.tile.height == 2) {
        climbspiraleastdown(player)
    }
}

on_obj_option(obj = Objs.STAIRCASE_16672, option ="climb-down") {
    if (player.tile.x == 2898 && player.tile.z == 3427 && player.tile.height == 1) {
        climbspiralwestdown(player)
    } else if (player.tile.x == 3206 && player.tile.z == 3208 && player.tile.height == 1) {
        climbdownspiralstairs(player)
    } else { climbspiraleastdown(player) }
}

fun climbspiralwestup(player: Player) {
    player.moveTo(player.tile.x +1, player.tile.z -1, player.tile.height +1)
    //start on west
}
fun climbspiralwestdown(player: Player) {
    player.moveTo(player.tile.x -1, player.tile.z +1, player.tile.height -1)
    //start on west
}

fun climbspiralsouthup(player: Player) {
    player.moveTo(player.tile.x +1, player.tile.z +1, player.tile.height +1)
    //start on south
}
fun climbspiralsouthdown(player: Player) {
    player.moveTo(player.tile.x -1, player.tile.z -1, player.tile.height -1)
    //start on south
}

fun climbspiraleastup(player: Player) {
    player.moveTo(player.tile.x -1, player.tile.z +1, player.tile.height +1)
    //start on east
}
fun climbspiraleastdown(player: Player) {
    player.moveTo(player.tile.x +1, player.tile.z -1, player.tile.height -1)
    //start on east
}

fun climbspiralnorthup(player: Player) {
    player.moveTo(player.tile.x -1, player.tile.z -1, player.tile.height +1)
    //start on north
}
fun climbspiralnorthdown(player: Player) {
    player.moveTo(player.tile.x +1, player.tile.z +1, player.tile.height -1)
    //start on north
}

fun climbupspiralstairs(player: Player) {
    player.moveTo(player.tile.x, player.tile.z, player.tile.height + 1)
}

fun climbdownspiralstairs(player: Player) {
    player.moveTo(player.tile.x, player.tile.z, player.tile.height - 1)
}