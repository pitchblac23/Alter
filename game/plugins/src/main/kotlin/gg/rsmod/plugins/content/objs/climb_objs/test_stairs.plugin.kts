package gg.rsmod.plugins.content.objs.climb_objs

/**Spiral Staircase Up*/
arrayOf(Objs.STAIRCASE_9582).forEach { south_west_up ->
    on_obj_option(obj = south_west_up, option = "climb-up") {
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
}

arrayOf(Objs.STAIRCASE_24075).forEach { north_east_up ->
    on_obj_option(obj = north_east_up, option = "climb-up") {
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
}

/**Spiral Staircase down*/
arrayOf(Objs.STAIRCASE_9584).forEach { south_west_down ->
    on_obj_option(obj = south_west_down, option = "climb-down") {
        if (player.tile.x == 3025 && player.tile.z == 3261 && player.tile.height == 1 ||
            player.tile.x == 2933 && player.tile.z == 3282 && player.tile.height == 1 ) {
            climbspiralsouthdown(player)

        } else if (player.tile.x == 3026 && player.tile.z == 3247 && player.tile.height == 1) {
            climbspiralwestdown(player)

        }
    }
}

arrayOf(Objs.STAIRCASE_24076).forEach { north_east_down ->
    on_obj_option(obj = north_east_down, option = "climb-down") {
        if (player.tile.x == 3035 && player.tile.z == 3364 && player.tile.height == 1 ||
            player.tile.x == 3049 && player.tile.z == 3354 && player.tile.height == 1) {
            climbspiraleastdown(player)
        }
        else if (player.tile.x == 2972 && player.tile.z == 3385 && player.tile.height == 1) {
            climbspiralnorthdown(player)
        }
    }
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