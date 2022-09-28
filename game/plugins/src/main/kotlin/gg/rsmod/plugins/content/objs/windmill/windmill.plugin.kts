package gg.rsmod.plugins.content.objs.windmill

import gg.rsmod.plugins.api.cfg.Varbits.FLOUR_AMOUNT_VARBIT
import gg.rsmod.plugins.api.cfg.Varbits.FLOUR_COLLECTABLE_VARBIT

/**
 * Thanks to Desetude for the working windmill
 * Thanks to @MKP for better code logic
 * */

val HOPPER_LUMBY = AttributeKey<Unit>(persistenceKey = "hopper_lumby")
val HOPPER_ARDY = AttributeKey<Unit>(persistenceKey = "hopper_ardy")
val HOPPER_HOSIDIUS = AttributeKey<Unit>(persistenceKey = "hopper_hosidius")

val LUMB_FILL: Tile = Tile(3166, 3307, 2)
val ARDY_FILL: Tile = Tile(2632, 3386, 2)
val HOSIDIUS_FILL: Tile = Tile(1732, 3542, 2)

val LUMB_CTRL: Tile = Tile(3166, 3305, 2)
val ARDY_CTRL: Tile = Tile(2633, 3385, 2)
val HOSIDIUS_CTRL: Tile = Tile(1732, 3540, 2)

arrayOf(Objs.HOPPER_24961, Objs.HOPPER_24963).forEach { hopper ->
    on_item_on_obj(hopper, Items.GRAIN) { fillHopper(player) }
    on_obj_option(hopper, "Fill") { fillHopper(player) }
}

arrayOf(Objs.HOPPER_CONTROLS_24964, Objs.HOPPER_CONTROLS_24966, Objs.HOPPER_CONTROLS).forEach { controls ->
    on_obj_option(controls, "Operate") {
        val obj = player.getInteractingGameObj()

        player.queue {
            player.lock()
            wait(3)
            player.animate(3571)
            wait(1)

            world.queue {
                world.remove(obj)
                world.spawn(DynamicObject(obj, Objs.HOPPER_CONTROLS_24967))
                wait(2)
                world.remove(DynamicObject(obj, Objs.HOPPER_CONTROLS_24967))
                world.spawn(DynamicObject(obj))
            }
            player.unlock()

            val amount = player.getVarbit(FLOUR_AMOUNT_VARBIT)
            if (amount > 0) {
                player.setVarbit(FLOUR_COLLECTABLE_VARBIT, 1)
            }

            when (player.getInteractingGameObj().tile) {
                LUMB_CTRL -> { UseHopper(player, HOPPER_LUMBY) }
                ARDY_CTRL -> { UseHopper(player, HOPPER_ARDY) }
                HOSIDIUS_CTRL -> { UseHopper(player, HOPPER_HOSIDIUS) }
            }
        }
    }
}

on_item_on_obj(Objs.FLOUR_BIN, Items.POT) { emptyFlour(player) }
on_obj_option(Objs.FLOUR_BIN, "Empty") { emptyFlour(player) }
on_obj_option(Objs.FLOUR_BIN_5792, "Empty") { player.message("The flour bin is already empty. You need to place wheat in the hopper upstairs first.") }

fun fillHopper(player: Player) {
    when (player.getInteractingGameObj().tile) {
        LUMB_FILL -> { hopperAnim(player, HOPPER_LUMBY) }
        ARDY_FILL -> { hopperAnim(player, HOPPER_ARDY) }
        HOSIDIUS_FILL -> { hopperAnim(player, HOPPER_HOSIDIUS) }
    }
}

fun hopperAnim(player: Player, Key: AttributeKey<Unit>) {
    if (!player.attr.has(Key)) {
        player.queue {
            wait(3)
            player.lock()
            player.animate(3572)
            player.unlock()
            player.inventory.remove(Items.GRAIN)
            player.filterableMessage("You put the grain in the hopper. You should now pull the lever nearby to operate the hopper.")
        }
        player.attr.put(Key, Unit)
    } else {
        player.message("There is already grain in the hopper.")
    }
}

fun UseHopper(player: Player, persistanceKey: AttributeKey<Unit>) {
    val amount = player.getVarbit(FLOUR_AMOUNT_VARBIT)
    if (!player.attr.has(persistanceKey)) {
        player.filterableMessage("You operate the empty hopper. Nothing interesting happens.")
        return
    }
    player.filterableMessage("You operate the hopper. The grain slides down the chute.")
    player.attr.remove(persistanceKey)
    player.setVarbit(FLOUR_AMOUNT_VARBIT, amount + 1)
}

fun emptyFlour(player: Player) {
    if (!player.inventory.contains(Items.POT)) {
        player.message("You need an empty pot to hold the flour in.")
        return
    }

    var amount = player.getVarbit(FLOUR_AMOUNT_VARBIT)

    amount--

    player.inventory.remove(Items.POT)
    player.inventory.add(Items.POT_OF_FLOUR)
    if (amount == 0) {
        player.filterableMessage("You fill a pot with the last of the flour in the bin.")
        player.setVarbit(FLOUR_COLLECTABLE_VARBIT, 0)
        //return?
    }
    else { player.filterableMessage("You fill a pot with flour from the bin.") }

    player.setVarbit(FLOUR_AMOUNT_VARBIT, amount)
}