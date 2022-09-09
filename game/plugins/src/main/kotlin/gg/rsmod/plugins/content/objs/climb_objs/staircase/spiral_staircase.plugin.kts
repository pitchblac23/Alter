package gg.rsmod.plugins.content.objs.climb_objs.staircase

/**Spiral Staircase Up*/
arrayOf(Objs.STAIRCASE_24072, Objs.STAIRCASE_11888, Objs.STAIRCASE_16671,
        Objs.STAIRCASE_16672, Objs.STAIRCASE_12536, Objs.STAIRCASE_24075,
        Objs.STAIRCASE_9582, Objs.STAIRCASE_12537, Objs.STAIRCASE_11889,
        Objs.STAIRCASE_11511).forEach { spiral_up ->
    on_obj_option(obj = spiral_up, option = "climb-up") {
        player.queue {
            //Height 0
            if (player.getInteractingGameObj().tile == Tile(3204, 3207, 0)) { player.moveTo(3205, 3209, 1) }
            if (player.getInteractingGameObj().tile == Tile(2898, 3428, 0)) { player.moveTo(2898, 3427, 1) }
            if (player.getInteractingGameObj().tile == Tile(2954, 3338, 0)) { player.moveTo(2956, 3338, 1) }
            if (player.getInteractingGameObj().tile == Tile(2907, 3334, 0)) { player.moveTo(2908, 3336, 1) }
            if (player.getInteractingGameObj().tile == Tile(3103, 3159, 0)) { player.moveTo(3104, 3161, 1) }
            if (player.getInteractingGameObj().tile == Tile(3034, 3362, 0)) { player.moveTo(3035, 3364, 1) }
            if (player.getInteractingGameObj().tile == Tile(3048, 3352, 0)) { player.moveTo(3049, 3354, 1) }
            if (player.getInteractingGameObj().tile == Tile(2973, 3384, 0)) { player.moveTo(2972, 3385, 1) }
            if (player.getInteractingGameObj().tile == Tile(3026, 3248, 0)) { player.moveTo(3026, 3247, 1) }
            if (player.getInteractingGameObj().tile == Tile(3023, 3261, 0)) { player.moveTo(3025, 3261, 1) }
            if (player.getInteractingGameObj().tile == Tile(2931, 3282, 0)) { player.moveTo(2933, 3282, 1) }

            //Height 1
            if (player.getInteractingGameObj().tile == Tile(2960, 3338, 1)) { player.moveTo(2959, 3339, 2) }
            if (player.getInteractingGameObj().tile == Tile(3204, 3207, 1)) { player.moveTo(3205, 3209, 2) }
            if (player.getInteractingGameObj().tile == Tile(3104, 3362, 1)) { player.moveTo(3105, 3364, 2) }
            if (player.getInteractingGameObj().tile == Tile(3103, 3159, 1)) { player.moveTo(player.tile.x, player.tile.z, 2) }
            if (player.getInteractingGameObj().tile == Tile(2907, 3334, 1)) { player.moveTo(player.tile.x, player.tile.z, 2) }

            //Height 2
            if (player.getInteractingGameObj().tile == Tile(2957, 3338, 2)) { player.moveTo(2959, 3338, 3) }
        }
    }
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

/**Spiral Staircase Down*/
arrayOf(Objs.STAIRCASE_24074, Objs.STAIRCASE_16672, Objs.STAIRCASE_16673,
        Objs.STAIRCASE_11889, Objs.STAIRCASE_11890, Objs.STAIRCASE_24076,
        Objs.STAIRCASE_9584, Objs.STAIRCASE_12537, Objs.STAIRCASE_12538).forEach { spiral_down ->
    on_obj_option(obj = spiral_down, option = "climb-down") {
        player.queue {
            //Height 1
            if (player.getInteractingGameObj().tile == Tile(2955, 3338, 1)) { player.moveTo(2955, 3337, 0) }
            if (player.getInteractingGameObj().tile == Tile(2898, 3428, 1)) { player.moveTo(2897, 3428, 0) }
            if (player.getInteractingGameObj().tile == Tile(3204, 3207, 1)) { player.moveTo(3206, 3208, 0) }
            if (player.getInteractingGameObj().tile == Tile(2907, 3334, 1)) { player.moveTo(2909, 3335, 0) }
            if (player.getInteractingGameObj().tile == Tile(3035, 3363, 1)) { player.moveTo(3036, 3363, 0) }
            if (player.getInteractingGameObj().tile == Tile(3049, 3353, 1)) { player.moveTo(3050, 3353, 0) }
            if (player.getInteractingGameObj().tile == Tile(2973, 3385, 1)) { player.moveTo(2973, 3386, 0) }
            if (player.getInteractingGameObj().tile == Tile(3024, 3261, 1)) { player.moveTo(3024, 3260, 0) }
            if (player.getInteractingGameObj().tile == Tile(2932, 3282, 1)) { player.moveTo(2932, 3281, 0) }
            if (player.getInteractingGameObj().tile == Tile(3026, 3248, 1)) { player.moveTo(3025, 3248, 0) }
            if (player.getInteractingGameObj().tile == Tile(3103, 3159, 1)) { player.moveTo(player.tile.x, player.tile.z, 0) }

            //Height 2
            if (player.getInteractingGameObj().tile == Tile(2960, 3339, 2)) { player.moveTo(2960, 3340, 1) }
            if (player.getInteractingGameObj().tile == Tile(3205, 3208, 2)) { player.moveTo(3206, 3208, 1) }
            if (player.getInteractingGameObj().tile == Tile(3105, 3363, 2)) { player.moveTo(3106, 3363, 1) }
            if (player.getInteractingGameObj().tile == Tile(2908, 3335, 2)) { player.moveTo(player.tile.x, player.tile.z, 1) }
            if (player.getInteractingGameObj().tile == Tile(3104, 3160, 2)) { player.moveTo(player.tile.x, player.tile.z, 1) }

            //Height 3
            if (player.getInteractingGameObj().tile == Tile(2958, 3338, 3)) { player.moveTo(2958, 3337, 2) }
        }
    }
}

fun climbspiraleastup(player: Player) {
    player.moveTo(player.tile.x -1, player.tile.z +1, player.tile.height +1)
    //start on east
}
fun climbspiraleastdown(player: Player) {
    player.moveTo(player.tile.x +1, player.tile.z -1, player.tile.height -1)
    //start on east
}

fun climbupspiralstairs(player: Player) {
    player.moveTo(player.tile.x, player.tile.z, player.tile.height + 1)
}

fun climbdownspiralstairs(player: Player) {
    player.moveTo(player.tile.x, player.tile.z, player.tile.height - 1)
}