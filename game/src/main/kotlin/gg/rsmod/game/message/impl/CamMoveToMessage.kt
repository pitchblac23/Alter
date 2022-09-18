package gg.rsmod.game.message.impl

import gg.rsmod.game.message.Message

/**
 * @author Bmyte
 */

data class CamMoveToMessage(val scene_x: Int, val scene_z: Int, val height: Int, val param4: Int, val param5: Int) : Message