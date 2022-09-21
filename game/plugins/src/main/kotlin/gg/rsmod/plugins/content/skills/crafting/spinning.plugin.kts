package gg.rsmod.plugins.content.skills.crafting

arrayOf(Objs.SPINNING_WHEEL_25824, Objs.SPINNING_WHEEL_14889, Objs.SPINNING_WHEEL).forEach { spinning_wheels ->
    on_obj_option(obj = spinning_wheels, option = "Spin") {
        //player.queue { produceItemBox(title = "What would you like to spin?") }
    }
}