package gg.rsmod.plugins.content.objs.climb_objs.trapdoor

/**Lumbridge kitchen trapdoor*/
on_obj_option(Objs.TRAPDOOR_14880, option = "climb-down") {
    player.queue {
        player.animate(827)
        player.lock()
        wait(2)
        player.moveTo(3210, 9616)
        player.unlock()
    }
}

on_obj_option(Objs.TRAPDOOR_10048, option = "climb-down") {
    /**trap door for santas workshop*/
    player.queue { chatPlayer("There are no lights on downstairs in the basement, the<br><br>pixies must have moved on. I hope I see them again.") }
}

on_obj_option(Objs.TRAPDOOR_6434, option = "Open") {
 /**transforms object Objs.TRAPDOOR_6435 transforms back after climbdown*/
    player.moveTo(3118, 9644)
}

//TODO: added from old files will fix later
/**Dwarven mines*/
on_obj_option(Objs.TRAPDOOR_11867, "climb-down") {
    if (player.tile.x == 3018 && player.tile.z == 3450) {
        player.queue {
            wait(2)
            player.animate(827)
            wait(1)
            player.moveTo(3018, 9850)
        }
    }
    if (player.tile.x == 3020 && player.tile.z == 3450) {
        player.queue {
            wait(2)
            player.animate(827)
            wait(1)
            player.moveTo(3020, 9850)
        }
    }
}