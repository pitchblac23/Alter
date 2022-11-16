package gg.rsmod.plugins.content.inter.quest.quest_guides

import gg.rsmod.game.model.entity.Player
import gg.rsmod.plugins.api.ext.*

fun sheep_shearer(player: Player) {
    if (player.getVarp(179) == 0) {
        player.setComponentText(interfaceId = 119, component = 2, text = "<col=7f0000>Sheep Shearer</col>")
        player.setComponentText(interfaceId = 119, component = 4, text = "<col=000080>I can start this quest by speaking to <col=800000>Farmer Fred<col=000080> at his")
        player.setComponentText(interfaceId = 119, component = 5, text = "<col=000080><col=800000>farm<col=000080> just a little way <col=800000>North West of Lumbridge")
        player.setComponentText(interfaceId = 119, component = 7, text = "")
    }

    if (player.getVarp(179) == 1) {
        player.setComponentText(interfaceId = 119, component = 2, text = "<col=7f0000>Sheep Shearer</col>")
        player.setComponentText(interfaceId = 119, component = 4, text = "<str>I asked Farmer Fred, near Lumbridge, for a quest. Fred")
        player.setComponentText(interfaceId = 119, component = 5, text = "<str>said he'd pay me for shearing his sheep for him!")
    }

    /**
    TODO: add in also need better fix for the $ballsNeeded
    on_interface_open(119) {
        player.setComponentText(interfaceId = 119, component = 7, text = "<col=000080>I need to collect $ballsNeeded more <col=800000>balls of wool.")
    }
    */

    if (player.getVarp(179) == 2) {
        player.setComponentText(interfaceId = 119, component = 2, text = "<col=7f0000>Sheep Shearer</col>")
        player.setComponentText(interfaceId = 119, component = 4, text = "<str>I brought Farmer Fred 20 balls of wool, and he paid me for")
        player.setComponentText(interfaceId = 119, component = 5, text = "<str>it!")
        player.setComponentText(interfaceId = 119, component = 6, text = "")
        player.setComponentText(interfaceId = 119, component = 7, text = "<col=ff0000>QUEST COMPLETE!")
    }
}