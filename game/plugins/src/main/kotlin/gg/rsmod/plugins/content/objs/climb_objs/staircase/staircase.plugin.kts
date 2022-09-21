package gg.rsmod.plugins.content.objs.climb_objs.staircase

/**Climbing up stairs.*/
arrayOf(Objs.STAIRCASE_23969, Objs.STAIRCASE_18991, Objs.STAIRCASE_15645,
        Objs.STAIRCASE_16670, Objs.STAIRCASE_24077, Objs.STAIRCASE_24067,
        Objs.STAIRCASE_24079, Objs.STAIRCASE_11498, Objs.STAIRCASE_26106).forEach { stair_up ->
    on_obj_option(obj = stair_up, option = "climb-up") {
        player.queue {
            //Height 0
            if (player.getInteractingGameObj().tile == Tile(2965, 3215, 0)) { player.moveTo(2968, 3215, 1) }
            if (player.getInteractingGameObj().tile == Tile(3099, 3266, 0)) { player.moveTo(3102, 3266, 1) }
            if (player.getInteractingGameObj().tile == Tile(2968, 3347, 0)) { player.moveTo(2968, 3348, 1) }
            if (player.getInteractingGameObj().tile == Tile(3059, 9776, 0)) { player.moveTo(player.tile.x +3, player.tile.z -6400) }
            if (player.getInteractingGameObj().tile == Tile(2971, 3370, 0)) { player.moveTo(player.tile.x, player.tile.z +4, 1) }
            if (player.getInteractingGameObj().tile == Tile(2959, 3369, 0)) { player.moveTo(player.tile.x, player.tile.z +4, 1) }
            if (player.getInteractingGameObj().tile == Tile(3108, 3362, 0)) { player.moveTo(player.tile.x, player.tile.z +5, 1) }
            if (player.getInteractingGameObj().tile == Tile(2750, 3509, 0)) { player.moveTo(player.tile.x, player.tile.z +5, 1) }

            //Height 1
            if (player.getInteractingGameObj().tile == Tile(2984, 3337, 1)) { player.moveTo(player.tile.x, player.tile.z +4, 2) }
        }
    }
}

on_obj_option(Objs.STAIRS_2617, option = "walk-up") {
    player.queue {
        if (player.getInteractingGameObj().tile == Tile(3077, 9768, 0)) { player.moveTo(3116, 3356, 0) }
    }
}

/**Interacting with multilevel stairs*/

/**Climbing down the stairs.*/
arrayOf(Objs.STAIRCASE_18992, Objs.STAIRCASE_15648, Objs.STAIRCASE_16664,
        Objs.STAIRCASE_16669, Objs.STAIRCASE_24078, Objs.STAIRCASE_24068,
        Objs.STAIRCASE_24080, Objs.STAIRCASE_11499, Objs.STAIRCASE_25604).forEach { stair_down ->
    on_obj_option(obj = stair_down, option = "climb-down") {
        player.queue {
            //Height 0
            if (player.getInteractingGameObj().tile == Tile(3058, 3376, 0)) { player.moveTo(player.tile.x -3, player.tile.z +6400) }

            //Height 1
            if (player.getInteractingGameObj().tile == Tile(2966, 3215, 1)) { player.moveTo(2964, 3215) }
            if (player.getInteractingGameObj().tile == Tile(3100, 3266, 1)) { player.moveTo(3098, 3266) }
            if (player.getInteractingGameObj().tile == Tile(2968, 3347, 1)) { player.moveTo(x = 2971, z = 3347, 0) }
            if (player.getInteractingGameObj().tile == Tile(2959, 3370, 1)) { player.moveTo(player.tile.x, player.tile.z -4, 0) }
            if (player.getInteractingGameObj().tile == Tile(2971, 3371, 1)) { player.moveTo(player.tile.x, player.tile.z -4, 0) }
            if (player.getInteractingGameObj().tile == Tile(3108, 3364, 1)) { player.moveTo(player.tile.x, player.tile.z -5, 0) }
            if (player.getInteractingGameObj().tile == Tile(2750, 3511, 1)) { player.moveTo(player.tile.x, player.tile.z -5, 0) }

            //Height 2
            if (player.getInteractingGameObj().tile == Tile(2984, 3338, 2)) { player.moveTo(player.tile.x, player.tile.z -4, 1) }
        }
    }
}

on_obj_option(Objs.STAIRS_2616, option = "walk-down") {
    player.queue {
        if (player.getInteractingGameObj().tile == Tile(3115, 3357, 0)) { player.moveTo(3078, 9771, 0) }
    }
}