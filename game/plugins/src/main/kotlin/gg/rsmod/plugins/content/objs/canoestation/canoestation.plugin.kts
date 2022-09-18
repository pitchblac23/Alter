package gg.rsmod.plugins.content.objs.canoestation

/**Thanks to Ingot
 * for helping me get the face direction
 * and for making the functions
 *
 **Thanks to ComradeNuzzles
 * for helping clean up the code
 * and for reworking the canoe stations & destinations
 *
 * TODO:
 * make the sinking canoes spawn
 * add in fading interface and blackout minimap
 * add proper sounds
 * add in Camera settings
 * fix interface issues
 * */

import gg.rsmod.game.message.impl.CamLookAtMessage
import gg.rsmod.game.message.impl.CamMoveToMessage
import gg.rsmod.game.message.impl.CamResetMessage

//player.playSound(id = 2734, volume = 1, delay = 0) //tree falling
//player.playSound(id = 2731, volume = 1, delay = 0) //canoe in water
//player.playSound(id = 2728, volume = 16, delay = 0) //rowing canoe scene

on_obj_option(Objs.CANOE_STATION, "Chop-down") {
    val obj = player.getInteractingGameObj()
    if (player.getSkills().getBaseLevel(Skills.WOODCUTTING) <= 11) {
        player.message("You need to have at least 12 woodcutting to use canoes.")
    } else

    player.queue {
        player.lock()

        if (obj.tile.x == 3241 && obj.tile.z == 3235) {
            player.walkTo(x = 3243, z = 3235, MovementQueue.StepType.FORCED_WALK)
            wait(5)

            if (player.tile.x == 3243 && player.tile.z == 3235) {
                player.faceTile(player.tile.transform(Direction.WEST.getDeltaX(), Direction.WEST.getDeltaZ()))
                action(player)
                wait(1)
                player.setVarbit(1839, 10)
            }
        }

        if (obj.tile.x == 3200 && obj.tile.z == 3341) {
            player.walkTo(x = 3204, z = 3343, MovementQueue.StepType.FORCED_WALK)
            wait(5)

            if (player.tile.x == 3204 && player.tile.z == 3343) {
                player.faceTile(player.tile.transform(Direction.SOUTH.getDeltaX(), Direction.SOUTH.getDeltaZ()))
                action(player)
                wait(1)
                player.setVarbit(1840, 10)
            }
        }

        if (obj.tile.x == 3110 && obj.tile.z == 3409) {
            player.walkTo(x = 3112, z = 3409, MovementQueue.StepType.FORCED_WALK)
            wait(5)

            if (player.tile.x == 3112 && player.tile.z == 3409) {
                player.faceTile(player.tile.transform(Direction.WEST.getDeltaX(), Direction.WEST.getDeltaZ()))
                action(player)
                wait(1)
                player.setVarbit(1841, 10)
            }
        }

        if (obj.tile.x == 3130 && obj.tile.z == 3508) {
            player.walkTo(x = 3132, z = 3508, MovementQueue.StepType.FORCED_WALK)
            wait(5)

            if (player.tile.x == 3132 && player.tile.z == 3508) {
                player.faceTile(player.tile.transform(Direction.WEST.getDeltaX(), Direction.WEST.getDeltaZ()))
                action(player)
                wait(1)
                player.setVarbit(1842, 10)
            }
        }

        if (obj.tile.x == 3155 && obj.tile.z == 3628) {
            player.walkTo(x = 3154, z = 3632, MovementQueue.StepType.FORCED_WALK)
            wait(5)

            if (player.tile.x == 3154 && player.tile.z == 3632) {
                player.faceTile(player.tile.transform(Direction.EAST.getDeltaX(), Direction.EAST.getDeltaZ()))
                action(player)
                wait(1)
                player.setVarbit(10527, 10)
            }
        }
        player.unlock()
    }
}

on_obj_option(Objs.CANOE_STATION_12146, "Shape-Canoe") {
    val obj = player.getInteractingGameObj()

    player.queue {
        if (obj.tile.x == 3241 && obj.tile.z == 3235) {
            player.moveTo(x = 3243, z = 3237)
            wait(2)
            if (player.tile.x == 3243 && player.tile.z == 3237) {
                player.faceTile(player.tile.transform(Direction.WEST.getDeltaX(), Direction.WEST.getDeltaZ()))
            }
        }
        player.openInterface(interfaceId = 416, dest = InterfaceDestination.MAIN_SCREEN)
    }
}

