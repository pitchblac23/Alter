package gg.rsmod.plugins.content.objs.climb_objs.staircase

/**Climbing up stairs.*/
on_obj_option(obj = Objs.STAIRCASE_15645, option ="climb-up") {
    player.moveTo(3102, 3266, 1)
}

on_obj_option(obj = Objs.STAIRCASE_18991, option ="climb-up") {
    player.moveTo(2968, 3215, 1)
}

on_obj_option(obj = Objs.STAIRCASE_23969, option ="climb-up") {
    player.moveTo(player.tile.x +3, player.tile.z -6400)
}

/**Climbing up long stairs horizontal.*/
arrayOf(Objs.STAIRCASE_16670, Objs.STAIRCASE_24077).forEach { stair_up ->
    on_obj_option(obj = stair_up, option = "climb-up") {
        climbuplongstairsH(player)
    }
}

/**Climbing up long stairs vertical.*/
on_obj_option(obj = Objs.STAIRCASE_24079, option = "climb-up") {
    climbuplongstairsV(player)
}

/**Interacting with multilevel stairs*/

/**Climbing down the stairs.*/
on_obj_option(obj = Objs.STAIRCASE_15648, option ="climb-down") {
    player.moveTo(3098, 3266)
}

on_obj_option(obj = Objs.STAIRCASE_18992, option ="climb-down") {
    player.moveTo(2964, 3215)
}

on_obj_option(obj = Objs.STAIRCASE_16664, option ="climb-down") {
    player.moveTo(player.tile.x -3, player.tile.z +6400)
}

/**Climbing down long stairs horizontal.*/
arrayOf(Objs.STAIRCASE_16669, Objs.STAIRCASE_24078).forEach {stair_down ->
    on_obj_option(obj = stair_down, option ="climb-down") {
        climbdownlongstairsH(player)
    }
}

/**Climbing down long stairs vertical.*/
on_obj_option(obj = Objs.STAIRCASE_24080, option ="climb-down") {
    climbdownlongstairsV(player)
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
