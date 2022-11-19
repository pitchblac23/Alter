package gg.rsmod.plugins.content.inter.quest.quests.sheep_shearer

import gg.rsmod.game.model.entity.Player
import gg.rsmod.plugins.api.cfg.Items
import gg.rsmod.plugins.api.ext.*

fun sheep_shearer(player: Player) {
    when (player.getVarp(179)) {
        0 -> {
            player.line(2, text = "<col=7f0000>Sheep Shearer</col>")
            player.line(4, text = "<col=000080>I can start this quest by talking to <col=800000>Fred<col=000080> at his farm in the northern")
            player.line(text = "<col=800000>Lumbridge<col=000080>.")
        }
        in 1 until 21 -> {
            val requiredWool = (21 - player.getVarp(179) - player.inventory.getItemCount(Items.BALL_OF_WOOL))

            player.line(2, text = "<col=7f0000>Sheep Shearer</col>")
            player.line(4, text = "<str>I asked Farmer Fred, near Lumbridge, for a quest. Fred")
            player.line(text = "<str>said he'd pay me for shearing his sheep for him!")

            if (requiredWool <= 0) {
                player.line(text = "<str>Fred gave me some shears to use, to get the job done.")
                player.line(text = "<col=800000>I have enough <col=000080>balls of wool <col=800000>to give <col=000080>Fred <col=800000>and get my <col=000080>reward")
                player.line(text = "<col=000080>money!</col>")
            } else {
                player.line(text = "<col=800000>Fred gave me some shears to use, to get the job done.")
                player.line(text = "<col=000080>Farmer Fred <col=800000>said there was a <col=000080>spinning wheel <col=800000>in <col=000080>Lumbridge")
                player.line(text = "<col=000080>castle <col=800000>I could use to make the balls of wool.")
                player.line(text = "<col=800000>I need to collect $requiredWool more <col=000080balls of wool.")
            }
        }
        21 -> {
            player.line(2, text = "<col=7f0000>Sheep Shearer</col>")
            player.line(4, text = "<str>I brought Farmer Fred 20 balls of wool, and he paid me for</str>")
            player.line(text = "<str>it!</str>")
            player.line(7, text = "<col=ff0000>QUEST COMPLETE!")
        }
    }
}