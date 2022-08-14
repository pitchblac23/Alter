package gg.rsmod.plugins.content.items.slayerring

import gg.rsmod.plugins.content.magic.TeleportType
import gg.rsmod.plugins.content.magic.canTeleport
import gg.rsmod.plugins.content.magic.teleport

val RING_OF_SLAYER = intArrayOf(
        Items.SLAYER_RING_1, Items.SLAYER_RING_2, Items.SLAYER_RING_3,
        Items.SLAYER_RING_4, Items.SLAYER_RING_5, Items.SLAYER_RING_6,
        Items.SLAYER_RING_7, Items.SLAYER_RING_8
)

private val SOUNDAREA_ID = 200
private val SOUNDAREA_RADIUS = 5
private val SOUNDAREA_VOLUME = 1

private val LOCATIONS = mapOf(
        "Stronghold Slayer Cave" to Tile(2434, 3422),
        "Morytania Slayer Tower" to Tile(3420, 3536),
        "Rellekka Slayer Caves" to Tile(2804, 9999),
        "Tarn's Lair" to Tile(3185, 4601),
        "Dark Beasts" to Tile(2030, 4637)
)

RING_OF_SLAYER.forEach { ring ->
    on_item_option(item = ring, option = "Check") {
        player.message(getRingChargeMessage(player.getInteractingItem()))
    }

    on_equipment_option(item = ring, option = "Check") {
        // I don't think this is very good.. but when would you ever have this be null
        player.message(getRingChargeMessage(player.getEquipment(EquipmentType.RING)!!))
    }

    on_item_option(item = ring, option = "Rub") {
        player.queue(TaskPriority.STRONG) {
            val tile = getTeleportOption()
            player.Teleport(tile = tile)
        }
    }

    on_equipment_option(item = ring, option = "Teleport") {
        player.queue(TaskPriority.STRONG) {
            val tile = getTeleportOption()
            player.Teleport(tile = tile)
        }
    }
}

fun Player.Teleport(tile: Tile) {
    if(canTeleport(TeleportType.MODERN)) {
        world.spawn(AreaSound(tile, SOUNDAREA_ID, SOUNDAREA_RADIUS, SOUNDAREA_VOLUME))
        teleport(tile, TeleportType.MODERN)

    }
}

suspend fun QueueTask.getTeleportOption(): Tile {
    // I think this needs to return a tile, and then teleport so we can add the teleport anim
    return when(options(
            "Teleport to Stronghold Slayer Cave",
            "Teleport to Morytania Slayer Tower",
            "Teleport to Rellekka Slayer Caves",
            "Teleport to Tarn's Lair",
            "Teleport to Dark Beasts"
    )) {
        1 -> return Tile(2434, 3422)
        2 -> return Tile(3420, 3536)
        3 -> return Tile(2804, 9999)
        4 -> return Tile(3185, 4601)
        5 -> return Tile(2030, 4637)
        else -> Tile(1, 1)
    }
}

fun getRingChargeMessage(item: Item): String {
    return when(item.id) {
        Items.SLAYER_RING_8 -> "<col=7f007f>Your slayer ring has eight uses left.</col>"
        Items.SLAYER_RING_7 -> "<col=7f007f>Your slayer ring has seven uses left.</col>"
        Items.SLAYER_RING_6 -> "<col=7f007f>Your slayer ring has six uses left.</col>"
        Items.SLAYER_RING_5 -> "<col=7f007f>Your slayer ring has five uses left.</col>"
        Items.SLAYER_RING_4 -> "<col=7f007f>Your slayer ring has four uses left.</col>"
        Items.SLAYER_RING_3 -> "<col=7f007f>Your slayer ring has three uses left.</col>"
        Items.SLAYER_RING_2 -> "<col=7f007f>Your slayer ring has two uses left.</col>"
        Items.SLAYER_RING_1 -> "<col=7f007f>Your slayer ring has one use left.</col>"
        else -> "<col=7f007f>Your slayer ring crumbles to dust.</col>"
    }
}

fun degradeRingCharge(item: Item): Int {
    return when(item.id) {
        Items.SLAYER_RING_8 -> Items.SLAYER_RING_7
        Items.SLAYER_RING_7 -> Items.SLAYER_RING_6
        Items.SLAYER_RING_6 -> Items.SLAYER_RING_5
        Items.SLAYER_RING_5 -> Items.SLAYER_RING_4
        Items.SLAYER_RING_4 -> Items.SLAYER_RING_3
        Items.SLAYER_RING_3 -> Items.SLAYER_RING_2
        Items.SLAYER_RING_2 -> Items.SLAYER_RING_1
        Items.SLAYER_RING_1 -> null
        else -> null
    }!!
}

/*RING_OF_SLAYER.forEach { ring ->
    LOCATIONS.forEach{ location, tile ->
        on_equipment_option(ring, option = location) {
            player.queue{ this.messageBox("test") }
        }
    }
}*/