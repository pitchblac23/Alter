package gg.rsmod.plugins.content.inter.bonds

import gg.rsmod.plugins.content.inter.options.OptionsTab

fun bind_setting(child: Int, plugin: Plugin.() -> Unit) {
    on_button(interfaceId = OptionsTab.OPTIONS_INTERFACE_ID, component = child) {
        plugin(this)
    }
}

bind_setting(child = OptionsTab.BOND_BUTTON_ID) {
    with (player) {
        openInterface(interfaceId = 65, dest = gg.rsmod.plugins.api.InterfaceDestination.MAIN_SCREEN)
        runClientScript(2498, 1, 0, 0)
        runClientScript(2524, -1, -1)
        setComponentText(interfaceId = 65, component = 25, text = "Redeem bonds for packages of <col=ffffff>14, 29 or 45 days</col>, or<br>up to <col=ffffff>a year</col> of Premier Membership.")
        runClientScript(3650, 0)
        runClientScript(733, 0,0,0,0,0,0,0,0)
    }
}
on_button(65, 90) {
    player.setVarbit(Varbits.BOND_INTERFACE_FOCUS_TAB, 0)
}
on_button(65, 89) {
    player.setVarbit(Varbits.BOND_INTERFACE_FOCUS_TAB, 1)
}
on_button(65, 91) {
    player.message("Placeholder to buy membership button")
}
on_button(65, 85) {
    player.message("Placeholder to buy bonds button")
}

/**
 * Bond Pouch
 */
val withDrawFromPouch = setOf(103, 99)
withDrawFromPouch.forEach {
    on_button(65, it) {
        player.message("Your inventory doesn't contain any of those bonds.")
    }
}

val depositFromPouch = setOf(95, 110)
depositFromPouch.forEach {
    on_button(65, it) {
        player.message("Your pouch doesn't contain any of those bonds.")
    }
}