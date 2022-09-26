package gg.rsmod.plugins.content.area.edgeville.objs

on_obj_option(obj = Objs.COFFIN_398, option = "open") { open(player, player.getInteractingGameObj()) }

on_obj_option(obj = Objs.COFFIN_3577, option = "close") { close(player, player.getInteractingGameObj()) }

fun open(p: Player, obj: GameObject) {
    p.playSound(Sounds.COFFIN_OPEN_SFX)
    p.message("The coffin creaks open...")
    world.spawn(DynamicObject(obj, Objs.COFFIN_3577))
}

fun close(p: Player, obj: GameObject) {
    p.playSound(Sounds.COFFIN_CLOSE_SFX)
    p.message("You close the coffin.")
    world.spawn(DynamicObject(obj, Objs.COFFIN_398))
}