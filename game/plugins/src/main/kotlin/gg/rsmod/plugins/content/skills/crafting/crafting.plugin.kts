package gg.rsmod.plugins.content.skills.crafting

import gg.rsmod.plugins.api.cfg.Items
import gg.rsmod.plugins.content.skills.crafting.data.Gems
import gg.rsmod.plugins.content.skills.crafting.data.Spin

Gems.values().forEach { gems ->
    on_item_on_item(Items.CHISEL, gems.uncutGem) {
        player.queue { Cutting.gemCut(this, gems) }
    }
}

arrayOf(Objs.SPINNING_WHEEL_14889, Objs.SPINNING_WHEEL_25824, Objs.SPINNING_WHEEL).forEach { spinning_wheel ->
    Spin.values().forEach { spin ->
        on_item_on_obj(obj = spinning_wheel, item = spin.unSpun) {
            player.queue { Spinning.Spin(this, spin) }
        }
    }
}
