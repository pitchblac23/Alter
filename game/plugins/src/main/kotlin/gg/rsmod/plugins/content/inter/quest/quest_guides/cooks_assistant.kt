package gg.rsmod.plugins.content.inter.quest.quest_guides

import gg.rsmod.game.model.entity.Player
import gg.rsmod.plugins.api.ext.*

fun cooks_assistant(p: Player) {
    if (p.getVarp(29) == 0) {
        p.setComponentText(interfaceId = 119, component = 2, text = "<col=7f0000>Cook's Assistant</col>")
        p.setComponentText(interfaceId = 119, component = 4, text = "<col=000080>I can start this quest by speaking to the <col=800000>Cook<col=000080> in the")
        p.setComponentText(interfaceId = 119, component = 5, text = "<col=000080><col=800000>Kitchen<col=000080> on the ground floor of <col=800000>Lumbridge Castle<col=000080>.")
        p.setComponentText(interfaceId = 119, component = 7, text = "")
    }

    if (p.getVarp(29) == 1) {
        p.setComponentText(interfaceId = 119, component = 2, text = "<col=7f0000>Cook's Assistant</col>")
        p.setComponentText(interfaceId = 119, component = 4, text = "<col=000080>It's the <col=800000>Duke of Lumbridge's<col=000080> birthday and I have to help")
        p.setComponentText(interfaceId = 119, component = 5, text = "<col=000080>his <col=800000>Cook<col=000080> make him a <col=800000>birthday cake<col=000080>. To do this I need to")
        p.setComponentText(interfaceId = 119, component = 6, text = "<col=000080>bring him the following ingredients:")
        p.setComponentText(interfaceId = 119, component = 7, text = "<col=000080>I need to find a <col=800000>bucket of milk<col=000080>. There's a cattle field east")
        p.setComponentText(interfaceId = 119, component = 8, text = "<col=000080>of Lumbridge, I should make sure I take an empty bucket")
        p.setComponentText(interfaceId = 119, component = 9, text = "<col=000080>with me.")
        p.setComponentText(interfaceId = 119, component = 10, text = "<col=000080>I need to find a <col=800000>pot of flour<col=000080>. There's a mill found north-")
        p.setComponentText(interfaceId = 119, component = 11, text = "<col=000080>west of Lumbridge, I should take an empty pot with me.")
        p.setComponentText(interfaceId = 119, component = 12, text = "<col=000080>I need to find an <col=800000>egg<col=000080>. The cook normally gets his eggs from")
        p.setComponentText(interfaceId = 119, component = 13, text = "<col=000080>the Groats' farm, found just to the west of the cattle")
        p.setComponentText(interfaceId = 119, component = 14, text = "<col=000080>field.")
        p.runClientScript(2523, 0, 10)
    }

    if (p.getVarp(29) == 2) {
        p.setComponentText(interfaceId = 119, component = 2, text = "<col=7f0000>Cook's Assistant</col>")
        p.setComponentText(interfaceId = 119, component = 4, text = "<str>It was the Duke of Lumbridge's birthday, but his cook had")
        p.setComponentText(interfaceId = 119, component = 5, text = "<str>forgotten to buy the ingredients he needed to make him a")
        p.setComponentText(interfaceId = 119, component = 6, text = "<str>cake. I brought the cook an egg, some flour and some milk")
        p.setComponentText(interfaceId = 119, component = 7, text = "<str>and the cook made a delicious looking cake with them.")
        p.setComponentText(interfaceId = 119, component = 8, text = "")
        p.setComponentText(interfaceId = 119, component = 9, text = "<str>As a reward he now lets me use his high quality range")
        p.setComponentText(interfaceId = 119, component = 10, text = "<str>which lets me burn things less whenever I wish to cook")
        p.setComponentText(interfaceId = 119, component = 11, text = "<str>there.")
        p.setComponentText(interfaceId = 119, component = 12, text = "")
        p.setComponentText(interfaceId = 119, component = 13, text = "<col=ff0000>QUEST COMPLETE!")
        p.runClientScript(2523, 0, 10)
    }
}