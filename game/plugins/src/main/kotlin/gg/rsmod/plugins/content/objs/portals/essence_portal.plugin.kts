package gg.rsmod.plugins.content.objs.portals

/**TODO:
 * add correct teleports to wizard
 * add more on objs
 * add projectile 109 not graphic
 */

arrayOf(Objs.PORTAL_34774, Objs.PORTAL_34776, Objs.PORTAL_34778).forEach { portal_use ->
    on_obj_option(obj = portal_use, option = "Use") {
        player.queue {
            player.graphic(109, 125)
            wait(2)
            player.graphic(110, 125)
            player.moveTo(3253, 3400)
        }
    }
}

arrayOf(Objs.PORTAL_34775, Objs.PORTAL_34777).forEach { portal_exit ->
    on_obj_option(obj = portal_exit, option = "Exit") {
        player.queue {
            player.graphic(109, 125)
            wait(2)
            player.graphic(110, 125)
            player.moveTo(3253, 3400)
        }
    }
}

on_npc_option(npc = Npcs.PORTAL_3088, option = "Exit") {
    player.graphic(110, 125)
    player.moveTo(3253, 3400)
}
on_npc_option(npc = Npcs.PORTAL_3086, option = "Use") {
    player.graphic(110, 125)
    player.moveTo(3253, 3400)
}