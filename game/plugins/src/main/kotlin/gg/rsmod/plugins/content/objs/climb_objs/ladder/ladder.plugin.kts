package gg.rsmod.plugins.content.objs.climb_objs.ladder

/**Climbing up a ladder.*/
arrayOf(Objs.LADDER_9558, Objs.LADDER_12964, Objs.LADDER_12965, Objs.LADDER_16683, Objs.LADDER_16684, Objs.LADDER_60).forEach { ladder_up ->
    on_obj_option(obj = ladder_up, option = "climb-up") {
        climbupladder(player)
    }
}

arrayOf(Objs.LADDER_24082, Objs.LADDER_24083).forEach { multi_ladder_up ->
    on_obj_option(obj = multi_ladder_up, option = "climb-up") {
        player.queue {
            player.animate(828)
            player.lock()
            wait(2)
            if (player.tile.x == 3035 && player.tile.z == 3345 ||
                player.tile.x == 2947 && player.tile.z == 3363) {
                player.moveTo(player.tile.x, player.tile.z, player.tile.height +1)

            } else if (player.tile.x == 2954 && player.tile.z == 3388 && player.tile.height == 2) {
                player.moveTo(player.tile.x, player.tile.z + 2, player.tile.height +1)

            } else if (player.tile.x == 2955 && player.tile.z == 3390 && player.tile.height == 1) {
                player.moveTo(player.tile.x -2, player.tile.z, player.tile.height +1)

            } else {
                player.moveTo(player.tile.x, player.tile.z -2, player.tile.height +1)
            }
            player.unlock()
        }
    }
}

//TODO: may need fix in future for different loc's
on_obj_option(Objs.LADDER_17385, option = "climb-up") {
    player.queue {
        player.animate(828)
        player.lock()
        wait(2)
        player.moveTo(player.tile.x, player.tile.z -6400)
        player.unlock()
    }
}

on_obj_option(obj = Objs.LADDER_6436, option = "climb-up") {
    player.queue {
        player.animate(828)
        player.lock()
        wait(2)
        player.moveTo(3118, 3243)
        player.unlock()
    }
}

on_obj_option(obj = Objs.LADDER_2148, option = "climb-up") {
    player.queue {
        player.animate(828)
        player.lock()
        wait(2)
        player.moveTo(3105, 3162)
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
arrayOf(Objs.LADDER_9559, Objs.LADDER_12965, Objs.LADDER_12966, Objs.LADDER_16684, Objs.LADDER_24085).forEach { ladder_down ->
    on_obj_option(obj = ladder_down, option = "climb-down") {
        climbdownladder(player)
    }
}

arrayOf(Objs.LADDER_16679).forEach { down_ladder ->
    on_obj_option(obj = down_ladder, option = "climb-down") {
        climbladderdown(player)
    }
}

arrayOf(Objs.LADDER_24084).forEach { multi_ladder_down ->
    on_obj_option(obj = multi_ladder_down, option = "climb-down") {
        player.queue {
            player.animate(828)
            player.lock()
            wait(2)
            if (player.tile.x == 2954 && player.tile.z == 3390 && player.tile.height == 3) {
                player.moveTo(player.tile.x, player.tile.z -2, player.tile.height -1)

            } else if (player.tile.x == 2953 && player.tile.z == 3390 && player.tile.height == 2) {
                player.moveTo(player.tile.x +2, player.tile.z, player.tile.height -1)

            } else {
                player.moveTo(player.tile.x, player.tile.z +2, player.tile.height -1)
            }
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
        player.animate(828)
        player.lock()
        wait(2)
        player.moveTo(player.tile.x, player.tile.z +6400)
        player.unlock()
    }
}

on_obj_option(obj = Objs.LADDER_2147, option = "climb-down") {
    player.queue {
        player.animate(827)
        player.lock()
        wait(2)
        player.moveTo(3104, 9576)
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

fun climbladderdown(player : Player) {
    player.queue {
        player.animate(827)
        player.lock()
        wait(2)
        player.moveTo(player.tile.x, player.tile.z, player.tile.height - 1)
        player.unlock()
    }
}