package gg.rsmod.plugins.content.objs.search_objs.bookcase

arrayOf(Objs.BOOKCASE_380, Objs.BOOKCASE_381, Objs.BOOKCASE_9611,
        Objs.OLD_BOOKSHELF_7327, Objs.BOOKCASE_9523, Objs.BOOKCASE_9609).forEach { bookcase ->
    on_obj_option(obj = bookcase, option = "search") {
        player.queue {
            search(this, player)
        }
    }
}

suspend fun search(it: QueueTask, p: Player) {
    p.lock()
    p.message("You search the books...")
    it.wait(3)
    p.unlock()
    when (world.random(2)) {
        0 -> p.message("You find nothing to interest you.")
        1 -> p.message("You don't find anything that you'd ever want to read.")
        2 -> p.message("None of them look very interesting.")
    }
}