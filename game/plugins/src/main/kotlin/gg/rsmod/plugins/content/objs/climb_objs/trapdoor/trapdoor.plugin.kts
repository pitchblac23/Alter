package gg.rsmod.plugins.content.objs.climb_objs.trapdoor

/**Lumbridge kitchen trapdoor*/

on_obj_option(Objs.TRAPDOOR_14880, option = "climb-down") {
    player.moveTo(3210, 9616, 0)
}

on_obj_option(Objs.LADDER_17385, option = "climb-up") {
    player.queue {
        player.animate(828)
        wait(2)
        player.moveTo(3210, 3216, 0)
    }

}

on_obj_option(Objs.TRAPDOOR_10048, option = "climb-down") {
    /**trap door for santas workshop*/
    player.queue { chatPlayer("There are no lights on downstairs in the basement, the<br><br>pixies must have moved on. I hope I see them again.") }
}

on_obj_option(Objs.TRAPDOOR_6434, option = "Open") {
 /**transforms object Objs.TRAPDOOR_6435 transforms back after climbdown*/
    player.moveTo(3118, 9644, 0)
}