class shapeCanoe (val inter674varp: Int, val tile: Tile)
val log = arrayOf(
        shapeCanoe(1, Tile(3243, 3237)),
        shapeCanoe(256, Tile(3202, 3343)),
        shapeCanoe(65536, Tile(3112, 3411)),
        shapeCanoe(16777216, Tile(3132, 3510))
)
val dugout = arrayOf(
        shapeCanoe(2, Tile(3243, 3237)),
        shapeCanoe(512, Tile(3202, 3343)),
        shapeCanoe(131072, Tile(3112, 3411)),
        shapeCanoe(33554432, Tile(3132, 3510))
)
val stable_dugout = arrayOf(
        shapeCanoe(3, Tile(3243, 3237)),
        shapeCanoe(768, Tile(3202, 3343)),
        shapeCanoe(196608, Tile(3112, 3411)),
        shapeCanoe(50331648, Tile(3132, 3510))
)
val waka = arrayOf(
        shapeCanoe(4, Tile(3243, 3237)),
        shapeCanoe(1024, Tile(3202, 3343)),
        shapeCanoe(262144, Tile(3112, 3411)),
        shapeCanoe(67108864, Tile(3132, 3510))
)

on_button(52, 24){
    player.message("log")
    log.forEach {
        if (player.tile == (it.tile)) {
            player.setVarp(674, it.inter674varp)
        }//varbit 1839 1
    }
    close(player)
}
on_button(52, 37) {
    player.message("dugout")
    dugout.forEach {
        if (player.tile == (it.tile)) {
            player.setVarp(674, it.inter674varp)
        }
    }
    close(player)
}
on_button(52, 38) {
    player.message("stable dugout")
    stable_dugout.forEach {
        if (player.tile == (it.tile)) {
            player.setVarp(674, it.inter674varp)
        }
    }
    close(player)
}
on_button(52, 39) {
    player.message("waka")
    waka.forEach {
        if (player.tile == (it.tile)) {
            player.setVarp(674, it.inter674varp)
        }
    }
    close(player)
}

class FloatCanoes (val inter674varp: Int, val tile: Tile)
val floatLog = arrayOf (
        FloatCanoes(11, Tile(3243, 3237)),
        FloatCanoes(2816, Tile(3202, 3343)),
        FloatCanoes(720896, Tile(3112, 3411)),
        FloatCanoes(184549376, Tile(3132, 3510))
)
val floatDugout = arrayOf (
        FloatCanoes(12, Tile(3243, 3237)),
        FloatCanoes(3072, Tile(3202, 3343)),
        FloatCanoes(786432, Tile(3112, 3411)),
        FloatCanoes(201326592, Tile(3132, 3510))
)
val floatStable = arrayOf (
        FloatCanoes(13, Tile(3243, 3237)),
        FloatCanoes(3328, Tile(3202, 3343)),
        FloatCanoes(851968, Tile(3112, 3411)),
        FloatCanoes(218103808, Tile(3132, 3510))
)
val floatWaka = arrayOf (
        FloatCanoes(14, Tile(3243, 3237)),
        FloatCanoes(3584, Tile(3202, 3343)),
        FloatCanoes(917504, Tile(3112, 3411)),
        FloatCanoes(234881024, Tile(3132, 3510))
)

on_obj_option(Objs.CANOE_STATION_12147, "float log") {
    player.faceTile(player.tile.transform(Direction.WEST.getDeltaX(), Direction.WEST.getDeltaZ()))
    floatCanoe(player, Objs.CANOE_STATION_12151)
    player.message("float log")
    floatLog.forEach {
        if (player.tile == (it.tile)) {
            player.setVarbit(1843, 1)
            //varbit 1839 5 - 11
            player.setVarp(674, it.inter674varp)
        }
    }
}
on_obj_option(Objs.CANOE_STATION_12148, "float canoe") {
    player.faceTile(player.tile.transform(Direction.WEST.getDeltaX(), Direction.WEST.getDeltaZ()))
    floatCanoe(player, Objs.CANOE_STATION_12152)
    player.message("float dugout")
    floatDugout.forEach {
        if (player.tile == (it.tile)) {
            player.setVarbit(1843, 2)
            player.setVarp(674, it.inter674varp)
        }
    }
}
on_obj_option(Objs.CANOE_STATION_12149, "float canoe") {
    player.faceTile(player.tile.transform(Direction.WEST.getDeltaX(), Direction.WEST.getDeltaZ()))
    floatCanoe(player, Objs.CANOE_STATION_12153)
    player.message("float stable dugout")
    floatStable.forEach {
        if (player.tile == (it.tile)) {
            player.setVarbit(1843, 3)
            player.setVarp(674, it.inter674varp)
        }
    }
}
on_obj_option(Objs.CANOE_STATION_12150, "float canoe") {
    player.faceTile(player.tile.transform(Direction.WEST.getDeltaX(), Direction.WEST.getDeltaZ()))
    floatCanoe(player, Objs.CANOE_STATION_12154)
    player.message("float waka")
    floatWaka.forEach {
        if (player.tile == (it.tile)) {
            player.setVarbit(1843, 4)
            player.setVarp(674, it.inter674varp)
        }
    }
}

