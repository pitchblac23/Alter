package gg.rsmod.plugins.content.inter.quest.quests.cooks_assistant

import gg.rsmod.game.model.entity.Player
import gg.rsmod.plugins.api.ext.*

fun cooks_assistant(player: Player) {
    when (player.getVarp(29)) {
        0 -> {
            player.line(2, text = "<col=7f0000>Cook's Assistant</col>")
            player.line(4, text = "<col=000080>I can start this quest by speaking to the <col=800000>Cook<col=000080> in the")
            player.line(text = "<col=000080><col=800000>Kitchen<col=000080> on the ground floor of <col=800000>Lumbridge Castle<col=000080>.")
        }
        1 -> {
            player.line(2, text = "<col=7f0000>Cook's Assistant</col>")
            player.line(4, text = "<col=000080>It's the <col=800000>Duke of Lumbridge's<col=000080> birthday and I have to help")
            player.line(text = "<col=000080>his <col=800000>Cook<col=000080> make him a <col=800000>birthday cake<col=000080>. To do this I need to")
            player.line(text = "<col=000080>bring him the following ingredients:")
            player.line(text = "<col=000080>I need to find a <col=800000>bucket of milk<col=000080>. There's a cattle field east")
            player.line(text = "<col=000080>of Lumbridge, I should make sure I take an empty bucket")
            player.line(text = "<col=000080>with me.")
            player.line(text = "<col=000080>I need to find a <col=800000>pot of flour<col=000080>. There's a mill found north-")
            player.line(text = "<col=000080>west of Lumbridge, I should take an empty pot with me.")
            player.line(text = "<col=000080>I need to find an <col=800000>egg<col=000080>. The cook normally gets his eggs from")
            player.line(text = "<col=000080>the Groats' farm, found just to the west of the cattle")
            player.line(text = "<col=000080>field.")
            player.runClientScript(2523, 0, 10)
        }
        2 -> {
            player.line(2, text = "<col=7f0000>Cook's Assistant</col>")
            player.line(4, text = "<str>It was the Duke of Lumbridge's birthday, but his cook had")
            player.line(text = "<str>forgotten to buy the ingredients he needed to make him a")
            player.line(text = "<str>cake. I brought the cook an egg, some flour and some milk")
            player.line(text = "<str>and the cook made a delicious looking cake with them.")
            player.line(text = "")
            player.line(text = "<str>As a reward he now lets me use his high quality range")
            player.line(text = "<str>which lets me burn things less whenever I wish to cook")
            player.line(text = "<str>there.")
            player.line(text = "")
            player.line(text = "<col=ff0000>QUEST COMPLETE!")
            player.runClientScript(2523, 0, 10)
        }
    }
}