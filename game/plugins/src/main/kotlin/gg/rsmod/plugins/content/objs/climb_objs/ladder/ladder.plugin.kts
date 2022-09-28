package gg.rsmod.plugins.content.objs.climb_objs.ladder

/**Climbing up a ladder.*/
arrayOf(Objs.LADDER_9558, Objs.LADDER_12964, Objs.LADDER_12965,
        Objs.LADDER_16683, Objs.LADDER_16684, Objs.LADDER_60,
        Objs.LADDER_24070, Objs.LADDER_25938, Objs.LADDER_25941,
        Objs.LADDER_26107, Objs.LADDER_12112).forEach { ladder_up ->
    on_obj_option(obj = ladder_up, option = "Climb-up") {
        climbupladder(player)
    }
}

arrayOf(Objs.LADDER_24082, Objs.LADDER_24083, Objs.LADDER_6436,
        Objs.LADDER_2148, Objs.LADDER_17387, Objs.LADDER_11806,
        Objs.LADDER_17385).forEach { up ->
    on_obj_option(obj = up, option = "Climb-up") {
        player.queue {
            wait(2)
            player.animate(828)
            player.lock()
            wait(1)
            if (player.getInteractingGameObj().tile == Tile(3118, 9643)) { player.moveTo(3118, 3243) }
            if (player.getInteractingGameObj().tile == Tile(3103, 9576)) { player.moveTo(3105, 3162) }
            if (player.getInteractingGameObj().tile == Tile(3019, 9850)) { player.moveTo(3018, 3450) }
            if (player.getInteractingGameObj().tile == Tile(3237, 9858)) { player.moveTo(3236, 3458) }
            if (player.getInteractingGameObj().tile == Tile(3209, 9616)) { player.moveTo(player.tile.x, player.tile.z -6400) }
            if (player.getInteractingGameObj().tile == Tile(3035, 3344)) { player.moveTo(3035, 3345, 1) }
            if (player.getInteractingGameObj().tile == Tile(2946, 3363)) { player.moveTo(2947, 3363, 1) }
            if (player.getInteractingGameObj().tile == Tile(2954, 3389)) { player.moveTo(2954, 3388, 1) }

            //Height 1
            if (player.getInteractingGameObj().tile == Tile(2954, 3390, 1)) { player.moveTo(2953, 3390, 2) }

            //Height 2
            if (player.getInteractingGameObj().tile == Tile(2954, 3389, 2)) { player.moveTo(2954, 3390, 3) }
            player.unlock()
        }
    }
}

/**Interacting with multilevel ladder*/
arrayOf(Objs.LADDER_12965, Objs.LADDER_16684).forEach { ladder ->
    on_obj_option(obj = ladder, option = "Climb") {
        player.queue {
            when (options("Climb Up.", "Climb Down.", title = "Climb up or down the ladder?")) {
                1 -> climbupladder(player)
                2 -> climbdownladder(player)
            }
        }
    }
}

/**Climbing down a ladder.*/
arrayOf(Objs.LADDER_9559, Objs.LADDER_12965, Objs.LADDER_12966,
        Objs.LADDER_16684, Objs.LADDER_24085, Objs.LADDER_24071,
        Objs.LADDER_12113).forEach { ladder_down ->
    on_obj_option(obj = ladder_down, option = "climb-down") {
        climbdownladder(player)
    }
}

arrayOf(Objs.LADDER_16679, Objs.LADDER_25939, Objs.LADDER_25940,
        Objs.LADDER_25606).forEach { down_ladder ->
    on_obj_option(obj = down_ladder, option = "climb-down") {
        climbladderdown(player)
    }
}

arrayOf(Objs.LADDER_24084).forEach { down ->
    on_obj_option(obj = down, option = "Climb-down") {
        player.queue {
            wait(2)
            player.animate(828)
            player.lock()
            wait(2)
            //Height 1
            if (player.getInteractingGameObj().tile == Tile(2954, 3389, 1)) { player.moveTo(2954, 3390) }

            //Height 2
            if (player.getInteractingGameObj().tile == Tile(2954, 3390, 2)) { player.moveTo(2955, 3390, 1) }

            //Height 3
            if (player.getInteractingGameObj().tile == Tile(2954, 3389, 3)) { player.moveTo(2954, 3388, 2) }
            player.unlock()
        }
    }
}

on_obj_option(obj = Objs.LADDER_30367, option ="climb-down") {
    if (player.getSkills().getCurrentLevel(Skills.MINING) < 60) {
        player.queue {
            when (world.random(1)) {
                0 -> {
                    chatNpc("Sorry, but you're not experienced enough to go in<br>there.", npc = 7713)
                    messageBox("You need a ${Skills.getSkillName(player.world, Skills.MINING)} level of 60 to access the Mining Guild.")
                }
                1 -> {
                    chatNpc("Sorry, but you're not experienced enough to go in<br>there.", npc = 7712)
                    messageBox("You need a ${Skills.getSkillName(player.world, Skills.MINING)} level of 60 to access the Mining Guild.")
                }
            }
        }
    } else
    player.queue {
        wait(2)
        player.animate(828)
        player.lock()
        wait(2)
        player.moveTo(player.tile.x, player.tile.z +6400)
        player.unlock()
    }
}

on_obj_option(obj = Objs.LADDER_2147, option = "climb-down") {
    player.queue {
        wait(2)
        player.animate(827)
        player.lock()
        wait(2)
        player.moveTo(3104, 9576)
        player.unlock()
    }
}

fun climbupladder(player : Player) {
    player.queue {
        player.lock()
        wait(2)
        player.animate(828)
        wait(2)
        player.moveTo(player.tile.x, player.tile.z, player.tile.height + 1)
        player.unlock()
    }
}

fun climbdownladder(player : Player) {
    player.queue {
        player.lock()
        wait(2)
        player.animate(828)
        wait(2)
        player.moveTo(player.tile.x, player.tile.z, player.tile.height - 1)
        player.unlock()
    }
}

fun climbladderdown(player : Player) {
    player.queue {
        player.lock()
        wait(2)
        player.animate(827)
        wait(2)
        player.moveTo(player.tile.x, player.tile.z, player.tile.height - 1)
        player.unlock()
    }
}