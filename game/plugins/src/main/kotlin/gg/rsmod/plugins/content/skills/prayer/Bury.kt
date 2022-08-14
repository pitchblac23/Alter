package gg.rsmod.plugins.content.skills.prayer

import gg.rsmod.game.fs.def.ItemDef
import gg.rsmod.game.model.entity.Player
import gg.rsmod.plugins.api.Skills
import gg.rsmod.plugins.api.cfg.Animation
import gg.rsmod.plugins.api.ext.message

/**
 * @author Fritz <frikkipafi@gmail.com>
 */
object Bury {
    fun canBury(p: Player, bones: Bones): Boolean = true

    fun Bury(p: Player, bones: Bones) {
            p.queue {
                p.lock()
                p.message("You dig a hole in the ground...")
                p.addXp(Skills.PRAYER, bones.xp)
                p.animate(Animation.BURY_BONE_ANIM)
                wait(3)
                p.message("You bury the bones.")
                p.unlock()
            }
    }
}