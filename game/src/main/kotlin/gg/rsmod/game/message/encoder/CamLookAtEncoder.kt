package gg.rsmod.game.message.encoder

import gg.rsmod.game.message.MessageEncoder
import gg.rsmod.game.message.impl.CamLookAtMessage

/**
 * @author Tom <rspsmods@gmail.com>
 */
class CamLookAtEncoder : MessageEncoder<CamLookAtMessage>() {

    override fun extract(message: CamLookAtMessage, key: String): Number = when (key) {
        "scene_x" -> message.scene_x
        "scene_z" -> message.scene_z
        "height" -> message.height
        "param4" -> message.param4
        "param5" -> message.param5
        else -> throw Exception("Unhandled value key.")
    }

    override fun extractBytes(message: CamLookAtMessage, key: String): ByteArray = throw Exception("Unhandled value key.")
}