//interface 647 buttons needs work
class Paddle (val paddleObj: Int)
class Destination(val name: String, val component: Int, val tile: Tile)
val paddle = arrayOf(
        Paddle(Objs.CANOE_STATION_12153),
        Paddle(Objs.CANOE_STATION_12156),
        Paddle(Objs.CANOE_STATION_12155),
        Paddle(Objs.CANOE_STATION_12157),
        Paddle(Objs.CANOE_STATION_12158)
)
val destinations = arrayOf(
        Destination("lumbridge", 32, Tile(3240, 3242)),
        Destination("champions guild", 33, Tile(3199, 3344)),
        Destination("barbvillage", 34, Tile(3109, 3415)),
        Destination("edgeville", 39, Tile(3128, 3503)),
        Destination("wilderness pond", 35, Tile(3141, 3796))
)

on_button(647, 15) {
    player.message("test")
}

paddle.forEach {
    on_obj_option(it.paddleObj, "Paddle Canoe") {
        player.openInterface(57, InterfaceDestination.MAIN_SCREEN)
    }//647 interface required 57 for now till fix
}
destinations.forEach{
    on_button(57, it.component){ //needs to be 647 needs click ids
        player.message(it.name)
        doCanoeAction(player, it.tile)
    }
}

fun action(player: Player) {
    val obj = player.getInteractingGameObj()

    player.queue {
        wait(1)
        player.animate(875)
        wait(1)
        player.animate(-1)
        world.queue {
            world.remove(obj)
            world.spawn(DynamicObject(obj, Objs.CANOE_STATION_12145))
            wait(3)
            world.remove(DynamicObject(obj, Objs.CANOE_STATION_12145))
            world.spawn(DynamicObject(obj))
        }
    }
    return
}

fun close(player: Player) {
    player.closeInterface(dest = InterfaceDestination.MAIN_SCREEN)
    player.animate(3289)
}

fun floatCanoe(player: Player, canoe: Int) {
    val obj = player.getInteractingGameObj()

    player.queue {
        player.animate(3301)
        world.queue {
            world.remove(obj)
            world.spawn(DynamicObject(obj, canoe))
            wait(4)
            world.remove(DynamicObject(obj, canoe))
            world.spawn(DynamicObject(obj))
        }
    }
}

fun doCanoeAction(player: Player, finalMoveLocation: Tile) {
    player.closeInterface(dest = InterfaceDestination.MAIN_SCREEN)
    player.moveTo(1817, 4515)
    player.animate(3302)
    player.queue {
        player.faceTile(player.tile.transform(Direction.WEST.getDeltaX(), Direction.WEST.getDeltaZ()))
        wait(2)

        if (player.tile.x == 1817 && player.tile.z == 4515) {
            player.lock()
            player.setVarbit(id = 4606, value = 1)
            player.setVarbit(id = 542, value = 1)
            player.write(CamMoveToMessage(44, 51, 2500, 100, 100))
            player.write(CamMoveToMessage(44, 51, 255, 100, 100))
            player.write(CamLookAtMessage(49, 51, 225, 100, 100))
            player.queue {
                wait(20)
                player.setVarp(674, 0)
                player.setVarbit(10527, 0)
                player.setVarbit(4606, 0)
                player.setVarbit(542, 0)
                player.animate(-1)
                player.moveTo(finalMoveLocation)
                player.write(CamResetMessage())
                player.unlock()
            }
        }
    }
}

on_logout {
    player.setVarp(674, 0)
    player.setVarbit(10527, 0)
}