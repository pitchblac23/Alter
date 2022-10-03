package gg.rsmod.plugins.content.objs.windmill

import gg.rsmod.plugins.api.cfg.Varbits.FLOUR_AMOUNT_VARBIT
import gg.rsmod.plugins.api.cfg.Varbits.FLOUR_COLLECTABLE_VARBIT

/**
 * Thanks to Desetude for the working windmill
 * Thanks to @MKP for better code logic
 * */

val HOPPER_LUMBY = AttributeKey<Unit>(persistenceKey = "hopper_lumby")
val HOPPER_COOK = AttributeKey<Unit>(persistenceKey = "hopper_cook")
val HOPPER_ZANARIS = AttributeKey<Unit>(persistenceKey = "hopper_zanaris")
val HOPPER_ARDY = AttributeKey<Unit>(persistenceKey = "hopper_ardy")
val HOPPER_HOSIDIUS = AttributeKey<Unit>(persistenceKey = "hopper_hosidius")

val LUMB_FILL: Tile = Tile(3166, 3307, 2)
val COOK_FILL: Tile = Tile(3142, 3452, 2)
val ZANARIS_FILL: Tile = Tile(2405, 4457, 1)
val ARDY_FILL: Tile = Tile(2632, 3386, 2)
val HOSIDIUS_FILL: Tile = Tile(1732, 3542, 2)

val LUMB_CTRL: Tile = Tile(3166, 3305, 2)
val COOK_CTRL: Tile = Tile(3141, 3453, 2)
val ZANARIS_CTRL: Tile = Tile(2404, 4456, 1)
val ARDY_CTRL: Tile = Tile(2633, 3385, 2)
val HOSIDIUS_CTRL: Tile = Tile(1732, 3540, 2)

arrayOf(Objs.HOPPER, Objs.HOPPER_24961, Objs.HOPPER_24963,
        Objs.HOPPER_24962).forEach { hopper ->
    on_item_on_obj(hopper, Items.GRAIN) { fillHopper(player) }
    on_obj_option(hopper, "Fill") { fillHopper(player) }
}

arrayOf(Objs.HOPPER_CONTROLS, Objs.HOPPER_CONTROLS_2607, Objs.HOPPER_CONTROLS_24964,
        Objs.HOPPER_CONTROLS_24966, Objs.HOPPER_CONTROLS_24965).forEach { controls ->
    on_obj_option(controls, "Operate") {
        val obj = player.getInteractingGameObj()
        val amount = player.getVarbit(FLOUR_AMOUNT_VARBIT)

        if (amount == 31) {
            player.message("The flour bin downstairs is full, I should empty it first.")
            return@on_obj_option
        }
        if (amount > 0) {
            player.setVarbit(FLOUR_COLLECTABLE_VARBIT, 1)
        }

        player.queue {
            player.lock()
            wait(3)
            player.animate(Animation.PUSH_CONTROLS)
            wait(1)

            if (obj.tile == COOK_CTRL) {
                //No world change
            } else {
            world.queue {
                    world.remove(obj)
                    world.spawn(DynamicObject(obj, Objs.HOPPER_CONTROLS_24967))
                    wait(2)
                    world.remove(DynamicObject(obj, Objs.HOPPER_CONTROLS_24967))
                    world.spawn(DynamicObject(obj))
                }
            }
            player.unlock()

            when (player.getInteractingGameObj().tile) {
                LUMB_CTRL -> { UseHopper(player, HOPPER_LUMBY) }
                COOK_CTRL -> { UseHopper(player, HOPPER_COOK) }
                ZANARIS_CTRL -> { UseHopper(player, HOPPER_ZANARIS) }
                ARDY_CTRL -> { UseHopper(player, HOPPER_ARDY) }
                HOSIDIUS_CTRL -> { UseHopper(player, HOPPER_HOSIDIUS) }
            }
        }
    }
}

arrayOf(Objs.FLOUR_BIN, Objs.FLOUR_BIN_2574).forEach { emptyBin ->
    on_obj_option(emptyBin, "Empty") { emptyFlour(player) }
    on_item_on_obj(emptyBin, Items.POT) { emptyFlour(player) }
}

on_obj_option(Objs.FLOUR_BIN_5792, "Empty") { player.message("The flour bin is already empty. You need to place wheat in the hopper upstairs first.") }

fun fillHopper(player: Player) {
    when (player.getInteractingGameObj().tile) {
        LUMB_FILL -> { hopperAnim(player, HOPPER_LUMBY) }
        COOK_FILL -> { hopperAnim(player, HOPPER_COOK) }
        ZANARIS_FILL -> { hopperAnim(player, HOPPER_ZANARIS) }
        ARDY_FILL -> { hopperAnim(player, HOPPER_ARDY) }
        HOSIDIUS_FILL -> { hopperAnim(player, HOPPER_HOSIDIUS) }
    }
}

fun hopperAnim(player: Player, Key: AttributeKey<Unit>) {
    if (!player.attr.has(Key)) {
        player.queue {
            wait(3)
            player.lock()
            player.animate(Animation.PUT_IN_HOPPER)
            player.unlock()
            player.inventory.remove(Items.GRAIN)
            player.filterableMessage("You put the grain in the hopper. You should now pull the lever nearby to operate the hopper.")
        }
        player.attr.put(Key, Unit)
    }
    else { player.message("There is already grain in the hopper.") }
}

fun UseHopper(player: Player, persistanceKey: AttributeKey<Unit>) {
    val amount = player.getVarbit(FLOUR_AMOUNT_VARBIT)

    if (!player.attr.has(persistanceKey)) {
        player.filterableMessage("You operate the empty hopper. Nothing interesting happens.")
        return
    }
    player.filterableMessage("You operate the hopper. The grain slides down the chute.")
    if (amount == 30) {
        player.message("The flour bin downstairs is now full.")
    }
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