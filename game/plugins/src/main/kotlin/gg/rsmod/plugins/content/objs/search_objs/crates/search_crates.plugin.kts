package gg.rsmod.plugins.content.objs.search_objs.crates

arrayOf(Objs.CRATE_354, Objs.CRATE_355, Objs.CRATE_356,
        Objs.CRATE_357, Objs.CRATE_358, Objs.CRATE_366,
        Objs.CRATE_1990, Objs.CRATE_1999, Objs.CRATE_2064,
        Objs.CRATE_11485, Objs.CRATES_11486, Objs.CRATE_16564,
        Objs.CRATE_16565, Objs.CRATE_25775, Objs.CRATES_15693).forEach { search ->
    on_obj_option(obj = search, option = "Search") {
        player.message("You search the crate but find nothing.")
    }
}

arrayOf(Objs.BOXES_24087, Objs.CRATES_24088).forEach { search ->
    on_obj_option(obj = search, option = "Search") {
        when (world.random(1)) {
            0 -> player.message("You don't find anything interesting.")
            1 -> player.message("You search the crates but find nothing.")
        }
    }
}