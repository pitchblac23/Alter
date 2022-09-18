package gg.rsmod.plugins.content.cmd.commands.developer

import gg.rsmod.game.model.priv.Privilege
import gg.rsmod.plugins.content.cmd.Commands_plugin.Command.tryWithUsage
import gg.rsmod.game.message.impl.CamLookAtMessage
import gg.rsmod.game.message.impl.CamMoveToMessage
import gg.rsmod.game.message.impl.CamResetMessage
import gg.rsmod.game.message.impl.CamShakeMessage

on_command("camreset", Privilege.DEV_POWER){
    player.write(CamResetMessage())
}

on_command("shakecam", Privilege.DEV_POWER){
    val args = player.getCommandArgs()
    tryWithUsage(player, args, "Invalid format! Example of proper command <col=801700>::shakecam param1 param2 param3 param4</col>") { values ->
        val index = values[0].toInt()
        val param2  = values[1].toInt()
        val param3  = values[2].toInt()
        val param4  = values[3].toInt()
        player.write(CamShakeMessage(index, param2, param3, param4))
    }
}

on_command("movecam", Privilege.DEV_POWER){
    val args = player.getCommandArgs()
    tryWithUsage(player, args, "Invalid format! Example of proper command <col=801700>::movecam param1 param2 param3 param4 param5</col>") { values ->
        val param1 = values[0].toInt()
        val param2  = values[1].toInt()
        val index  = values[2].toInt()
        val param4  = values[3].toInt()
        val param5  = values[4].toInt()
        player.write(CamMoveToMessage(param1, param2, index, param4, param5))
    }
}

on_command("lookat", Privilege.DEV_POWER){
    val args = player.getCommandArgs()
    tryWithUsage(player, args, "Invalid format! Example of proper command <col=801700>::lookat param1 param2 param3 param4 param5</col>") { values ->
        val param1 = values[0].toInt()
        val param2  = values[1].toInt()
        val index  = values[2].toInt()
        val param4  = values[3].toInt()
        val param5  = values[4].toInt()
        player.write(CamLookAtMessage(param1, param2, index, param4, param5))
    }
}